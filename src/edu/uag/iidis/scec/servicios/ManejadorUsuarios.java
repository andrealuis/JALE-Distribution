package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Usuario;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.UsuarioDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

/**
 * Esta clase contiene metodos que ayudan al manejo de los datos del usuario
 * @author: Julio De Buen, Andrea Luis, Lesli Olvera y Enrique Espinosa
 * @version: 23/03/2017
 */

public class ManejadorUsuarios {
    private Log log = LogFactory.getLog(ManejadorUsuarios.class);
    private UsuarioDAO dao;

    public ManejadorUsuarios() {
        dao = new UsuarioDAO();
    }

    /**
     * Metodo que obtiene un Usuario por medio de su nombre
     * y manda a llamar los métodos con acceso a la base de datos
     * @param: nombreUsuario String
     * @return: Usuario
     * @see: obtenerUsuario
     */
    public Usuario obtenerUsuario(String nombreUsuario) 
            throws ExcepcionServicio {

        if (log.isDebugEnabled()) {
            log.debug(">obtenerUsuario(" + nombreUsuario + ")");
        }

        try {
            return dao.buscarPorNombreUsuario(nombreUsuario);
        } catch (ExcepcionInfraestructura e) {
            log.error("<ExcepcionInfraestructura");
            throw new ExcepcionServicio(e.getMessage(), e);
        }
    }

    /**
     * Metodo que crea un nuevo usuario
     * y manda a llamar los métodos con acceso a la base de datos
     * @param: usuario Usuario
     * @return: int
     * @see: crearUsuario
     */
    public int crearUsuario(Usuario usuario) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();           
            
            if (dao.existeUsuario(usuario.getCredencial()
                                         .getNombreUsuario())) {
               resultado = 1; // Excepción. El nombre de usuario ya existe
            } else {

               dao.hazPersistente(usuario);

               resultado = 0; // Exito. El usuario se creo satisfactoriamente.
            }

            HibernateUtil.commitTransaction();

        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();

            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
            resultado = 2;    // Excepción. Falla en la infraestructura
        } finally {
            HibernateUtil.closeSession();
        }
        return resultado;
    }    
}
