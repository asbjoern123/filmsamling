import java.time.LocalDate;

public class Movie {
    private String title;
    private String director;
    private int yearCreated;
    private boolean inColor;
    private int lengthInMinutes;
    private String genre;
    private static final int FIRST_MOVIE_YEAR = 1888;


    public Movie(String title, String director, int yearCreated, boolean inColor, int lengthInMinutes, String genre){
        this.title = title;
        this.director = director;
        setYearCreated(yearCreated);
        this.inColor = inColor;
        this.lengthInMinutes = lengthInMinutes;
        this.genre = genre;
    }

        public String getTitle(){
            return title;
        }
        public String getDirector(){
            return director;
        }
        public int getYearCreated(){
            return yearCreated;
        }
        public boolean isInColor(){
            return inColor;
        }
        public int getLengthInMinutes(){
            return lengthInMinutes;
        }                                     
        public String getGenre(){
            return genre;
        }

        public void setTitle (String title){
            this.title = title;
        }
        public void setDirector (String director){
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
        public void setInColor (boolean inColor){
            this.inColor = inColor;
        }
        public void setLengthInMinutes(int lengthInMinutes) {
            this.lengthInMinutes = lengthInMinutes;
        }
        public void setGenre(String genre) {
            this.genre = genre;
    }
}
