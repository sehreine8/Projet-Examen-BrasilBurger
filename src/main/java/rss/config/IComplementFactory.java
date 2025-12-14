package rss.config;

import rss.entity.Complement;

public interface IComplementFactory {
    Complement create(String nom, double prix, String imageUrl);
}
