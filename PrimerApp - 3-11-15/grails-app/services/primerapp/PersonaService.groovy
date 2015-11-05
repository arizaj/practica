package primerapp

import grails.transaction.Transactional

@Transactional
class PersonaService {

    def utilService

    Persona guardar(params)
    {
        Persona persona = new Persona(params)
        persona.save(flush: true)
        if (!persona.save()) {
            persona.errors.each {
                println it
            }
        }
       persona.save(flush: true, failOnError: true)
       persona
    }
    Persona consultarPersona(Long id)
    {
        Persona persona = persona.get(id)
        persona
    }

    List<Persona> listaPersonas(params)
    {
        List<Persona> listaPersonas = Persona.list()
    }
}