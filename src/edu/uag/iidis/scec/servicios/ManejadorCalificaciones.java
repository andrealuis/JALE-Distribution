package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Calificacion;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.CalificacionDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

/**
 * Esta clase contiene metodos que ayudan al manejo de las calificaciones
 * @author: Julio De Buen, Andrea Luis, Lesli Olvera y Enrique Espinosa
 * @version: 23/03/2017
 */

public class ManejadorCalificaciones {
    private Log log = LogFactory.getLog(ManejadorCalificaciones.class);
    private CalificacionDAO dao;

    public ManejadorCalificaciones() {
        dao = new CalificacionDAO();
    }

    /**
     * Metodo que lista las calificaciones de una atracción por su nombre
     * y manda a llamar los métodos con acceso a la base de datos
     * @param: nombreAtraccion String
     * @return: Collection
     * @see: listarAtraccionesPorAtraccion
     */
    public Collection listarCalificacionesPorAtraccion(String nombreAtraccion) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">ListarCalificacionPorAtraccion(calificacion)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarPorAtraccion(nombreAtraccion);
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
     * Metodo que lista todas las calificaciones de todos las atracciones
     * y manda a llamar los métodos con acceso a la base de datos
     * @return: Collection
     * @see: listarCalificaciones
     */
    public Collection listarCalificaciones() {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">ListarCalificacion(calificacion)");
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

    /**
     * Metodo que elimina la calificacion por su id
     * y manda a llamar los métodos con acceso a la base de datos
     * @param: id Long
     * @see: eliminarCalificacion
     */
    public void eliminarCalificacion(Long id) {
        if (log.isDebugEnabled()) {
            log.debug(">eliminarCalificacion(calificacion)");
        }
        try {
            HibernateUtil.beginTransaction();           
            Calificacion calificacion = dao.buscarPorId(id, true);
            if (calificacion != null) {
              dao.hazTransitorio(calificacion);
            }
            HibernateUtil.commitTransaction();
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
        } finally {
            HibernateUtil.closeSession();
        }

    }

    /**
     * Metodo que añade una nueva calificacion a la atraccion
     * y manda a llamar los métodos con acceso a la base de datos
     * @param: calificacion Calificacion
     * @return: int
     * @see: crearCalificacion
     */
    public int crearCalificacion(Calificacion calificacion) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarCalificacion(calificacion)");
        }

        try {
            HibernateUtil.beginTransaction();           
            dao.hazPersistente(calificacion);

            resultado = 0; // Exito.

            HibernateUtil.commitTransaction();

        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();

            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
            resultado = 3;    // Excepción. Falla en la infraestructura
        } finally {
            HibernateUtil.closeSession();
        }
        return resultado;
    }    
}
