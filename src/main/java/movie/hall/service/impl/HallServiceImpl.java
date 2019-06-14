package movie.hall.service.impl;

import movie.hall.domain.Hall;
import movie.hall.repositorium.HallRepository;
import movie.hall.service.HallService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallServiceImpl implements HallService {

    private final HallRepository repository;

    public HallServiceImpl(HallRepository repository) {
        this.repository = repository;
    }


    @Override
    public Hall save(Hall hall) {
        return repository.save(hall);
    }

    @Override
    public Hall update(Long id, Hall hall) {
        if(findById(id) == null)
            return null;

        hall.setId(id);
        return repository.save(hall);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Hall findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Hall> findAll() {
        return repository.findAll();
    }


}
