package def;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private Map<String, Integer> genrePreference;
    private Map<String, Integer> directorPreference;
    private Map<String, Integer> actorPreference;
    private Map<Movie, Integer> ratings;  // 평가한 영화와 평점

    // Constructor
    public User(String name) {
        this.name = name;
        this.genrePreference = new HashMap<>();
        this.directorPreference = new HashMap<>();
        this.actorPreference = new HashMap<>();
        this.ratings = new HashMap<>();
    }

    // Getters and setters
    public String getName() { return name; }
    public Map<String, Integer> getGenrePreference() { return genrePreference; }
    public Map<String, Integer> getDirectorPreference() { return directorPreference; }
    public Map<String, Integer> getActorPreference() { return actorPreference; }
    public Map<Movie, Integer> getRatings() { return ratings; }

    // Method to add rating for a movie
    public void addRating(Movie movie, int rating) {
        ratings.put(movie, rating);
    }
}
