package primerapp

class Persona {

    String nombre
    String apellidoPaterno
    String apellidoMaterno
    Date fechaDeNacimiento

    static constraints = {
        nombre nullable: false, blank: false
        apellidoPaterno nullable: false, blank: false
        apellidoMaterno nullable: false, blank: false
        fechaDeNacimiento nullable: false, blank: false
    }
}
