package poeDownloader;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleActions {

    public Map<String, String> scannerMethod() {

        Map<String, String> listOfChoices = new HashMap();


        Scanner scanner = new Scanner(System.in);

        System.out.println("to jest apka do pobierania filtrów ze strony. Apka automatycznie ściąga pliki do lokalizacji poe");
        System.out.println("wybierz filtr: rekomendowany wybór: NeverSink(stable)");
        System.out.println("inne wyory : NeverSink(latest softcore)     ;     NeverSink(latest hardcore) ");
        System.out.println("dla NeverSink(stable) wybierz 1");
        System.out.println("dla NeverSink(latest softcore)  wybierz 2");
        System.out.println("dla NeverSink(latest hardcore) wybierz 3");
        String filterSpecies = scanner.nextLine();
        listOfChoices.put("filterSpecies", filterSpecies);
        System.out.println("wybrałeś  :" + filterSpecies);

        return listOfChoices;
    }
}
