package rss.repository.impl;

import rss.database.Database;
import rss.entity.Menu;
import rss.entity.Burger;
import rss.entity.Complement;
import rss.repository.IMenuRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuRepositoryImpl implements IMenuRepository {

    private final BurgerRepositoryImpl burgerRepo = new BurgerRepositoryImpl();
    private final ComplementRepositoryImpl complementRepo = new ComplementRepositoryImpl();

    @Override
    public void add(Menu m) {
        String sql = "INSERT INTO menu (nom, burger_id, boisson_id, frites_id, prix_total, image_url, description) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, m.getNom());
            ps.setInt(2, m.getBurger().getId());
            ps.setInt(3, m.getBoisson().getId());
            ps.setInt(4, m.getFrites().getId());
            ps.setDouble(5, m.getPrixTotal());
            ps.setString(6, m.getImageUrl());
            ps.setString(7, m.getDescription());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'insertion d'un menu", e);
        }
    }

    @Override
    public List<Menu> getAll() {
        List<Menu> list = new ArrayList<>();
        String sql = "SELECT id, nom, burger_id, boisson_id, frites_id, prix_total, image_url, description FROM menu ORDER BY id";

        try (Connection conn = Database.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                int burgerId = rs.getInt("burger_id");
                int boissonId = rs.getInt("boisson_id");
                int fritesId = rs.getInt("frites_id");
                double prixTotal = rs.getDouble("prix_total");
                String imageUrl = rs.getString("image_url");
                String description = rs.getString("description");

                Burger burger = burgerRepo.getById(burgerId);
                Complement boisson = complementRepo.getById(boissonId);
                Complement frites = complementRepo.getById(fritesId);

                // if any sub-object missing, skip or create placeholder
                if (burger == null || boisson == null || frites == null) {
                    // skip inconsistent menu
                    continue;
                }

                Menu m = new Menu(nom, burger, boisson, frites, imageUrl, description);
                // optionally set id via reflection or extended constructor; leaving id=0 is acceptable
                m.setId(id);                // on applique l'id venant de la BD
                m.setPrixTotal(prixTotal); 
                list.add(m);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la lecture des menus", e);
        }

        return list;
    }
}
