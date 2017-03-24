package edu.uag.iidis.scec.excepciones;

/**
 * Esta excepcion es usada para marcar violaciones.
 * de acceso (autorizacion)
 * @author: Julio De Buen, Andrea Luis, Lesli Olvera y Enrique Espinosa
 * @version: 23/03/2017
 */
public class ExcepcionServicio
        extends RuntimeException {

    public ExcepcionServicio() {
    }

    public ExcepcionServicio(String mensaje) {
        super(mensaje);
    }

    public ExcepcionServicio(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

    public ExcepcionServicio(Throwable causa) {
        super(causa);
    }
}
