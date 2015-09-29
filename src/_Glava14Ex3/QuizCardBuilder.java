package _Glava14Ex3;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class QuizCardBuilder {

    private JFrame frame;
    private JTextArea question;
    private JTextArea answer;
    private ArrayList<QuizCard> cardList;
    
    public static void main(String[] args) {
        QuizCardBuilder builder = new QuizCardBuilder();
        builder.go();
    }//main
    
    public void go() {//Формируем и выводим на экран GUI, включая создание и регистрацию слушателей для событий
        frame = new JFrame("Quiz Card Builder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(50,50,500,550);
        
        JPanel mainPanel = new JPanel();
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
        Font bigFont = new Font("sanserif", Font.BOLD, 24);
        
        JLabel qLabel = new JLabel("Question");
        JLabel aLabel = new JLabel("Answer");
        
        question = new JTextArea(6, 20);
        question.setLineWrap(true);//Включить перенос строк, если не хватает места
        question.setWrapStyleWord(true);//Переносит слово целиком, если не хватило места (а не по символам)
        question.setFont(bigFont);
        
        JScrollPane qScroller = new JScrollPane(question);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        answer = new JTextArea(6, 20);
        answer.setLineWrap(true);//Включить перенос строк, если не хватает места
        answer.setWrapStyleWord(true);//Переносит слово целиком, если не хватило места (а не по символам)
        answer.setFont(bigFont);
        
        JScrollPane aScroller = new JScrollPane(answer);
        aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        JButton nextButton = new JButton("Next Card");
        nextButton.addActionListener(new NextCardListener());
        
        cardList = new ArrayList<QuizCard>();
        
        mainPanel.add(qLabel);
        mainPanel.add(qScroller);
        mainPanel.add(aLabel);
        mainPanel.add(aScroller);
        mainPanel.add(nextButton);
        
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        
        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.addActionListener(new NewMenuListener());
        fileMenu.add(newMenuItem);
        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(new SaveMenuListener());
        fileMenu.add(saveMenuItem);
        
    }//go
    
    private void clearCard(){
        question.setText("");
        answer.setText("");
        question.requestFocus();
    }//clearCard
    
    private void saveFile(File file){//Метод, записывающий файл. Запускается в SaveMenuListner. Аргумент - объект File, который сохраняется пользователем
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for(QuizCard card:cardList){
                writer.write(card.getQuestion() + "/");//Разделяем вопрос и ответ карточки символом "/"
                writer.write(card.getAnswer() + "\n");//Саму карточку заканчиваем (т.е. по сути отделяем) символом "\n"
            }
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(QuizCardBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//saveFile
    
    private class NextCardListener implements ActionListener{//Добавляем текущую карточку в список и очищаем текстовые области
        public void actionPerformed(ActionEvent e) {
            System.out.println("Next Card");
            QuizCard card = new QuizCard(question.getText(), answer.getText());
            cardList.add(card);
            clearCard();
        }
    }//NextCardListener
    
    private class SaveMenuListener implements ActionListener{//Вызываем диалоговое окно, позволяющее назвать и сохранить текущий набор карточек
        public void actionPerformed(ActionEvent e) {
            System.out.println("Save Menu");
            JFileChooser fileChooser = new JFileChooser();//Вызывается диалоговое окно, программа останавливается, пока пользователь не выберет меню Save
            fileChooser.showSaveDialog(frame);//Всю навигацию, выбор файла и т.д. за нас выполняет JFileChooser.
            saveFile(fileChooser.getSelectedFile());
        }
    }//SaveMenuListenr
    
    private class NewMenuListener implements ActionListener{//Очищаем весь текущий набор карточе и текстовые области
        public void actionPerformed(ActionEvent e) {
            System.out.println("New Menu");
            cardList.clear();
            clearCard();
        }
    }//NewMenuListner
    
}//QuizCardBuilder