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

        List<Integer>  xxx = numbers.stream()
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
                .filter(n-> n % 2 != 0)
                .toList();
        System.out.println(oddNumbers);

        System.out.println("Zadanie 2: wszystkie liczby do kwadratu");

        List<Integer> squaredNumbers = numbers.stream()
                .map(n-> n * n)
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
                .map(n-> String.valueOf(n))
                .toList();
        System.out.println(changeToString.get(0).length()); // length istnieje tylko dla Stringa a wiec tak sie sprawdza czy jest dobrze
        System.out.println(changeToString);

        System.out.println("Zadanie 12: wszystkie elementy for each");

        numbers.stream().forEach(System.out::println);
        numbers.stream().forEach(n-> System.out.println(n));
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
                .map(n-> n * n)
                .filter(n-> n >50)
                .toList();
        System.out.println(doKwadratu);

        //   3. Przelicz na double i wyświetl bez powtórzeń połówki każdej liczby
        System.out.println();
        System.out.println("2: Przeliczenie na double, bez dubli polowki kazdej liczby");
        List<Double> polowki = numbers.stream()
                .map(n-> n - (0.5 * n))
                .distinct()
                .toList();
        System.out.println(polowki);

        //   4. Zapisz liczbę unikalnych elementów do zmiennej a następnie ją wyświetl
        System.out.println();
        System.out.println("4: unikalne elementy");
        List<Integer> unikaty = numbers.stream()
                .distinct()
                .toList();
        System.out.println(unikaty);

        //   5. Wyświetl elementy rosnąco
        System.out.println();
        System.out.println("5: Elementy rosnaco");
        List<Integer> rosnaco = numbers.stream()
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
                .mapToInt(n-> n * 2)
                .sum();
        System.out.println(suma);

        //   9. Oblicz średnią elementów na liście
        System.out.println();
        System.out.println("9: Średnia elementów na liście");
        double iloscElementow = numbers.stream()
                .mapToInt(n-> n)
                .average()
                .orElse(0); // tak sie daje jakby lista byla pusta i zeby zamknac streama

        BigDecimal zaokraglona = BigDecimal.valueOf(iloscElementow);
        System.out.println(zaokraglona.setScale(2, RoundingMode.HALF_UP));

        //   10. Policz ile jest liczb parzystych
        System.out.println();
        System.out.println("10: Ilość liczb parzystych");
        List<Integer> parzyste = numbers.stream()
                .filter(n-> n % 2 == 0)
                .toList();
        System.out.println(parzyste);

        //   11. Policz ile jest różnych liczb parzystych
        System.out.println();
        System.out.println("11: Ilość różnych liczby parzystych");
        long rozneParzyste = numbers.stream()
                .filter(n-> n % 2 == 0)
                .count();
        System.out.println(rozneParzyste);

        //   12. Napisz klasę Osoba, która będzie zawierała pola imie, nazwisko, rokUrodzenia, ulubionySport
        System.out.println();
        System.out.println("12: Klasa Osoba");

        Person derek = new Person("Derek", "Kutafon", 1978, "Piłka nożna");
        Person stefan = new Person("Stefan", "Jarzębina", 1988, "Koszykówka");
        Person zyta = new Person("Zyta", "Placek", 1978, "Siatkówka");
        Person klaus = new Person("Klaus", "Germański", 1999,"Piłka nożna");
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
                .filter(n-> n.getYearOfBirth() > 1998)
                .count();
        System.out.println(rokUrodzenia);

        //   14. Napisz strumień, który dla podanej listy osób zwróci te, które urodziły się przed rokiem 1990
        System.out.println();
        System.out.println("14: Osoby urodzone przed rokiem 1990");
        List<Person> urodzonePo90 = persons.stream()
                .filter(n-> n.getYearOfBirth() > 1990)
                .collect(Collectors.toList());
        System.out.println(urodzonePo90);

        //   15. Napisz strumień, który dla podanej listy osób zwróci te, które urodziły się przed rokiem 1990 posortowane po nazwisku
        System.out.println();
        System.out.println("15: Osoby urodzone przed rokiem 1990 posortowane po nazwisku");
        List<Person> poNazwisku = persons.stream()
                .filter(n-> n.getYearOfBirth() < 1990)
                .sorted(Comparator.comparing(Person::getSurname))
                .collect(Collectors.toList());
        poNazwisku.forEach(n-> System.out.println(n.getSurname() + " " + stefan.getName()));

        //   16. Napisz strumień, który dla podanej listy osób zwróci te, które lubią grać w piłkę nożną
        System.out.println();
        System.out.println("16: osoby, które lubią grać w piłkę nożną");
        List<Person> pilka = persons.stream()
                .filter(n-> n.getFavouriteSport().equals("Piłka nożna"))
                .collect(Collectors.toList());
        System.out.println(pilka);

        //   17. Napisz strumień, który dla podanej listy osób zwróci te, które urodziły się przed rokiem 1998 i lubią koszykówkę
        System.out.println();
        System.out.println("17: Osoby urodzone przed 1998 i lubiące koszykówkę");
        List<Person> osoby = persons.stream()
                .filter(n-> n.getYearOfBirth() < 1998 && n.getFavouriteSport().equals("Koszykówka"))
                .collect(Collectors.toList());
        System.out.println(osoby);

        //   18. Napisz strumień, który dla podanej listy osób zwróci te, które urodziły się przed rokiem 1998 i lubią koszykówkę
        //  (osoby posortowane po nazwisku, jeśli nazwisko takie samo to po imieniu)
        System.out.println();
        System.out.println("18: Osoby urodzone przed 1998 lubiace koszykowke, posortowane po nazwisku ");
        List<Person> osoby2 = persons.stream()
                .filter(n-> n.getYearOfBirth() < 1998 && n.getFavouriteSport().equals("Koszykówka"))
                .collect(Collectors.toList());

        osoby2.forEach(n-> System.out.println(n.getSurname() + " " + n.getName()));

        //   19. Napisz metodę, która dla podanej listy osób zwróci te, które urodziły się przed podanym jako argument rokiem i lubią
        //  podany jako argument sport
        System.out.println();
        System.out.println("19: Metoda"); // musze nad tym wiecej pomyslec



            //   20. Napisz strumień, który dla podanej listy osób zwróci tę, która jest najstarsza
        int maxAge = persons.stream()
                .mapToInt(Person::getAge)
                .max()
                .orElseThrow(); // to sie pisze w razie pustej listy
        List<Person> old = persons.stream()
                .filter(n-> n.getAge() == maxAge) // jezeli maja taki sam wiek
                .collect(Collectors.toList());
        System.out.println(old);



    }
}
