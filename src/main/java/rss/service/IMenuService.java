package rss.service;

import rss.entity.Menu;
import java.util.List;

public interface IMenuService {
    void addMenu(String nom, int burgerId, int boissonId, int fritesId, String imageUrl, String description);
    List<Menu> getAllMenus();
}
