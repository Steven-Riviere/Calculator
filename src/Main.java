import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🧮 Bienvenue dans la calculatrice Java !");

        try {
            // Saisie des deux nombres
            System.out.print("Entrez le premier nombre : ");
            double nombre1 = scanner.nextDouble();

            System.out.print("Entrez le deuxième nombre : ");
            double nombre2 = scanner.nextDouble();

            // Choisir l'opération
            System.out.print("Choisissez l'opération (+, -, *, /) : ");
            char operation = scanner.next().charAt(0);

            double resultat = 0;
            boolean operationValide = true;

            // Calcul en fonction de l'opération
            switch (operation) {
                case '+':
                    resultat = nombre1 + nombre2;
                    break;
                case '-':
                    resultat = nombre1 - nombre2;
                    break;
                case '*':
                    resultat = nombre1 * nombre2;
                    break;
                case '/':
                    if (nombre2 != 0) {
                        resultat = nombre1 / nombre2;
                    } else {
                        System.out.println("❌ Erreur : Division par zéro !");
                        operationValide = false;
                    }
                    break;
                default:
                    System.out.println("❌ Erreur : Opération non reconnue !");
                    operationValide = false;
            }

            // Affichage du résultat
            if (operationValide) {
                System.out.println("📊 Résultat : " + resultat);
            }

        } catch (Exception e) {
            System.out.println("❌ Erreur : Saisie invalide !");
        }

        scanner.close();
        System.out.println("👋 Fin du programme.");
    }
}
