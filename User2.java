import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String password;
    private List<String> favoriteGenres;

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
        this.favoriteGenres = new ArrayList<>();
    }

    public String getUserId() { return userId; }
    public String getPassword() { return password; }
    public List<String> getFavoriteGenres() { return favoriteGenres; }

    public void addFavoriteGenre(String genre) {
        if (!favoriteGenres.contains(genre)) {
            favoriteGenres.add(genre);
        }
    }

    public String getGenresAsString() {
        return String.join("|", favoriteGenres);
    }
}
