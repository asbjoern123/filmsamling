import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MovieCollectionTest {

    private MovieCollection collection;

    @BeforeEach
    void setUp() {
        // Kører før HVER test – så starter alle tests med den samme, friske samling
        collection = new MovieCollection();
        collection.addMovie("The Godfather", "Francis Ford Coppola", 1972, true, 175, "Crime", LocalDate.now());
        collection.addMovie("Casablanca", "Michael Curtiz", 1942, false, 102, "Drama", LocalDate.now());
        collection.addMovie("Godzilla", "Ishirō Honda", 1954, false, 96, "Sci-fi", LocalDate.now());
    }

    @Test
    void newCollectionHasNoMovies() {
        // Arrange
        MovieCollection movieCollection = new MovieCollection();

        // Act
        int result = movieCollection.getNumberOfMovies();

        // Assert
        assertEquals(0, result);
    }

    @Test
    void addOneMovie() {
        // Arrange
        MovieCollection movieCollection = new MovieCollection();

        // Act
        movieCollection.addMovie("Jaws", "Steven Spielberg", 1995, true, 124, "Thriller", LocalDate.now());

        // Assert
        assertEquals("Jaws", movieCollection.getMovies().get(0).getTitle());
        assertEquals(1, movieCollection.getNumberOfMovies());
    }

    @Test
    void addMultipleMovies() {
        // Arrange
        // Intet, "setup" har allerede lavet en samling med 3 film

        // Act
        collection.addMovie("Jaws", "Steven Spielberg", 1995, true, 124, "Thriller", LocalDate.now());
        collection.addMovie("Jaws2", "Steven Spielberg", 1995, true, 127, "Thriller", LocalDate.now());

        // Assert
        assertEquals(5, collection.getNumberOfMovies());
    }

    @Test
    void editMovieChangesInfo() {
        // Arrange
        Movie movie = collection.getMovies().get(0);

        // Act
        boolean result = collection.editMovie(movie, "Shrek", "James", 2002, true, 129, "Comedy", LocalDate.now());

        // Assert
        assertEquals("Shrek", movie.getTitle());
        assertTrue(result);
    }

    @Test
    void editMovieNotInCollection() {
        // Arrange
        Movie movie = new Movie("Titanic", "James Cameron", 1997, true, 195, "Drama", LocalDate.now());

        // Act
        boolean result = collection.editMovie(movie, "Shrek", "James", 2002, true, 129, "Comedy", LocalDate.now());

        // Assert
        assertFalse(result);
        assertEquals("Titanic", movie.getTitle());
    }

    @Test
    void searchMoviesNoMatch() {
        ArrayList<Movie> result = collection.searchMovies("blablabla");

        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    void searchMovies1Match() {
        ArrayList<Movie> result = collection.searchMovies("godfather");

        assertEquals(1, result.size());
    }

    @Test
    void searchMoviesflereMatches() {
        ArrayList<Movie> result = collection.searchMovies("god");

        assertEquals(2, result.size());
    }

    @Test
    void searchmoviesIgnoresCaps() {
        ArrayList<Movie> result = collection.searchMovies("GODFATHER");

        assertEquals(1, result.size());
    }

    @Test
    void deletemovie() {
        Movie godfather = collection.searchMovies("godfather").get(0);

        boolean deletemovie = collection.deleteMovie(godfather);

        assertTrue(deletemovie);
        assertTrue(collection.searchMovies("godfather").isEmpty());
        assertEquals(2, collection.getMovies().size());
    }

    @Test
    void deleteMovieThatDosentExist() {
        Movie blablabla = new Movie("blablabla", "ask", 1990, true, 90, "gyser", LocalDate.now());

        boolean deletemovie = collection.deleteMovie(blablabla);

        assertFalse(deletemovie);
        assertEquals(3, collection.getMovies().size());
    }

    @Test
    void editWithInvalidValueChangesNothing() {
        // Arrange
        Movie casablanca = collection.searchMovies("casablanca").get(0);

        // Act
        assertThrows(IllegalArgumentException.class, () -> {
            collection.editMovie(casablanca, "Casablanca 2", "Michael Curtiz", 1800, false, 102, "Drama", LocalDate.now());
        });

        // Assert
        assertEquals("Casablanca", casablanca.getTitle());
        assertEquals(1942, casablanca.getYearCreated());
    }
}