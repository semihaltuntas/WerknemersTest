package be.vdab.util;

import be.vdab.util.Datum;
import be.vdab.util.DatumException;

import java.io.Serializable;

public class WerknemersDatum extends Datum implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final Datum oprichtingsdatum = new Datum(12, 02, 1977);


    public WerknemersDatum(int dag, int maand, int jaar) throws DatumException {
        super(dag, maand, jaar);

        Datum werknemersdatum = new Datum(dag, maand, jaar);
        if (werknemersdatum.compareTo(oprichtingsdatum)<0){
            throw new WerknemerException("Werknemersdatum moet na de oprichtingsdatum zijn");
        }

    }
}
