package movie.hall.service;


import movie.hall.domain.Hall;

import java.util.List;

public interface HallService {
    Hall save(Hall hall);

    Hall update(Long id, Hall hall);

    void deleteById(Long id);

    Hall findById(Long id);

    List<Hall> findAll();

}
