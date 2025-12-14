package rss.repository;

import rss.entity.Complement;
import java.util.List;

public interface IComplementRepository {
    void add(Complement c);
    List<Complement> getAll();
    Complement getById(int id);  // <-- 🔥 Ajouter ceci
}
