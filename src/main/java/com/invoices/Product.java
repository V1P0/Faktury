package com.invoices;

/**
 * klasa ktora przechowuje nazwe, ilosc i koszt produktu
 */
public class Product {
    private final String nazwa;
    private final int ilosc;
    private final float cena;
    public Product(final int ilosc, final String nazwa, final float cena){
        this.ilosc=ilosc;
        this.nazwa=nazwa;
        this.cena=cena;
    }

    /**
     * funkcja zwracajaca koszt produktow
     */
    public float summarizedCost(){
        return ilosc*cena;
    }

    /**
     *funkcja zwracajaca string z danymi produktu
     */
    public String view(){
        return ilosc + " | " + nazwa + " | " + cena;
    }
}
