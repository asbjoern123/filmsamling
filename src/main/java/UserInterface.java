import java.time.LocalDate;
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
        System.out.print("Skriv en titel: ");
        String title = scanner.nextLine();

        System.out.print("Skriv en instruktør: ");
        String director = scanner.nextLine();
        int yearCreated = 0;

        while (true) {
            yearCreated = readInt("Skriv udgivelses år: ");

            if (yearCreated >= 1888 && yearCreated <= getNextYear()) {
                break;
            } else System.out.println("Udgivelsesåret skal være mellem 1888-" + getNextYear());
        }

        boolean inColor = readYesNo("Er filmen i farve? (ja/nej)");

        int lengthInMinutes = readInt("Hvor lang er filmen i minutter?: ");

        System.out.print("Skriv en genre: ");
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

        int valgt = readInt("Vælg nummer (0 for at afbryde): ");

        while (valgt < 0 || valgt > matches.size()) {
            valgt = readInt("Ugyldigt nummer. Prøv igen (0 for at afbryde): ");
        }

        if (valgt == 0) {
            System.out.println("Sletning afbrudt.");
            return;
        }

        Movie valgtmovie = matches.get(valgt - 1);

        boolean confirm = readYesNo("Er du sikker på, at du vil slette filmen? (ja/nej)");

        if (confirm) {
            boolean deleted = controller.deleteMovie(valgtmovie);

            if (deleted) {
                System.out.println(valgtmovie.getTitle() + " er slettet.");
            } else {
                System.out.println("Filmen kunne ikke findes.");
            }
        } else {
            System.out.println("Sletning afbrudt.");
        }

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

        int chosenMovieNum = readInt("Vælg nummer (0 for at afbryde): ");

        while (chosenMovieNum < 0 || chosenMovieNum > matches.size()) {
            chosenMovieNum = readInt("Ugyldigt nummer. Prøv igen (0 for at afbryde): ");
        }

        if (chosenMovieNum == 0) {
            System.out.println("Redigering afbrudt.");
            return;
        }

        Movie chosenMovie;

        chosenMovie = matches.get(chosenMovieNum - 1);

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

        int newYear = readInt(
                "Årstal [" + chosenMovie.getYearCreated() + "]: ",
                chosenMovie.getYearCreated()
        );

        while (newYear < 1888 || newYear > getNextYear()) {
            System.out.println("Årstallet skal være mellem 1888 og " + (getNextYear()));

            newYear = readInt(
                    "Prøv igen. Enter beholder det gamle årstal: ",
                    chosenMovie.getYearCreated()
            );
        }

        boolean inColor = chosenMovie.isInColor();

        while (true) {
            System.out.println("Er filmen i farve? (ja/nej). Enter beholder den gamle værdi.");
            String answer = scanner.nextLine().trim();

            if (answer.isEmpty()) {
                break;
            }

            if (answer.equalsIgnoreCase("ja")
                    || answer.equalsIgnoreCase("j")) {
                inColor = true;
                break;
            }

            if (answer.equalsIgnoreCase("nej")
                    || answer.equalsIgnoreCase("n")) {
                inColor = false;
                break;
            }

            System.out.println("Svar ja eller nej.");
        }

        int newLength = readInt(
                "Længde i minutter [" + chosenMovie.getLengthInMinutes() + "]: ",
                chosenMovie.getLengthInMinutes()
        );

        System.out.print("Genre " + "[" + chosenMovie.getGenre() + "]: ");
        String newGenre = scanner.nextLine();
        if (newGenre.isBlank()) {
            newGenre = chosenMovie.getGenre();
        }

        boolean edited = controller.editMovie(chosenMovie, newTitle, newDirector, newYear, inColor, newLength, newGenre);

        if (edited) {
            System.out.println("Filmen er opdateret:");

            System.out.println(chosenMovie.getTitle() + " (" + chosenMovie.getYearCreated() + ")");
            System.out.println("  Instruktør: " + chosenMovie.getDirector());
            System.out.println("  Genre: " + chosenMovie.getGenre());
            String color = chosenMovie.isInColor() ? "farver" : "sort-hvid";

            System.out.println("  Længde: " + chosenMovie.getLengthInMinutes() + " minutter, " + color);
        }

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
        return readInt(prompt, null);
    }

    private int readInt(String prompt, Integer oldValue) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (input.isEmpty() && oldValue != null) {
                return oldValue;
            }

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                numberFormatExceptionMessage();
            }
        }
    }

    private static void numberFormatExceptionMessage() {
        System.out.println("Dit input skal være et tal. Prøv igen.");
    }

    private static int getNextYear() {
        LocalDate localDate = LocalDate.now();
        return localDate.getYear() + 1;
    }

    private boolean readYesNo(String prompt) {
        while (true) {
            System.out.println(prompt);
            String answer = scanner.nextLine().trim();

            if (answer.equalsIgnoreCase("ja")
                    || answer.equalsIgnoreCase("j")) {
                return true;
            }

            if (answer.equalsIgnoreCase("nej")
                    || answer.equalsIgnoreCase("n")) {
                return false;
            }

            System.out.println("Svar ja eller nej.");
        }
    }
}




