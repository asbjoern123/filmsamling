import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    void constructorSetsAllFields() {
        Movie movie = new Movie(
                "The Hunger Games", "Gary Ross", 2012, true, 142, "Action",LocalDate.now());

        assertEquals("The Hunger Games", movie.getTitle());
        assertEquals("Gary Ross", movie.getDirector());
        assertEquals(2012, movie.getYearCreated());
        assertTrue(movie.isInColor());
        assertEquals(142, movie.getLengthInMinutes());
        assertEquals("Action", movie.getGenre());
    }

    @Test
    void setTitleChangesTitle() {
        Movie movie = new Movie(
                "The Hunger Games", "Gary Ross", 2012, true, 142, "Action",LocalDate.now());

        movie.setTitle("Hunger Games");

        assertEquals("Hunger Games", movie.getTitle());
    }

    @Test
    void setInvalidYearCreated(){
        // Arrange
        Movie movie = new Movie("The Hunger Games", "Gary Ross", 2025, true, 142, "Action", LocalDate.now());

        // Act + Assert
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            movie.setYearCreated(LocalDate.now().plusYears(2).getYear());
        });
    }

    @Test
    void setInvalidTitle(){
        // Arrange
        Movie movie = new Movie("The Hunger Games", "Gary Ross", 2025, true, 142, "Action", LocalDate.now());

        // Act + Asserts
        Assertions.assertThrows(NullPointerException.class, () ->{
            movie.setTitle(null);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            movie.setTitle("");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            movie.setTitle(" ");
        });
    }
    @Test
    void setInvalidDirector(){
        // Arrange
        Movie movie = new Movie("The Hunger Games", "Gary Ross", 2025, true, 142, "Action", LocalDate.now());

        // Act + Asserts
        Assertions.assertThrows(NullPointerException.class, () ->{
            movie.setDirector(null);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            movie.setDirector("");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            movie.setDirector(" ");
        });
    }

    @Test
    void setInvalidGenre(){
        // Arrange
        Movie movie = new Movie("The Hunger Games", "Gary Ross", 2025, true, 142, "Action", LocalDate.now());

        // Act + Asserts
        Assertions.assertThrows(NullPointerException.class, () ->{
            movie.setGenre(null);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            movie.setGenre("");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            movie.setGenre(" ");
        });
    }

    @Test
    void setInvalidLength(){
        // Arrange
        Movie movie = new Movie("The Hunger Games", "Gary Ross", 2025, true, 142, "Action", LocalDate.now());

        // Act + Asserts
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            movie.setLengthInMinutes(-1);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            movie.setLengthInMinutes(0);
        });
    }
    @Test
    void futureWatchDateIsRejected() {
        LocalDate oldDate = LocalDate.of(2025, 1, 1);

        Movie movie = new Movie(
                "The Hunger Games", "Gary Ross", 2012,
                true, 142, "Action", oldDate
        );

        assertThrows(IllegalArgumentException.class, () -> {
            movie.markAsWatched(LocalDate.now().plusYears(1));
        });

        assertEquals(oldDate, movie.getLastWatchedDate());
    }

    @Test
    void canMakeMovieYear1888(){
        // Arrange + Act + Assert
        Assertions.assertDoesNotThrow(() ->{
                Movie movie = new Movie("The Hunger Games", "Gary Ross", 1888, true, 142, "Action", LocalDate.now());
        });
    }
    @Test
    void daysSinceWatchedCountsAcrossMonths() {
        // Arrange
        Movie movie = new Movie("Jaws", "Steven Spielberg", 1975, true, 124, "Thriller", LocalDate.now());
        movie.setLastWatchedDate(LocalDate.of(2025, 9, 26));
    }

    @Test
    void year1887IsRejected() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Movie(
                    "The Hunger Games",
                    "Gary Ross",
                    1887,
                    true,
                    142,
                    "Action",
                    LocalDate.of(2025, 1, 1)
            );
        });
    }
    @Test
    void invalidTitleKeepsOldTitle() {
        Movie movie = new Movie(
                "The Hunger Games", "Gary Ross", 2012,
                true, 142, "Action", LocalDate.of(2025, 1, 1)
        );

        // Act
        long days = movie.getLastWatchedDate().getDayOfMonth();

        // Assert
        assertEquals(26, days);

        assertThrows(IllegalArgumentException.class, () -> {
            movie.setTitle("");
        });

        assertEquals("The Hunger Games", movie.getTitle());
    }

    @Test
    void newMovieStartsUnwatched() {
        Movie movie = new Movie(
                "The Hunger Games", "Gary Ross", 2012,
                true, 142, "Action"
        );

        assertNull(movie.getLastWatchedDate());
    }
}