package _Glava12Ex0;
import javax.swing.JFrame;
import java.awt.Frame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.List;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.Scrollbar;
import java.awt.ScrollPane;

public class MyFrameTest {    
    JFrame frame;
    MyPanel panel;
    ScrollPane scrollPane;
    MyCanvas canvas;
    Label label;
    Checkbox chBoxCat, chBoxDog, duck, pisec, vihuh;
    CheckboxGroup groupAnimal;
    Choice animals;
    List shapes;
    TextField text;
    TextArea bigText;
    Scrollbar vs, hs;
    
    public static void main(String[] args) {
        MyFrameTest gui = new MyFrameTest();
        gui.go();
    }
    
    void go() {
        frame = new MyFrame("My Test Frame");//создаём фрейм (окно)
        frame.setBounds(200, 100, 600, 600);//Задаем граници-область фрейма (int x, int y, int width, int height)
        frame.setVisible(true);
        frame.setBackground(Color.GREEN);
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        
        //Добавление компонента класса java.awt.Panel
        panel = new MyPanel();
        panel.setBounds(0, 0, 500, 500);
        panel.setBackground(Color.LIGHT_GRAY);
        //frame.add(panel);
        
        scrollPane = new ScrollPane(1);
        scrollPane.setBounds(150, 110, 300, 300);
        scrollPane.setBackground(Color.CYAN);
        scrollPane.add(panel);
        frame.add(scrollPane);
        /*
        //Добавление компонента класса java.awt.Canvas (это простейший компонент)
        canvas = new MyCanvas();
        canvas.setBackground(Color.DARK_GRAY);
        frame.add(canvas);
        */
        /*
        //Добавление компонента класса java.awt.Scrollbar
        int height = frame.getHeight(), width = frame.getWidth(); 
        int thickness = 16; 
        hs = new Scrollbar(Scrollbar.HORIZONTAL, 50, width/10, 0, 100); 
        frame.add(hs);
        vs = new Scrollbar(Scrollbar.VERTICAL, 50, height/2, 0, 100);  
        frame.add(vs);

        hs.setBounds(0, height - thickness, width - thickness, thickness); 
        vs.setBounds(width - thickness, 0, thickness, height - thickness);
        */
        /*
        //Добавление компонента класса java.awt.Checkbox
        chBoxCat = new Checkbox("Хочу кота!");
            chBoxCat.setBounds(10, 10, 90, 20);
            frame.add(chBoxCat);
        chBoxDog = new Checkbox("Хочу собаку!");
            chBoxDog.setBounds(100, 10, 90, 20);
            frame.add(chBoxDog);
        */
        /*
        //Добавление компонента класа java.awt.CheckboxGroup
        groupAnimal = new CheckboxGroup();
        duck = new Checkbox("Утку!",groupAnimal,true);
            duck.setBounds(10, 30, 90, 20);
            frame.add(duck);
        pisec = new Checkbox("Писца!",groupAnimal,false);
            pisec.setBounds(100, 30, 90, 20);
            frame.add(pisec);
        vihuh = new Checkbox("Выхухоль!",groupAnimal,false);
            vihuh.setBounds(200, 30, 90, 20);
            frame.add(vihuh);
        */
        /*
        //Добавление компонента класса java.awt.Choice
        animals = new Choice();
            animals.add("Гиппопотам");
            animals.add("Тюлень");
            animals.add("Олень");
            animals.add("Добрый день");
            animals.setBounds(10, 30, 90, 90);
            frame.add(animals);
        */
        /*
        //Добавление компонента класса java.awt.List
        shapes = new List(3, true);
            shapes.add("Треугольник");
            shapes.add("Квадрат");
            shapes.add("Ромб");
            shapes.add("Окружность");
            shapes.add("Эллипс");
            shapes.add("Трапеция");
            shapes.add("Сектор");
            shapes.add("Многоугольник");
            shapes.setBounds(310, 10, 120, 50);
            frame.add(shapes);
        */
        /*
        //Добавление компонента класса java.awt.TextField
        text = new TextField("Пароль", 100);
        //text.setEchoChar('*');
        text.setBounds(450, 10, 100, 20);
        frame.add(text);
        */
        /*
        //Добавление компонента класса java.awt.TextArea
        bigText = new TextArea("Здесь можно писать большой текст", 20,20);
        bigText.setBounds(10, 150, 200, 80);
        frame.add(bigText);
        */
        
        //Добавление компонента класса java.awt.Lable
        label = new Label("Лейбл!");    
            label.setBounds(10, 550, 100, 20);
            frame.add(label);
        
    }
    
}//class