package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.LoginDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

/**
 * Esta clase contiene metodos que ayudan al manejo de inicio de sesion del usuario
 * @author: Julio De Buen, Andrea Luis, Lesli Olvera y Enrique Espinosa
 * @version: 23/03/2017
 */

public class ManejadorLogin {
    private Log log = LogFactory.getLog(ManejadorLogin.class);
    private LoginDAO dao;

    public ManejadorLogin() {
        dao = new LoginDAO();
    }

    /**
     * Metodo que busca el usuario para loguearse
     * y manda a llamar los métodos con acceso a la base de datos
     * @param: nombre String
     * @param: password String
     * @return: Collection
     * @see: buscarLogin
     */
    public Collection buscarLogin(String nombre, String password) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarLogin(nombre,password);
            HibernateUtil.commitTransaction();
            return resultado;         
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }
   
}
