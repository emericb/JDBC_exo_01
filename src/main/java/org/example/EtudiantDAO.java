package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDAO {
    public void insertEtudiant(Etudiant etudiant) throws SQLException {
        String sql = "INSERT INTO etudiant (nom, prenom, numero_classe, date_diplome) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection()) {
            assert conn != null;
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, etudiant.getNom());
                pstmt.setString(2, etudiant.getPrenom());
                pstmt.setString(3, etudiant.getNumeroClasse());
                pstmt.setDate(4, etudiant.getDateDiplome());
                pstmt.executeUpdate();
            }
        }
    }

    public List<Etudiant> getAllEtudiants() throws SQLException {
        List<Etudiant> etudiants = new ArrayList<>();
        String sql = "SELECT * FROM etudiant";
        try (Connection conn = DatabaseConnection.getConnection()) {
            assert conn != null;
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    Etudiant etudiant = new Etudiant(
                            rs.getInt("id"),
                            rs.getString("nom"),
                            rs.getString("prenom"),
                            rs.getString("numero_classe"),
                            rs.getDate("date_diplome")
                    );
                    etudiants.add(etudiant);
                }
            }
        }
        return etudiants;
    }

    public List<Etudiant> getEtudiantsByClasse(String numeroClasse) throws SQLException {
        List<Etudiant> etudiants = new ArrayList<>();
        String sql = "SELECT * FROM etudiant WHERE numero_classe = ?";
        try (Connection conn = DatabaseConnection.getConnection()) {
            assert conn != null;
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, numeroClasse);
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        Etudiant etudiant = new Etudiant(
                                rs.getInt("id"),
                                rs.getString("nom"),
                                rs.getString("prenom"),
                                rs.getString("numero_classe"),
                                rs.getDate("date_diplome")
                        );
                        etudiants.add(etudiant);
                    }
                }
            }
        }
        return etudiants;
    }

    public void deleteEtudiant(int id) throws SQLException {
        String sql = "DELETE FROM etudiant WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection()) {
            assert conn != null;
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            }
        }
    }
}