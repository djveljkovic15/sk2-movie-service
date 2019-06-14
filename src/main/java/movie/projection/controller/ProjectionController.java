package movie.projection.controller;


import io.swagger.annotations.ApiOperation;
import movie.projection.domain.Projection;
import movie.projection.service.ProjectionService;
import movie.token.security.CheckSecurity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/service/projection")
public class ProjectionController {
    private final ProjectionService service;

    public ProjectionController(ProjectionService service) {
        this.service = service;
    }


    @CheckSecurity(roles = {"ADMIN","REGULAR"})
    @PostMapping("/save")
    @ApiOperation("Saves projection.")
    public ResponseEntity<Projection> save(@RequestHeader("Authorization") String authorization,
                                           @Valid @RequestBody Projection projection){
        return new ResponseEntity<>(service.save(projection), HttpStatus.CREATED);
    }

    @CheckSecurity(roles = {"ADMIN","REGULAR"})
    @PostMapping("/update/{projectionId}")
    @ApiOperation("Update projection.")
    public ResponseEntity<Projection> update(@RequestHeader("Authorization") String authorization,
                                             @PathVariable Long projectionId,
                                             @Valid @RequestBody Projection projection){
        return new ResponseEntity<>(service.update(projectionId, projection), HttpStatus.CREATED);
    }
    @CheckSecurity(roles = "ADMIN")
    @DeleteMapping("/delete/{projectionId}")
    @ApiOperation(value = "Deletes projection.")
    public ResponseEntity<?> deleteById(@RequestHeader("Authorization") String authorization,
                                        @PathVariable Long projectionId){
        service.deleteById(projectionId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CheckSecurity(roles = {"ADMIN","REGULAR"})
    @GetMapping("/{projectionId}")
    @ApiOperation(value = "Finds projection by id.")
    public ResponseEntity<Projection> findById(@RequestHeader("Authorization") String authorization,
                                               @PathVariable Long projectionId){
        return new ResponseEntity<>(service.findById(projectionId), HttpStatus.OK);
    }

    @CheckSecurity(roles = {"ADMIN","REGULAR"})
    @GetMapping("/name/{filmName}")
    @ApiOperation("Finds projection by movie name")
    public ResponseEntity<Projection> findByName(@RequestHeader("Authorization") String authorization,
                                               @PathVariable String filmName){
        return new ResponseEntity<>(service.findByFilm(filmName), HttpStatus.OK);
    }

    @CheckSecurity(roles = {"ADMIN","REGULAR"})
    @GetMapping("/all")
    @ApiOperation(value = "Finds all projections.")
    public List<Projection> findAll(@RequestHeader("Authorization") String authorization){
        return service.findAll();
    }


}
