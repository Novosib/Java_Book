package _Glava14Ex3;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class QuizCardPlayer {
    private JTextArea display;
    private JTextArea  answer;
    private ArrayList<QuizCard> cardList;
    private QuizCard currentCard;
    private int currentCardIndex = 0;
    private JFrame frame;
    private JButton nextButton = new JButton("Show Question");
    private boolean isShowAnswer;
    
    public static void main(String[] args) {
        QuizCardPlayer player = new QuizCardPlayer();
        player.go();
    }//main
    
    public void go(){//Формируем GUI
        frame = new JFrame("Quiz Card Player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(50,50,500,550);
        
        JPanel mainPanel = new JPanel();
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
        Font bigFont = new Font("sanserif", Font.BOLD, 24);
        
        display = new JTextArea(5, 20);
        display.setFont(bigFont);
        display.setLineWrap(true);//Включить перенос строк, если не хватает места
        display.setWrapStyleWord(true);//Переносит слово целиком, если не хватило места (а не по символам)
        display.setEditable(false);
        
        JScrollPane qScroller = new JScrollPane(display);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        nextButton.addActionListener(new NextCardListener());
        
        mainPanel.add(qScroller);
        mainPanel.add(nextButton);
        
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        
        JMenuItem loadMenuItem = new JMenuItem("Load card set");
        loadMenuItem.addActionListener(new OpenMenuListener());
        fileMenu.add(loadMenuItem);
        
    }//go
    
    private void loadFile(File file){
        //Создаем ArrayList с карточками, считывая их из текстового файла, выбранного в OpenMenuListener
        //Читаем файл по одной строке за один раз, вызываем метод makeCard для создания новой карточки из строки
        //Одна строка в файле содержит и вопрос, и ответ, разделенные символом "/" 
        
        cardList = new ArrayList<QuizCard>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null){
                makeCard(line);
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(QuizCardPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
                Logger.getLogger(QuizCardPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        showNextCard();//После загрузки сразу показываем первую карточку
    }//loadFile
    
    private void makeCard(String lineToParse){//Вызывается в loadFile
        String[] result = lineToParse.split("/");//Берет строку из файла, разбивает её на части по символу "/"
        QuizCard card = new QuizCard(result[0], result[1]);
        cardList.add(card);
        System.out.println("Made a card");
    }//makeCard
    
    private void showNextCard(){
        currentCard = cardList.get(currentCardIndex);
        currentCardIndex++;
        display.setText(currentCard.getQuestion());
        nextButton.setText("Show Answer");
        isShowAnswer = true;
    }//showNextCard
    
    class NextCardListener implements ActionListener {//Проверяем значение флага isShowAnswer, что бы определить, что сейчас отображается: вопрос или ответ
        public void actionPerformed(ActionEvent e) {//В зависимости от результата выполняем соответствующее действие
            System.out.println("Show Question");
            if(isShowAnswer){//Показываем ответ, т.к. вопрос уже был увиден
                System.out.println("0. isShowAnswer = " + isShowAnswer);
                display.setText(currentCard.getAnswer());
                nextButton.setText("Next Card");
                System.out.println("1. isShowAnswer = " + isShowAnswer);
                isShowAnswer = false;
                System.out.println("2. isShowAnswer = " + isShowAnswer);
            } else{//Показываем следующий вопрос
                System.out.println("3. isShowAnswer = " + isShowAnswer);
                if (currentCardIndex < cardList.size()){//В cardList еще есть карточки в 
                    System.out.println("4. isShowAnswer = " + isShowAnswer);
                    showNextCard();
                    System.out.println("5. isShowAnswer = " + isShowAnswer);
                } else{//В cardList больше нет карточек
                    display.setText("That was last Card");
                    nextButton.setEnabled(false);//Выключаем кнопку
                }//Внутреннее ветвление по CardList
            }//Внешнее ветвление по флажку isShowAnswer
        }
    }//NextCardListener
    
    class OpenMenuListener implements ActionListener {//Вызываем диалоговое окно, позволяющее пользователю выбирать, какой файл (набор карточек) открыть
        public void actionPerformed(ActionEvent e) {
            System.out.println("Load card set");
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(frame);
            loadFile(fileOpen.getSelectedFile());
        }
    }//OpenMenuListener
    
}//QuizCardPlayer