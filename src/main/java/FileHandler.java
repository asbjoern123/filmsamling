import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class FileHandler {
    private String fileName;
    private static final String HEADER = "title;director;yearCreated;inColor;lengthInMinutes;genre;lastWatched";
    public FileHandler(String fileName) {
        this.fileName = fileName;
    }

    private String toCsvLine(Movie movie) {
        String lastWatched = "";
        if (movie.hasBeenWatched()) {
            lastWatched = movie.getLastWatchedDate().toString();
        }
        return movie.getTitle() + ";" + movie.getDirector() + ";" + movie.getYearCreated() + ";" + movie.isInColor() + ";" + movie.getLengthInMinutes() + ";" + movie.getGenre() + ";" + lastWatched;
    }
    public void saveMovies(ArrayList<Movie> movies) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File(fileName));
        output.println(HEADER);

        for (Movie movie : movies) {
            output.println(toCsvLine(movie));
        }

        output.close();
    }
}
