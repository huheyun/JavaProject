package _MovieDataFetcher1;

import java.util.List;

public class Movie {
    private int id;
    private String title;
    private List<Integer> genreIds;
    private String releaseDate;
    private double voteAverage;
    private String overview;

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<Integer> getGenreIds() {
        return genreIds;
    }
    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    public double getVoteAverage() {
        return voteAverage;
    }
    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }
    public String getOverview() {
        return overview;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }
}
