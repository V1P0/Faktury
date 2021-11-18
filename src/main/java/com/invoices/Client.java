package com.invoices;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * klasa posiadajaca liste faktur dla klienta i umozliwiajaca dodawanie nowych faktur
 */
public class Client {
    private final List<Invoice> faktury = new LinkedList<>();
    private final String name,surname,address;
    public Client(final String name,final  String surname, final String address){
        this.name = name;
        this.address = address;
        this.surname = surname;
    }

    /**
     * funkcja zwracajaca string z imieniem nazwiskiem i adresem klienta
     */
    public String view(){
        return name + " " + surname + " " + address;
    }

    /**
     * funkcja dodajaca fakture do klienta
     */
    public void addFacture(){
        final Invoice newFacture = new Invoice();
        final Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("1 - dodaj produkt");
            System.out.println("Dowolny inny symbol - wyjdz");
            final String menu = scanner.nextLine();
            if("1".equals(menu)) {
                newFacture.addProduct();
            }else{
                faktury.add(newFacture);
                return;
            }
        }
    }

    /**
     * funkcja wyswietlajaca faktury klienta
     */
    public void seeFactures(){
        for(final Invoice f : faktury){
            System.out.println("===================");
            f.view();
            System.out.println("Suma: " + f.koszt());
        }
        System.out.println("===================");
    }
}
