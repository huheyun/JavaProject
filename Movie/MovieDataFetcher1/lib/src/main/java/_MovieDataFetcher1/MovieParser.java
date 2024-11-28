package _MovieDataFetcher1;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MovieParser {

    private final MovieFetcher fetcher;

    public MovieParser() {
        this.fetcher = new MovieFetcher();
    }

    // 영화 데이터 파싱
    public List<Movie> parseMovies(String jsonResponse, Map<Integer, String> genreMap) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(jsonResponse);
        JsonNode results = root.get("results");

        List<Movie> movies = new ArrayList<>();
        for (JsonNode node : results) {
            Movie movie = new Movie();
            movie.setId(node.get("id").asInt());
            movie.setTitle(node.get("title").asText());
            movie.setVoteAverage(node.get("vote_average").asDouble());
            movie.setOverview(node.get("overview").asText());

            // 장르 ID -> 이름 변환
            List<String> genreNames = new ArrayList<>();
            for (JsonNode genreId : node.get("genre_ids")) {
                if (genreMap.containsKey(genreId.asInt())) {
                    genreNames.add(genreMap.get(genreId.asInt()));
                }
            }
            movie.setGenreNames(genreNames);

            // 크레딧 데이터 병합
            addCreditsToMovie(movie);

            movies.add(movie);
        }
        return movies;
    }

    // 크레딧 데이터 병합
    private void addCreditsToMovie(Movie movie) throws Exception {
        String creditsJson = fetcher.fetchCredits(movie.getId());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(creditsJson);

        // 감독 정보 추가
        JsonNode crew = root.get("crew");
        for (JsonNode person : crew) {
            if ("Director".equals(person.get("job").asText())) {
                movie.setDirector(person.get("name").asText());
                break;
            }
        }

        // 배우 정보 추가
        JsonNode cast = root.get("cast");
        List<String> actors = new ArrayList<>();
        for (JsonNode person : cast) {
            actors.add(person.get("name").asText());
        }
        movie.setActors(actors);
    }
}