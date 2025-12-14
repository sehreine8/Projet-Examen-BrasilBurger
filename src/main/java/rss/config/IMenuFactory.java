package rss.config;

import rss.entity.Menu;
import rss.entity.Burger;
import rss.entity.Complement;

public interface IMenuFactory {
    Menu create(String nom, Burger burger, Complement boisson, Complement frites,
                String imageUrl, String description);
}
