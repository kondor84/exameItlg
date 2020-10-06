package com.itlg.examen.services.base;

import com.itlg.examen.model.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {

    public List<Persona> findByOrderByLastNameAsc();
    public Optional<Persona> findById(Long idPersona);
    public Persona findByName(String personaName);
    public Persona createPersona(Persona persona);
    public Persona updatePersona(Persona persona);
    public void deletePerson (Persona persona);

}
