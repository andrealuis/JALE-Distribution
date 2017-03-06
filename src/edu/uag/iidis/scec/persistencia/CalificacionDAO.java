package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Calificacion;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class CalificacionDAO {

    private Log log = LogFactory.getLog(CalificacionDAO.class);

    public CalificacionDAO() {
    }


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


    public Collection buscarPorEjemplo(Calificacion calificacion)
            throws ExcepcionInfraestructura {


        Collection calificaciones;
 
        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        try {
            Criteria criteria = HibernateUtil.getSession()
                                             .createCriteria(Calificacion.class);
            calificaciones = criteria.add(Example.create(calificacion)).list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return calificaciones;
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
