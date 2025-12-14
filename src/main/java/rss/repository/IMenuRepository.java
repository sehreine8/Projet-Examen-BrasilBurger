package rss.repository;

import rss.entity.Menu;
import java.util.List;

public interface IMenuRepository {
    void add(Menu m);
    List<Menu> getAll();
}
