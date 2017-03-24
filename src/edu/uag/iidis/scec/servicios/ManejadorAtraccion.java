package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.AtraccionDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

/**
 * Esta clase contiene metodos que ayudan al manejo de las atracciones
 * @author: Julio De Buen, Andrea Luis, Lesli Olvera y Enrique Espinosa
 * @version: 23/03/2017
 */

public class ManejadorAtraccion {
    private Log log = LogFactory.getLog(ManejadorAtraccion.class);
    private AtraccionDAO dao;

    public ManejadorAtraccion() {
        dao = new AtraccionDAO();
    }

    /**
     * Metodo que busca una atraccion a través del nombre
     * y manda a llamar los métodos con acceso a la base de datos
     * @param: buscarAtracciones String
     * @return: Collection
     * @see: buscarAtraccion
     */
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

    /**
     * Metodo que lista atracciones de un lugar por medio del id del municipio
     * y manda a llamar los métodos con acceso a la base de datos
     * @param: id String
     * @return: Collection
     * @see: listarAtraccionesporMunicipio
     */
    public Collection listarAtraccionesporMunicipio(String id) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">listarAtraccionesporMunicipio(id)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarAtraccionPorMunicipio(id);
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
