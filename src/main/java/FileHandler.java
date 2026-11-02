import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private String fileName;
    private static final String HEADER = "title;director;yearCreated;inColor;lengthInMinutes;genre;lastWatched";
    private int skippedLineCount;

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

    private Movie parseMovie(String line) {
        String[] fields = line.split(";", -1);

        if (fields.length != 7) {
            return null;
        }

        try {
            String title = fields[0];
            String director = fields[1];
            int yearCreated = Integer.parseInt(fields[2]);
            boolean inColor = Boolean.parseBoolean(fields[3]);
            int lengthInMinutes = Integer.parseInt(fields[4]);
            String genre = fields[5];

            Movie movie = new Movie(title, director, yearCreated, inColor, lengthInMinutes, genre);

            if (!fields[6].isEmpty()) {
                movie.markAsWatched(LocalDate.parse(fields[6]));
            }
            return movie;

        } catch (IllegalArgumentException e) {
            return null;
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public ArrayList<Movie> loadMovies() throws FileNotFoundException {
        ArrayList<Movie> movies = new ArrayList<>();
        skippedLineCount = 0;

        Scanner scanner = new Scanner(new File(fileName));

        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Movie movie = parseMovie(line);

            if (movie == null) {
                skippedLineCount++;
            } else {
                movies.add(movie);
            }
        }

        scanner.close();
        return movies;
    }

    public int getSkippedLineCount() {
        return skippedLineCount;
    }
}
