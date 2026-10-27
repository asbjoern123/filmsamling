import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Controller controller = new Controller();
    public boolean running = true;

    public void startProgram() {
        System.out.println("Velkommen til min filmsamling");
        while (running) {
            printMenu();
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

    public void createMovie() {
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

    public void deleteMovie() {

        System.out.println("søg efter en film du ville slette?");
        String searchText = scanner.nextLine();

        ArrayList<Movie> matches = controller.searchMovies(searchText);

        if (matches.isEmpty()) {
            System.out.println("Ingen film fundet.");
            return;
        }

        for (int i = 0; i < matches.size(); i++) {
            System.out.println((i + 1) + ". " + matches.get(i).getTitle());
        }

        System.out.println("vælg et nummer");
        int valgt = scanner.nextInt();

        Movie valgtmovie = matches.get(valgt - 1);
        System.out.println(" du har fjernet " + valgt);
        controller.deleteMovie(valgtmovie);

    }

    public void searchMovies() {
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

    public void showAllMovies() {
        ArrayList<Movie> movies = controller.getMovies();
        if (movies.isEmpty()) {
            System.out.println("Filmlisten er tom");
        } else {
            for (Movie movie : movies) {
                String color = movie.isInColor() ? "farver" : "sort-hvid";
                System.out.println(movie.getTitle() + " (" + movie.getYearCreated() + ") i " + color);
                System.out.println("Instruktør: " + movie.getDirector());
                System.out.println("Genre: " + movie.getGenre());
                System.out.println("Længde: " + movie.getLengthInMinutes() + " minutter");
            }
        }
    }

    public void editMovie() {
        System.out.print("Søg efter titel: ");
        String searchText = scanner.nextLine();

        ArrayList<Movie> matches = controller.searchMovies(searchText);

        if (matches.isEmpty()) {
            System.out.println("Ingen film matcher din søgning.");
            return;
        }

        for (int i = 1; i <= matches.size(); i++) {
            System.out.println(i + ". " + matches.get(i - 1).getTitle());
        }

        System.out.print("Vælg nummer: ");

        int chosenMovieNum = scanner.nextInt();
        scanner.nextLine();

        Movie chosenMovie = null;

        while(chosenMovieNum < 1 || chosenMovieNum > matches.size())
        {
            System.out.println("Det valgte nummer fandtes ikke. Prøv igen");
            chosenMovieNum = scanner.nextInt();
            scanner.nextLine();
        }

        chosenMovie = matches.get(chosenMovieNum-1);

        System.out.println("Tryk Enter for at beholde den nuværende værdi.");

        System.out.print("Titel " + "[" + chosenMovie.getTitle() + "]: ");
        String newTitle = scanner.nextLine();
        if (newTitle.isBlank()) {
            newTitle = chosenMovie.getTitle();
        }

        System.out.print("Instruktør " + "[" + chosenMovie.getDirector() + "]: ");
        String newDirector = scanner.nextLine();
        if (newDirector.isBlank()) {
            newDirector = chosenMovie.getDirector();
        }

        System.out.print("Årstal " + "[" + chosenMovie.getYearCreated() + "]: ");
        String newYearString = scanner.nextLine();
        int newYear = chosenMovie.getYearCreated();
        if (!newYearString.isBlank()) {
            newYear = Integer.parseInt(newYearString);
        }

        System.out.print("I farver " + "(" + (chosenMovie.isInColor() ? "Ja" : "Nej") + "): ");
        String inColorString = scanner.nextLine();
        boolean inColor = chosenMovie.isInColor();

        if (!inColorString.isBlank()) {
            inColor = inColorString.equalsIgnoreCase("ja");
        }

        System.out.print("Længde i minutter " + "[" + chosenMovie.getLengthInMinutes() + "]: ");
        String newLengthString = scanner.nextLine();
        int newLength = chosenMovie.getLengthInMinutes();
        if (!newLengthString.isBlank()) {
            newLength = Integer.parseInt(newLengthString);
        }

        System.out.print("Genre " + "[" + chosenMovie.getGenre() + "]: ");
        String newGenre = scanner.nextLine();
        if (newGenre.isBlank()) {
            newGenre = chosenMovie.getGenre();
        }

        controller.editMovie(chosenMovie, newTitle, newDirector, newYear, inColor, newLength, newGenre);

        System.out.println("Filmen er opdateret:");

        System.out.println(chosenMovie.getTitle() + " (" + chosenMovie.getYearCreated() + ")");
        System.out.println("  Instruktør: " + chosenMovie.getDirector());
        System.out.println("  Genre: " + chosenMovie.getGenre());
        String color = chosenMovie.isInColor() ? "farver" : "sort-hvid";

        System.out.println("  Længde: " + chosenMovie.getLengthInMinutes() + " minutter, " + color);

    }

    public void printMenu() {
        System.out.println("Tast 1 for at oprette en film");
        System.out.println("Tast 2 for at vise alle film");
        System.out.println("Tast 3 for at søge efter en film");
        System.out.println("Tast 4 for at redigere en film");
        System.out.println("Tast 5 for at slette en film");
        System.out.println("Tast 0 for at stoppe programmet");
    }

    private int readInt(String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(scanner.nextLine().trim());
    }
}




