import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    void constructorSetsAllFields() {
        Movie movie = new Movie(
                "The Hunger Games", "Gary Ross", 2012, true, 142, "Action",null);

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
                "The Hunger Games", "Gary Ross", 2012, true, 142, "Action",null);

        movie.setTitle("Hunger Games");

        assertEquals("Hunger Games", movie.getTitle());
    }

    @Test
    void setInvalidYearCreated(){
        // Arrange
        Movie movie = new Movie("The Hunger Games", "Gary Ross", 2025, true, 142, "Action", null);

        // Act + Assert
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            movie.setYearCreated(6767);
        });
    }

    @Test
    void setInvalidTitle(){
        // Arrange
        Movie movie = new Movie("The Hunger Games", "Gary Ross", 2025, true, 142, "Action", null);

        // Act + Asserts
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
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
        Movie movie = new Movie("The Hunger Games", "Gary Ross", 2025, true, 142, "Action", null);

        // Act + Asserts
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
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
        Movie movie = new Movie("The Hunger Games", "Gary Ross", 2025, true, 142, "Action", null);

        // Act + Asserts
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
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
        Movie movie = new Movie("The Hunger Games", "Gary Ross", 2025, true, 142, "Action", null);

        // Act + Asserts
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            movie.setLengthInMinutes(-1);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            movie.setLengthInMinutes(0);
        });
    }
    @Test
    void setInvalidWatchDate(){
        Movie movie = new Movie("The Hunger Games", "Gary Ross", 2025, true, 142, "Action", null);

        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            movie.setDate(LocalDate.parse("01-01-3000"));
        });
    }





}