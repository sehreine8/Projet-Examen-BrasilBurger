package rss.service;

import rss.entity.Burger;
import java.util.List;

public interface IBurgerService {
    void addBurger(String nom, double prix, String imageUrl, String description);
    List<Burger> getAllBurgers();
}
