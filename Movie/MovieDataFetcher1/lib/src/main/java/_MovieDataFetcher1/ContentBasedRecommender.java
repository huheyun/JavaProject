package _MovieDataFetcher1;

import java.util.ArrayList;
import java.util.List;

public class ContentBasedRecommender {

    // 선택한 영화와 비슷한 영화 추천
    public List<Movie> recommend(List<Movie> movies, Movie targetMovie) {
        List<Movie> recommendations = new ArrayList<>();

        for (Movie movie : movies) {
            // 같은 영화를 제외하고, 장르가 겹치는 영화 추천
            if (!movie.equals(targetMovie) && hasCommonGenres(movie, targetMovie)) {
                recommendations.add(movie);
            }
        }

        return recommendations;
    }

    // 두 영화의 장르가 겹치는지 확인
    private boolean hasCommonGenres(Movie movie1, Movie movie2) {
        for (int genreId : movie1.getGenreIds()) {
            if (movie2.getGenreIds().contains(genreId)) {
                return true;
            }
        }
        return false;
    }
}
