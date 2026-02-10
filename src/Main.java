import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

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




    }
}
