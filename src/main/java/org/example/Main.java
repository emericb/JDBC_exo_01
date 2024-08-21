package org.example;

import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final EtudiantDAO etudiantDAO = new EtudiantDAO();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Ajouter un etudiant");
            System.out.println("2. Afficher tous les etudiants");
            System.out.println("3. Afficher les etudiants d'une classe");
            System.out.println("4. Supprimer un etudiant");
            System.out.println("5. Quitter\n");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1 -> ajouterEtudiant();
                    case 2 -> afficherTousLesEtudiants();
                    case 3 -> afficherEtudiantsParClasse();
                    case 4 -> supprimerEtudiant();
                    case 5 -> System.exit(0);
                    default -> System.out.println("Choix invalide");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void ajouterEtudiant() throws SQLException {
        System.out.print("Nom: ");
        String nom = scanner.nextLine();
        System.out.print("Prenom: ");
        String prenom = scanner.nextLine();
        System.out.print("Numero de classe: ");
        String numeroClasse = scanner.nextLine();
        System.out.print("Date de diplome (JJ-MM-YYYY): ");
        String dateDiplomeStr = scanner.nextLine();
        Date dateDiplome = DateFormatter.formatDate(dateDiplomeStr);
        Etudiant etudiant = new Etudiant(0, nom, prenom, numeroClasse, dateDiplome);
        etudiantDAO.insertEtudiant(etudiant);
    }

    private static void afficherTousLesEtudiants() throws SQLException {
        List<Etudiant> etudiants = etudiantDAO.getAllEtudiants();
        for (Etudiant e : etudiants) {
            System.out.println(e);
        }
    }

    private static void afficherEtudiantsParClasse() throws SQLException {
        System.out.print("Numero de classe: ");
        String classe = scanner.nextLine();
        List<Etudiant> etudiantsClasse = etudiantDAO.getEtudiantsByClasse(classe);
        for (Etudiant e : etudiantsClasse) {
            System.out.println(e);
        }
    }

    private static void supprimerEtudiant() throws SQLException {
        System.out.print("ID de l'etudiant a supprimer: ");
        int id = scanner.nextInt();
        etudiantDAO.deleteEtudiant(id);
    }
}