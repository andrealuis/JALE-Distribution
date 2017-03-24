package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;

import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;

import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;

/**
 * Esta clase contiene metodos con acceso a la base de datos de los usuarios para poder loguearse
 * @author: Julio De Buen, Andrea Luis, Lesli Olvera y Enrique Espinosa
 * @version: 23/03/2017
 */

public class LoginDAO {

    private Log log = LogFactory.getLog(LoginDAO.class);

    public LoginDAO() {
    }

    /**
     * Metodo que busca usuario a través del nombre del usuario y de la contraseña
     * @param: nombreLogin String
     * @param: password String
     * @return: Collection
     * @see: buscarLogin
     */
    public Collection buscarLogin(String nombreLogin, String password)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {
 
            String hql = "from Usuario where credencial.nombreUsuario= '"+nombreLogin+"' and credencial.claveAcceso = '"+password+"'";
            
             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreLogin);
            }
        
            Query query = HibernateUtil.getSession()
                                        .createQuery(hql);
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< create query ok " );
            }
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< set Parameter ok antes del query list >>>>>");
            }
            List results = query.list();
            int resultado = results.size();
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< Result size " + resultado);
            }
            if (resultado == 0) {
               return results;
            }
            
            return results;

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException *******************");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }
}