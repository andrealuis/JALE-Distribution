package edu.uag.iidis.scec.pruebas;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.extensions.TestSetup;
import junit.textui.TestRunner;

import org.hibernate.cfg.Environment;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import edu.uag.iidis.scec.vista.*;
import edu.uag.iidis.scec.modelo.*;
import edu.uag.iidis.scec.persistencia.*;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;

import java.util.*;


public class CalificacionDAOTest extends TestCase {

    private static CalificacionDAO dao = null;


    protected void setUp() throws Exception {
        dao = new CalificacionDAO();
    }

    protected void tearDown() {
        dao = null;
    }

   
   public void testbuscarPorAtraccion() throws Exception {
        HibernateUtil.beginTransaction();
        try {
            Collection result = dao.buscarPorAtraccion("Parque de la marimba");
            HibernateUtil.commitTransaction();

            assertTrue(result.size() > 0);

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    public void testbuscarPorAtraccionInvalido() throws Exception {
        HibernateUtil.beginTransaction();
        try {
            Collection result = dao.buscarPorAtraccion("Cerro hueco");
            HibernateUtil.commitTransaction();

            assertTrue(result.size() == 0);

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }


    public void testBuscarTodos() throws Exception {
        
        HibernateUtil.beginTransaction();
        try {
            Collection resultado = dao.buscarTodos();
            HibernateUtil.commitTransaction();

            assertTrue(resultado.size() > 0);
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    public void testBuscarTodosInvalido() throws Exception {

        HibernateUtil.beginTransaction();
        try {
            Collection resultado = dao.buscarTodos();
            HibernateUtil.commitTransaction();

            assertTrue("Si no hay datos en la tabla success",resultado.size() == 0);
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }


    public void testHazPersistente() throws Exception {
        Calificacion calificacion = new Calificacion(5, "Nice place", "Parque de la marimba");

        HibernateUtil.beginTransaction();
        try {
            dao.hazPersistente(calificacion);
            HibernateUtil.commitTransaction();

            assertTrue(calificacion.getNombreAtraccion().equals("Parque de la marimba")); //acierta
            assertTrue(calificacion.getPuntaje() == 5);
            assertTrue(calificacion.getComentario().equals("Nice place"));
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    public void testHazPersistenteInvalido() throws Exception {
        Calificacion calificacion = new Calificacion();
        calificacion.setNombreAtraccion("Parque de la marimba");
        calificacion.setComentario("Nice place");

        try {
            HibernateUtil.beginTransaction();
            dao.hazPersistente(calificacion);
            HibernateUtil.commitTransaction();
            fail("Fallo");
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    public static Test suite() {

       TestSetup suite = new TestSetup(new TestSuite(CalificacionDAOTest.class)) {

            protected void setUp(  ) throws Exception {
                // Se ejecuta al inicio de la suite de pruebas
                dao = new CalificacionDAO();
            }

            protected void tearDown(  ) throws Exception {
                // se ejecuta al final de la suite
                dao = null;
            }
        };

        return suite;    
    }

    public static void main(String[] args) throws Exception {
        TestRunner.run( suite() );
    }

}
