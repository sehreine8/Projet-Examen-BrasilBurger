package rss.service;

import rss.entity.Complement;
import java.util.List;

public interface IComplementService {
    void addComplement(String nom, double prix, String imageUrl);
    List<Complement> getAllComplements();
}
