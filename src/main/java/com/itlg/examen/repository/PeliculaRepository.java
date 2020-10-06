package com.itlg.examen.repository;

import com.itlg.examen.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

    @Query("SELECT per.favouriteMovies FROM Persona per\n" +
            "    WHERE per.id = :id")
    List<Pelicula> findMovieByPerson(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO peliculas_x_persona (persona_id, pelicula_id) VALUES (:idPersona, :idPelicula)", nativeQuery = true)
    void addMovieToPerson(@Param("idPelicula") Long idPelicula, @Param("idPersona") Long idPersona);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM peliculas_x_persona WHERE PERSONA_ID = :idPersona AND PELICULA_ID = :idPelicula", nativeQuery = true)
    void deleteMovieFromPerson(@Param("idPelicula") Long idPelicula, @Param("idPersona") Long idPersona);

}
