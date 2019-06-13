package movie.cinema.service;


import movie.cinema.domain.Cinema;

import java.util.List;

public interface CinemaService {
    Cinema save(Cinema cinema);

    Cinema update(Long id, Cinema cinema);

    void deleteById(Long id);

    Cinema findById(Long id);

    List<Cinema> findAll();

//    Cinema findByName(String name);
}
