import org.junit.jupiter.api.Test;

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
}