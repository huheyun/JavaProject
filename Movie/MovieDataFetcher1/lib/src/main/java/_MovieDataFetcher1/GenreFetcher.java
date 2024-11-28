package _MovieDataFetcher1;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.HashMap;
import java.util.Map;

public class GenreFetcher {
    private static final String API_KEY = "73e437a2cc6f065cbaf58c32d011f598";
    private static final String GENRE_URL = "https://api.themoviedb.org/3/genre/movie/list";

    public static Map<Integer, String> fetchGenres() throws Exception {
        OkHttpClient client = new OkHttpClient();

        String url = GENRE_URL + "?api_key=" + API_KEY + "&language=ko-KR";
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RuntimeException("HTTP Request Failed: " + response.code());
            }

            String jsonResponse = response.body().string();
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(jsonResponse);

            Map<Integer, String> genreMap = new HashMap<>();
            for (JsonNode genre : root.get("genres")) {
                genreMap.put(genre.get("id").asInt(), genre.get("name").asText());
            }
            return genreMap;
        }
    }
}
