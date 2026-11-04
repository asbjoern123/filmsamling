package domainmodel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ComparatorTest {

    private Movie movie1;
    private Movie movie2;

    @BeforeEach
    void setUp() {
        movie1 = new Movie("Alien", "Alfred Hitchcock", 1990, true, 90, "Gyser");
        movie2 = new Movie("Jaws", "Steven Spielberg", 2000, true, 120, "Thriller");
    }

    @Test
    void titleComparatorSortsAlphabetically(){
        // Arrange
        TitleComparator comparator = new TitleComparator();

        // Act
        int forward = comparator.compare(movie1, movie2);
        int backward = comparator.compare(movie2, movie1);

        // Assert
        assertTrue(forward < 0);
        assertTrue(backward > 0);
    }

    @Test
    void directorComparatorSortsAlphabetically(){

        // Arrange
        DirectorComparator comparator = new DirectorComparator();

        // Act
        int forward = comparator.compare(movie1, movie2);
        int backward = comparator.compare(movie2, movie1);

        // Assert
        assertTrue(forward < 0);
        assertTrue(backward > 0);

    }
    @Test
    void genreComparatorSortsAlphabetically(){

        // Arrange
        GenreComparator comparator = new GenreComparator();

        // Act
        int forward = comparator.compare(movie1, movie2);
        int backward = comparator.compare(movie2, movie1);

        // Assert
        assertTrue(forward < 0);
        assertTrue(backward > 0);


    }
    @Test
    void yearComparatorSortsOldestFirst(){

        // Arrange
        YearComparator comparator = new YearComparator();

        // Act
        int forward = comparator.compare(movie1, movie2);
        int backward = comparator.compare(movie2, movie1);

        // Assert
        assertTrue(forward < 0);
        assertTrue(backward > 0);

    }

    @Test
    void lengthComparatorSortsShortestFirst(){

        // Arrange
        LengthComparator comparator = new LengthComparator();

        // Act
        int forward = comparator.compare(movie1, movie2);
        int backward = comparator.compare(movie2, movie1);

        // Assert
        assertTrue(forward < 0);
        assertTrue(backward > 0);


    }

    @Test
    void titleComparatorIgnoresCase(){

        // Arrange
        TitleComparator comparator = new TitleComparator();
        movie1.setTitle("Alien");
        movie2.setTitle("ALIEN");

        // Act
        int result = comparator.compare(movie1, movie2);

        // Assert
        assertEquals(0, result);

    }
    @Test
    void getMoviesSortedSortsByTitel(){
        MovieCollection movieCollection = new MovieCollection();
        movieCollection.addMovie("Zebra", "Forfatter A", 2000, true, 90,"Drama");
        movieCollection.addMovie("Alfa", "Forfatter B", 1999, true, 90,"Drama");

        ArrayList<Movie> sorted = movieCollection.getMoviesSorted(new TitleComparator());


        assertEquals("Alfa", sorted.get(0).getTitle());
        assertEquals("Zebra", sorted.get(1).getTitle());
    }
    @Test
    void getMoviesSortedByReturnsSortedList() {
        Controller controller = new Controller();
        controller.addMovie("Zebra", "Forfatter A", 2000, true,300, "Drama");
        controller.addMovie("Alfa", "Forfatter B", 1999, true, 250, "Drama");

        ArrayList<Movie> sorted = controller.getMoviesSortedBy(SortField.TITLE);

        assertEquals("Alfa", sorted.get(0).getTitle());
        assertEquals("Zebra", sorted.get(1).getTitle());

    }


}
