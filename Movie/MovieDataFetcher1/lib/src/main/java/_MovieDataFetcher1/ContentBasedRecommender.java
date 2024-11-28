package _MovieDataFetcher1;

import java.util.ArrayList;
import java.util.List;

public class ContentBasedRecommender {

    // 사용자 선호를 기반으로 영화 추천
    public List<Movie> recommend(List<Movie> movies, User user) {
        List<Movie> recommendations = new ArrayList<>();

        // 사용자 선호 정보
        List<String> preferredGenres = user.getFavoriteGenresAsList();
        List<String> preferredActors = user.getFavoriteActorsAsList();
        List<String> preferredDirectors = user.getFavoriteDirectorsAsList();

        // 영화 데이터를 기반으로 추천
        for (Movie movie : movies) {
            boolean matchesGenre = matchesAny(preferredGenres, movie.getGenreNames());
            boolean matchesActor = matchesAny(preferredActors, movie.getActors());
            boolean matchesDirector = preferredDirectors.contains(movie.getDirector());

            // 하나 이상의 조건에 부합하면 추천
            if (matchesGenre || matchesActor || matchesDirector) {
                recommendations.add(movie);
            }
        }

        return recommendations;
    }

    // 리스트 간의 일치 여부 확인 (대소문자 무시)
    private boolean matchesAny(List<String> preferredList, List<String> movieList) {
        for (String preferred : preferredList) {
            for (String item : movieList) {
                if (preferred.equalsIgnoreCase(item)) {
                    return true;
                }
            }
        }
        return false;
    }
}
