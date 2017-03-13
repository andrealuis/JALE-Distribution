package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.AtraccionDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

public class ManejadorAtraccion {
    private Log log = LogFactory.getLog(ManejadorAtraccion.class);
    private AtraccionDAO dao;

    public ManejadorAtraccion() {
        dao = new AtraccionDAO();
    }

    public Collection buscarAtraccion(String nombreAtraccion) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">buscarAtraccion");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarAtraccion(nombreAtraccion);
            HibernateUtil.commitTransaction();
            return resultado;         
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public Collection listarAtracciones() {
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
