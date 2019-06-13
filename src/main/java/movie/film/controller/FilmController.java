package movie.film.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import movie.film.domain.Film;
import movie.film.service.FilmService;
import movie.token.security.CheckSecurity;
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


    @CheckSecurity(roles = {"ADMIN"})
    @PostMapping("/save")
    @ApiOperation(value = "Save film.")
    public ResponseEntity<Film> save(@RequestHeader("Authorization") String authorization,
                                     @Valid @RequestBody Film film){
        return new ResponseEntity<>(service.save(film), HttpStatus.CREATED);
    }


    @CheckSecurity(roles = {"ADMIN"})
    @PostMapping("/update/{filmId}")
    @ApiOperation(value = "update film.")
    public ResponseEntity<Film> update(@RequestHeader("Authorization") String authorization,
                                       @PathVariable Long filmId, @Valid @RequestBody Film film){
        return new ResponseEntity<>(service.update(filmId, film), HttpStatus.CREATED);
    }

    @CheckSecurity(roles = {"ADMIN"})
    @DeleteMapping("/delete/{filmId}")
    @ApiOperation(value = "Deletes cinema.")
    public ResponseEntity<?> deleteById(@RequestHeader("Authorization") String authorization,
                                        @PathVariable Long filmId){
        service.deleteById(filmId);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @CheckSecurity(roles = {"ADMIN","REGULAR"})
    @GetMapping("/{filmId}")
    @ApiOperation(value = "Finds film by id.")
    public ResponseEntity<Film> findById(@RequestHeader("Authorization") String authorization,
                                         @PathVariable Long filmId){
        return new ResponseEntity<>(service.findById(filmId), HttpStatus.OK);
    }


    @CheckSecurity(roles = {"ADMIN","REGULAR"})
    @GetMapping("/all")
    @ApiOperation(value = "Finds all films.")
    public List<Film> findAll(@RequestHeader("Authorization") String authorization){
        return service.findAll();
    }

}
