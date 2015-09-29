package _Glava11Ex2;

import javax.sound.midi.*;

public class MiniMiniMusicApp {
    
    public static void main(String[] args) {
        MiniMiniMusicApp.main2();
        System.out.println("It is work!");
        //MiniMiniMusicApp mini = new MiniMiniMusicApp();
        //mini.play();
    }//main

public static void main2() {
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
        mini.play();
}//main2    
    
    public void play() {
        System.out.println("Начало метода play");
        try {
            System.out.println("    Зашли в блок try");
            Sequencer player = MidiSystem.getSequencer();//получаем секвенсор (или синтезатор)
            System.out.println("        0. Создали секвенсер - ситезатор");
            player.open();//Открываем его, что бы использовать (изначально он не открыт)
            System.out.println("        1. Открыли секвенсер - ситезатор");
            Sequence seq = new Sequence(Sequence.PPQ,4);//Создаем последовательность, используя непонятные аргументы
            Track track = seq.createTrack();//Создаем в последовательности трек. В треке будут MIDI-данные
            System.out.println("        2. Создали последовательность и трек");
            
            //Инструмент по умолчанию - фортепиано
            ShortMessage first = new ShortMessage();//Создаем новое MIDI-сообщение
            first.setMessage(192, 1, 50, 0);//Меняем музыкальнй инструмент. 
            //192 - тип сообщения об изменении инструмента, 1 поток, № - тип инструмента
            MidiEvent changeInstrument = new MidiEvent(first,0);//Создаем MIDI-событие, которое означает: выполняем MIDI-сообщение "first" на 0 такте
            track.add(changeInstrument);//Помещаем MIDI-событие instrument в трек
            System.out.println("        3. Добавили в трек смену музыкального инструмента");
            
            
            ShortMessage a = new ShortMessage();//Создаем новое MIDI-сообщение
            a.setMessage(144, 1, 44, 100);//Наполняем его. Аргуметы: (тип сообщения, канал, нота, сила звука). 
                                          //Наши параметры говорят: (Начать проигрывать ноту, через 1 канал, нота №44, мощность звука 100)
            MidiEvent noteOn = new MidiEvent(a,1);//Создаем MIDI-событие, которое означает: выполняем MIDI-сообщение "a" на 1 такте
            track.add(noteOn);//Помещаем MIDI-событие noteOn в трек
            System.out.println("        4. Добавили в трек начало пригрывания мелодии");
            
            ShortMessage b = new ShortMessage();//Создаем новое MIDI-сообщение
            b.setMessage(128, 1, 44, 100);//Наполняем его. Аргуметы: (тип сообщения, канал, нота, сила звука). 
                                          //Наши параметры говорят: (Закончить проигрывать ноту, через 1 канал, нота №44, мощность звука 100)
            MidiEvent noteOff = new MidiEvent(b,8);//Создаем MIDI-событие, которое означает: выполняем MIDI-сообщение "b" на 16 такте
            track.add(noteOff);//Помещаем MIDI-событие noteOff в трек
            System.out.println("        5. Добавили в трек конец пригрывания мелодии");
            
            player.setSequence(seq);//Передаем нашу последовательность с треком в синтезатор
            System.out.println("        6. Передали последовательность с треком в синтезатор");
            System.out.println("        7. Запускаем ситезатор");
            player.start();//Запускаем синтезатор (Вроде нажатия кнопки "Play")
            System.out.println("    Выходим из блока try");
        } catch (Exception ex) {
            System.out.println("    Зашли в блок catch");
            ex.printStackTrace();
        }
        System.out.println("Конец метода play");
    }//play
}//class