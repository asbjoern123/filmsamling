# FURPS – vores filmsamling

|   | Krav                                                                                                | Opfyldt? | Hvor                                                           |
|---|-----------------------------------------------------------------------------------------------------|----------|----------------------------------------------------------------|
| F | Opret en film                                                                                       | Ja       | US1, `domainmodel.MovieCollection`                                |
| F | Menu til navigation                                                                                 | Ja       | US2, `ui.UserInterface`                              |
| F | Vise en liste af alle film                                                                          | Ja       | US3, `ui.UserInterface`                             |
| F | Søg efter film                                                                                      | Ja       | US4, `ui.UserInterface`                              |
| F | Rediger en film                                                                                     | Ja       | US5, `ui.UserInterface`                                 |
| F | Slet en film                                                                                        | Ja       | US6, `ui.UserInterface`                               |
| F | Find film du ikke har set længe               | Ja       | US9, `ui.UserInterface`                             |
| F | Markér en film som set                        | Ja       | US8, `ui.UserInterface`                                |
| F | Vis film alfabetisk ved "Vis alle film"        | Nej      | US16, `` (ikke lavet endnu)                                    |
| F | Gem og indlæs samlingen fra fil                | Ja      | US13, `FileHandler`                             |
| F | Vælg sorteringsfelt (menuvalg 8)                | Nej      | US17, `` (ikke lavet endnu)                                    |
| F | Sortér efter to felter (ekstraopgave)           | Nej      | US18, `` (ikke lavet endnu)                                    |
| U | Ved ja/nej-spørgsmål accepteres ja, j, nej og n uanset store og små bogstaver; andre svar giver en besked, og man bliver spurgt igen | ja       | US10 , `ui.UserInterface`                               |
| R | Bogstaver ved tal-input og ugyldige filmnumre giver en fejlbesked og et nyt forsøg                  | Ja       | ui.UserInterface.readInt og filmvalg                              |
| R | Ugyldige filmoplysninger afvises uden at oprette eller delvist ændre filmen                         | Ja       | domainmodel.Movie, domainmodel.MovieCollection.editMovie og try/catch i ui.UserInterface  |
| R | Forkert datoformat giver et nyt forsøg. Fremtidige set-datoer afvises, og den gamle dato bevares    | Ja       | ui.UserInterface.readMovieDate, markAsSeen og domainmodel.Movie.markAsWatched |
| P | Søgeresultatet vises på under ét sekund                                                             | Ja       | US4, `ui.UserInterface`                              |
| P | gemmer kun ved ændring                                                                              | ja        | US14 , `domainmodel.Controller`                        |
| S | Der er skrevet JUnit tests på domainmodel.Movie                                                                 | Ja       | Del 5 , `MovieTest.java`                                       |
| S | Der er skrevet JUnit tests på domainmodel.MovieCollection                                                       | Ja       | Del 5 , `MovieCollectionTest.java`                             |
| S | Lag i koden (packages: ui/domainmodel/datasource) | Ja      | US15                                    |
