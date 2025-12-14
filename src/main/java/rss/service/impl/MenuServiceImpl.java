package rss.service.impl;

import rss.config.IMenuFactory;
import rss.config.impl.MenuFactoryImpl;
import rss.entity.Burger;
import rss.entity.Complement;
import rss.entity.Menu;
import rss.repository.IBurgerRepository;
import rss.repository.IComplementRepository;
import rss.repository.IMenuRepository;
import rss.repository.impl.BurgerRepositoryImpl;
import rss.repository.impl.ComplementRepositoryImpl;
import rss.repository.impl.MenuRepositoryImpl;
import rss.service.IMenuService;

import java.util.List;

public class MenuServiceImpl implements IMenuService {

    private final IMenuFactory factory = new MenuFactoryImpl();

    private final IBurgerRepository burgerRepo = new BurgerRepositoryImpl();
    private final IComplementRepository complementRepo = new ComplementRepositoryImpl();
    private final IMenuRepository menuRepo = new MenuRepositoryImpl();

    @Override
    public void addMenu(String nom, int burgerId, int boissonId, int fritesId, String imageUrl, String description) {

        // récupérer les objets depuis la BD
        Burger burger = burgerRepo.getById(burgerId);
        Complement boisson = complementRepo.getById(boissonId);
        Complement frites = complementRepo.getById(fritesId);

        if (burger == null || boisson == null || frites == null) {
            throw new RuntimeException("Impossible de créer le menu : éléments manquants.");
        }

        Menu m = factory.create(nom, burger, boisson, frites, imageUrl, description);

        menuRepo.add(m);
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuRepo.getAll();
    }
}
