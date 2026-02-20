import javax.swing.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 5, 5, 5, 7, 8, 9, 10);

        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10); //stream tworzony tak samo jak kolkcja

        //Operator Lambda to skrot zapisuj funkcji anonimowej.

        // ->
        // n -> n*2 to troche jak for each
        // n -> n*2 to troche jak for each
        // for (int n : numerki) {
        // n * 2}

        //bez lambdy i streama
        List<Integer> y = new ArrayList<>();
        for (Integer n : numbers) {
            y.add(n * 2);
        }
        System.out.println(y);

        List<Integer> numbersAfterMulti = numbers.stream()
                .map(n -> n * 2)
                .toList();

        System.out.println(numbersAfterMulti);

        //podstawowe metody stream

        numbers.stream(); // tworzy streama z kolekcji

        List<Integer> asd = numbers.stream() //mozemy tym filtrowac podajac warunek
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println(asd);

        List<Integer> das = numbers.stream()
                .distinct()
                .toList();
        System.out.println(das); //usuwa duplikaty

        List<Integer> pac = numbers.stream()
                .sorted()
                .toList();
        System.out.println(pac); //sortuje rosnaco

        List<Integer> par = numbers.stream()
                .sorted(Comparator.reverseOrder()) //sortowanie odwrotne z wykorzystaniem Comparator czyli klasy do porownywania
                .toList();
        System.out.println(par);

        List<Integer> xxx = numbers.stream()
                .limit(3) //bierze pierwsze N elementow
                .toList();
        System.out.println(xxx);

        List<Integer> yyy = numbers.stream()
                .skip(3) // analogicznie tylko omija, czyli okreslamy punkt startowy
                .toList();
        System.out.println(yyy);

        long liczbaElementow = numbers.stream().count(); //zwraca ilosc elementow


        numbers.stream().forEach(System.out::println); // :: to jest referencja do metody

        numbers.stream().forEach(n -> System.out.println(n));
        //np dla Animal ktory ma klase make sound

        //animals.stream().forEach(Animal::makeSound());
        //analigcznie moznaby tak
        //animals.stream().forEach(animal -> animal.makeSound()) zadziala tak samo ale jest dluzsze

        //ZADANIE
        //czym sie rozni metoda terminalna od nieterminalnej

        //wypisz w ten sam sposob jak wyzej metody findFirst, anyMatch, allMatch, peek, flatMap(tu poczytaj

