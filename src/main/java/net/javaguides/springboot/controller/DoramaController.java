package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Dorama;
import net.javaguides.springboot.model.Tagdorama;
import net.javaguides.springboot.repository.DoramaRepository;
import net.javaguides.springboot.repository.TagdoramaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/dorama")
public class DoramaController {

    @Autowired
    private DoramaRepository doramaRepository;

    @Autowired
    private TagdoramaRepository tagdoramaRepository;

    @GetMapping
    public List<Dorama> getAllSklad(){
        return doramaRepository.findAll();
    }

    // build create employee REAST API
    @PostMapping
    public Dorama createDorama(@RequestBody Dorama dorama){

        dorama.setDoramaImg("http://code.kupava.by:8080/files/" + dorama.getDoramaImg());

        for(Tagdorama tag : tagdoramaRepository.findAll()) {
            dorama.addDoramaTag(tag);
        }
        return doramaRepository.save(dorama);
    }

    // // build get emloyee by id REST API
    // @GetMapping("{id}")
    // public ResponseEntity<Sklad> getSkladById(@PathVariable long id){
    //     Sklad sklad = skladRepository.findById(id)
    //             .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
    //     return ResponseEntity.ok(sklad);
    // }

    // //bulid update employee REST API
    // @PutMapping("{id}")
    // public ResponseEntity<Sklad> updateSklad(@PathVariable long id, @RequestBody Sklad skladDetails){
    //     Sklad updateSklad = skladRepository.findById(id)
    //             .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));

    //     updateSklad.setInvet(skladDetails.getInvet());
    //     updateSklad.setSystemName(skladDetails.getSystemName());
    //     updateSklad.setComment(skladDetails.getComment());
    //     updateSklad.setHardware(skladDetails.getHardware());

    //     skladRepository.save(updateSklad);

    //     return ResponseEntity.ok(updateSklad);
    // }

    // //build delete employee REST API
    // @DeleteMapping("{id}")
    // public ResponseEntity<HttpStatus> deleteSklad(@PathVariable long id) {
    //     Sklad sklad = skladRepository.findById(id)
    //             .orElseThrow(() -> new ResourceNotFoundException("sklad not exist with id:" + id));
    //     skladRepository.delete(sklad);

    //     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }
    
}
