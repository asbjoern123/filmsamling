import java.time.LocalDate;
import java.util.ArrayList;

public class MovieCollection {
    private ArrayList<Movie> movies;

    public MovieCollection() {
        this.movies = new ArrayList<>();
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void addMovie(String title, String director, int yearCreated, boolean inColor, int lengthInMinutes, String genre, LocalDate date) {
        movies.add(new Movie(title, director, yearCreated, inColor, lengthInMinutes, genre, date));
    }

    public int getNumberOfMovies() {

        return movies.size();
    }

    public boolean deleteMovie(Movie movie) {
        return movies.remove(movie);
    }

    public boolean editMovie(Movie movie, String title, String director, int yearCreated, boolean inColor, int lengthInMinutes, String genre,LocalDate date) {
        if (!movies.contains(movie)) {
            return false;
        }
        movie.setTitle(title);
        movie.setDirector(director);
        movie.setGenre(genre);
        movie.setInColor(inColor);
        movie.setLengthInMinutes(lengthInMinutes);
        movie.setYearCreated(yearCreated);
        movie.setLastWatchedDate(date);
        return true;
    }

    public ArrayList<Movie> searchMovies(String searchText){
        ArrayList<Movie> matches = new ArrayList<>();

        for(Movie movie:movies){
            if(movie.getTitle().toLowerCase().contains(searchText.toLowerCase()))
            {
                matches.add(movie);
            }
        }
        return matches;
    }

}
