package _MovieDataFetcher1;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MovieFetcher {
    private static final String API_KEY = "YOUR_API_KEY";
    private static final String API_URL = "https://api.themoviedb.org/3/discover/movie";

    public static String fetchMovies() throws Exception {
        OkHttpClient client = new OkHttpClient();

        String url = API_URL + "?sort_by=popularity.desc&api_key=" + API_KEY + "&language=ko-KR";

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RuntimeException("HTTP Request Failed: " + response.code());
            }
            return response.body().string();
        }
    }
}
