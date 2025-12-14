package rss.config.impl;

import rss.config.IMenuFactory;
import rss.entity.Menu;
import rss.entity.Burger;
import rss.entity.Complement;

public class MenuFactoryImpl implements IMenuFactory {

    @Override
    public Menu create(String nom, Burger burger, Complement boisson, Complement frites,
                       String imageUrl, String description) {
        return new Menu(nom, burger, boisson, frites, imageUrl, description);
    }
}
