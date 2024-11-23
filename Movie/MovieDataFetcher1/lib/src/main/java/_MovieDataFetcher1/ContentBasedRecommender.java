package _MovieDataFetcher1;

import java.util.ArrayList;
import java.util.List;

public class ContentBasedRecommender {

    public List<Movie> recommend(List<Movie> movies, Movie targetMovie) {
        List<Movie> recommendations = new ArrayList<>();
        for (Movie movie : movies) {
            if (!movie.equals(targetMovie) && movie.getGenreIds().equals(targetMovie.getGenreIds())) {
                recommendations.add(movie);
            }
        }
        return recommendations;
    }
}
