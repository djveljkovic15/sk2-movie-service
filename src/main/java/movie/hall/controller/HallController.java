package movie.hall.controller;


import io.swagger.annotations.ApiOperation;
import movie.hall.domain.Hall;
import movie.hall.service.HallService;
import movie.token.security.CheckSecurity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("service/hall")
public class HallController {

    private final HallService service;

    public HallController(HallService service){
        this.service = service;
    }


    @CheckSecurity(roles = {"ADMIN"})
    @PostMapping("/save")
    @ApiOperation(value = "Saves hall.")
    public ResponseEntity<Hall> save(@RequestHeader("Authorization") String authorization,
                                     @Valid @RequestBody Hall hall){
            return new ResponseEntity<>(service.save(hall), HttpStatus.CREATED);
    }

    @CheckSecurity(roles = {"ADMIN"})
    @PostMapping("/update/{hallId}")
    @ApiOperation(value = "Updates hall.")
    public ResponseEntity<Hall> update(@RequestHeader("Authorization") String authorization,
                                       @PathVariable Long hallId, @Valid @RequestBody Hall hall){
            return new ResponseEntity<>(service.update(hallId, hall), HttpStatus.CREATED);
    }


    @CheckSecurity(roles = {"ADMIN"})
    @DeleteMapping("/delete/{hallId}")
    @ApiOperation(value = "Deletes hall.")
    public ResponseEntity<?> deleteById(@RequestHeader("Authorization") String authorization,
                                        @PathVariable Long hallId){
        service.deleteById(hallId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @CheckSecurity(roles = {"ADMIN","REGULAR"})
    @GetMapping("/{hallId}")
    @ApiOperation(value = "Finds hall by id.")
    public ResponseEntity<Hall> findById(@RequestHeader("Authorization") String authorization, @PathVariable Long hallId){
        return new ResponseEntity<>(service.findById(hallId), HttpStatus.OK);
    }


    @CheckSecurity(roles = {"ADMIN","REGULAR"})
    @GetMapping("/all")
    @ApiOperation(value = "Finds all halls.")
    public List<Hall> findAll(@RequestHeader("Authorization") String authorization){
        return service.findAll();
    }

//    @GetMapping("/name/{hallName}")
//    @ApiOperation(value = "Find by name")
//    public ResponseEntity<Hall> findByName(@PathVariable String hallName){
//        return new ResponseEntity<>(service.findByName(hallName), HttpStatus.OK);
//    }

}
