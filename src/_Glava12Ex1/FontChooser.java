package _Glava12Ex1;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
/**
 * Диалог выбора шрифта с возможностью предварительного просмотра.
 * @author Старовъръ
 */
public class FontChooser extends JDialog implements ActionListener {
    // Признак подтверждения пользователем выбора шрифта.
    private boolean ok = false;
    // Названия доступных шрифтов.
    private String[] fontName = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    // Поле предварительного просмотра.
    private JTextField textField;
    // Флаги выбора атрибутов шрифта - полужирный / курсив.
    private JCheckBox boldBox, italicBox;
    private JLabel nameLabel, sizeLabel;
    // Размеры шрифтов.
    private String[] sizeArray;
    // Меню выбора названия шрифта и его размера.
    private JComboBox nameComboBox, sizeComboBox;
    // Кнопки ОК, Отмена.
    private JButton okButton, cancelButton;
    // Выбранный шрифт.
    private Font font;
 
    /**
     * Создает диалоговое окно выбора шрифта.
     * @param owner родительский фрейм.
     */
    public FontChooser(JFrame owner) {
        super(owner, "Choose Font", true);
        addWindowListener(new WindowListener());
        setVisible(false);
        setSize(240, 305);
        setResizable(false);
        setLocationRelativeTo(owner);
        setLayout(null);
        //********Buttons**********
        okButton = new JButton("Ok");
        cancelButton = new JButton("Cancel");
        JPanel butPanel = new JPanel();
        butPanel.setBounds(10, 240, 239, 100);
        butPanel.add(okButton);
        butPanel.add(cancelButton);
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);
        add(butPanel);
        //*********LABEL***********
        nameLabel = new JLabel("Font");
        sizeLabel = new JLabel("Size");
 
        nameLabel.setBounds(10, 10, 40, 10);
        sizeLabel.setBounds(160, 10, 40, 10);
 
        add(nameLabel);
        add(sizeLabel);
        //**********JLIST*************
        nameComboBox = new JComboBox(fontName);
        sizeComboBox = new JComboBox(getSizes());
        sizeComboBox.addActionListener(this);
        nameComboBox.addActionListener(this);
        nameComboBox.setBounds(10, 30, 140, 20);
        sizeComboBox.setBounds(160, 30, 60, 20);
        add(nameComboBox);
        add(sizeComboBox);
        //*********CheckBox************
        boldBox = new JCheckBox("BOLD");
        italicBox = new JCheckBox("ITALIC");
        boldBox.addActionListener(this);
        italicBox.addActionListener(this);
        JPanel boxPanel = new JPanel();
        boxPanel.setLayout(new GridLayout(1, 2));
        boxPanel.setBounds(30, 60, 150, 60);
        boxPanel.add(boldBox);
        boxPanel.add(italicBox);
        Border etched = BorderFactory.createEtchedBorder();
        Border titled = BorderFactory.createTitledBorder(etched, "Style");
        boxPanel.setBorder(titled);
        add(boxPanel);
        //*******TextField*********
        textField = new JTextField();
        textField.setFont(new Font(fontName[0], Font.PLAIN, 5));
        textField.setBounds(35, 150, 150, 50);
        textField.setAlignmentX(textField.getSize().width / 2);
        textField.setEditable(false);
        textField.setText("AaBbCc");
        add(textField);
    }
 
    /**
     * Слушатель событий окна.
     */
    class WindowListener extends WindowAdapter {
        /**
         * Вызывается при закрытии окна.
         * @param e событие окна.
         */
        public void windowClosed(WindowEvent e) {
            ok = false;
        }
    }
 
    /**
     * Создает и возвращает массив размеров шрифтов <code>[5, 39]</code>
     * @return массив размеров шрифтов.
     */
    private String[] getSizes() {
        if(sizeArray == null) {
            sizeArray = new String[35];
            for(int i = 5; i < 40; i++)
                sizeArray[i - 5] = String.valueOf(i);
        }
        return sizeArray;
    }
 
    /**
     * Вызывается при нажатии на кнопку.
     * @param e событие.
     */
    public void actionPerformed(ActionEvent e) {
        setProperties();
        if(e.getSource() == okButton) {
            ok = true;
            setVisible(false);
        }
        if(e.getSource() == cancelButton) {
            ok = false;
            setVisible(false);
        }
    }
 
    /**
     * Устанавливает выбранный шрифт тексту в поле предварительного просмотре.
     */
    private void setProperties() {
        int style = 0;
        if(boldBox.isSelected())
            style += Font.BOLD;
        if(italicBox.isSelected())
            style += Font.ITALIC;
        String[] size = getSizes();
        font = new Font(fontName[nameComboBox.getSelectedIndex()], style,
                Integer.parseInt(size[sizeComboBox.getSelectedIndex()]));
        textField.setFont(font);
    }
 
    /**
     * Показывает диалоговое окно выбора шрифта.
     * @return <code>true</code>, если пользователь подтвердил выбор шрифта, иначе <code>false</code>.
     */
    public boolean showDialog() {
        setVisible(true);
        return ok;
    }
 
    /**
     * Возвращает выбранный шрифт.
     * @return выбранный шрифт.
     */
    public Font getFont() {
        return font;
    }
 
    /**
     * Тестирует диалоговое окно выбора шрифта.
     * @param args аргументы командной строки.
     */
    public static void main(String[] args) {
        FontChooser fontChooser = new FontChooser(null);
        fontChooser.showDialog();
    }
}
