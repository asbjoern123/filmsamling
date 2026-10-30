import java.time.LocalDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Movie {
    private String title;
    private String director;
    private int yearCreated;
    private boolean inColor;
    private int lengthInMinutes;
    private String genre;
    private static final int FIRST_MOVIE_YEAR = 1888;
    private LocalDate lastWatchedDate = null;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Movie(String title, String director, int yearCreated, boolean inColor, int lengthInMinutes, String genre, LocalDate lastWatchedDate) {
        setTitle(title);
        setDirector(director);
        setYearCreated(yearCreated);
        this.inColor = inColor;
        setLengthInMinutes(lengthInMinutes);
        setGenre(genre);
        setLastWatchedDate(lastWatchedDate);
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public boolean isInColor() {
        return inColor;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public String getGenre() {
        return genre;
    }

    public void setTitle(String title) {
        if(title.isEmpty() || title.trim().isEmpty())
            throw new IllegalArgumentException(
                    "En film skal have en titel"
            );
        this.title = title;
    }

    public void setDirector(String director) {
        if(director.isEmpty() || director.trim().isEmpty())
            throw new IllegalArgumentException(
                    "En film skal have en director"
            );
        this.director = director;
    }

    public void setYearCreated(int yearCreated) {
        int latestYear = LocalDate.now().getYear() + 1;
        if (yearCreated < FIRST_MOVIE_YEAR || yearCreated > latestYear) {
            throw new IllegalArgumentException(
                    "Årstallet skal være mellem " + FIRST_MOVIE_YEAR + " og " + latestYear + ".");
        }
        this.yearCreated = yearCreated;
    }

    public void setInColor(boolean inColor) {
        this.inColor = inColor;
    }

    public void setLengthInMinutes(int lengthInMinutes) {
        if (lengthInMinutes <= 0){
            throw new IllegalArgumentException(
                    "en film kan ikke vare mindre eller lig med 0 minuter");
        }
        this.lengthInMinutes = lengthInMinutes;
    }

    public void setGenre(String genre) {
        if(genre.isEmpty() || genre.trim().isEmpty())
            throw new IllegalArgumentException(
                    "En film skal have en genre"
            );
        this.genre = genre;
    }


public LocalDate getLastWatchedDate() {
    return lastWatchedDate;
}

public void setLastWatchedDate(LocalDate date) {
        LocalDate today = LocalDate.now();
    if (date.isAfter(today)){
        throw new IllegalArgumentException(
                "du kan ikke havet set filmen i fremtiden");
    }
    this.lastWatchedDate = date;
}


}
