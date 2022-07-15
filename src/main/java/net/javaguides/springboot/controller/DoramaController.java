package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Dorama;
import net.javaguides.springboot.model.Tagdorama;
import net.javaguides.springboot.repository.DoramaRepository;
import net.javaguides.springboot.repository.TagdoramaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.javaguides.springboot.message.ResponseMessage;
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
    public List<Dorama> getAllSklad() {
        return doramaRepository.findAll();
    }

    // build create employee REAST API
    @PostMapping
    public ResponseEntity<ResponseMessage> createDorama(@RequestBody Dorama dorama) {
        String message = "";
        try {
            dorama.setDoramaImg("http://code.kupava.by:8080/files/" + dorama.getDoramaImg());

            for (Tagdorama tag : tagdoramaRepository.findAll()) {
                dorama.addDoramaTag(tag);
            }
            doramaRepository.save(dorama);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not new dorama!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteDorama(@PathVariable long id) {
        Dorama dorama = doramaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("dorma not exist with id" + id));
        doramaRepository.delete(dorama);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // // build get emloyee by id REST API
    // @GetMapping("{id}")
    // public ResponseEntity<Sklad> getSkladById(@PathVariable long id){
    // Sklad sklad = skladRepository.findById(id)
    // .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with
    // id:" + id));
    // return ResponseEntity.ok(sklad);
    // }

    // //bulid update employee REST API
    // @PutMapping("{id}")
    // public ResponseEntity<Sklad> updateSklad(@PathVariable long id, @RequestBody
    // Sklad skladDetails){
    // Sklad updateSklad = skladRepository.findById(id)
    // .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with
    // id:" + id));

    // updateSklad.setInvet(skladDetails.getInvet());
    // updateSklad.setSystemName(skladDetails.getSystemName());
    // updateSklad.setComment(skladDetails.getComment());
    // updateSklad.setHardware(skladDetails.getHardware());

    // skladRepository.save(updateSklad);

    // return ResponseEntity.ok(updateSklad);
    // }

    // //build delete employee REST API
    // @DeleteMapping("{id}")
    // public ResponseEntity<HttpStatus> deleteSklad(@PathVariable long id) {
    // Sklad sklad = skladRepository.findById(id)
    // .orElseThrow(() -> new ResourceNotFoundException("sklad not exist with id:" +
    // id));
    // skladRepository.delete(sklad);

    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }

}
