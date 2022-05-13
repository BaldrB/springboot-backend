package net.javaguides.springboot.controller;


import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.model.Sklad;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.repository.SkladRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/sklad")
public class SkladController {

    @Autowired
    private SkladRepository skladRepository;

    @GetMapping
    public List<Sklad> getAllSklad(){
        return skladRepository.findAll();
    }

    // build create employee REAST API
    @PostMapping
    public Sklad createSklad(@RequestBody Sklad sklad){
        return skladRepository.save(sklad);
    }

    // build get emloyee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Sklad> getSkladById(@PathVariable long id){
        Sklad sklad = skladRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        return ResponseEntity.ok(sklad);
    }

    //bulid update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Sklad> updateSklad(@PathVariable long id, @RequestBody Sklad skladDetails){
        Sklad updateSklad = skladRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));

        updateSklad.setInvet(skladDetails.getInvet());
        updateSklad.setSystemName(skladDetails.getSystemName());
        updateSklad.setComment(skladDetails.getComment());
        updateSklad.setHardware(skladDetails.getHardware());

        skladRepository.save(updateSklad);

        return ResponseEntity.ok(updateSklad);
    }

    //build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteSklad(@PathVariable long id) {
        Sklad sklad = skladRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("sklad not exist with id:" + id));
        skladRepository.delete(sklad);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
