package org.exercise.eventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento{
    //ATTRIBUTI
    private LocalTime ora;
    private BigDecimal prezzo;

    //COSTRUTTORE
    public Concerto(String titolo, LocalDate data, int postiTotali, int postiPrenotati, LocalTime ora, BigDecimal prezzo) throws IllegalArgumentException {
        super(titolo, data, postiTotali, postiPrenotati);
        this.ora = ora;
        this.prezzo = prezzo;
    }

    //GETTER E SETTER
    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }
    //METODI
    public String dataFormattata(){
        return getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    public String oraFormattata(){
    return ora.format(DateTimeFormatter.ofPattern("HH:mm"));
    }
    public String prezzoFormattato(){
    return String.format("%.2f€", prezzo);
    }

    //Override


    @Override
    public String toString() {
        return "\n" + "Data evento:"+ " " + dataFormattata()+ "\n" +"Orario:"+ " " + oraFormattata() + "\n" +"Tipo di evento:" + " " + getTitolo() + "\n" + "Prezzo del biglietto:"+ " " + prezzoFormattato() ;
    }
}
