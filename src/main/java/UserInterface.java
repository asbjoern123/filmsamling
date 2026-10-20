import java.util.ArrayList;
import java.util.Scanner;
public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Controller controller = new Controller();
    public boolean running = true;
public void startProgram(){
    while (running){
        printinfo();
        String choice = scanner.nextLine().trim();
        switch (choice) {
            case "1" -> createMovie();
            case "2" -> showAllMovies();
            case "3" -> searchMovies();
            case "4" -> editMovie();
            case "5" -> deleteMovie();
            case "0" -> running = false;
            default -> System.out.println("Ukendt valg: " + choice);
        }
    }

}
public void createMovie(){
    System.out.print("skrive en title:");
    String title = scanner.nextLine();
    System.out.println("skrive en director");
    String director = scanner.nextLine();
    System.out.println("skrive udgivelses år");
    int yearCreated = scanner.nextInt();
    scanner.nextLine();
    System.out.println("er filem i farve skriv endten true eller false");
    boolean inColor = scanner.nextBoolean();
    scanner.nextLine();
    System.out.println("hvor lang er filmen i minutter");
    int lengthInMinutes = scanner.nextInt();
    scanner.nextLine();
    System.out.println("skrive en genren");
    String genre = scanner.nextLine();
    controller.addMovie(title, director, yearCreated, inColor, lengthInMinutes, genre);
}
public void deleteMovie(){
    System.out.println("hvilken film ville du slette");
    String title = scanner.nextLine();
    if()
    for(Movie movie: controller.getMovies())
    controller.deleteMovie(movie);

}

public void searchMovies(){

}

public void showAllMovies(){
    ArrayList<Movie> movies = controller.getMovies();
    if (movies.isEmpty()){
        System.out.println("Filmlisten er tom");
        }
    else {
        for (Movie movie : movies) {
            System.out.println(movie.getTitle() + " af " + movie.getDirector() + ", genren: " + movie.getGenre() + " fra " + movie.getYearCreated() + " på " + movie.getLengthInMinutes() + " Minutter.");
        }
    }
}
public void editMovie(){

}

public void printinfo(){
    System.out.println("press 1 to createMovie");
    System.out.println("press 2 to showAllMovies");
    System.out.println("press 3 to searchMovies");
    System.out.println("press 4 to editMovie");
    System.out.println("press 5 to deleteMovie");
    System.out.println("press 0 to stop the program");
}
}




