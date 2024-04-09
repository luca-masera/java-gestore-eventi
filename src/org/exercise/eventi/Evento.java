package org.exercise.eventi;

import java.time.LocalDate;

public class Evento {

    //ATTRIBUTI
    private String titolo;
    private LocalDate data;
    private int postiTotali;
    private int postiPrenotati;

    //COSTRUTTORE

    public Evento(String titolo, LocalDate data, int postiTotali, int postiPrenotati) throws IllegalArgumentException  {
        if (data.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("La data dell'evento è già passata. ");
        }
        if (postiTotali <= 0){
            throw new IllegalArgumentException("I posti totali non possono essere negativi.");
        }
        if (titolo.isEmpty()){
            throw new IllegalArgumentException("Il titolo non può essere vuoto.");
        }

        this.titolo = titolo;
        this.data = data;
        this.postiTotali = postiTotali;
        this.postiPrenotati = 0;
    }



    //GETTER E SETTER

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getPostiTotali() {
        return postiTotali;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    //METODI
    public void prenota(int numPosti) throws IllegalArgumentException{
        if (data.isBefore(LocalDate.now())){
            throw new IllegalStateException("La data dell'evento è già passata. ");
        }
        if (postiPrenotati + numPosti > postiTotali){
            throw new IllegalStateException("Non ci sono abbastanza posti a sedere.");

        }
        postiPrenotati += numPosti;
    }
    public void disdici(int numPosti) throws IllegalArgumentException{
        if (data.isBefore(LocalDate.now())){
            throw new IllegalStateException("La data dell'evento è già passata. ");
        }
        if (postiPrenotati - numPosti < 0){
            throw new IllegalStateException("Non puoi disdire più posti di quelli che hai prenotato. ");
        }
        postiPrenotati -= numPosti;
    }

    @Override
    public String toString() {
        return "Data dell'evento:"+ " " + data.toString() + "-" + "Nome dell'evento: " + " " + titolo;
    }
}

