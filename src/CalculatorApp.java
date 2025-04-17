import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp {
    public static void main(String[] args) {
        // Fenêtre principale
        JFrame frame = new JFrame("Menu Principal");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        frame.getRootPane().setBorder(new EmptyBorder(10,30,20,10));

        JLabel label = new JLabel("Choisissez une calculatrice :");

        label.setBorder(new EmptyBorder(10,0,5,10));

        JButton simpleCalcButton = new JButton("Calculatrice à 2 nombres");
        JButton multiCalcButton = new JButton("Calculatrice multi-nombres");

        // Action pour ouvrir la calculatrice simple
        simpleCalcButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Calculator().start();
            }
        });

        // Action pour ouvrir la calculatrice multi-nombres
        multiCalcButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MultiNumberCalculator().start();
            }
        });

        simpleCalcButton.setBorder(new EmptyBorder(10,20,10,20));
        multiCalcButton.setBorder(new EmptyBorder(10,20,10,20));

        // Ajouter les composants à la fenêtre
        frame.add(label);
        frame.add(simpleCalcButton);
        frame.add(multiCalcButton);

        frame.setVisible(true);
    }
}