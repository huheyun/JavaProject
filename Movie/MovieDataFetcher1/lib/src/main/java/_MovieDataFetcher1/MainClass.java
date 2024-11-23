package _MovieDataFetcher1;

import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        try {
            // 1. TMDb API에서 영화 데이터 가져오기
            String jsonResponse = MovieFetcher.fetchMovies();

            // 2. JSON 데이터를 객체로 변환
            List<Movie> movies = MovieParser.parseMovies(jsonResponse);

            // 3. 추천 알고리즘 실행
            System.out.println("Content-Based Recommendation:");
            ContentBasedRecommender contentRecommender = new ContentBasedRecommender();
            List<Movie> contentRecommendations = contentRecommender.recommend(movies, movies.get(0)); // 첫 번째 영화 기준

            for (Movie movie : contentRecommendations) {
                System.out.println(movie.getTitle());
            }

            System.out.println("\nCollaborative Filtering Recommendation:");
            CollaborativeRecommender collaborativeRecommender = new CollaborativeRecommender();
            collaborativeRecommender.simulateUserRatings(movies);
            List<Movie> collaborativeRecommendations = collaborativeRecommender.recommend(movies, 1); // 사용자 ID: 1

            for (Movie movie : collaborativeRecommendations) {
                System.out.println(movie.getTitle());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
