package rss.service.impl;

import rss.config.IComplementFactory;
import rss.config.impl.ComplementFactoryImpl;
import rss.entity.Complement;
import rss.repository.IComplementRepository;
import rss.repository.impl.ComplementRepositoryImpl;
import rss.service.IComplementService;

import java.util.List;

public class ComplementServiceImpl implements IComplementService {

    private final IComplementFactory factory = new ComplementFactoryImpl();
    private final IComplementRepository repository = new ComplementRepositoryImpl();

    @Override
    public void addComplement(String nom, double prix, String imageUrl) {
        Complement c = factory.create(nom, prix, imageUrl);
        repository.add(c);
    }

    @Override
    public List<Complement> getAllComplements() {
        return repository.getAll();
    }
}
