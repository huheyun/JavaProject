package _MovieDataFetcher1;

import java.util.*;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 사용자 이름 입력
        System.out.println("사용자의 이름을 입력하세요:");
        String userName = scanner.nextLine();
        System.out.println("환영합니다, " + userName + "님!");

        try {
            // 1. TMDb에서 장르 데이터 가져오기
            Map<Integer, String> genreMap = GenreFetcher.fetchGenres();
            List<String> genres = new ArrayList<>(genreMap.values());

            // 사용자 선호 장르 선택
            System.out.println("선호하는 장르를 선택하세요 (쉼표로 구분하여 여러 개 선택 가능):");
            for (int i = 0; i < genres.size(); i++) {
                System.out.println((i + 1) + ". " + genres.get(i));
            }
            System.out.print("선호 장르 번호 입력: ");
            String genreChoices = scanner.nextLine();
            List<String> selectedGenres = Arrays.stream(genreChoices.split(","))
                    .map(choice -> genres.get(Integer.parseInt(choice.trim()) - 1))
                    .collect(Collectors.toList());

            // 2. TMDb에서 영화 데이터 가져오기
            MovieFetcher fetcher = new MovieFetcher();
            String movieJson = fetcher.fetchMovies(1); // 페이지 1의 영화 데이터 가져오기
            MovieParser parser = new MovieParser();
            List<Movie> movies = parser.parseMovies(movieJson, genreMap);

            // 배우 및 감독 목록 생성
            Set<String> actorSet = new HashSet<>();
            Set<String> directorSet = new HashSet<>();
            for (Movie movie : movies) {
                actorSet.addAll(movie.getActors());
                if (movie.getDirector() != null) {
                    directorSet.add(movie.getDirector());
                }
            }

            List<String> actors = new ArrayList<>(actorSet);
            List<String> directors = new ArrayList<>(directorSet);

            // 사용자 선호 배우 선택 (랜덤 5명)
            System.out.println("선호하는 배우를 선택하세요 (쉼표로 구분하여 여러 개 선택 가능, 없으면 'x' 입력):");
            List<String> randomActors = getRandomSubList(actors, 5);
            for (int i = 0; i < randomActors.size(); i++) {
                System.out.println((i + 1) + ". " + randomActors.get(i));
            }
            System.out.print("선호 배우 번호 입력: ");
            String actorChoices = scanner.nextLine();
            List<String> selectedActors = actorChoices.equalsIgnoreCase("x") ? new ArrayList<>()
                    : Arrays.stream(actorChoices.split(","))
                            .map(choice -> randomActors.get(Integer.parseInt(choice.trim()) - 1))
                            .collect(Collectors.toList());

            // 사용자 선호 감독 선택 (랜덤 5명)
            System.out.println("선호하는 감독을 선택하세요 (쉼표로 구분하여 여러 개 선택 가능, 없으면 'x' 입력):");
            List<String> randomDirectors = getRandomSubList(directors, 5);
            for (int i = 0; i < randomDirectors.size(); i++) {
                System.out.println((i + 1) + ". " + randomDirectors.get(i));
            }
            System.out.print("선호 감독 번호 입력: ");
            String directorChoices = scanner.nextLine();
            List<String> selectedDirectors = directorChoices.equalsIgnoreCase("x") ? new ArrayList<>()
                    : Arrays.stream(directorChoices.split(","))
                            .map(choice -> randomDirectors.get(Integer.parseInt(choice.trim()) - 1))
                            .collect(Collectors.toList());

            // 사용자 객체 생성
            User user = new User(userName, String.join(",", selectedGenres), String.join(",", selectedActors), String.join(",", selectedDirectors));

            // 3. 추천 영화 출력
            ContentBasedRecommender recommender = new ContentBasedRecommender();
            List<Movie> recommendedMovies = recommender.recommend(movies, user);

            System.out.println("\n추천 영화 목록:");
            for (Movie movie : recommendedMovies) {
                System.out.println("- " + movie.getTitle() + " (" + movie.getVoteAverage() + ")");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner.close();
    }

    // 랜덤으로 최대 5개의 항목 가져오기
    private static List<String> getRandomSubList(List<String> list, int count) {
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        Collections.shuffle(list);
        return list.subList(0, Math.min(count, list.size()));
    }
}
