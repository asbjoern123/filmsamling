import java.util.ArrayList;

public class MovieCollection {
    private ArrayList<Movie> movies;

    public ArrayList<Movie> getMovies() {
        return movies;
    }
    public void addMovie(String title, String director, int yearCreated, boolean inColor, int lengthInMinutes, String genre){
        movies.add(new Movie(title, director, yearCreated, inColor, lengthInMinutes, genre));

    }
    public int getNumberOfMovies(){

        return movies.size();
    }
    public boolean deleteMovie(String title) {
        for (Movie movie : movies) {
            if (title.equals(movie.getTitle())) {
                movies.remove(movie.getTitle());
                return true;
            }
        }
        return false;
    }
    public boolean editMovie(String title, String director, int yearCreated, boolean inColor, int lengthInMinutes, String genre)
    {
        movies.add(new Movie(title, director, yearCreated, inColor, lengthInMinutes, genre));
        return false;
    }

    public boolean searchMovies(String searchText){
        for(Movie movie:movies){
            if(searchText.equals(movie.getTitle()))
            {
                return true;
            }
        }
        return false;
    }

}
