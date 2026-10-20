import java.util.Scanner;
public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Controller controller = new Controller();
    public boolean running = true;
public void startProgram(){
    while (running){
        String choice = scanner.nextLine().trim();
        printinfo();
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
    System.out.println("skrive en title");
    String title = scanner.nextLine();
    System.out.println("skrive en director");
    String director = scanner.nextLine();
    System.out.println("skrive udgivelses år");
    int year
    System.out.println("er filem i farve");
    System.out.println("hvor lang er filmen i minutter");
    System.out.println("skrive en genren");
    controller.addMovie(title, String director, int yearCreated, boolean inColor, int lengthInMinutes, String genre));
}
public void deleteMovie(){}
public void searchMovies(){}
public void showAllMovies(){}
public void editMovie(){}
public void printinfo(){
    System.out.println("press 1 to createMovie");
    System.out.println("press 2 to showAllMovies");
    System.out.println("press 3 to searchMovies");
    System.out.println("press 4 to editMovie");
    System.out.println("press 5 to deleteMovie");
    System.out.println("press 0 to stop the program");
}
}




