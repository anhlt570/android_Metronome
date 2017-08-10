package com.anhlt.metronome;

import java.util.ArrayList;
import java.util.List;


public class Data {
    private static Data sInstance;
    public static Data getInstance()
    {
        if(sInstance ==null)
        {
            sInstance = new Data();
        }
        return sInstance;
    }

    private List<Tempo> temposList;

    private Data()
    {
        initData();
    }

    private void initData(){
        temposList = new ArrayList<Tempo>();
        temposList.add(new Tempo("Larghissimo",0,20));
        temposList.add(new Tempo("Grave",20,40));
        temposList.add(new Tempo("Lento",40,60));
        temposList.add(new Tempo("Largo",40,60));
        temposList.add(new Tempo("Larghetto",60,66));
        temposList.add(new Tempo("Adagio",66,76));
        temposList.add(new Tempo("Adagietto",0,20));
        temposList.add(new Tempo("Andante",76,108));
        temposList.add(new Tempo("Moderato",108,120));
        temposList.add(new Tempo("Allegretto",112,124));
        temposList.add(new Tempo("Allegro",120,168));
        temposList.add(new Tempo("Vivace",138,140));
        temposList.add(new Tempo("Presto",168,200));
        temposList.add(new Tempo("Prestisssimo",200,40));
    }

    public List<Tempo> getTemposList() {
        return temposList;
    }
}
