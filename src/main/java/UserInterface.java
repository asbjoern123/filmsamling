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
public void deleteMovie(){}
public void createMovie(){}
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




