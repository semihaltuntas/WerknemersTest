package be.vdab.util;

import java.io.Serializable;
import java.util.Objects;

public class Datum implements IDatum, Comparable<Datum>, Serializable {

    private int dag;
    private int maand;
    private int jaar;

    public Datum(int dag, int maand, int jaar) throws DatumException {
        if (dag < 1 || dag > dagVanMaand(maand, jaar)) {
            throw new DatumException("De dag moet tussen 1 en " + dagVanMaand(maand, jaar) + " liggen..!");
        }
        if (maand < 1 || maand > 12) {
            throw new DatumException("De maand moet tussen 1 en 12 liggen..!");
        }
        if (jaar < 1584 || jaar > 4099) {
            throw new DatumException("Het jaar moet tussen 1584 en 4099 liggen..!");
        }

        this.dag = dag;
        this.maand = maand;
        this.jaar = jaar;
    }

    public int dagVanMaand(int maand, int jaar) {
        switch (maand) {
            case 2 -> {
                return isSchrikkeljaar(jaar) ? 29 : 28;
            }
            case 4, 6, 9, 11 -> {
                return 30;
            }
            default -> {
                return 31;
            }
        }
    }


    public boolean isSchrikkeljaar(int jaar) {
        return (jaar % 4 == 0 && jaar % 100 != 0) || jaar % 400 == 0;
    }


    @Override
    public int getDag() {
        return dag;
    }

    @Override
    public int getMaand() {
        return maand;
    }

    @Override
    public int getJaar() {
        return jaar;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dag, maand, jaar);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Datum datum = (Datum) o;
        return dag == datum.dag && maand == datum.maand && jaar == datum.jaar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dag, maand, jaar);
    }

    @Override
    public int compareTo(Datum andere) {
        if (jaar != andere.jaar) {
            return jaar - andere.jaar;
        } else if (maand != andere.maand) {
            return maand - andere.maand;
        } else {
            return dag - andere.dag;
        }
    }
}
