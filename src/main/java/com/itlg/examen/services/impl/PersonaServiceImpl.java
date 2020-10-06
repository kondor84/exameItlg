package com.itlg.examen.services.impl;

import com.itlg.examen.model.Persona;
import com.itlg.examen.repository.PersonaRepository;
import com.itlg.examen.services.base.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public List<Persona> findByOrderByLastNameAsc() {
        return personaRepository.findByOrderByLastNameAsc();
    }

    @Override
    public Optional<Persona> findById(Long idPersona) {
        return personaRepository.findById(idPersona);
    }

    @Override
    public Persona findByName(String personaName) {
        return personaRepository.findByName(personaName);
    }

    @Override
    public Persona createPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona updatePersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public void deletePerson(Persona persona) {
        personaRepository.delete(persona);
    }
}
