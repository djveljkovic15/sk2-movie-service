package movie.film.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import movie.film.domain.Film;
import movie.film.service.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("service/film")
public class FilmController {
    private final FilmService service;

    public FilmController(FilmService service) {
        this.service = service;
    }

    @PostMapping("/save")
    @ApiOperation("Save film.")
    public ResponseEntity<Film> saveOrUpdate(@Valid @RequestBody Film film){
        return new ResponseEntity<>(service.saveOrUpdate(film), HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{filmId}")
    @ApiOperation(value = "Deletes cinema.")
    public ResponseEntity<?> deleteById(@PathVariable Long filmId){
        service.deleteById(filmId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{filmId}")
    @ApiOperation(value = "Finds film by id.")
    public ResponseEntity<Film> findById(@PathVariable Long filmId){
        return new ResponseEntity<>(service.findById(filmId), HttpStatus.OK);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Finds all films.")
    public List<Film> findAll(){
        return service.findAll();
    }

}
