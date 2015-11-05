package primerapp
import javax.swing.JOptionPane

class PersonaController
{
    def personaService

    def index()
    {
        List<Persona> persona = personaService.listaPersonas(params)
        render(view: '/persona/index', model: [personas:persona])

        params.max = Math.min(params.max ? params.int('max'): 2,100)
        if(!params.offset)
            params.offset = 0

        def mapa = personaService.listaPersonas(params)
        if(params.offset)
            render (view: "index",model:[personas:Persona.list(params)])
        else
            render (view: "index",model:[personas:Persona.list(params)])
    }

    def create ()
    {
        render(view:'/persona/create')
    }

    def buscar ()
    {
        def valor = params.combo
        switch (valor){

            case 'nombre':
                String nombre = params.buscar
                List<Persona> persons = Persona.findAllByNombre(nombre)
                render(view:'/persona/index', model: [personas:persons])
                break

            case 'apellidoPaterno':
                String apellidoP = params.buscar
                List<Persona> persons = Persona.findAllByApellidoPaterno(apellidoP)
                render(view:'/persona/index', model: [personas:persons])
                break

            case 'apellidoMaterno':
                String apellidoM = params.buscar
                List<Persona> persons = Persona.findAllByApellidoMaterno(apellidoM)
                render(view:'/persona/index', model: [personas:persons])
                break

            case 'fechaNacimiento':
                Date fecha = params.buscar1
                List<Persona> persons = Persona.findAllByFechaDeNacimiento(fecha)
                render(view:'/persona/index', model: [personas:persons])
                break

            default:
                println("¡Imposible! ¡¡¡!!!")
        }
    }

    def guardar () {
        personaService.guardar(params)
        List<Persona> lista = personaService.listaPersonas(params)
        render(view: '/persona/index', model: [personas:lista])

        params.max = Math.min(params.max ? params.int('max'): 2,100)
        if(!params.offset)
            params.offset = 0

        def mapa = personaService.listaPersonas(params)
        if(params.offset)
            render (view: "index",model:[personas:Persona.list(params)])

        else
            render (view: "index",model:[personas:Persona.list(params)])

    }
    def updateList () {
        params.max = Math.min(params.max ? params.int('max'): 1,100)
        if(!params.offset)
            params.offset = 0

        def mapa = personaService.listaPersonas(params)
        if(params.offset)
            render (view: "index",model:[personas:Persona.list(params)])
        else
            render (view: "index",model:[personas:Persona.list(params)])
    }
}