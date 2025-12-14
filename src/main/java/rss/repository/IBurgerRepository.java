package rss.repository;

import rss.entity.Burger;
import java.util.List;

public interface IBurgerRepository {

    void add(Burger b);

    List<Burger> getAll();

    Burger getById(int id);
}
