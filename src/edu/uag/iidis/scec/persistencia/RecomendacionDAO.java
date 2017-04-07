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

/**
 * Esta clase contiene metodos con acceso a la base de datos de atracciones
 * @author: Julio De Buen, Andrea Luis, Lesli Olvera y Enrique Espinosa
 * @version: 23/03/2017
 */

public class RecomendacionDAO {

    private Log log = LogFactory.getLog(RecomendacionDAO.class);

    public RecomendacionDAO() {
    }


     /**
     * Metodo que busca todos los lugares con buena calificacion para darlos como recomendacion
     * @return: Collection
     * @see: buscarTodos
     */
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
}
