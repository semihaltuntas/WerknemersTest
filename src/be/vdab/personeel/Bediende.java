package be.vdab.personeel;

import be.vdab.util.WerknemerException;
import be.vdab.util.WerknemersDatum;

import java.io.Serializable;
import java.math.BigDecimal;

public class Bediende extends Werknemer implements Serializable {
    private static final long serialVersionUID = 1L;

    private BigDecimal maandwedde;

    public Bediende(int personeelsNummer, String naam, Geslacht geslacht, WerknemersDatum datumInDienst, BigDecimal maandwedde) {
        super(personeelsNummer, naam, geslacht, datumInDienst);
        setMaandwedde(maandwedde);
    }


    public BigDecimal getMaandwedde() {
        return maandwedde;
    }

    public void setMaandwedde(BigDecimal maandwedde) {
        if (maandwedde.compareTo(BigDecimal.valueOf(1129.47)) < 0) {
            throw new WerknemerException("De minimum maandwedde moet 1129,47 euro zijn..!");
        }
        this.maandwedde = maandwedde;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + String.valueOf(maandwedde);
    }

    @Override
    public BigDecimal getVerloning() {
        return maandwedde;
    }
}
