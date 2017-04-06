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

            assertTrue(result.size() > 0); //acierta

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
            Collection result = dao.buscarPorAtraccion("1203123");
            HibernateUtil.commitTransaction();

            assertTrue(result.size() == 0);

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
            Collection result = dao.hazPersistente(calificacion);
            HibernateUtil.commitTransaction();

            assertTrue(result.size() > 0); //acierta

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

        HibernateUtil.beginTransaction();
        try {
            Collection result = dao.hazPersistente(calificacion);
            HibernateUtil.commitTransaction();

            assertTrue(result.size() == 0);

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

                SchemaExport ddlExport = new SchemaExport(HibernateUtil.getConfiguration());
                ddlExport.create(false, true);

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
