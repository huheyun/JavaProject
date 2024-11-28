package _MovieDataFetcher1;

import java.util.Arrays;
import java.util.List;

public class User {
    private String name; // 사용자 이름
    private String favoriteGenres; // 선호 장르 (쉼표로 구분된 문자열)
    private String favoriteActors; // 선호 배우 (쉼표로 구분된 문자열)
    private String favoriteDirectors; // 선호 감독 (쉼표로 구분된 문자열)
    public User() {
    	return;
    }
    // 생성자
    public User(String name, String favoriteGenres, String favoriteActors, String favoriteDirectors) {
        this.name = name;
        this.favoriteGenres = favoriteGenres;
        this.favoriteActors = favoriteActors;
        this.favoriteDirectors = favoriteDirectors;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteGenres() {
        return favoriteGenres;
    }

    public void setFavoriteGenres(String favoriteGenres) {
        this.favoriteGenres = favoriteGenres;
    }

    public String getFavoriteActors() {
        return favoriteActors;
    }

    public void setFavoriteActors(String favoriteActors) {
        this.favoriteActors = favoriteActors;
    }

    public String getFavoriteDirectors() {
        return favoriteDirectors;
    }

    public void setFavoriteDirectors(String favoriteDirectors) {
        this.favoriteDirectors = favoriteDirectors;
    }

    // 쉼표로 구분된 문자열을 리스트로 변환
    public List<String> getFavoriteGenresAsList() {
        return Arrays.asList(favoriteGenres.split(","));
    }

    public List<String> getFavoriteActorsAsList() {
        return Arrays.asList(favoriteActors.split(","));
    }

    public List<String> getFavoriteDirectorsAsList() {
        return Arrays.asList(favoriteDirectors.split(","));
    }
}
