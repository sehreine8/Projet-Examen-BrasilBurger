package rss.repository.impl;

import rss.database.Database;
import rss.entity.Complement;
import rss.repository.IComplementRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComplementRepositoryImpl implements IComplementRepository {

    @Override
    public void add(Complement c) {
        String sql = "INSERT INTO complement (nom, prix, image_url) VALUES (?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getNom());
            ps.setDouble(2, c.getPrix());
            ps.setString(3, c.getImageUrl());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'insertion d'un complément", e);
        }
    }

    @Override
    public List<Complement> getAll() {
        List<Complement> list = new ArrayList<>();
        String sql = "SELECT id, nom, prix, image_url FROM complement ORDER BY id";
        try (Connection conn = Database.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Complement c = new Complement(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getDouble("prix"),
                        rs.getString("image_url")
                );
                list.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la lecture des compléments", e);
        }
        return list;
    }

    // helper used by MenuRepositoryImpl
    public Complement getById(int id) {
        String sql = "SELECT id, nom, prix, image_url FROM complement WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Complement(
                            rs.getInt("id"),
                            rs.getString("nom"),
                            rs.getDouble("prix"),
                            rs.getString("image_url")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de getById complement", e);
        }
        return null;
    }
}
