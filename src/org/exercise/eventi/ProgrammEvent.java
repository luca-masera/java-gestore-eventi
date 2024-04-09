package org.exercise.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammEvent {
    //ATTRIBUTI
    private String titolo;
    private List<Evento> eventi;

    //COSTRUTTORE

    public ProgrammEvent(String titolo) {
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }

    //METODI
    //primo metodo aggiungere alla lista
    public void addElemento(Evento evento){
        eventi.add(evento);
    }
    //secondo metodo che restituisce una lista a una certa data
    public List<Evento> dataList(LocalDate data){
        List<Evento> dataList = new ArrayList<>();
        for (Evento evento : eventi) {
            if (evento.getData().equals(data)) {
                dataList.add(evento);
            }
        }
        return dataList;
    }
    //metodo che indica il numero totale di eventi nel programma
    public int numEventi(){
        return eventi.size();
    }

    //metodo che svuota la lista

    public void svuotaLista(){
        eventi.clear();
    }

}
