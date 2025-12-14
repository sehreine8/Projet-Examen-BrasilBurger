package rss.config.impl;

import rss.config.IBurgerFactory;
import rss.entity.Burger;

public class BurgerFactoryImpl implements IBurgerFactory {

    @Override
    public Burger create(String nom, double prix, String imageUrl, String description) {
        return new Burger(nom, prix, imageUrl, description);
    }
}
