package _Glava12Ex3;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.*;

public class MiniPlayer_2 implements ControllerEventListener {
    static int num = 0;
    public static void main(String[] args) {
        MiniPlayer_2 mini = new MiniPlayer_2();
        mini.go();
    }//main
    
    void go(){
        try {
            Sequencer sequencer = MidiSystem.getSequencer();//Создаем и открываем синтезатор
            sequencer.open();
            int[] eventIWant = {127};
            sequencer.addControllerEventListener(this, eventIWant);
            
            Sequence seq = new Sequence(Sequence.PPQ, 4);//Создаем последовательность и дорожку
            Track track = seq.createTrack();
            for (int i = 4; i < 61; i+=4){//Создаем последовательность событий: поднимающиеся ноты (15 нот)
                track.add(makeEvent(144, 1, 110-i, 100, i));//Начать проигрывать ноту 110-i на такте i
                track.add(makeEvent(176, 1, 127, 0, i));//событие ControllerEvent (число 176 задает этот тип события) - это событие ничего не делает, нужно только для отлавливания Listener'ом
                track.add(makeEvent(128, 1, 110-i, 100, i+2));//Закончить проигрывать ноту 110-i на такте i+2
            }
            
            //Запускаем синтезатор
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        }
        catch (MidiUnavailableException ex) {
            System.out.println("Исключение MidiUnavailableException в методе main (class MiniPlayer_1)");
            Logger.getLogger(MiniPlayer_1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidMidiDataException ex) {
            System.out.println("Исключение InvalidMidiDataException в методе main (class MiniPlayer_1)");
            Logger.getLogger(MiniPlayer_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//go
    
    //Статический метод, выдающий midi-событие с заданными параметрами 
    static MidiEvent makeEvent(int comd, int chan, int note, int power, int tick) {
       MidiEvent event = null;
        try {
            ShortMessage massage = new ShortMessage();
            massage.setMessage(comd, chan, note, power);
            event = new MidiEvent(massage, tick);
        } catch (InvalidMidiDataException ex) {
            System.out.println("Исключение InvalidMidiDataException в методе MakeEvent (class MiniPlayer_1)");
            Logger.getLogger(MiniPlayer_1.class.getName()).log(Level.SEVERE, null, ex);
        }
       return event;
    }//MakeEvent

    //Реализуем метод интерфейса ControllerEventListener -- То, что будет происходить в момент отлавливания события ControllerEvent
    public void controlChange(ShortMessage event) {
        System.out.println("--- Шаг "+ ++num);
    }
}