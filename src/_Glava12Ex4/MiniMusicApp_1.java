package _Glava12Ex4;

import _Glava12Ex3.MiniPlayer_1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MiniMusicApp_1 {
    JFrame frame;
    DrawPanel panel;
    JButton button;
    MyPlayer player;
    static int num = 0;
    
    public static void main(String[] args) {
        MiniMusicApp_1 app = new MiniMusicApp_1();
        app.go();
    }//main
    
    void go(){
        frame = new JFrame("Mini Music Application");
        frame.setVisible(true);
        frame.setBounds(50, 50, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new DrawPanel();
        panel.setBackground(Color.WHITE);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        
        button = new JButton("Play");
        button.addActionListener(new MyButton_Listener());
        frame.getContentPane().add(button, BorderLayout.SOUTH);
    }
    
    class DrawPanel extends JPanel{//Создаем класс отвечающий за работу панели рисования
        public void paintComponent (Graphics g){
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            
            int red, green, blue;
            Color myColor ;
            red = (int) (Math.random() * 255);
            green = (int) (Math.random() * 255);
            blue = (int) (Math.random() * 255);
            myColor = new Color(red, green, blue);
            
            g.setColor(myColor);
            g.fillOval(100, 100, 200, 200);
        }//paintComponent 
    }//inter class DrawPanel
        
    class MyPlayer {
        void go(){
            try {
                Sequencer sequencer = MidiSystem.getSequencer();//Создаем и открываем синтезатор
                sequencer.open();
                int[] eventIWant = {127};
                sequencer.addControllerEventListener(new MyMidi_Listener(), eventIWant);

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
    }//inter class Myplayer
    
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

    class MyButton_Listener implements ActionListener{//Создаем класс-наблюдатель за кнопкой button
        public void actionPerformed(ActionEvent ev){
            //Здесь запускается плейер
            player = new MyPlayer();
            player.go();
        }
    }
    
    class MyMidi_Listener implements ControllerEventListener{//Создаем класс-наблюдатель за событием ControllerEvent
        public void controlChange(ShortMessage event) {
            System.out.println("--- Шаг "+ ++num);
            panel.repaint();
        }
    }

}//outer class MiniMusicApp_1