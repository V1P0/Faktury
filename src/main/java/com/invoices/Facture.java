package com.invoices;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Facture {
    private final List<Product> produkty = new LinkedList<>();
    public void view(){
        for (final Product p:produkty) {
            System.out.println(p.view());
        }
    }
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
        scanner.close();
    }
    public float koszt(){
        float koszt = 0;
        for (final Product p: produkty) {
            koszt+=p.summarizedCost();
        }
        return koszt;
    }
}
