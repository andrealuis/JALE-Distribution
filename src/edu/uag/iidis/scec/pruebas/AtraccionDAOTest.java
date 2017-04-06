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


public class AtraccionDAOTest extends TestCase {

    private static AtraccionDAO dao = null;


    protected void setUp() throws Exception {
        dao = new AtraccionDAO();
    }

    protected void tearDown() {
        dao = null;
    }

    public void testBuscarAtraccion() throws Exception {
        Atraccion atraccion = new Atraccion(1,1,"Parque de la marimba");
        FormaAtraccion forma = new FormaAtraccion();

        HibernateUtil.beginTransaction();
        try {
            Collection result = dao.buscarAtraccion(atraccion.getNombreAtraccion());
            HibernateUtil.commitTransaction();

            assertTrue(result.size() > 0); //acierta

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    public void testBuscarAtraccionInvalido() throws Exception {
        Atraccion atraccionError = new Atraccion(1,1,"Parque Central");
        FormaAtraccion forma = new FormaAtraccion();

        HibernateUtil.beginTransaction();
        try {
            Collection result = dao.buscarAtraccion(atraccionError.getNombreAtraccion());

            HibernateUtil.commitTransaction();

            assertTrue(result.size() == 0); //falla

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    public void testbuscarAtraccionPorMunicipio() throws Exception {
        

        HibernateUtil.beginTransaction();
        try {
            Collection result = dao.buscarAtraccionPorMunicipio("1");

            HibernateUtil.commitTransaction();

            assertTrue(result.size() > 0);

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    public void testbuscarAtraccionPorMunicipio() throws Exception {
        

        HibernateUtil.beginTransaction();
        try {
            Collection result = dao.buscarAtraccionPorMunicipio("invalido");

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

       TestSetup suite = new TestSetup(new TestSuite(AtraccionDAOTest.class)) {

            protected void setUp(  ) throws Exception {
                // Se ejecuta al inicio de la suite de pruebas

                SchemaExport ddlExport = new SchemaExport(HibernateUtil.getConfiguration());
                ddlExport.create(false, true);

                dao = new AtraccionDAO();
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
