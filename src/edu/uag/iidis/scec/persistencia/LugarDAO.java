package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.*;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;

/**
 * Esta clase contiene metodos con acceso a la base de datos de lugares
 * @author: Julio De Buen, Andrea Luis, Lesli Olvera y Enrique Espinosa
 * @version: 23/03/2017
 */

public class LugarDAO {

    private Log log = LogFactory.getLog(LugarDAO.class);

    public LugarDAO() {
    }

    /**
     * Metodo que busca paises y devuelve una coleccion de paises
     * @return: Collection
     * @see: buscarPaises
     */    
     public Collection buscarPaises()
            throws ExcepcionInfraestructura {

        Collection paises;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            paises = HibernateUtil.getSession()
                                    .createCriteria(Pais.class)
                                    .list();
                                    
              log.debug(">buscarTodos() ---- list   " + paises.size());
            log.debug(">buscarTodos() ---- contenido   " + paises);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return paises;
    }

    /**
     * Metodo que busca estado por el id de estado
     * @param: id String
     * @return: Collection
     * @see: buscarEstado
     */
    public Collection buscarEstado(String id)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">buscarEstado(id)");
        }

        try {
            String hql = "from Estado where idPais= "+id;
            
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

    /**
     * Metodo que busca municipio por el id de municipio
     * @param: id String
     * @return: Collection
     * @see: buscarMunicipio
     */
    public Collection buscarMunicipio(String id)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">buscarMunicipio(id)");
        }

        try {
 
            String hql = "from Municipio where idEstado= "+id;
            
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
