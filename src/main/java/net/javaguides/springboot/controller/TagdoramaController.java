package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Tagdorama;
import net.javaguides.springboot.repository.DoramaRepository;
import net.javaguides.springboot.repository.TagdoramaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/tagdorama")
public class TagdoramaController {

    @Autowired
    private TagdoramaRepository tagdoramaRepository;

    @GetMapping
    public List<Tagdorama> getAllTagdorama(){
        return tagdoramaRepository.findAll();
    }

    // build create employee REAST API
    @PostMapping
    public Tagdorama createTagdorama(@RequestBody Tagdorama tagdorama){
        return tagdoramaRepository.save(tagdorama);
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
