package org.exercise.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true){
            //punto 1 milestone 2
            System.out.println("Inserisci un nuovo evento:");
            String newEvento = scan.nextLine();

            System.out.println("Inserisci una data per l'evento in questo formato (YYYY-MM-DD):");
            LocalDate newData = LocalDate.parse(scan.nextLine());

            System.out.println("Inserisci quanti posti totali possono esserci:");
            int newPostiPrenotati = Integer.parseInt(scan.nextLine());

            Evento evento;
            try{
                evento= new Evento(newEvento, newData, newPostiPrenotati, 0);
                System.out.println("Evento creato con successo:"
                        + evento);
            } catch (IllegalArgumentException e){
                System.out.println("C'è un errore:" + e.getMessage() );
                return;
            }
            //punto 2 milestone 2
            System.out.println("Vuoi prenotare dei posti? Si/No");
            String prenotazioni= scan.nextLine();
            if (prenotazioni.equalsIgnoreCase("si")){
                System.out.println("Quanti posti vuoi prenotare?");
                int postiDaPrenotare = Integer.parseInt(scan.nextLine());
                try{
                    evento.prenota(postiDaPrenotare);
                    System.out.println("Posti prenotati con successo");
                } catch (IllegalArgumentException e){
                    System.out.println("Errore:" + e.getMessage());
                }
            }
            //punto 3 milestone 2
            System.out.println("Il numero di posti prenotati è:" + " " + evento.getPostiPrenotati());
            System.out.println("Il numero totale dei posti disponibile è:" + " " + (evento.getPostiTotali() - evento.getPostiPrenotati()));

            //punto 4 e 5 milestone 2
            System.out.println("Vuoi disdire dei posti? Si/No");
            String disdette= scan.nextLine();
            if (disdette.equalsIgnoreCase("si")){
                System.out.println("Quanti posti vuoi disdire?");
                int postiDaDisdire = Integer.parseInt(scan.nextLine());
                try{
                    evento.disdici(postiDaDisdire);
                    System.out.println("Posti disdetti:");
                } catch (IllegalArgumentException e){
                    System.out.println("Errore:" + e.getMessage());
                }
            }
            //punto 6 milestone 2
            System.out.println("Il numero di posti prenotati, dopo le relative disdette è:" + " " + evento.getPostiPrenotati());
            System.out.println("Il numero totale dei posti disponibile è:" + " " + (evento.getPostiTotali() - evento.getPostiPrenotati()));
        }


    }
}
