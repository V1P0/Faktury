package com.invoices;

public class Product {
    private final String nazwa;
    private final int ilosc;
    private final float cena;
    public Product(final int ilosc, final String nazwa, final float cena){
        this.ilosc=ilosc;
        this.nazwa=nazwa;
        this.cena=cena;
    }
    public float summarizedCost(){
        return ilosc*cena;
    }
    public String view(){
        return ilosc + " | " + nazwa + " | " + cena;
    }
}
