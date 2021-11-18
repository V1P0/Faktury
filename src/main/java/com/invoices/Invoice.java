package com.invoices;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * klasa majaca liste produktow i umozliwiajaca dodawanie produktu do listy
 */
public class Invoice {
    private final List<Product> produkty = new LinkedList<>();

    /**
     * funkcja wyswietlajaca produkty na fakturze
     */
    public void view(){
        for (final Product p:produkty) {
            System.out.println(p.view());
        }
    }

    /**
     * funkcja dodajaca pordukt do listy
     */
    public void addProduct(){
        final Scanner scanner = new Scanner(System.in);
        int ilosc;
        float cena;
        System.out.println("dodaj ilosc produktu:");
        while(true) {
            try {
                ilosc = Integer.parseInt(scanner.nextLine());
                if(ilosc < 1) {throw new NumberFormatException();}
                break;
            }catch (NumberFormatException e){
                System.out.println("nieprawidlowa ilosc, podaj prawidlowa liczbe");
            }
        }
        System.out.println("podaj nazwe produktu:");
        final String nazwa = scanner.nextLine();
        System.out.println("podaj cene produktu:");
        while(true) {
            try {
                cena = Float.parseFloat(scanner.nextLine());
                if(cena < 1) {throw new NumberFormatException();}
                break;
            }catch (NumberFormatException e){
                System.out.println("nieprawidlowa cena, podaj prawidlowa liczbe");
            }
        }
        produkty.add(new Product(ilosc,nazwa,cena));
    }

    /**
     * funkcja zwracajaca zsumowany koszt faktury
     */
    public float koszt(){
        float koszt = 0;
        for (final Product p: produkty) {
            koszt+=p.summarizedCost();
        }
        return koszt;
    }
}
