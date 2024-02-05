package be.vdab.personeel;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Bedrijf implements Serializable {
    private static final Path PATH = Paths.get("/data/personeel.dat");
    private static final long serialVersionUID = 1L;
    private List<Werknemer> bedrijfslijst;

    public Bedrijf() {
        this.bedrijfslijst = new LinkedList<>();
    }

    public List<Werknemer> getBedrijfslijst() {
        return bedrijfslijst;
    }

    public void voegWerknemerToe(Werknemer werknemer) {
        if (!bedrijfslijst.contains(werknemer))
            bedrijfslijst.add(werknemer);
    }

    public void printLijst() {
        if (bedrijfslijst != null && !bedrijfslijst.isEmpty()) {
            bedrijfslijst.stream()
                    .collect(Collectors.groupingBy(Werknemer::getNaam))
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(entry -> {
                        System.out.println("\t" + entry.getKey());
                        entry.getValue().forEach(System.out::println);
                    });
        }
    }

    public List<Werknemer> gesorteerdeLijst() {
        return bedrijfslijst
                .stream()
                .sorted(Comparator.naturalOrder())
                .toList();

    }

    public List<Werknemer> lijstVanArbeiders() {
        return bedrijfslijst
                .stream()
                .filter(werknemer -> werknemer instanceof Arbeider)
                .toList();
    }

    public double percentageMannelijkeWerknemers() {
        var aantalMannen = bedrijfslijst
                .stream()
                .filter(werknemer -> werknemer.getGeslacht().equals(Werknemer.Geslacht.M))
                .count();
        return (double) aantalMannen * 100 / bedrijfslijst.size();
    }


    public void bewaarLijst() {
        try (var stream = new ObjectOutputStream(Files.newOutputStream(PATH))) {
            stream.writeObject(bedrijfslijst);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }


}
