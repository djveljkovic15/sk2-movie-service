package movie.projection.service;

import movie.projection.domain.Projection;

import java.util.List;

public interface ProjectionService {
    Projection save(Projection projection);

    Projection update(Long id, Projection projection);

    void deleteById(Long id);

    Projection findById(Long id);

    Projection findByFilm(String film);

    List<Projection> findAll();
}
