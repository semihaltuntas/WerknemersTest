package be.vdab;

import be.vdab.personeel.Arbeider;
import be.vdab.personeel.Bediende;
import be.vdab.personeel.Bedrijf;
import be.vdab.personeel.Werknemer;
import be.vdab.personeel.kader.Kaderlid;
import be.vdab.util.WerknemerException;
import be.vdab.util.WerknemersDatum;

import java.math.BigDecimal;

public class BedrijfApp {
    public static void main(String[] args) {

        // Correctie Werknemer Gegevens

        Bedrijf correctieWerknemersGegevens = new Bedrijf();

        Arbeider semih = new Arbeider(3, "Semih", Werknemer.Geslacht.M,
                new WerknemersDatum(12, 5, 1987), BigDecimal.valueOf(9.76));
        Arbeider steve = new Arbeider(4, "Steve", Werknemer.Geslacht.M,
                new WerknemersDatum(14, 7, 1992), BigDecimal.valueOf(12.9));
        Bediende burak = new Bediende(1, "Burak", Werknemer.Geslacht.M,
                new WerknemersDatum(15, 9, 2022), BigDecimal.valueOf(1423.56));
        Bediende marco = new Bediende(5, "Marco", Werknemer.Geslacht.M,
                new WerknemersDatum(14, 12, 1999), BigDecimal.valueOf(1315.65));
        Kaderlid jutta = new Kaderlid(2, "Jutta", Werknemer.Geslacht.V,
                new WerknemersDatum(23, 10, 1987), BigDecimal.valueOf(2100.45), Kaderlid.Functietitel.DIRECTEUR);
        Kaderlid frank = new Kaderlid(6, "Frank", Werknemer.Geslacht.M,
                new WerknemersDatum(10, 12, 1998), BigDecimal.valueOf(3100.98), Kaderlid.Functietitel.MANAGER);
        Kaderlid ander = new Kaderlid(6, "ander", Werknemer.Geslacht.M,
                new WerknemersDatum(11, 12, 1982), BigDecimal.valueOf(2100), Kaderlid.Functietitel.MANAGER);


        correctieWerknemersGegevens.voegWerknemerToe(semih);
        correctieWerknemersGegevens.voegWerknemerToe(steve);
        correctieWerknemersGegevens.voegWerknemerToe(burak);
        correctieWerknemersGegevens.voegWerknemerToe(marco);
        correctieWerknemersGegevens.voegWerknemerToe(jutta);
        correctieWerknemersGegevens.voegWerknemerToe(frank);
        correctieWerknemersGegevens.voegWerknemerToe(ander);

        System.out.println("Print Lijst :");
        correctieWerknemersGegevens.printLijst();

        System.out.println("\n");
        System.out.println("Lijst van Arbeiders :");
        correctieWerknemersGegevens.lijstVanArbeiders().forEach(System.out::println);

        System.out.println("\n");
        System.out.println("GesorteerdeLijst van Werknemers :");
        correctieWerknemersGegevens.gesorteerdeLijst().forEach(System.out::println);

        System.out.println("\n");
        System.out.println("Percentage Mannelijke Werknemers :" + correctieWerknemersGegevens.percentageMannelijkeWerknemers());
        System.out.println("\n");

        // Van uurloon naar Maandwedde
        var alex = new Arbeider(10, "Alex", Werknemer.Geslacht.M,
                new WerknemersDatum(24, 5, 1986), BigDecimal.valueOf(14.5));
        System.out.println("Van uurloon naar Maandwedde van Alex :" + alex.getVerloning());
        System.out.println("\n");


        // Schrijven naar en lezen uit bestand (Path)
        correctieWerknemersGegevens.bewaarLijst();
        var lezenVanGegevens = new ZusterBedrijf();
        lezenVanGegevens.leesGegevens();


        // Foutieve vermeldingen.
        System.out.println("\n");
        System.out.println("Foutieve vermeldingen.");
        var verkeerdeWerknemersGegevens = new Bedrijf();
        try {
            verkeerdeWerknemersGegevens.voegWerknemerToe(new Kaderlid(3, "Leslie",
                    Werknemer.Geslacht.M, new WerknemersDatum(24, 10, 1999),
                    BigDecimal.valueOf(1000.90), Kaderlid.Functietitel.MANAGER));
        } catch (WerknemerException ex) {
            System.err.println(ex.getMessage());
        }
        try {
            verkeerdeWerknemersGegevens.voegWerknemerToe(new Arbeider(1, "Alex",
                    Werknemer.Geslacht.M, new WerknemersDatum(16, 6, 1989), BigDecimal.valueOf(7.90)));
        } catch (WerknemerException ex) {
            System.err.println(ex.getMessage());
        }
        try {
            verkeerdeWerknemersGegevens.voegWerknemerToe(new Bediende(2, "Ian",
                    Werknemer.Geslacht.M, new WerknemersDatum(13, 12, 1973), BigDecimal.valueOf(1455.55)));
        } catch (WerknemerException ex) {
            System.err.println(ex.getMessage());
        }
        try {
            verkeerdeWerknemersGegevens.voegWerknemerToe(new Bediende(0, "Angela",
                    Werknemer.Geslacht.V, new WerknemersDatum(13, 12, 1985), BigDecimal.valueOf(1785.55)));
        } catch (WerknemerException ex) {
            System.err.println(ex.getMessage());
        }
        try {
            verkeerdeWerknemersGegevens.voegWerknemerToe(new Arbeider(7, "Bred",
                   null, new WerknemersDatum(22, 12, 1988), BigDecimal.valueOf(10.89)));
        } catch (WerknemerException ex) {
            System.err.println(ex.getMessage());
        }


    }
}
