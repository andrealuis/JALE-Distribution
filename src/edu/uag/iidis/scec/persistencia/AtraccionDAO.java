package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Atraccion;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class AtraccionDAO {

    private Log log = LogFactory.getLog(AtraccionDAO.class);

    public AtraccionDAO() {
    }


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

    public Atraccion buscarPorId(Long idAtraccion, boolean bloquear)
            throws ExcepcionInfraestructura {

        Atraccion atraccion = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idAtraccion + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                atraccion = (Atraccion)HibernateUtil.getSession()
                                                .load(Atraccion.class, 
                                                      idAtraccion, 
                                                      LockMode.UPGRADE);
            } else {
                atraccion = (Atraccion)HibernateUtil.getSession()
                                                .load(Atraccion.class,
                                                      idAtraccion);
            }
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return atraccion;
    }

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
}