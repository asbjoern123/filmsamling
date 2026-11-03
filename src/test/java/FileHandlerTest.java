import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;


public class FileHandlerTest {
    private static final String TEST_FILE = "test-movies.csv";

    @AfterEach
    void deleteTestFile() {
        new File(TEST_FILE).delete();
    }

    @Test
    void savedMoviesCanBeLoadedAgain() throws FileNotFoundException {
        //Arrange
        FileHandler fileHandlerTest = new FileHandler(TEST_FILE);
        MovieCollection collection = new MovieCollection();
        Movie movie1 = new Movie("The Godfather", "Francis Ford Coppola", 1972, true, 175, "Crime");
        Movie movie2 = new Movie("ÆÅØ the movie", "Michael Curtiz", 1942, false, 102, "Drama", LocalDate.of(2004, 9, 23));
        collection.addMovie(movie1);
        collection.addMovie(movie2);

        // Act
        fileHandlerTest.saveMovies(collection.getMovies());
        ArrayList<Movie> loaded = fileHandlerTest.loadMovies();

        // Assert
        assertEquals(2, loaded.size());

        Movie movie1Result = loaded.getFirst();
        Movie movie2Result = loaded.get(1);

        assertEquals(movie1.getTitle(), movie1Result.getTitle());
        assertEquals(movie2.getTitle(), movie2Result.getTitle());

        assertEquals(movie1.getDirector(), movie1Result.getDirector());
        assertEquals(movie2.getDirector(), movie2Result.getDirector());

        assertEquals(movie1.getYearCreated(), movie1Result.getYearCreated());
        assertEquals(movie2.getYearCreated(), movie2Result.getYearCreated());

        assertTrue(movie1Result.isInColor());
        assertFalse(movie2Result.isInColor());

        assertEquals(movie1.getLengthInMinutes(), movie1Result.getLengthInMinutes());
        assertEquals(movie2.getLengthInMinutes(), movie2Result.getLengthInMinutes());

        assertEquals(movie1.getGenre(), movie1Result.getGenre());
        assertEquals(movie2.getGenre(), movie2Result.getGenre());

        assertNull(movie1Result.getLastWatchedDate());
        assertEquals(LocalDate.of(2004, 9, 23), movie2Result.getLastWatchedDate());
    }

    @Test
    void emptyListCanBeSavedAndLoaded() throws FileNotFoundException {
        // Arrange
        FileHandler fileHandlerTest = new FileHandler(TEST_FILE);
        MovieCollection collection = new MovieCollection();

        // Act
        fileHandlerTest.saveMovies(collection.getMovies());
        ArrayList<Movie> loaded = fileHandlerTest.loadMovies();

        // Assert
        assertEquals(0, loaded.size());

    }

    @Test
    void loadingMissingFileThrowsException() {
        File file = new File(TEST_FILE);
        if (file.exists()) {
            file.delete();
        }
        FileHandler fileHandler = new FileHandler(TEST_FILE);

        assertFalse(file.exists());
        assertThrows(FileNotFoundException.class, () -> {
            fileHandler.loadMovies();
        });
    }
    @Test
    void invalidLinesAreSkipped() throws FileNotFoundException {
        PrintStream output = new PrintStream(new File(TEST_FILE));
        output.println("title;director;yearCreated;inColor;lengthInMinutes;genre;lastWatched");
        output.println("Dune;Denis Villeneuve;2021;true;155;Sci-fi;");
        output.println("Kun;to;felter");
        output.println("Titel;Forfatter;ikkeEtTal;true;300;Genre;");
        output.close();

        FileHandler fileHandler = new FileHandler(TEST_FILE);
        ArrayList<Movie> movies = fileHandler.loadMovies();

        assertEquals(1, movies.size());
        assertEquals("Dune",movies.get(0).getTitle());
        assertEquals(2, fileHandler.getSkippedLineCount());
    }

}


