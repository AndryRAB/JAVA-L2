package infographie;

import javax.swing.JFrame;

import infographie.view.View;

class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("InfoGraphie");
        View view = new View();
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setFocusable(true);
        frame.setContentPane(view);
        frame.setVisible(true);

        frame.requestFocusInWindow();
    }
}