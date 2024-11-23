package _MovieDataFetcher1;

import java.util.List;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // TMDb API에서 영화 데이터 가져오기
            String jsonResponse = MovieFetcher.fetchMovies();
            List<Movie> movies = MovieParser.parseMovies(jsonResponse);

            while (true) {
                // 메뉴 표시
                System.out.println("\n=== 영화 추천 프로그램 ===");
                System.out.println("1. 인기 영화 TOP 5 보기");
                System.out.println("2. 영화 추천 받기");
                System.out.println("0. 프로그램 종료");
                System.out.print("선택: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // 인기 영화 TOP 5 출력
                        showTopMovies(movies);
                        break;

                    case 2:
                        // 추천 기능 실행
                        recommendMovies(movies, scanner);
                        break;

                    case 0:
                        // 프로그램 종료
                        System.out.println("프로그램을 종료합니다.");
                        scanner.close();
                        return;

                    default:
                        System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                }
            }
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // 인기 영화 TOP 5 출력
    private static void showTopMovies(List<Movie> movies) {
        System.out.println("\n=== 인기 영화 TOP 5 ===");
        for (int i = 0; i < Math.min(5, movies.size()); i++) {
            Movie movie = movies.get(i);
            System.out.printf("%d. %s (평점: %.1f)\n", i + 1, movie.getTitle(), movie.getVoteAverage());
        }
    }

    // 영화 추천
    private static void recommendMovies(List<Movie> movies, Scanner scanner) {
        System.out.println("\n=== 추천 받을 영화 선택 ===");
        // 인기 영화 10개를 표시
        for (int i = 0; i < Math.min(10, movies.size()); i++) {
            Movie movie = movies.get(i);
            System.out.printf("%d. %s\n", i + 1, movie.getTitle());
        }

        System.out.print("추천을 받을 영화를 선택하세요 (1-10): ");
        int selectedIndex = scanner.nextInt() - 1;

        if (selectedIndex < 0 || selectedIndex >= 10) {
            System.out.println("잘못된 선택입니다. 메뉴로 돌아갑니다.");
            return;
        }

        Movie selectedMovie = movies.get(selectedIndex);
        System.out.println("\n선택한 영화: " + selectedMovie.getTitle());

        // 내용 기반 필터링으로 유사한 영화 추천
        ContentBasedRecommender recommender = new ContentBasedRecommender();
        List<Movie> recommendations = recommender.recommend(movies, selectedMovie);

        System.out.println("\n=== 추천 영화 ===");
        for (int i = 0; i < Math.min(10, recommendations.size()); i++) {
            Movie movie = recommendations.get(i);
            System.out.printf("%d. %s\n", i + 1, movie.getTitle());
        }
    }
}
