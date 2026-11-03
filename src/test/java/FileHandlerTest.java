import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class FileHandlerTest {
    private static final String TEST_FILE = "test-movies.csv";

    @AfterEach
    void deleteTestFile() {
        new File(TEST_FILE).delete();
    }


    @Test
    void loadingMissingFileThrowsException() {
        File file = new File(TEST_FILE);
        if (file.exists()) {
            file.delete();
        }
        FileHandler fileHandler = new FileHandler(TEST_FILE);

        assertThrows(FileNotFoundException.class, () -> {
            fileHandler.loadMovies();
        });
    }
    @Test
    void invalidLinesAreSkipped() throws FileNotFoundException {
        PrintStream skriver = new PrintStream(new File(TEST_FILE));
        skriver.println("title;author;yearPublished;isHardcover;pages;genre;lastBorrowed");
        skriver.println("Dune;Frank Herbert;1965;true;412;Sci-fi;");
        skriver.println("Kun;to;felter");
        skriver.println("Titel;Forfatter;ikkeEtTal;true;300;Genre;");
        skriver.close();

        FileHandler fileHandler = new FileHandler(TEST_FILE);
        ArrayList<Movie> movies = fileHandler.loadMovies();

        assertEquals(1, movies.size());
        assertEquals("Dune",movies.get(0).getTitle());
        assertEquals(2, fileHandler.getSkippedLineCount());

    }

}


