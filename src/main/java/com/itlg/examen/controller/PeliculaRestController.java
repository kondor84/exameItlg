package com.itlg.examen.controller;

import com.itlg.examen.exception.ResourceNotFoundException;
import com.itlg.examen.model.Pelicula;
import com.itlg.examen.services.impl.PeliculaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PeliculaRestController {

    @Autowired
    PeliculaServiceImpl peliculaService;

    @GetMapping(value = "/peliculas/all")
    public List<Pelicula> getAll() {
        return peliculaService.findAll();
    }

    @PostMapping("/peliculas")
    public Pelicula createPelicula(@Valid @RequestBody Pelicula pelicula) {
        return peliculaService.save(pelicula);
    }

    @GetMapping("/peliculas/personas/{id}")
    public ResponseEntity<List<Pelicula>> findMovieByPerson(
            @PathVariable(value = "id") Long personaId) throws ResourceNotFoundException {
        List<Pelicula> favouriteMovies = peliculaService.findMovieByPerson(personaId);
        return ResponseEntity.ok().body(favouriteMovies);
    }

    @PostMapping("/peliculas/{idPelicula}/personas/{idPersona}")
    public ResponseEntity<HttpStatus> addMovieToPerson(
            @PathVariable(value = "idPelicula") Long idPelicula,
            @PathVariable(value = "idPersona") Long idPersona) throws ResourceNotFoundException {
        peliculaService.addMovieToPerson(idPelicula, idPersona);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/peliculas/{idPelicula}/personas/{idPersona}")
    public ResponseEntity<HttpStatus> deleteMovieFromPerson(
            @PathVariable(value = "idPelicula") Long idPelicula,
            @PathVariable(value = "idPersona") Long idPersona) throws ResourceNotFoundException {
        peliculaService.deleteMovieFromPerson(idPelicula, idPersona);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
