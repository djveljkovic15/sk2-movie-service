package movie.film.service;

import movie.film.domain.Film;

import java.util.List;

public interface FilmService {
    Film save(Film film);

    Film update(Long id, Film film);

    void deleteById(Long id);

    Film findById(Long id);

    List<Film> findAll();
}
