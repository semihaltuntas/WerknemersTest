package be.vdab.personeel;

import be.vdab.util.Datum;
import be.vdab.util.WerknemerException;
import be.vdab.util.WerknemersDatum;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public abstract class Werknemer implements Comparable, Serializable {
    private static final long serialVersionUID = 1L;

    public enum Geslacht {
        M, V
    }

    private final int personeelsNummer;
    private String naam;
    private Geslacht geslacht;
    private WerknemersDatum datumInDienst;

    public Werknemer(int personeelsNummer, String naam, Geslacht geslacht, WerknemersDatum datumInDienst) {
        if (personeelsNummer < 1) {
            throw new WerknemerException("Het personeelsnummer kan niet 0 of negatief zijn.");
        }
        this.personeelsNummer = personeelsNummer;
        setNaam(naam);
        setGeslacht(geslacht);
        setDatumInDienst(datumInDienst);
    }

    public int getPersoneelsNummer() {
        return personeelsNummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        if (naam.isBlank() || naam == null) {
            throw new WerknemerException("De naam moet ingevuld worden.");
        }
        this.naam = naam;
    }

    public Geslacht getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(Geslacht geslacht) {
        if (geslacht == null) {
            throw new WerknemerException("Het geslacht moet ingevuld worden.");
        }
        this.geslacht = geslacht;
    }

    public WerknemersDatum getDatumInDienst() {
        return datumInDienst;
    }

    public void setDatumInDienst(WerknemersDatum datumInDienst) {
        if (datumInDienst == null) {
            throw new WerknemerException("DatumInDienst moet ingevuld worden");
        }
        this.datumInDienst = datumInDienst;
    }

    @Override
    public int compareTo(Object o) {
        var obje = (Werknemer) o;
        return personeelsNummer - obje.getPersoneelsNummer();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\t")
                .append(personeelsNummer)
                .append("\t")
                .append(datumInDienst)
                .append("\t")
                .append(naam)
                .append("\t")
                .append(geslacht)
                .append("\t")
                .append(getVerloning());
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Werknemer werknemer = (Werknemer) o;
        return personeelsNummer == werknemer.personeelsNummer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(personeelsNummer);
    }

    public abstract BigDecimal getVerloning();
}
