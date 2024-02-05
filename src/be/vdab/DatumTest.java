package be.vdab;

import be.vdab.util.Datum;
import be.vdab.util.DatumException;

import java.io.IOException;
import java.util.LinkedHashSet;

public class DatumTest {
    public static void main(String[] args) {

        // Je mag gestoordeLijst checken .!!
        System.out.println("Gesorteerd lijst van oud naar nieuw :");
        var datumLijst = new LinkedHashSet<>();

        try {
            Datum datum1 = new Datum(05, 7, 1975);
            Datum datum2 = new Datum(06, 8, 2003);
            Datum datum3 = new Datum(06, 8, 1975);
            Datum datum4 = new Datum(10, 8, 2003);
            Datum datum5 = new Datum(14, 10, 1968);

            datumLijst.add(datum1);
            datumLijst.add(datum2);
            datumLijst.add(datum3);
            datumLijst.add(datum4);
            datumLijst.add(datum5);

            datumLijst.stream().sorted().forEach(System.out::println);

        } catch (DatumException ex) {
            System.err.println(ex.getMessage());
        }

        System.out.println("--------");


        System.out.println("De exceptions van de foute datum objecten :");
     // De exceptions van de foute datum objecten.

        try {
            Datum datum = new Datum(32, 2, 2000);
            System.out.println("datum = " + datum);

        } catch (DatumException ex) {
            System.err.println(ex.getMessage());
        }


        try {
            Datum datum = new Datum(17, 13, 1888);
            System.out.println("datum = " + datum);
        } catch (DatumException ex) {
            System.err.println(ex.getMessage());
        }

        try {
            Datum datum = new Datum(14, 8, 1543);
            System.out.println("datum = " + datum);
        } catch (DatumException ex) {
            System.err.println(ex.getMessage());
        }
        try {
            Datum datum = new Datum(5, 5, 1990);
            System.out.println("datum = " + datum);
        } catch (DatumException ex) {
            System.err.println(ex.getMessage());
        }
        try {
            Datum datum = new Datum(22, 12, 4100);
            System.out.println("datum = " + datum);
        } catch (DatumException ex) {
            System.err.println(ex.getMessage());
        }
        try {
            Datum datum = new Datum(29, 2, 2001);
            System.out.println("datum = " + datum);
        } catch (DatumException ex) {
            System.err.println(ex.getMessage());
        }
        try {
            Datum datum = new Datum(29, 2, 2000);
            System.out.println("datum = " + datum);
        } catch (DatumException ex) {
            System.err.println(ex.getMessage());
        }

        try {
            Datum datum = new Datum(29, 0, 2000);
            System.out.println("datum = " + datum);
        } catch (DatumException ex) {
            System.err.println(ex.getMessage());
        }


    }

}
