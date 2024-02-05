package be.vdab;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ZusterBedrijf  {

    private static final Path PATH = Paths.get("/data/personeel.dat");

    public ZusterBedrijf() {
    }

    public void leesGegevens() {
        try (var stream = new ObjectInputStream(Files.newInputStream(PATH))) {
            System.out.println("Lees Gegevens van Werknemers :");
            var ss = stream.readObject();
            System.out.println(ss);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
