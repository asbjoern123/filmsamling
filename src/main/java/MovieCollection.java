import java.util.ArrayList;

public class MovieCollection {
    private ArrayList<Movie> movies;

    public ArrayList<Movie> getMovies() {
        return movies;
    }
    public addMovie(String titel, String genre){
        movies.add(movie(titel,genre));

    }
    public int getNumbreOfMovies(){
        return movies.size();
    }
    public boolean deleteMovie(String titel) {
        for (Movie movie : movies) {
            if (titel.equals(movie.getTitel)) {
                movies.remove(movie.getTitel);
            }
        }
        return false;
    }
    public boolean editeMovie(){
        return false;
    }
    public boolean searchMovies(String SearchText){
        for(Movie movie:movies){
            if(SearchText.equals(movies.getTitel)){
                return movie.getTitel;
            }
        }
        return false;
    }

}
