package _Glava12Ex3;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.*;


public class MiniPlayer_1 {

    public static void main(String[] args) {
        try {
            int i = 0;
            Sequencer sequencer = MidiSystem.getSequencer();//Создаем и открываем синтезатор
            sequencer.open();
            
            Sequence seq = new Sequence(Sequence.PPQ, 4);//Создаем последовательность и дорожку
            Track track = seq.createTrack();
            
            for (i = 4; i < 61; i+=4){//Создаем последовательность событий: поднимающиеся ноты (15 нот)
                track.add(makeEvent(144, 1, 110-i, 100, i));//Начать проигрывать ноту 110-i на такте i
                System.out.println("Шаг "+ (i/4) + ": Нота № " + (110-i));
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
        
    } //main
    
    
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
    
}//class