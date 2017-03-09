package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;

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
 
            //String hql = "from Lugar as l INNER join l.Atraccion as result INNER join result.Imagen WHERE Atraccion.nombreAtraccion = '"+nombreAtraccion+"'";
            ///String hql = "from Atraccion as at INNER join at.Imagen as result WHERE at.nombreAtraccion = '"+nombreAtraccion+"'";
            String hql = "select nombreAtraccion from Atraccion where nombreAtraccion= '"+nombreAtraccion+"'";

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
}