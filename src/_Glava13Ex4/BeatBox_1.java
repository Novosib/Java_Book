package _Glava13Ex4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BeatBox_1 {

    JFrame frame;
    JPanel mainPanel, background;
    ArrayList<JCheckBox> checkBoxList;//Массив для хранения флажков
    Sequencer sequencer;
    Sequence sequence;
    Track track;
    
    String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", 
        "Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", 
        "Low Conga", "Crowbell", "Vibraslab", "Low-mid Tom", "High Agogo", "Open Hi Conga"};
    int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};
    
    public static void main(String[] args) {
        new BeatBox_1().buildGUI();
    }
    
    public void buildGUI(){
        frame = new JFrame("Cyber BeatBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(100, 50, 600, 400);
        
        BorderLayout layout = new BorderLayout();
        background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));//Пустая граница между краями панели и содержащимися в ней компонентами
        //background.setBackground(Color.LIGHT_GRAY);
        frame.getContentPane().add(background);
        
        checkBoxList = new ArrayList<JCheckBox>();
        
        Box buttonBox = new Box(BoxLayout.Y_AXIS);
        background.add(buttonBox, BorderLayout.EAST);
        
        JButton start = new JButton("Start");
        start.addActionListener(new StartListener());
        buttonBox.add(Box.createVerticalStrut(10));
        buttonBox.add(start);
        
        JButton stop = new JButton("Stop");
        stop.addActionListener(new StopListener());
        buttonBox.add(Box.createVerticalStrut(5));
        buttonBox.add(stop);
        
        JButton upTempo = new JButton("Tempo Up");
        upTempo.addActionListener(new UpTempoListener());
        buttonBox.add(Box.createVerticalStrut(5));
        buttonBox.add(upTempo);
        
        JButton downTempo = new JButton("Tempo Down");
        downTempo.addActionListener(new DownTempoListener());
        buttonBox.add(Box.createVerticalStrut(5));
        buttonBox.add(downTempo);
        
        Box nameBox = new Box(BoxLayout.Y_AXIS);
        background.add(nameBox, BorderLayout.WEST);
        nameBox.add(Box.createVerticalStrut(10));
        for (int i = 0; i < 16; i++){
            nameBox.add(new JLabel(instrumentNames[i]));
            nameBox.add(Box.createVerticalStrut(10));
        }
        
        GridLayout grid = new GridLayout(16, 16);//Менеджер размещения, располагающий компоненты по сетке X x Y
        grid.setHgap(1);//Задади горизонтальный и вертикальный интервалы между элемаетами грида
        grid.setVgap(2);
        mainPanel = new JPanel(grid);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 20));
        background.add(mainPanel, BorderLayout.CENTER);
        
        for (int i = 0; i < 256; i++){
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkBoxList.add(c);
            mainPanel.add(c);
        }
                
        setUpMidi();
        
        frame.pack();//Делает размер окна соответствующим всем его компонентам
    }//method buildGUI
    
    public void setUpMidi(){
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);
        } catch (MidiUnavailableException ex) {
            Logger.getLogger(BeatBox_1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidMidiDataException ex) {
                Logger.getLogger(BeatBox_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// setUpMidi
    
    public void buildTrackAndStart(){//Здесь мы преобразуем состояния флажков в MIDI-события и добавляем их на дорожку
        int[] trackList = null;//Массив из 16 элементов, что бы хранить значения для каждого интсруента на все 16 тактов
        sequence.deleteTrack(track);//Удаляем старую дорожку
        track = sequence.createTrack();//Создаем новую дорожку
        
        for (int i = 0; i < 16; i++){//Делаем для каждого инструмента
            trackList = new int[16];//Создаем массив для хранения значений каждого из 16 тактов
            int thisInstrument = instruments[i];//запоминаем текущий инструмент
            System.out.println();
            System.out.print("Инструмент " + instrumentNames[i] + ". Включчены флажки: ");
            for (int j = 0; j < 16; j++){//Внутренний цикл по флажкам текущего инструмента (т.е. по 16 тактам)
                JCheckBox jc = (JCheckBox) checkBoxList.get(j + (16*i));
                if (jc.isSelected()) {//Если на такте j флаг установлен, то запоминаем текущий инструмент в массиве trackList в ячейке j (т.е. на j-ом такте)
                    trackList[j] = thisInstrument;
                    System.out.print(j + " ");
                } else {//Если на такте j флаг НЕ установлен, то на текущем такте проигрывать инструмент не нужно, и в массиве trackList в ячейке j ставим 0
                    trackList[j] = 0;
                }
            }//Внутренний цикл по флажкам (т.е. по тактам). 
             //На выходе имеем массив trackList[16], который знает, на каких тактах нужно играть текущий инструмент
            
            makeTracks(trackList);//Для этогои инструмента на основании его массива trackList[] создаем звуковую дорожку специальным методом makeTracks
            track.add(makeEvent(176, 1, 127, 0, 16));//На 16-ом такте создаем MIDI-событие ControllerEvent (число 176 задает этот тип события) 
                                                    //это событие ничего не делает, нужно только для отлавливания Listener'ом
        }//внешний цикл по инструментам
        
        track.add(makeEvent(192, 9, 1, 0, 15));//Вспомогательное событие: Меняем музыкальнй инструмент
                                              //Мы должны быть уверены, что событие на 16-ом такте существует. 
                                              //Иначе BeatBox не пройти все 16 тактов перед тем как заново начнет последовательность
        
        try {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);//Позволяет задать количество повторений цикла. В данном случае задается непрерывный цикл
            sequencer.start();//Проигрываем мелодию!!!
            sequencer.setTempoInBPM(120);
        } catch (InvalidMidiDataException ex) {
            Logger.getLogger(BeatBox_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//buildTrackAndStart
    
    public void makeTracks(int[] list){//Создаем MIDI-события для инструмента, чей массив значений передается, проходя для него по всем 16 тактам
        for (int i = 0; i < 16; i++){
            int ThisInstrument = list[i];
            if (ThisInstrument != 0){
                track.add(makeEvent(144, 9, ThisInstrument, 100, i));//Начать проигрывать инструмент на i-ом такте
                track.add(makeEvent(128, 9, ThisInstrument, 100, i + 1));//Закончить проигрывать инструмент на i-ом такте
            }
        }
    }//makeTracks
    
    //Статический метод, выдающий midi-событие с заданными параметрами 
    static MidiEvent makeEvent(int comd, int chan, int note, int power, int tick) {
       MidiEvent event = null;
        try {
            ShortMessage massage = new ShortMessage();
            massage.setMessage(comd, chan, note, power);
            event = new MidiEvent(massage, tick);
        } catch (InvalidMidiDataException ex) {
            System.out.println("Исключение InvalidMidiDataException в методе MakeEvent (class MiniPlayer_1)");
            Logger.getLogger(BeatBox_1.class.getName()).log(Level.SEVERE, null, ex);
        }
       return event;
    }//MakeEvent
    
    
    
    class StartListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Start");//Обработка события кнопки "Start"
            buildTrackAndStart();
        }   
    }
    class StopListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Stop");//Обработка события кнопки "Stop"
            sequencer.stop();
        }   
    }
    class UpTempoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Tempo Up");//Обработка события кнопки "Tempo Up"
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float)(tempoFactor * 1.03));
        }   
    }
    class DownTempoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Tempo Down");//Обработка события кнопки "Tempo Down"
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float)(tempoFactor * 0.97));
        }   
    }
    
}//outer class BeatBox_1