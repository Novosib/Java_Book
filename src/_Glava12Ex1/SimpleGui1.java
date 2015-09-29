package _Glava12Ex1;

public class SimpleGui1 {

    public static void main(String[] args) {
        javax.swing.JFrame frame = new javax.swing.JFrame();
        javax.swing.JButton button = new javax.swing.JButton("Click me");
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(button);
        frame.setSize(300,300);
        frame.setVisible(true);
    }//main
    
}//class