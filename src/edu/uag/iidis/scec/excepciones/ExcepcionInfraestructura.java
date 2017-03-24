package edu.uag.iidis.scec.excepciones;

/**
 * Esta excepcion es usada para atrapar fallas 
 * en la infraestructura del sistema.
 * @author: Julio De Buen, Andrea Luis, Lesli Olvera y Enrique Espinosa
 * @version: 23/03/2017
 */
public class ExcepcionInfraestructura
        extends RuntimeException {

    public ExcepcionInfraestructura() {
    }

    public ExcepcionInfraestructura(String mensaje) {
        super(mensaje);
    }

    public ExcepcionInfraestructura(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

    public ExcepcionInfraestructura(Throwable causa) {
        super(causa);
    }
}
