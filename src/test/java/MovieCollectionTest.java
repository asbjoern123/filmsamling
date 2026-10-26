import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MovieCollectionTest {

    private MovieCollection collection;

    @BeforeEach
    void setUp(){
        // Kører før HVER test – så starter alle tests med den samme, friske samling
        collection = new MovieCollection();
        collection.addMovie("The Godfather", "Francis Ford Coppola", 1972, true, 175, "Crime");
        collection.addMovie("Casablanca", "Michael Curtiz", 1942, false, 102, "Drama");
        collection.addMovie("Godzilla", "Ishirō Honda", 1954, false, 96, "Sci-fi");
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

        // Act

        // Assert
    }

    @Test
    void searchMoviesNoMatch(){
        ArrayList<Movie> result = collection.searchMovies("blablabla");

        assertNotNull(result);
        assertEquals(0, result.size());
    }
    @Test
    void searchMovies1Match(){
        ArrayList<Movie> result = collection.searchMovies("godfather");

        assertEquals(1, result.size());
    }
    @Test
    void searchMoviesflereMatches(){
        ArrayList<Movie> result = collection.searchMovies("god");

        assertEquals(2, result.size());
    }
    @Test
    void searchmoviesIgnoresCaps(){
        ArrayList<Movie> result = collection.searchMovies("GODFATHER");

        assertEquals(1, result.size());
    }
    @Test
    void deletemovie(){
        Movie godfather = collection.searchMovies("godfather").get(0);

        boolean deletemovie = collection.deleteMovie(godfather);

        assertTrue(deletemovie);
        assertTrue(collection.searchMovies("godfather").isEmpty());
        assertEquals(2,collection.getMovies().size());
    }
    @Test
    void deleteMovieThatDosentExist(){
        MovieCollection movies = new MovieCollection();
        movies.addMovie("okidoki","ask",1990,true,90,"gyser");

        Movie blablabla = new Movie("blablabla","ask",1990,true,90,"gyser");

        boolean deletemovie = collection.deleteMovie(blablabla);

        assertFalse(deletemovie);
        assertEquals(1,collection.getMovies().size());
    }
}