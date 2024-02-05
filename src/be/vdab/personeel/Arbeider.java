package be.vdab.personeel;

import be.vdab.util.WerknemerException;
import be.vdab.util.WerknemersDatum;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Arbeider extends Werknemer implements Serializable {
    private static final long serialVersionUID = 1L;
    private BigDecimal uurloon;

    public Arbeider(int personeelsNummer, String naam, Geslacht geslacht,
                    WerknemersDatum datumInDienst, BigDecimal uurloon) throws WerknemerException {
        super(personeelsNummer, naam, geslacht, datumInDienst);
        setUurloon(uurloon);
    }

    public BigDecimal getUurloon() {
        return uurloon;
    }

    public void setUurloon(BigDecimal uurloon) {
        if (uurloon.compareTo(BigDecimal.valueOf(9.76)) < 0) {
            throw new WerknemerException("Het minimum uurloon moet 9,76 euro zijn..!");
        }
        this.uurloon = uurloon;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + String.valueOf(uurloon) ;
    }

    @Override
    public BigDecimal getVerloning() {
        return uurloon
                .multiply(BigDecimal.valueOf(7.6))
                .multiply(BigDecimal.valueOf(65))
                .divide(BigDecimal.valueOf(3),2, RoundingMode.HALF_UP);
    }
}
