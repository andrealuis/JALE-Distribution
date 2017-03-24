package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;

import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Calificacion;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;

/**
 * Esta clase contiene metodos con acceso a la base de datos de calificacion
 * @author: Julio De Buen, Andrea Luis, Lesli Olvera y Enrique Espinosa
 * @version: 23/03/2017
 */

public class CalificacionDAO {

    private Log log = LogFactory.getLog(CalificacionDAO.class);

    public CalificacionDAO() {
    }

    /**
     * Metodo que busca una calificacion por id
     * @param: id Long
     * @param: bloquear boolean
     * @return: Calificacion
     * @see: buscarPorId
     */
    public Calificacion buscarPorId(Long id, boolean bloquear)
            throws ExcepcionInfraestructura {

        Calificacion calificacion = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + id + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                calificacion = (Calificacion)HibernateUtil.getSession()
                                                .load(Calificacion.class, 
                                                      id, 
                                                      LockMode.UPGRADE);
            } else {
                calificacion = (Calificacion)HibernateUtil.getSession()
                                                .load(Calificacion.class,
                                                      id);
            }
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return calificacion;
    }

    /**
     * Metodo que busca calificacion por el nombre de la atraccion
     * @param: nombreAtraccion String
     * @return: Collection
     * @see: buscarPorAtraccion
     */
    public Collection buscarPorAtraccion(String nombreAtraccion) throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeAtraccion(nombreAtraccion)");
        }

        try {
 
            String hql = "from Calificacion where nombreAtraccion='"+nombreAtraccion+"'";
            
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
     * Metodo que busca todas las calificaciones y devuelve una coleccion
     * @return: Collection
     * @see: buscarTodos
     */
    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection calificacion;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            calificacion = HibernateUtil.getSession()
                                    .createCriteria(Calificacion.class)
                                    .list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return calificacion;
    }

    public void hazPersistente(Calificacion calificacion)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(calificacion)");
        }

        try {
            HibernateUtil.getSession().saveOrUpdate(calificacion);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }


    public void hazTransitorio(Calificacion calificacion)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(calificacion)");
        }

        try {
            HibernateUtil.getSession().delete(calificacion);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }
}
