import java.util.ArrayList;

public class Controller {

    private MovieCollection movieCollection = new MovieCollection();

    public void addMovie(String title, String director, int yearCreated, boolean inColor, int lengthInMinutes, String genre) {
        movieCollection.addMovie(title, director, yearCreated, inColor, lengthInMinutes, genre);
    }

    public ArrayList<Movie> getMovies() {
        return movieCollection.getMovies();
    }

    public ArrayList<Movie> searchMovies(String searchText) {
        return movieCollection.searchMovies(searchText);
    }

    public boolean editMovie(Movie movie, String title, String director, int yearCreated, boolean inColor, int lengthInMinutes, String genre) {
        return movieCollection.editMovie(movie, title, director, yearCreated, inColor, lengthInMinutes, genre);
    }

    public boolean deleteMovie(Movie movie) {
        if(movieCollection.getMovies().contains(movie)){
            return movieCollection.deleteMovie(movie);
        }
        else {
            return false;
        }
    }
}



