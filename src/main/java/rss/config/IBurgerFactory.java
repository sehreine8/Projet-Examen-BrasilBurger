package rss.config;

import rss.entity.Burger;

public interface IBurgerFactory {
    Burger create(String nom, double prix, String imageUrl, String description);
}
