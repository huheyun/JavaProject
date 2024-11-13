package def;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static List<Movie> movies = new ArrayList<>();
    private static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== 영화 추천 프로그램 =====");
            System.out.println("1. 영화 추가");
            System.out.println("2. 사용자 정보 입력");
            System.out.println("3. 영화 탐색");
            System.out.println("4. 사용자 기반 추천 출력");
            System.out.println("5. 종료");
            System.out.print("메뉴를 선택하세요: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addMovie(scanner);
                    break;
                case 2:
                    addUser();
                    break;
                case 3:
                case 4:
                    System.out.println("아직 구현되지 않은 기능입니다.");
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("올바른 번호를 선택하세요.");
            }
        }
    }

    private static void addMovie(Scanner scanner) {
    	System.out.print("영화 제목을 입력하세요: ");
        String title = scanner.nextLine();

        System.out.print("영화 장르를 입력하세요: ");
        String genre = scanner.nextLine();

        System.out.print("감독 이름을 입력하세요: ");
        String director = scanner.nextLine();

        System.out.print("출연 배우를 쉼표로 구분하여 입력하세요: ");
        String actorsInput = scanner.nextLine();
        List<String> actors = List.of(actorsInput.split(",\\s*")); // 쉼표로 구분하여 배우 목록 생성

        System.out.print("평점을 입력하세요 (0 ~ 10): ");
        double rating = scanner.nextDouble();
        scanner.nextLine(); // 줄바꿈 문자 제거

        System.out.print("줄거리를 입력하세요: ");
        String synopsis = scanner.nextLine();

        // Movie 객체 생성 및 리스트에 추가
        Movie movie = new Movie(title, genre, director, actors, rating, synopsis);
        movies.add(movie);
        System.out.println("영화가 성공적으로 추가되었습니다!");
    }

    private static void addUser() {
        // 임시로 간단히 입력받아 사용자 추가
        System.out.println("사용자 정보 입력 기능을 아직 구현하지 않았습니다.");
    }
}
