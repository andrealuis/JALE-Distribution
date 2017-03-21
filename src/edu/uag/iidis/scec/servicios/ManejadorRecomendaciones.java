package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Recomendacion;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.RecomendacionDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

public class ManejadorRecomendaciones {
    private Log log = LogFactory.getLog(ManejadorRecomendaciones.class);
    private RecomendacionDAO dao;

    public ManejadorRecomendaciones() {
        dao = new RecomendacionDAO();
    }


    public Collection listarRecomendaciones() {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarTodos();
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
