package be.vdab.personeel.kader;

import be.vdab.personeel.Bediende;
import be.vdab.util.WerknemerException;
import be.vdab.util.WerknemersDatum;
import java.math.BigDecimal;

public class Kaderlid extends Bediende {
    public enum Functietitel {
        DIRECTEUR, CEO, MANAGER
    }

    private Functietitel functietitel;

    public Kaderlid(int personeelsNummer, String naam, Geslacht geslacht,
                    WerknemersDatum datumInDienst, BigDecimal maandwedde, Functietitel functietitel) {
        super(personeelsNummer, naam, geslacht, datumInDienst, maandwedde);
        setFunctietitel(functietitel);
    }

    public Functietitel getFunctietitel() {
        return functietitel;
    }

    public void setFunctietitel(Functietitel functietitel) {
        if (functietitel == null) {
            throw new WerknemerException("De functietitel moet ingevuld zijn..!");
        }
        this.functietitel = functietitel;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + getFunctietitel();
    }
}
