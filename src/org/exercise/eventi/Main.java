package org.exercise.eventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Concerto concerto = null;
        boolean play = false;

        while (!play){
            //punto 1 milestone 2

            try{
                System.out.println("Inserisci un nuovo evento:");
                String newEvento = scan.nextLine();

                System.out.println("Inserisci una data per l'evento in questo formato (YYYY-MM-DD):");
                LocalDate newData = LocalDate.parse(scan.nextLine());

                System.out.println("Inserisci quanti posti totali possono esserci:");
                int newPostiPrenotati = Integer.parseInt(scan.nextLine());
                System.out.println("Inserisci l'ora (HH:mm):");
                LocalTime ora = LocalTime.parse(scan.nextLine());

                System.out.println("Inserisci il prezzo:");
                BigDecimal prezzo = new BigDecimal(scan.nextLine());

               concerto= new Concerto(newEvento, newData, newPostiPrenotati, 0, ora, prezzo);

                play = true;

            } catch (Exception e){
                System.out.println("C'è un errore:" + e.getMessage() );

            }
        }

            System.out.println("------------------------------");
            System.out.println();
            System.out.println("Evento creato con successo:" + concerto);
            System.out.println("------------------------------");


            //punto 2 milestone 2
        boolean playP = false;
        while(!playP){
            System.out.println("Vuoi prenotare dei posti? Si/No");
            String prenotazioni= scan.nextLine();
            if (prenotazioni.equalsIgnoreCase("si")){
                System.out.println("Quanti posti vuoi prenotare?");
                int postiDaPrenotare = Integer.parseInt(scan.nextLine());
                try{
                    concerto.prenota(postiDaPrenotare);
                    System.out.println("Posti prenotati con successo");
                    playP=true;
                } catch (Exception e){
                    System.out.println("Errore:" + e.getMessage());
                }
            } else if (prenotazioni.equalsIgnoreCase("no")) {
                break;
            }
        }

        //punto 3 milestone 2
        System.out.println("Il numero di posti prenotati è:" + " " + concerto.getPostiPrenotati());
        System.out.println("Il numero totale dei posti disponibile è:" + " " + (concerto.getPostiTotali() - concerto.getPostiPrenotati()));

        //punto 4 e 5 milestone 2
        boolean playD = false;
        while (!playD){
            System.out.println("Vuoi disdire dei posti? Si/No");
            String disdette= scan.nextLine();
            if (disdette.equalsIgnoreCase("si")){
                System.out.println("Quanti posti vuoi disdire?");
                int postiDaDisdire = Integer.parseInt(scan.nextLine());
                try{
                    concerto.disdici(postiDaDisdire);
                    System.out.println("Posti disdetti:");
                    playD=true;
                } catch (Exception e){
                    System.out.println("Errore:" + e.getMessage());
                }
            }else if (disdette.equalsIgnoreCase("no")) {
                break;
            }
        }
        //punto 6 milestone 2
        System.out.println("Il numero di posti prenotati, dopo le relative disdette è:" + " " + concerto.getPostiPrenotati());
        System.out.println("Il numero totale dei posti disponibile è:" + " " + (concerto.getPostiTotali() - concerto.getPostiPrenotati()));



        scan.close();

    }
}

