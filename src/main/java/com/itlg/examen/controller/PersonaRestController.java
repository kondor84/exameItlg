package com.itlg.examen.controller;

import com.itlg.examen.exception.ResourceNotFoundException;
import com.itlg.examen.model.Persona;
import com.itlg.examen.services.impl.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PersonaRestController {

    @Autowired
    private PersonaServiceImpl personaService;

    @GetMapping(value = "/personas/all")
    public List<Persona> getAll() {
        return personaService.findByOrderByLastNameAsc();
    }

    @GetMapping("/personas/{id}")
    public ResponseEntity<Persona> getPersonaById(
            @PathVariable(value = "id") Long personaId) throws ResourceNotFoundException{
        Persona persona = personaService.findById(personaId)
                .orElseThrow(() -> new ResourceNotFoundException("Persona no encontrada ID :: " + personaId));
        return ResponseEntity.ok().body(persona);
    }

   @GetMapping("/personas/nombre/{name}")
    public ResponseEntity<Persona> findByName(
            @PathVariable(value = "name") String personaName) {
        Persona persona = personaService.findByName(personaName.toLowerCase());
        return ResponseEntity.ok().body(persona);
    }

    @PostMapping("/personas")
    public Persona createPersona(@Valid @RequestBody Persona persona) {
        return personaService.createPersona(persona);
    }

    @PutMapping("/personas/{id}")
    public ResponseEntity<Persona> updatePersona(
            @PathVariable(value = "id") Long personaId,
            @Valid @RequestBody Persona personaDetails) throws ResourceNotFoundException{
        Persona persona = personaService.findById(personaId)
                .orElseThrow(() -> new ResourceNotFoundException("Persona no encontrada ID :: " + personaId));

        persona.setId(personaDetails.getId());
        persona.setFirstName(personaDetails.getFirstName());
        persona.setLastName(personaDetails.getLastName());
        persona.setBirthdate(personaDetails.getBirthdate());
        persona.setHasInsurance(personaDetails.isHasInsurance());

        final Persona updatedPersona = personaService.updatePersona(persona);
        return ResponseEntity.ok(updatedPersona);
    }

    @DeleteMapping("/personas/{id}")
    public ResponseEntity<HttpStatus> deletePerson(
            @PathVariable(value = "id") Long personaId) throws ResourceNotFoundException{
        Persona persona = personaService.findById(personaId)
                .orElseThrow(() -> new ResourceNotFoundException("Persona no encontrada ID :: " + personaId));

        personaService.deletePerson(persona);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
