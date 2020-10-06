package com.itlg.examen.services.base;

import com.itlg.examen.model.Pelicula;

import java.util.List;

public interface PeliculaService {

    public List<Pelicula> findAll();
    public Pelicula save(Pelicula pelicula);
    public List<Pelicula> findMovieByPerson(Long id);
    public void addMovieToPerson (Long idPelicula, Long idPersona);
    public void deleteMovieFromPerson (Long idPelicula, Long idPersona);

}
