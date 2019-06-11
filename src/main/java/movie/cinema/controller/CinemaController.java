package movie.cinema.controller;


import io.swagger.annotations.ApiOperation;
import movie.cinema.domain.Cinema;
import movie.cinema.service.CinemaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("service/cinema")
public class CinemaController {

    private final CinemaService service;

    public CinemaController(CinemaService service){
        this.service = service;
    }

    @PostMapping("/save")
    @ApiOperation(value = "Saves or updates cinema.")
    public ResponseEntity<Cinema> saveOrUpdate(@Valid @RequestBody Cinema cinema){
            return new ResponseEntity<>(service.saveOrUpdate(cinema), HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{cinemaId}")
    @ApiOperation(value = "Deletes cinema.")
    public ResponseEntity<?> deleteById(@PathVariable Long cinemaId){
        service.deleteById(cinemaId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{cinemaId}")
    @ApiOperation(value = "Finds cinema by id.")
    public ResponseEntity<Cinema> findById(@PathVariable Long cinemaId){
        return new ResponseEntity<>(service.findById(cinemaId), HttpStatus.OK);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Finds all cinemas.")
    public List<Cinema> findAll(){
        return service.findAll();
    }

}
