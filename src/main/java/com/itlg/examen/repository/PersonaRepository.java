package com.itlg.examen.repository;

import com.itlg.examen.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

   @Query("select p from Persona p where lower(p.firstName) like :personaName or lower(p.lastName) like :personaName")
   Persona findByName(@Param("personaName") String personaName);

   List<Persona> findByOrderByLastNameAsc();

}
