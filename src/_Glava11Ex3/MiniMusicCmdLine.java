package _Glava11Ex3;
import javax.sound.midi.*;

public class MiniMusicCmdLine {
    
    public static void main(String[] args) {
        MiniMusicCmdLine mini = new MiniMusicCmdLine();
        Glava5Ex1.GameHelper helper = new Glava5Ex1.GameHelper();//Специальный класс, содержащий метод для приема пользовательского ввода
        
        int instrument = -1, note = -1;//Переменные для хранения инструмента и ноты
        Boolean true_Instrument = true;//индикатор, определяющий верно ли указан инструмент
        Boolean true_Note = true;//индикатор, определяющий верно ли указана нота
        String[] parameters = new String[2];//Массив для хранения данных, введенных пользователем с клавиатуры
        
        //Блок приема инструмента- НАЧАЛО
        parameters[0] = helper.getUserInput("введите инстумент (от 0 до 127) :   ");//Получаем строковой вариант, вводимый пользователем
        if (parameters[0] == null) {
            System.out.println("Инструмент не указан :( Проигрывание невозможно");
            true_Instrument = false;
        } else { 
            instrument = Integer.parseInt(parameters[0]);
        }
        if (true_Instrument && (instrument < 0 || instrument > 128) ){
            System.out.println("Инструмент не попадает в интервал [0, 127]. Проигрывание невозможно");
            true_Instrument = false;
        }
        //Блок приема инструмента - КОНЕЦ
        
        //Блок приема ноты - НАЧАЛО
        if (true_Instrument){//Если инструмент введен верно, то запрашиваем у пользователя ноту
            parameters[1] = helper.getUserInput("введите ноту (от 0 до 127) :   ");//Получаем строковой вариант, вводимый пользователем
            if (parameters[1] == null) {
                System.out.println("Нота не указана :( Проигрывание невозможно");
                true_Note = false;
            } else { 
                note = Integer.parseInt(parameters[1]);
            }
            if ( true_Note && (note < 0 || note > 128) ){
                System.out.println("Нота не попадает в интервал [0, 127]. Проигрывание невозможно");
                true_Note = false;
            }
        }
        //Блок приема ноты - КОНЕЦ
        
        if (true_Instrument && true_Note) {//Если инструмент и нота указаны корректно, запускаем метод play 
            mini.play(instrument, note);
        }
    }//main
    
    
    public void play(int instrument, int note) {
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
            first.setMessage(192, 1, instrument, 0);//Меняем музыкальнй инструмент. 
            //192 - тип сообщения об изменении инструмента, 1 поток, instrumrnt - тип инструмента
            MidiEvent changeInstrument = new MidiEvent(first,0);//Создаем MIDI-событие, которое означает: выполняем MIDI-сообщение "first" на 0 такте
            track.add(changeInstrument);//Помещаем MIDI-событие instrument в трек
                    System.out.println("        3. Добавили в трек смену музыкального инструмента");
            
            
            ShortMessage a = new ShortMessage();//Создаем новое MIDI-сообщение
            a.setMessage(144, 1, note, 100);//Наполняем его. Аргуметы: (тип сообщения, канал, нота, сила звука). 
                                          //Наши параметры говорят: (Начать проигрывать ноту, через 1 канал, нота note, мощность звука 100)
            MidiEvent noteOn = new MidiEvent(a,1);//Создаем MIDI-событие, которое означает: выполняем MIDI-сообщение "a" на 1 такте
            track.add(noteOn);//Помещаем MIDI-событие noteOn в трек
                    System.out.println("        4. Добавили в трек начало пригрывания мелодии");
            
            ShortMessage b = new ShortMessage();//Создаем новое MIDI-сообщение
            b.setMessage(128, 1, note, 100);//Наполняем его. Аргуметы: (тип сообщения, канал, нота, сила звука). 
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