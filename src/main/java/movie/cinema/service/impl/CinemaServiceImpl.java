package movie.cinema.service.impl;

import movie.cinema.domain.Cinema;
import movie.cinema.repositorium.CinemaRepository;
import movie.cinema.service.CinemaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {

    private final CinemaRepository repository;

    public CinemaServiceImpl(CinemaRepository repository) {
        this.repository = repository;
    }


    @Override
    public Cinema save(Cinema cinema) {
        return repository.save(cinema);
    }

    @Override
    public Cinema update(Long id, Cinema cinema) {
        if(findById(id) == null)
            return null;

        cinema.setId(id);
        return repository.save(cinema);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Cinema findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Cinema> findAll() {
        return repository.findAll();
    }

//    @Override
//    public Cinema findByName(String name) {
//        return repository.findByName(name);
//    }
}
