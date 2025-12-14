package rss.service.impl;

import rss.config.IBurgerFactory;
import rss.config.impl.BurgerFactoryImpl;
import rss.entity.Burger;
import rss.repository.IBurgerRepository;
import rss.repository.impl.BurgerRepositoryImpl;
import rss.service.IBurgerService;

import java.util.List;

public class BurgerServiceImpl implements IBurgerService {

    private final IBurgerFactory factory = new BurgerFactoryImpl();
    private final IBurgerRepository repository = new BurgerRepositoryImpl();

    @Override
    public void addBurger(String nom, double prix, String imageUrl, String description) {
        Burger b = factory.create(nom, prix, imageUrl, description);
        repository.add(b);
    }

    @Override
    public List<Burger> getAllBurgers() {
        return repository.getAll();
    }
}
