import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    public void start() {
        // Fenêtre principale
        JFrame frame = new JFrame("Calculatrice Java");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Champs de saisie pour les nombres
        JTextField number1Field = new JTextField(10);
        JTextField number2Field = new JTextField(10);

        // Liste déroulante pour l'opération
        String[] operations = {"+", "-", "*", "/"};
        JComboBox<String> operationBox = new JComboBox<>(operations);

        // Bouton de calcul
        JButton calculateButton = new JButton("Calculer");

        // Label pour afficher le résultat
        JLabel resultLabel = new JLabel("Résultat : ");

        // Action : calculer et afficher le résultat
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(number1Field.getText());
                    double num2 = Double.parseDouble(number2Field.getText());
                    String operation = (String) operationBox.getSelectedItem();
                    double result = 0;

                    switch (operation) {
                        case "+" -> result = num1 + num2;
                        case "-" -> result = num1 - num2;
                        case "*" -> result = num1 * num2;
                        case "/" -> {
                            if (num2 == 0) {
                                resultLabel.setText("Erreur : Division par zéro");
                                return;
                            }
                            result = num1 / num2;
                        }
                    }
                    resultLabel.setText("Résultat : " + result);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Erreur : Entrée invalide");
                }
            }
        });

        // Ajout des composants à la fenêtre
        frame.add(new JLabel("Nombre 1 :"));
        frame.add(number1Field);
        frame.add(new JLabel("Nombre 2 :"));
        frame.add(number2Field);
        frame.add(operationBox);
        frame.add(calculateButton);
        frame.add(resultLabel);

        frame.setVisible(true);
    }
}
