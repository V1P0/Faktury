package com.invoices;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * klasa odpowiedzialna za uruchamianie aplikacji, posiada dostęp do listy klientów i może aktywować wyświetlanie faktur lub dodawanie faktur dla danego klienta
 * GRASP - niskie sprzezenie i wysoka spojnosc przez liniowe polaczenie klas Aplication -> Client -> Facture -> Product
 */
public class Aplication {
    private final List<Client> klienci = new LinkedList<>();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(final String[] args) {
        new Aplication();
    }
    public Aplication(){

        while(true) {
            System.out.println("1 - Dodaj klienta");
            System.out.println("2 - Operacje na kliencie");
            System.out.println("Dowolny inny symbol - wyjdz");
            final String menu = scanner.nextLine();
            switch(menu){
                case "1" -> addClient();
                case "2" -> clientOperations();
                default -> System.exit(0);
            }
        }
    }
    public void addClient(){
        System.out.println("Podaj imie klienta:");
        final String name = scanner.nextLine();
        System.out.println("Podaj nazwisko klienta:");
        final String surname = scanner.nextLine();
        System.out.println("Podaj adres klienta:");
        final String address = scanner.nextLine();
        klienci.add(new Client(name,surname,address));
    }
    public void clientOperations(){
        final Client currentClient = chooseClient();
        while(true){
            System.out.println("1 - dodaj fakture");
            System.out.println("2 - wyswietl faktury");
            System.out.println("Dowolny inny symbol - wyjdz");
            final String menu = scanner.nextLine();
            switch(menu){
                case "1" -> currentClient.addFacture();
                case "2" -> currentClient.seeFactures();
                default -> {return;}
            }
        }

    }
    public Client chooseClient(){
        int number = 0;
        for(final Client c : klienci){
            System.out.println(number + " - " + c.view());
            number++;
        }
        System.out.println("na ktorym kliencie chcesz wykonac operacje:");
        int clientid;
        while(true) {
            try {
                clientid = Integer.parseInt(scanner.nextLine());
                if(clientid >= klienci.size()) {throw new NumberFormatException();}
                break;
            } catch (NumberFormatException e) {
                System.out.println("nieprawidłowy numer, podaj prawidlowy numer:");
            }
        }
        return klienci.get(clientid);
    }
}
