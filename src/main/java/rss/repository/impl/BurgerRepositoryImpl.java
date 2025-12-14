package rss.repository.impl;

import rss.database.Database;
import rss.entity.Burger;
import rss.repository.IBurgerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BurgerRepositoryImpl implements IBurgerRepository {

    @Override
    public void add(Burger b) {
        String sql = "INSERT INTO burger (nom, prix, image_url, description) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, b.getNom());
            ps.setDouble(2, b.getPrix());
            ps.setString(3, b.getImageUrl());
            ps.setString(4, b.getDescription());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'insertion d'un burger", e);
        }
    }

    @Override
    public List<Burger> getAll() {
        List<Burger> list = new ArrayList<>();
        String sql = "SELECT id, nom, prix, image_url, description FROM burger ORDER BY id";
        try (Connection conn = Database.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Burger b = new Burger(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getDouble("prix"),
                        rs.getString("image_url"),
                        rs.getString("description")
                );
                list.add(b);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la lecture des burgers", e);
        }
        return list;
    }

    // helper used by MenuRepositoryImpl
    public Burger getById(int id) {
        String sql = "SELECT id, nom, prix, image_url, description FROM burger WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Burger(
                            rs.getInt("id"),
                            rs.getString("nom"),
                            rs.getDouble("prix"),
                            rs.getString("image_url"),
                            rs.getString("description")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de getById burger", e);
        }
        return null;
    }
}
