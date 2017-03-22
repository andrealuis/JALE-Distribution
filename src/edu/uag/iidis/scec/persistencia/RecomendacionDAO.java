package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Recomendacion;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class RecomendacionDAO {

    private Log log = LogFactory.getLog(RecomendacionDAO.class);

    public RecomendacionDAO() {
    }



    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection recomendaciones;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            recomendaciones = HibernateUtil.getSession()
                                    .createCriteria(Recomendacion.class)
                                    .list();
                                    
              log.debug(">buscarTodos() ---- list   " + recomendaciones.size());
			log.debug(">buscarTodos() ---- contenido   " + recomendaciones);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return recomendaciones;
    }


    public Collection buscaRecomendacion(String nombreLugar)
            throws ExcepcionInfraestructura {
                
        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {
            String hql = "from Recomendacion where nombre = '"+nombreLugar+"'";
            
             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreLugar);
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
