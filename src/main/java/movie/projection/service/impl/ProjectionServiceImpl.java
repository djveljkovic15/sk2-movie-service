package movie.projection.service.impl;

import movie.projection.domain.Projection;
import movie.projection.repositorium.ProjectionRepository;
import movie.projection.service.ProjectionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectionServiceImpl implements ProjectionService {

    private final ProjectionRepository repository;

    public ProjectionServiceImpl(ProjectionRepository repository) {
        this.repository = repository;
    }


    @Override
    public Projection save(Projection projection) {
        return repository.save(projection);
    }

    @Override
    public Projection update(Long id, Projection projection) {
        if(findById(id)==null)
            return null;
        projection.setId(id);
        return repository.save(projection);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Projection findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Projection findByFilm(String film) {
        return repository.findAll().stream().filter(projection -> projection.getFilm()
                .getName().equalsIgnoreCase(film)).findFirst().orElse(null);
    }

    @Override
    public List<Projection> findAll() {
        return repository.findAll();
    }
}
