package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Lugar;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.LugarDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;
import net.webservicex.*;
import java.util.ArrayList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;

/**
 * Esta clase contiene metodos que ayudan al manejo de lugares
 * @author: Julio De Buen, Andrea Luis, Lesli Olvera y Enrique Espinosa
 * @version: 23/03/2017
 */

public class ManejadorLugares {
    private Log log = LogFactory.getLog(ManejadorLugares.class);
    private LugarDAO dao;

    public ManejadorLugares() {
        dao = new LugarDAO();
    }

    /**
     * Metodo que lista todos los lugares
     * y manda a llamar los métodos con acceso a la base de datos
     * @return: Collection
     * @see: listarLugares
     */
    public Collection listarLugares() {
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

    /**
     * Metodo que lista los lugares de acuerdo a su nombre
     * y manda a llamar los métodos con acceso a la base de datos
     * @param: nombre String
     * @return: Collection
     * @see: listarLugaresPorNombre
     */
	public Collection listarLugaresPorNombre(String nombre) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarLugar(nombre);
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
     * Metodo que busca todos los paises
     * y manda a llamar los métodos con acceso a la base de datos
     * @return: Collection
     * @see: buscaPaises
     */
    public Collection buscaPaises() {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">buscaPaises()");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarPaises();
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
     * Metodo que busca el estado de acuerdo a su id
     * y manda a llamar los métodos con acceso a la base de datos
     * @param: id String
     * @return: Collection
     * @see: buscaEstado
     */
    public Collection buscaEstado(String id) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">BuscaEstado(id)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarEstado(id);
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
     * Metodo que busca el municipio por su nombre
     * y manda a llamar los métodos con acceso a la base de datos
     * @param: nombre String
     * @return: Collection
     * @see: buscaMunicipio
     */
    public Collection buscaMunicipio(String nombre) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">BuscaMunicipio(nombre)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarMunicipio(nombre);
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
     * Metodo que elimina un lugar de acuerdo a su id
     * y manda a llamar los métodos con acceso a la base de datos
     * @param: id Long
     * @see: eliminarLugar
     */
    public void eliminarLugar(Long id) {
        if (log.isDebugEnabled()) {
            log.debug(">eliminarLugar(lugar)");
        }
        try {
            HibernateUtil.beginTransaction();           
            Lugar lugar = dao.buscarPorId(id, true);
            if (lugar != null) {
              dao.hazTransitorio(lugar);
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
    
}
