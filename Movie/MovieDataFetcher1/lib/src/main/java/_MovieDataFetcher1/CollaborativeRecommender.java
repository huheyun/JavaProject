package _MovieDataFetcher1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollaborativeRecommender {
    private Map<Integer, Map<Integer, Double>> userRatings = new HashMap<>();

    public void simulateUserRatings(List<Movie> movies) {
        for (int userId = 1; userId <= 5; userId++) {
            Map<Integer, Double> ratings = new HashMap<>();
            for (Movie movie : movies) {
                ratings.put(movie.getId(), Math.random() * 5); // 랜덤 평점
            }
            userRatings.put(userId, ratings);
        }
    }

    public List<Movie> recommend(List<Movie> movies, int userId) {
        // 간단한 임의 추천
        return new ArrayList<>(movies.subList(0, 5));
    }
}
