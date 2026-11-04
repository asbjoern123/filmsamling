# Filmsamling

Et CRUD-program til en filmsamling – 1. semester, datamatiker, EK.

## Gruppen

| Fornavn | GitHub     |
|---------|------------|
| Asbjørn | AsbjornKMR |
| Ask     | Askhuae    |
| Mikkel  | MTinggaard |
| Cennet  | Rosaxyz    |

## Sådan køres programmet

**Main-klasse:** `Main.java` (indeholder `main`-metoden).

**Krav:** JDK 25.

**Kør fra IntelliJ:**
1. Åbn projektet i IntelliJ.
2. Find `Main.java` i `src/main/java`.
3. Højreklik på filen og vælg "Run 'Main.main()'".

**Kør fra terminalen:**
```bash
mvn compile
java -cp target/classes Main
```
## User stories

**Lavet:**
- US1 – Opret en film
- US2 – Menu
- US3 – Vis alle film
- US4 – Søg efter film
- US5 – Redigér en film
- US6 – Slet en film
- US7 – Automatiske tests
- US8 – Markér film som set
- US9 – Find film ikke set længe
- US10 – Robust input
- US11 – Kun gyldige film
- US12 – Angiv dato for set
- US13 – Gem/indlæs samlingen fra fil
- US14 – Gem kun ved ændringer
- US15 – Lag i koden (packages)
- US16 – Alfabetisk visning
- US17 – Vælg sorteringsfelt

**Mangler:**

- US18 – Sortér efter to felter (ekstraopgave)
