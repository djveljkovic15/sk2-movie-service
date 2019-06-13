package movie.cinema.controller;


import io.swagger.annotations.ApiOperation;
import movie.cinema.domain.Cinema;
import movie.cinema.service.CinemaService;
import movie.token.security.CheckSecurity;
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


    @CheckSecurity(roles = {"ADMIN"})
    @PostMapping("/save")
    @ApiOperation(value = "Saves cinema.")
    public ResponseEntity<Cinema> save(@RequestHeader("Authorization") String authorization,
                                       @Valid @RequestBody Cinema cinema){
            return new ResponseEntity<>(service.save(cinema), HttpStatus.CREATED);
    }

    @CheckSecurity(roles = {"ADMIN"})
    @PostMapping("/update/{cinemaId}")
    @ApiOperation(value = "Updates cinema.")
    public ResponseEntity<Cinema> update(@RequestHeader("Authorization") String authorization,
                                         @PathVariable Long cinemaId, @Valid @RequestBody Cinema cinema){
            return new ResponseEntity<>(service.update(cinemaId, cinema), HttpStatus.CREATED);
    }


    @CheckSecurity(roles = {"ADMIN"})
    @DeleteMapping("/delete/{cinemaId}")
    @ApiOperation(value = "Deletes cinema.")
    public ResponseEntity<?> deleteById(@RequestHeader("Authorization") String authorization,
                                        @PathVariable Long cinemaId){
        service.deleteById(cinemaId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @CheckSecurity(roles = {"ADMIN","REGULAR"})
    @GetMapping("/{cinemaId}")
    @ApiOperation(value = "Finds cinema by id.")
    public ResponseEntity<Cinema> findById(@RequestHeader("Authorization") String authorization,@PathVariable Long cinemaId){
        return new ResponseEntity<>(service.findById(cinemaId), HttpStatus.OK);
    }


    @CheckSecurity(roles = {"ADMIN","REGULAR"})
    @GetMapping("/all")
    @ApiOperation(value = "Finds all cinemas.")
    public List<Cinema> findAll(@RequestHeader("Authorization") String authorization){
        return service.findAll();
    }

//    @GetMapping("/name/{cinemaName}")
//    @ApiOperation(value = "Find by name")
//    public ResponseEntity<Cinema> findByName(@PathVariable String cinemaName){
//        return new ResponseEntity<>(service.findByName(cinemaName), HttpStatus.OK);
//    }

}
