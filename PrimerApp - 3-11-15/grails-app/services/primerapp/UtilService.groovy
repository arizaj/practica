package primerapp

/**
 * Created by Sintel on 09/10/2015.
 */
class UtilService {

    Integer calcularEdad(Date date){
        println("dateeeeeeeeeeeeeee" + date)
        Integer edad = new Date().year - date.year
        println("Edadddddddddddddddd!!!!!!!!" + edad)
        edad
    }
}
