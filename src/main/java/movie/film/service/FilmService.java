package movie.film.service;

import movie.film.domain.Film;

import java.util.List;

public interface FilmService {
    Film saveOrUpdate(Film film);

    void deleteById(Long id);

    Film findById(Long id);

    List<Film> findAll();
}
