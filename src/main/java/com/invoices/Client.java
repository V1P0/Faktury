package com.invoices;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Client {
    private final List<Facture> faktury = new LinkedList<>();
    private final String name,surname,address;
    public Client(final String name,final  String surname, final String address){
        this.name = name;
        this.address = address;
        this.surname = surname;
    }
    public String view(){
        return name + " " + surname + " " + address;
    }
    public void addFacture(){
        final Facture newFacture = new Facture();
        final Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("1 - dodaj produkt");
            System.out.println("Dowolny inny symbol - wyjdz");
            final String menu = scanner.nextLine();
            if("1".equals(menu)) {
                newFacture.addProduct();
            }else{
                faktury.add(newFacture);
                scanner.close();
                return;
            }
        }
    }
    public void seeFactures(){
        for(final Facture f : faktury){
            System.out.println("===================");
            f.view();
            System.out.println("Suma: " + f.koszt());
        }
        System.out.println("===================");
    }
}