//        1) Wyswietl tylko liczby nieparzyste
//        2) Podnies wszystkie liczby do kwadratu
//        3) Wyswietl liczby wieksze niz 5
//        4) Usun duplikaty z listy
//        5) Posortuj liste malejaco
//        6) Wez pierwsze 3 elementy
//        7) Pomin pierwsze 2 elementy
//        10) Policz ilosc elementow
//        11) Zamien liczby na String
//        12) Wyswietl wszystkie elementy forEach
        System.out.println();
        System.out.println("Zadanie 1: tylko liczby nieparzyste");

        List<Integer> oddNumbers = numbers.stream()
                .filter(n -> n % 2 != 0)
                .toList();
        System.out.println(oddNumbers);

        System.out.println("Zadanie 2: wszystkie liczby do kwadratu");

        List<Integer> squaredNumbers = numbers.stream()
                .map(n -> n * n)
                .toList();
        System.out.println(squaredNumbers);

        System.out.println("Zadanie 3: liczby większe niż 5");
        List<Integer> moreThanFive = numbers.stream()
                .filter(n -> n > 5)
                .toList();
        System.out.println(moreThanFive);

        System.out.println("Zadanie 4: usunięcie duplikatów");
        List<Integer> duplicates = numbers.stream()
                .distinct()
                .toList();
        System.out.println(duplicates);

        System.out.println("Zadanie 5: Sortowanie malejące");
        List<Integer> sortedNumbers = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println(sortedNumbers);

        System.out.println("Zadani 6: pierwsze 3 elementy");
        List<Integer> firstThree = numbers.stream()
                .limit(3)
                .toList();
        System.out.println(firstThree);

        System.out.println("Zadanie 7: pominięcie pierwszych dwóch elementów");
        List<Integer> skipTwoNumbers = numbers.stream()
                .skip(2)
                .toList();
        System.out.println(skipTwoNumbers);

        System.out.println("Zadanie 10: ilość elementów");

        long amount = numbers.stream()
                .count();
        System.out.println(amount);

        System.out.println("Zadanie 11: zamiana liczby na String");
        List<String> changeToString = numbers.stream()
                .map(n -> String.valueOf(n))
                .toList();
        System.out.println(changeToString.get(0).length()); // length istnieje tylko dla Stringa a wiec tak sie sprawdza czy jest dobrze
        System.out.println(changeToString);

        System.out.println("Zadanie 12: wszystkie elementy for each");

        numbers.stream().forEach(System.out::println);
        numbers.stream().forEach(n -> System.out.println(n));
        //1. Wyświetl tylko liczby, które są nieparzyste
        System.out.println();
        System.out.println("1: Liczby nieparzyste:");

        List<Integer> nieparzyste = numbers.stream()
                .filter(n -> n % 2 != 0)
                .toList();
        System.out.println(nieparzyste);

        //   2. Podnieś wszystkie liczby do kwadratu i wyświetl tylko te, które są mniejsze niż 50
        System.out.println();
        System.out.println("2: Liczby do kwadratu wieksze od 50:");
        List<Integer> doKwadratu = numbers.stream()
                .map(n -> n * n)
                .filter(n -> n < 50)
                .toList();
        System.out.println(doKwadratu);

        //   3. Przelicz na double i wyświetl bez powtórzeń połówki każdej liczby
        System.out.println();
        System.out.println("2: Przeliczenie na double, bez dubli polowki kazdej liczby");
        List<Double> polowki = numbers.stream()
                .map(n -> n - (0.5 * n))
                .distinct()
                .toList();
        System.out.println(polowki);

        //   4. Zapisz liczbę unikalnych elementów do zmiennej a następnie ją wyświetl
        System.out.println();
        System.out.println("4: unikalne elementy");
        long unikaty = numbers.stream()
                .distinct()
                .count();
        System.out.println(unikaty);

        //   5. Wyświetl elementy rosnąco
        System.out.println();
        System.out.println("5: Elementy rosnaco");
        List<Integer> rosnaco = numbers.stream()
                .sorted()
                .toList();
        System.out.println(rosnaco);

        //   6. Stwórz listę posortowanych malejąco elementów, ale bez powtórzeń
        System.out.println();
        System.out.println("7: Elementy malejace, bez duplikatow");
        List<Integer> malejace = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .toList();
        System.out.println(malejace);

        //   7. Stwórz set BigIntegerów posortowanych malejąco
        System.out.println();
        System.out.println("8: Set BigInteger posortowany malejąco");
        Set<BigInteger> duzeLiczby = new TreeSet<>(Comparator.reverseOrder());
        duzeLiczby.add(new BigInteger("10"));
        duzeLiczby.add(new BigInteger("20"));
        duzeLiczby.add(new BigInteger("30"));
        duzeLiczby.add(new BigInteger("40"));
        duzeLiczby.add(new BigInteger("30"));
        duzeLiczby.forEach(System.out::println);

        //   8. Policz sumę elementów pomnożonych przez 2
        System.out.println();
        System.out.println("8: Suma elementów pomnożonych przez 2");
        int suma = numbers.stream()
                .mapToInt(n -> n * 2)
                .sum();
        System.out.println(suma);

        //   9. Oblicz średnią elementów na liście
        System.out.println();
        System.out.println("9: Średnia elementów na liście");
        double iloscElementow = numbers.stream()
                .mapToInt(n -> n)
                .average()
                .orElse(0); // tak sie daje jakby lista byla pusta i zeby zamknac streama

        BigDecimal zaokraglona = BigDecimal.valueOf(iloscElementow);
        System.out.println(zaokraglona.setScale(2, RoundingMode.HALF_UP));

        //   10. Policz ile jest liczb parzystych
        System.out.println();
        System.out.println("10: Ilość liczb parzystych");
        long parzyste = numbers.stream()
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println(parzyste);

        //   11. Policz ile jest różnych liczb parzystych
        System.out.println();
        System.out.println("11: Ilość różnych liczb parzystych");
        long rozneParzyste = numbers.stream()
                .filter(n -> n % 2 == 0)
                .distinct()
                .count();
        System.out.println(rozneParzyste);

        //   12. Napisz klasę Osoba, która będzie zawierała pola imie, nazwisko, rokUrodzenia, ulubionySport
        System.out.println();
        System.out.println("12: Klasa Osoba");

        Person derek = new Person("Derek", "Kutafon", 1978, "Piłka nożna");
        Person stefan = new Person("Stefan", "Jarzębina", 1988, "Koszykówka");
        Person zyta = new Person("Zyta", "Placek", 1978, "Siatkówka");
        Person klaus = new Person("Klaus", "Germański", 1999, "Piłka nożna");
        Person błażej = new Person("Błażej", "Juras", 1998, "Siatkówka");
        List<Person> persons = new ArrayList<>();
        persons.add(derek);
        persons.add(stefan);
        persons.add(zyta);
        persons.add(klaus);
        persons.add(błażej);

        //   13. Napisz strumień, który dla podanej listy osób policzy, ile jest takich, które urodziły się po roku 1998
        System.out.println();
        System.out.println("13: Osoby urodzone po 1998");
        long rokUrodzenia = persons.stream()
                .filter(n -> n.getYearOfBirth() > 1998)
                .count();
        System.out.println(rokUrodzenia);

        //   14. Napisz strumień, który dla podanej listy osób zwróci te, które urodziły się przed rokiem 1990
        System.out.println();
        System.out.println("14: Osoby urodzone przed rokiem 1990");
        List<Person> urodzonePo90 = persons.stream()
                .filter(n -> n.getYearOfBirth() < 1990)
                .collect(Collectors.toList());
        System.out.println(urodzonePo90);

        //   15. Napisz strumień, który dla podanej listy osób zwróci te, które urodziły się przed rokiem 1990 posortowane po nazwisku
        System.out.println();
        System.out.println("15: Osoby urodzone przed rokiem 1990 posortowane po nazwisku");
        List<Person> poNazwisku = persons.stream()
                .filter(n -> n.getYearOfBirth() < 1990)
                .sorted(Comparator.comparing(Person::getSurname))
                .toList();
        poNazwisku.forEach(n -> System.out.println(n.getSurname() + " " + n.getName()));

        //   16. Napisz strumień, który dla podanej listy osób zwróci te, które lubią grać w piłkę nożną
        System.out.println();
        System.out.println("16: osoby, które lubią grać w piłkę nożną");
        List<Person> pilka = persons.stream()
                .filter(n -> n.getFavouriteSport().equals("Piłka nożna"))
                .collect(Collectors.toList());
        System.out.println(pilka);

        //   17. Napisz strumień, który dla podanej listy osób zwróci te, które urodziły się przed rokiem 1998 i lubią koszykówkę
        System.out.println();
        System.out.println("17: Osoby urodzone przed 1998 i lubiące koszykówkę");
        List<Person> osoby = persons.stream()
                .filter(n -> n.getYearOfBirth() < 1998 && n.getFavouriteSport().equals("Koszykówka"))
                .collect(Collectors.toList());
        System.out.println(osoby);

        //   18. Napisz strumień, który dla podanej listy osób zwróci te, które urodziły się przed rokiem 1998 i lubią koszykówkę
        //  (osoby posortowane po nazwisku, jeśli nazwisko takie samo to po imieniu)
        System.out.println();
        System.out.println("18: Osoby urodzone przed 1998 lubiace koszykowke, posortowane po nazwisku ");
        List<Person> osoby2 = persons.stream()
                .filter(n -> n.getYearOfBirth() < 1998 && n.getFavouriteSport().equals("Koszykówka"))
                .sorted(Comparator.comparing(Person::getSurname).thenComparing(Person::getName))
                .toList();

        osoby2.forEach(n -> System.out.println(n.getSurname() + " " + n.getName()));

        //   19. Napisz metodę, która dla podanej listy osób zwróci te, które urodziły się przed podanym jako argument rokiem i lubią
        //  podany jako argument sport
        System.out.println();
        System.out.println("19: Metoda");

        List<Person> metoda = filterPersons(2000, "Siatkówka", persons);
        System.out.println(metoda);

        System.out.println("20");//   20. Napisz strumień, który dla podanej listy osób zwróci tę, która jest najstarsza
        int maxAge = persons.stream()
                .mapToInt(Person::getAge)
                .max()
                .orElseThrow(); // to sie pisze w razie pustej listy
        List<Person> old = persons.stream()
                .filter(n -> n.getAge() == maxAge) // jezeli maja taki sam wiek
                .collect(Collectors.toList());
        System.out.println(old);

        // do poczytania: flatmap, lazy evaluation jak dziala od srodka, dlaczego jest ''leniwy'', metoda: peak sluzy do debugowania, optionals poczytac

        //FLAT MAP
        List<List<String>> teams = List.of(List.of("Adix", "Maciek"), List.of("Ewelina", "Monika"), List.of("Belykovy", "Belikova"));
        System.out.println(";;;;;;;;;;;;;;;");
        System.out.println(teams.stream().map(n -> n).toList());
        System.out.println(teams.stream().flatMap(n -> n.stream().filter(x -> x.equals("Adix"))).toList());
        //Flat map pozwala nam splaszczyc kolekcje w kolekcji do jednej kolekcji
        //czyli mamy pudelka w pudelku i za pmoca flat map wysypujemy wszsytkie pudelka na stol i za pomoca toList zbieramy do 1 pudelka
        System.out.println(";;;;;;;;;;;;;;;");

        //peek pozwala zajrzeć do strumienia w trakcie jego przetwarzania – debug, logowanie, bez zmiany elementów.
        // peek jest leniwy, czyli nie wykona się, dopóki nie będzie operacji terminalnej.

        //optionals może mieć wartość albo być pusty – używany zamiast null dla bezpieczeństwa.

        System.out.println("-------------------------------");
        System.out.println("ZADANIE 21:\n" +
                "Napisz metodę, która dla podanej listy osób zwróci mapę, gdzie kluczem jest ulubiony sport, \n" +
                "a wartością lista osób lubiących ten sport.\n" +
                "Metoda: Map<String, List<Person> grupujPoSporcie(List<Person> persons)");
        System.out.println();

        Map<String, List<Person>> metoda2 = grupujPoSporcie(persons);
        metoda2.entrySet().stream()
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
        System.out.println(metoda2);

        System.out.println();
        System.out.println("ZADANIE 22:\n" +
                "Napisz metodę, która dla podanej listy liczb całkowitych zwróci iloczyn wszystkich liczb \n" +
                "(użyj reduce). Jeśli lista jest pusta, zwróć 1.\n" +
                "Metoda: int iloczynLiczb(List<Integer> numbers)\n ");

        List<Integer> calkowite = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(iloczynLiczb(calkowite));

        System.out.println();
        System.out.println("ZADANIE 23:\n" +
                "Napisz metodę, która dla podanej listy osób zwróci mapę, gdzie kluczem jest dekada urodzenia \n" +
                "(np. 1970, 1980, 1990, 2000), a wartością liczba osób urodzonych w tej dekadzie.\n" +
                "Metoda: Map<Integer, Long> policzOsobyWDekadach(List<Person> persons)");

        System.out.println(policzOsobyWDekadach(persons));
        System.out.println();
        System.out.println("ZADANIE 24:\n" +
                "Napisz metodę, która dla podanej listy osób podzieli je na dwie grupy: urodzonych przed rokiem 2000 \n" +
                "i po roku 2000 (włącznie). Zwróć mapę z kluczem boolean (true = po 2000, false = przed 2000).\n" +
                "Metoda: Map<Boolean, List<Person>> podzielPoRoku2000(List<Person> persons)");

        podzielPoRoku2000(persons).entrySet().stream()
                .forEach(e -> {
                    String przypis = e.getKey() ? "Po 2000: " : "Przed 2000: ";
                    System.out.println(przypis + e.getValue());
                });
        System.out.println(podzielPoRoku2000(persons));

        System.out.println();
        System.out.println("ZADANIE 25:\n" +
                "Napisz metodę, która dla podanej listy osób znajdzie najstarszą osobę z każdego sportu. \n" +
                "Zwróć mapę, gdzie kluczem jest sport, a wartością osoba o największym wieku uprawiająca ten sport.\n" +
                "Jeśli dla sportu jest kilka osób z tym samym maksymalnym wiekiem, zwróć pierwszą znalezioną.\n" +
                "Metoda: Map<String, Person> najstarszeOsobyZKazdegSportu(List<Person> persons)");
        System.out.println(najstarszeOsobyZKazdegSportu(persons));

        System.out.println();
        System.out.println("ZADANIE 26:\n" +
                "Napisz metodę, która dla podanej listy osób obliczy średni wiek osób dla każdego sportu.\n" +
                "Zwróć mapę, gdzie kluczem jest sport, a wartością średni wiek (jako Double).\n" +
                "Metoda: Map<String, Double> sredniaWiekuDlaSportu(List<Person> persons)");
        System.out.println(sredniaWiekuDlaSportu(persons));

        System.out.println();
        System.out.println("ZADANIE 27:\n" +
                "Napisz metodę, która dla podanej listy osób utworzy String zawierający nazwiska wszystkich \n" +
                "osób urodzonych po 1990 roku, posortowanych alfabetycznie i oddzielonych przecinkami.\n" +
                "Jeśli nie ma takich osób, zwróć \"Brak osób\".\n" +
                "Metoda: String nazwiskaPoRoku1990(List<Person> persons)");
        System.out.println(nazwiskaPoRoku1990(persons));

        System.out.println();
        System.out.println("ZADANIE 28 (FlatMap - łatwe):\n" +
                "Stwórz klasę Firma z polami: String nazwa, List<Person> pracownicy.\n" +
                "Napisz metodę, która dla podanej listy firm zwróci listę wszystkich pracowników ze wszystkich firm.\n" +
                "Metoda: List<Person> wszystcyPracownicy(List<Firma> firmy)");

        Firma pilkaNozna = new Firma("Amatorszczyzna piłki nożnej sp.z o.o.");
        pilkaNozna.addPerson(derek);
        pilkaNozna.addPerson(klaus);

        Firma przywalWGale = new Firma("Sportowy ośrodek siatkówki Przywal w Gałę");
        przywalWGale.addPerson(zyta);
        przywalWGale.addPerson(błażej);

        Person klotylda = new Person("Klotylda", "Obskórnicza", 1956, "Szachy");
        Firma koloGospodyn = new Firma("Koło Gospodyń Wiejskich");
        koloGospodyn.addPerson(klotylda);

        List<Firma> firmy = new ArrayList<>();
        firmy.add(pilkaNozna);
        firmy.add(przywalWGale);
        firmy.add(koloGospodyn);

        System.out.println(wszyscyPracownicy(firmy));

        System.out.println();
        System.out.println("ZADANIE 29 (FlatMap - średnie):\n" +
                "Rozszerz klasę Person o pole List<String> hobby (lista hobby osoby).\n" +
                "Napisz metodę, która dla podanej listy osób zwróci listę wszystkich unikalnych hobby \n" +
                "(bez powtórzeń), posortowanych alfabetycznie.\n" +
                "Metoda: List<String> wszystkieUnikatweHobby(List<Person> persons)");
        //   Person derek = new Person("Derek", "Kutafon", 1978, "Piłka nożna");
        //        Person stefan = new Person("Stefan", "Jarzębina", 1988, "Koszykówka");
        //        Person zyta = new Person("Zyta", "Placek", 1978, "Siatkówka");
        //        Person klaus = new Person("Klaus", "Germański", 1999, "Piłka nożna");
        //        Person błażej = new Person("Błażej", "Juras", 1998, "Siatkówka");
        //        List<Person> persons = new ArrayList<>();
        //        persons.add(derek);
        //        persons.add(stefan);
        //        persons.add(zyta);
        //        persons.add(klaus);
        //        persons.add(błażej);
        //  Person klotylda = new Person("Klotylda", "Obskórnicza", 1956, "Szachy");

        stefan.addHobbies("Amerykańskie teleturnieje");
        stefan.addHobbies("Koszykówka");

        zyta.addHobbies("Szydełkowanie");
        zyta.addHobbies("Pieczenie ciast");
        zyta.addHobbies("Siatkówka");

        klaus.addHobbies("Granie na playstation");

        błażej.addHobbies("Siatkówka");
        błażej.addHobbies("Granie na playstation");

        System.out.println(wszystkieUnikalneHobby(persons));

        System.out.println();
        System.out.println("ZADANIE 30 (FlatMap - trudne):\n" +
                "Mając klasę Firma z polami: String nazwa, List<Person> pracownicy (gdzie Person ma List<String> hobby),\n" +
                "napisz metodę, która dla podanej listy firm i podanego hobby znajdzie wszystkie osoby z wszystkich \n" +
                "firm, które mają to hobby, posortuje je według nazwiska, i zwróci mapę gdzie kluczem jest nazwa firmy, \n" +
                "a wartością lista pracowników tej firmy mających to hobby.\n" +
                "Metoda: Map<String, List<Person>> pracownicyZHobbyWFirmach(List<Firma> firmy, String szukaneHobby)");

        System.out.println(pracownicyZHobbyWFirmach(firmy, "Granie na playstation"));
    }
    public static Map<String, List<Person>> pracownicyZHobbyWFirmach(List<Firma> firmy, String szukaneHobby) {
        return firmy.stream()
                .filter(firma-> firma.getPracownicy().stream()
                        .anyMatch(person -> person.getHobbies().contains(szukaneHobby))) // tutaj szukamy firmy, ktore maja przynajmniej jednego pracownika z hobby, zeby nie wyjebalo exeptions
                                                                                                //klotylda nie ma hobby wiec nie powinna sie wyswietlic
                .collect(Collectors.toMap(firma->firma.getName(), firma->firma.getPracownicy().stream()
                        .filter(person -> person.getHobbies().contains(szukaneHobby))
                        .sorted(Comparator.comparing(Person::getSurname))
                        .toList()));

    }
    public static List<String> wszystkieUnikalneHobby(List<Person> persons) {
        return persons.stream()
                .flatMap(person-> person.getHobbies().stream())
                .distinct()
                .sorted()
                .collect(Collectors.toList());

    }

    public static List<Person> wszyscyPracownicy(List<Firma> firmy) {
        return firmy.stream()
                .flatMap(firma -> firma.getPracownicy().stream())
                .collect(Collectors.toList());

    }

    public static String nazwiskaPoRoku1990(List<Person> persons) {

        String nazwiskami = persons.stream()
                .filter(Person -> Person.getYearOfBirth() > 1990)
                .sorted(Comparator.comparing(Person::getSurname))
                .map(Person::getSurname)
                .collect(Collectors.joining(", "));

        if (nazwiskami.isEmpty()) {
            return "Brak osób";
        }
        return nazwiskami;
    }

    public static Map<String, Double> sredniaWiekuDlaSportu(List<Person> persons) {
        return persons.stream()
                .collect(Collectors.groupingBy(
                        Person::getFavouriteSport,
                        Collectors.averagingDouble(Person::getAge)));
    }

    public static Map<String, Person> najstarszeOsobyZKazdegSportu(List<Person> persons) {
        return persons.stream()
                .collect(Collectors.groupingBy(
                        Person::getFavouriteSport,
                        Collectors.collectingAndThen( //dodatkowy kolektor, ktory wykona jeszcze jedna operacje po zebraniu wyniku
                                Collectors.maxBy( //wybiera max element
                                        Comparator.comparing(Person::getAge)),
                                Optional::get))); // uzywamy w razie gdy jest puste
    }

    public static Map<Boolean, List<Person>> podzielPoRoku2000(List<Person> persons) {
        return persons.stream()
                .collect(Collectors.groupingBy(Person -> Person.getYearOfBirth() >= 2000, Collectors.toList()));
    }

    public static Map<Integer, Long> policzOsobyWDekadach(List<Person> persons) {
        return persons.stream()
                .collect(Collectors.groupingBy(Person -> Person.getYearOfBirth() / 10 * 10, Collectors.counting()));
        //groupingBy kiedy dodamy counting zwraca Map<Cos, Long>

    }

    public static int iloczynLiczb(List<Integer> calkowite) {
        return calkowite.stream()
                .reduce(1, (a, b) -> a * b);
        // jedynka to wartosc podstawowa, przy mnozeniu neutralna
        //dalej jest lambda pozwalajaca obliczyc
    }

    public static Map<String, List<Person>> grupujPoSporcie(List<Person> persons) {
        return persons.stream()
                .collect(Collectors.groupingBy(Person::getFavouriteSport));
        //groupingBy zwraca mape w formacie Map<Cos,List<>>
    }

    public static List<Person> filterPersons(int yearOfBirth, String favouriteSport, List<Person> persons) {
        return persons.stream()
                .filter(n -> n.getYearOfBirth() < yearOfBirth)
                .filter(n -> n.getFavouriteSport().equals(favouriteSport))
                .toList();

    }

}
