package rss.config.impl;

import rss.config.IComplementFactory;
import rss.entity.Complement;

public class ComplementFactoryImpl implements IComplementFactory {

    @Override
    public Complement create(String nom, double prix, String imageUrl) {
        return new Complement(nom, prix, imageUrl);
    }
}
