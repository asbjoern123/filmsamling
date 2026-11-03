package domainmodel;

import datasource.FileHandler;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    private MovieCollection movieCollection = new MovieCollection();
    private FileHandler fileHandler = new FileHandler("movies.csv");
    private boolean changed;

    public void addMovie(String title, String director, int yearCreated, boolean inColor, int lengthInMinutes, String genre) {
        movieCollection.addMovie(title, director, yearCreated, inColor, lengthInMinutes, genre);
        changed = true;
    }


    public ArrayList<Movie> getMovies() {
        return movieCollection.getMovies();
    }

    public ArrayList<Movie> searchMovies(String searchText) {
        return movieCollection.searchMovies(searchText);
    }

    public boolean editMovie(Movie movie, String title, String director, int yearCreated, boolean inColor, int lengthInMinutes, String genre) {
        boolean edited = movieCollection.editMovie(movie, title, director, yearCreated, inColor, lengthInMinutes, genre);
        if (edited) {
            changed = true;
        }

        return edited;
    }

    public boolean deleteMovie(Movie movie) {
        if (movieCollection.getMovies().contains(movie)) {
            boolean deleted = movieCollection.deleteMovie(movie);
            if (deleted) {
                changed = true;
            }
            return deleted;
        } else {
            return false;
        }
    }

    public void markAsWatched(Movie movie, LocalDate date) {
        movie.markAsWatched(date);
        changed = true;
    }

    public ArrayList<Movie> getMoviesNotWatchedForDays(int days) {
        LocalDate cutoff = LocalDate.now().minusDays(days);
        return movieCollection.getMoviesNotWatchedSince(cutoff);
    }

    public int loadMovies() throws FileNotFoundException {
        int loadCount = 0;
        for (Movie movie : fileHandler.loadMovies()) {
            movieCollection.addMovie(movie);
            loadCount++;
        }
        return loadCount;
    }

    public boolean saveMoviesIfChanged() throws FileNotFoundException {
        if (!changed) {
            return false;
        }
        fileHandler.saveMovies(movieCollection.getMovies());
        changed = false;
        return true;
    }

    public int getSkippedLineCount() {
        return fileHandler.getSkippedLineCount();
    }

}



