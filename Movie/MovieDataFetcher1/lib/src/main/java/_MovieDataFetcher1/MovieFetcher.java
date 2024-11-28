package _MovieDataFetcher1;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MovieFetcher {
    private static final String API_KEY = "73e437a2cc6f065cbaf58c32d011f598";
    private static final String MOVIE_URL = "https://api.themoviedb.org/3/discover/movie";

    public String fetchMovies(int page) throws Exception {
        OkHttpClient client = new OkHttpClient();

        String url = MOVIE_URL + "?sort_by=popularity.desc&api_key=" + API_KEY + "&language=ko-KR&watch_region=KR&page=" + page;

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

    public String fetchCredits(int movieId) throws Exception {
        OkHttpClient client = new OkHttpClient();
        String url = "https://api.themoviedb.org/3/movie/" + movieId + "/credits?api_key=" + API_KEY;

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
