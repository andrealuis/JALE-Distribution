package edu.uag.iidis.scec.excepciones;

/**
 * Esta excepcion es usada para marcar violaciones.
 * de acceso (autorizacion)
 * @author: Julio De Buen, Andrea Luis, Lesli Olvera y Enrique Espinosa
 * @version: 23/03/2017
 */
public class ExcepcionSeguridad
        extends RuntimeException {

    public ExcepcionSeguridad() {
    }

    public ExcepcionSeguridad(String mensaje) {
        super(mensaje);
    }

    public ExcepcionSeguridad(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

    public ExcepcionSeguridad(Throwable causa) {
        super(causa);
    }
}
