# FURPS – vores filmsamling

|   | Krav                                                                                                | Opfyldt? | Hvor                                                           |
|---|-----------------------------------------------------------------------------------------------------|----------|----------------------------------------------------------------|
| F | Opret en film                                                                                       | Ja       | US1, `MovieCollection.addMovie`                                |
| F | Menu til navigation                                                                                 | Ja       | US2, `UserInterface.startProgram`                              |
| F | Vise en liste af alle film                                                                          | Ja       | US3, `UserInterface.showAllMovies`                             |
| F | Søg efter film                                                                                      | Ja       | US4, `UserInterface.searchMovies`                              |
| F | Rediger en film                                                                                     | Ja       | US5, `UserInterface.editMovie`                                 |
| F | Slet en film                                                                                        | Ja       | US6, `UserInterface.deleteMovie`                               |
| F | Find film du ikke har set længe               | Ja       | US9, `UserInterface.notSeenInTime`                             |
| F | Markér en film som set                        | Ja       | US8, `UserInterface.markAsSeen`                                |
| F | Vis film alfabetisk ved "Vis alle film"        | Nej      | US16, `` (ikke lavet endnu)                                    |
| F | Gem og indlæs samlingen fra fil                | Nej      | US13, `` (ikke wired ind endnu)                                |
| F | Vælg sorteringsfelt (menuvalg 8)                | Nej      | US17, `` (ikke lavet endnu)                                    |
| F | Sortér efter to felter (ekstraopgave)           | Nej      | US18, `` (ikke lavet endnu)                                    |
| U | Ved ja/nej-spørgsmål accepteres ja, j, nej og n uanset store og små bogstaver; andre svar giver en besked, og man bliver spurgt igen | ja       | US10 , `UserInterface.readYesNo`                               |
| R | Bogstaver ved tal-input og ugyldige filmnumre giver en fejlbesked og et nyt forsøg                  | Ja       | UserInterface.readInt og filmvalg                              |
| R | Ugyldige filmoplysninger afvises uden at oprette eller delvist ændre filmen                         | Ja       | Movie, MovieCollection.editMovie og try/catch i UserInterface  |
| R | Forkert datoformat giver et nyt forsøg. Fremtidige set-datoer afvises, og den gamle dato bevares    | Ja       | UserInterface.readMovieDate, markAsSeen og Movie.markAsWatched |
| P | Søgeresultatet vises på under ét sekund                                                             | Ja       | US4, `UserInterface.searchMovies`                              |
| p | gemmer kun ved ændring                                                                              | ja        | US14 , `Controller.saveMoviesIfChanged`                        |
| S | Der er skrevet JUnit tests på Movie                                                                 | Ja       | Del 5 , `MovieTest.java`                                       |
| S | Der er skrevet JUnit tests på MovieCollection                                                       | Ja       | Del 5 , `MovieCollectionTest.java`                             |
| S | Lag i koden (packages: ui/domainmodel/datasource) | Nej      | US15, `` (ikke lavet endnu)                                    |
