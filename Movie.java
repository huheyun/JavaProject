package def;
import java.util.List;

public class Movie {
    private String title;
    private String genre;
    private String director;
    private List<String> actors;
    private double rating;
    private String synopsis;

    // Constructor
    public Movie(String title, String genre, String director, List<String> actors, double rating, String synopsis) {
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.actors = actors;
        this.rating = rating;
        this.synopsis = synopsis;
    }

    // Getters and setters
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public String getDirector() { return director; }
    public List<String> getActors() { return actors; }
    public double getRating() { return rating; }
    public String getSynopsis() { return synopsis; }
}
