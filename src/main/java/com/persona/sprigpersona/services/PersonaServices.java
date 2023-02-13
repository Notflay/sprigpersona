package com.persona.sprigpersona.services;

import com.persona.sprigpersona.models.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServices {

    private List<Persona> personas = new ArrayList();

    public List<Persona> getPersonas() {
        return personas;
    }

    public Persona getPerson(String name){
        for(Persona persona : personas) {
            if (persona.getNombre().equalsIgnoreCase(name)) {
                return persona;
            }
        }
        return null;
    }

    public void setPersonas(Persona persona) {
        personas.add(persona);
    }
}
