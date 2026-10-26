import java.util.ArrayList;
import java.util.Scanner;
public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Controller controller = new Controller();
    public boolean running = true;
public void startProgram(){
    System.out.println("Velkommen til min filmsamling");
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
    System.out.println("Tak for denne gang.");
}
public void createMovie(){
    System.out.print("Skriv en titel.");
    String title = scanner.nextLine();

    System.out.println("Skriv en instruktør.");
    String director = scanner.nextLine();

    System.out.println("Skriv udgivelses år.");
    int yearCreated = scanner.nextInt();
    scanner.nextLine();

    System.out.println("Er filmen i farve (ja/nej).");
    String svar = scanner.nextLine();
    boolean inColor = svar.equalsIgnoreCase("ja");

    System.out.println("Hvor lang er filmen i minutter?");
    int lengthInMinutes = scanner.nextInt();
    scanner.nextLine();

    System.out.println("Skriv en genre.");
    String genre = scanner.nextLine();
    controller.addMovie(title, director, yearCreated, inColor, lengthInMinutes, genre);
    System.out.println(title + " er tilføjet til samlingen.");
}
public void deleteMovie(){
    System.out.println("Hvilken film vil du slette?");
    String title = scanner.nextLine();

}

public void searchMovies(){
System.out.print("Søg efter titel: ");
        String searchText = scanner.nextLine();

        ArrayList<Movie> matches = controller.searchMovies(searchText);

        if (matches.isEmpty()) {
            System.out.println("Ingen film matcher din søgning.");
            return;
        }

        for (Movie movie : matches) {
            String color;

            if (movie.isInColor()) {
                color = "Farver";
            } else {
                color = "Sort-hvid";
            }

            System.out.println("Titel: " + movie.getTitle());
            System.out.println("Instruktør: " + movie.getDirector());
            System.out.println("Årstal: " + movie.getYearCreated());
            System.out.println("Farver: " + color);
            System.out.println("Længde: " + movie.getLengthInMinutes() + " minutter");
            System.out.println("Genre: " + movie.getGenre());
            System.out.println();
        }

}

public void showAllMovies(){
    ArrayList<Movie> movies = controller.getMovies();
    if (movies.isEmpty()){
        System.out.println("Filmlisten er tom");
        }
    else {
        for (Movie movie : movies) {
            System.out.println("Titel: " + movie.getTitle());
            System.out.println("Instruktør: " + movie.getDirector());
            System.out.println("Genre: " + movie.getGenre());
            System.out.println("Årstal: " + movie.getYearCreated());
            System.out.println("Længde: " + movie.getLengthInMinutes() + " minutter");
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




