package com.spring.ProgettoDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ProgettoDemo.dto.DtoNegozio;
import com.spring.ProgettoDemo.dto.DtoRegistraNegozio;
import com.spring.ProgettoDemo.service.ServiceNegozio;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/Negozio")
public class ControllerNegozio {
	@Autowired
	ServiceNegozio service;
	
	 @PostMapping(path = "/createDb", consumes = "application/json")
	    public Boolean createNegozio(@RequestBody @Valid DtoRegistraNegozio n) {
		 //Crea elementi nel bd
		 	return service.createNegozio(n);
	 }

    @GetMapping(path = "/allnegozi")
    public List<DtoNegozio> allNegozi() {
	    	//Mostra ogni elemento del db della tabella negozi
	       return service.allNegozi();
	    }
	    
    @DeleteMapping(path="/deleteall")
    public Boolean deleteall() {
	    	//Elimina ogni elemento presente
	    	return service.deleteAll();
	    }
	
/* Da usare???
 * ResponseEntity
 * 				ResponseEntity viene utilizzato per restituire risposte
 * 				HTTP personalizzate,
 * 				permettendo di definire corpo, header e codici di
 * 				stato in modo flessibile.
 * @CrossOrigin(origins = "*")
 * 			@CrossOrigin(origins = "*")
 * 				è fondamentale per gestire le richieste cross-origin,
 * 				 facilitando lo sviluppo di applicazioni distribuite
 * 			 	e garantendo la comunicazione con client provenienti da differenti domini.
 * 
 * @RestController
	@RequestMapping("/api/negozio")
	@CrossOrigin(origins = "*")
public class ControllerNegozio {
    @Autowired
    ServiceNegozio service;
 *  @PostMapping(consumes = "application/json")
    public ResponseEntity<DtoNegozio> createNegozio(@RequestBody @Valid DtoRegistraNegozio n) {
        DtoNegozio negozioCreato = service.createNegozio(n);
        return new ResponseEntity<>(negozioCreato, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DtoNegozio>> getAllNegozi() {
        List<DtoNegozio> negozi = service.allNegozi();
        return new ResponseEntity<>(negozi, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<DtoNegozio> getNegozioById(@PathVariable Integer id) {
        DtoNegozio negozio = service.findById(id);
        return new ResponseEntity<>(negozio, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<DtoNegozio> updateNegozio(@PathVariable Integer id, @RequestBody @Valid DtoRegistraNegozio n) {
        DtoNegozio negozioAggiornato = service.updateNegozio(id, n);
        return new ResponseEntity<>(negozioAggiornato, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNegozio(@PathVariable Integer id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        service.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
*/
}
