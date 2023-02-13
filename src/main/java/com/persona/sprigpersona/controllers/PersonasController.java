package com.persona.sprigpersona.controllers;

import com.persona.sprigpersona.models.Persona;
import com.persona.sprigpersona.services.PersonaServices;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

@Component
@Path("/")
public class PersonasController {
    private PersonaServices personaServices;

    public PersonasController(PersonaServices personaServices) {
        this.personaServices = personaServices;

        this.personaServices.setPersonas(new Persona("Juan", "Maldonado", 18,"Perú"));
    }

    @GET
    @Path("/personas")
    @Produces("application/json")
    public List<Persona> listPersonas() {return personaServices.getPersonas();}

    @POST
    @Path("/personas")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createPerson(Persona persona) {
        personaServices.setPersonas(persona);

        return Response.created(URI.create("/personas" + persona.getNombre())).build();
    }
}

