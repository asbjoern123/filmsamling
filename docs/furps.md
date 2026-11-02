# FURPS – vores filmsamling

| | Krav      | Opfyldt? | Hvor                               |
|---|-----------|----------|------------------------------------|
| F | Menu til navigation | Ja       | US2, `UserInterface.startProgram`  |
| F | Opret en film | Ja       | US1, `MovieCollection.addMovie`    |
| F | Vise en liste af alle film | Ja       | US3, `UserInterface.showAllMovies` |
| F | Søg efter film | Ja       | US4, `UserInterface.searchMovies`  |
| F | Rediger en film | Ja       | US5, `UserInterface.editMovie`     |
| F | Slet en film | Ja       | US6, `UserInterface.deleteMovie`   |
| U | Ved ja/nej-spørgsmål accepteres ja, j, nej og n uanset store og små bogstaver; andre svar giver en besked, og man bliver spurgt igen          | ja        | US10 , `UserInterface.readYesNo`   |
| R | Bogstaver ved tal-input og ugyldige filmnumre giver en fejlbesked og et nyt forsøg | Ja | UserInterface.readInt og filmvalg |
| R | Ugyldige filmoplysninger afvises uden at oprette eller delvist ændre filmen | Ja | Movie, MovieCollection.editMovie og try/catch i UserInterface |
| R | Forkert datoformat giver et nyt forsøg. Fremtidige set-datoer afvises, og den gamle dato bevares | Ja | UserInterface.readMovieDate, markAsSeen og Movie.markAsWatched |
| P | Søgeresultatet vises på under ét sekund | Ja       | US4, `UserInterface.searchMovies`  |
| S | Der er skrevet JUnit tests på MovieCollection | Ja       | Del 5 , `MovieCollectionTest.java` |
| S | Der er skrevet JUnit tests på Movie | Ja       | Del 5 , `MovieTest.java`           |
