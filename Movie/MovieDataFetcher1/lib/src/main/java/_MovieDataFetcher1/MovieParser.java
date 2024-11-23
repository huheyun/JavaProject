package _MovieDataFetcher1;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class MovieParser {

    public static List<Movie> parseMovies(String jsonResponse) throws Exception {
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

            List<Integer> genreIds = new ArrayList<>();
            for (JsonNode genreId : node.get("genre_ids")) {
                genreIds.add(genreId.asInt());
            }
            movie.setGenreIds(genreIds);

            movies.add(movie);
        }
        return movies;
    }
}
