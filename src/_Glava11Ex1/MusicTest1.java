package _Glava11Ex1;

import javax.sound.midi.*;

public class MusicTest1 {
    
    public void play() {
        try { //Помещаем опастные строки с исключением в блок try
            Sequencer sq = MidiSystem.getSequencer();
            System.out.println("Мы успешно получили синтезатор");
        } //создаем блок catch на тот случай, если произойдет ислючительная ситуация
          //т.е. методом getSequencer будет выдано исключение MidiUnavailableException
        catch (MidiUnavailableException ex) { 
            System.out.println("Потерпели неудачу в getSequencer() метода play() класса MusicTest1");
        }
    }//конец метода play

    public static void main(String[] args) {
        MusicTest1 mt = new MusicTest1();
        mt.play();
    }//конец метода main
}//class