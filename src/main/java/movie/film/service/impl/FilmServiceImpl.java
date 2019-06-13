package movie.film.service.impl;

import movie.film.domain.Film;
import movie.film.repositorium.FilmRepository;
import movie.film.service.FilmService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository repository;

    public FilmServiceImpl(FilmRepository repository) {
        this.repository = repository;
    }


    @Override
    public Film save(Film film) {
        return repository.save(film);
    }

    @Override
    public Film update(Long id, Film film) {
        if(findById(id)==null)
            return null;
        film.setId(id);
        return repository.save(film);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Film findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Film> findAll() {
        return repository.findAll();
    }
}
