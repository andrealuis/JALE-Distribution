package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;

import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Atraccion;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;

/**
 * Esta clase contiene metodos con acceso a la base de datos de atraccion
 * @author: Julio De Buen, Andrea Luis, Lesli Olvera y Enrique Espinosa
 * @version: 23/03/2017
 */

public class AtraccionDAO {

    private Log log = LogFactory.getLog(AtraccionDAO.class);

    public AtraccionDAO() {
    }

    /**
     * Metodo que busca una atraccion por medio del nombre y devuelve sus atributos
     * @param: nombreAtraccion String
     * @return: Collection
     * @see: buscarAtraccion
     */
    public Collection buscarAtraccion(String nombreAtraccion)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">ExisteAtraccion(nombreAtraccion)");
        }

        try {
 
            String hql = "from VistaAtraccion where nombreAtraccion= '"+nombreAtraccion+"'";

             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreAtraccion);
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

    /**
     * Metodo que busca todas las atracciones y devuelve una coleccion
     * @return: Collection
     * @see: buscarTodos
     */
    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection atracciones;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            atracciones = HibernateUtil.getSession()
                                    .createCriteria(Atraccion.class)
                                    .list();
                                    
              log.debug(">buscarTodos() ---- list   " + atracciones.size());
            log.debug(">buscarTodos() ---- contenido   " + atracciones);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return atracciones;
    }

    /**
     * Metodo que busca atraccion por id del municipio
     * @param: id String
     * @return: Collection
     * @see: buscarAtraccionPorMunicipio
     */
    public Collection buscarAtraccionPorMunicipio(String id)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">buscarAtraccion(id)");
        }

        try {
            String hql = "from Atraccion where idMunicipio= "+id;
            
             if (log.isDebugEnabled()) {
                 log.debug(hql);
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