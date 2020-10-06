package com.itlg.examen.services.impl;

import com.itlg.examen.model.Pelicula;
import com.itlg.examen.repository.PeliculaRepository;
import com.itlg.examen.services.base.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    PeliculaRepository peliculaRepository;

    @Override
    public List<Pelicula> findAll() {
        return peliculaRepository.findAll();
    }

    @Override
    public Pelicula save(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @Override
    public List<Pelicula> findMovieByPerson(Long id) {
        return peliculaRepository.findMovieByPerson(id);
    }

    @Override
    public void addMovieToPerson(Long idPelicula, Long idPersona) {
        peliculaRepository.addMovieToPerson(idPelicula, idPersona);
    }

    @Override
    public void deleteMovieFromPerson(Long idPelicula, Long idPersona) {
        peliculaRepository.deleteMovieFromPerson(idPelicula, idPersona);
    }
}
