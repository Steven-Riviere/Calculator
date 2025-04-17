import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiNumberCalculator {
    public void start() {
        JFrame frame = new JFrame("Calculatrice Multi-Nombres");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Choix de l'opération
        JLabel operationLabel = new JLabel("Opération (+, -, *) :");
        String[] operations = {"+", "-", "*"};
        JComboBox<String> operationBox = new JComboBox<>(operations);

        // Champ d'entrée
        JTextField inputField = new JTextField(10);
        JButton addButton = new JButton("Ajouter");
        JButton calculateButton = new JButton("Calculer");

        // Zone pour afficher les nombres ajoutés
        JTextArea numberList = new JTextArea(10, 30);
        numberList.setEditable(false);

        // Label pour afficher le résultat
        JLabel resultLabel = new JLabel("Résultat : ");

        // Stocker les nombres
        StringBuilder numbers = new StringBuilder();

        // Action : Ajouter un nombre
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double value = Double.parseDouble(inputField.getText());
                    numbers.append(value).append("\n");
                    numberList.setText(numbers.toString());
                    inputField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Entrée invalide !");
                }
            }
        });

        // Action : Calculer le résultat
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String operation = (String) operationBox.getSelectedItem();
                double result = (operation.equals("*")) ? 1 : 0;
                boolean first = true;

                for (String line : numbers.toString().split("\n")) {
                    if (!line.isEmpty()) {
                        double value = Double.parseDouble(line);
                        switch (operation) {
                            case "+" -> result += value;
                            case "-" -> {
                                if (first) {
                                    result = value;
                                    first = false;
                                } else {
                                    result -= value;
                                }
                            }
                            case "*" -> result *= value;
                        }
                    }
                }
                resultLabel.setText("Résultat : " + result);
            }
        });

        // Ajout des composants à la fenêtre
        frame.add(operationLabel);
        frame.add(operationBox);
        frame.add(inputField);
        frame.add(addButton);
        frame.add(new JScrollPane(numberList));
        frame.add(calculateButton);
        frame.add(resultLabel);

        frame.setVisible(true);
    }
}
