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


public class LugarDAOTest extends TestCase {

    private static LugarDAO dao = null;


    protected void setUp() throws Exception {
        dao = new LoginDAO();
    }

    protected void tearDown() {
        dao = null;
    }


    public void testBuscarLugar() throws Exception {
        HibernateUtil.beginTransaction();
        try {
            Collection result = dao.buscarLugar("Parque de la marimba");
            HibernateUtil.commitTransaction();

            assertTrue(result.size() > 0); //acierta

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    public void testBuscarLugarInvalido() throws Exception {
        HibernateUtil.beginTransaction();
        try {
            Collection result = dao.buscarLugar("inexistente");
            HibernateUtil.commitTransaction();

            assertTrue(result.size() == 0);

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    public void testBuscarEstado() throws Exception {
        HibernateUtil.beginTransaction();
        try {
            Collection result = dao.buscarEstado("1");
            HibernateUtil.commitTransaction();

            assertTrue(result.size() > 0); //acierta

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    public void testBuscarEstadoInvalido() throws Exception {
        HibernateUtil.beginTransaction();
        try {
            Collection result = dao.buscarEstado("estado1");
            HibernateUtil.commitTransaction();

            assertTrue(result.size() == 0);

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    public void testBuscarMunicipio() throws Exception {
        HibernateUtil.beginTransaction();
        try {
            Collection result = dao.buscarMunicipio("1");
            HibernateUtil.commitTransaction();

            assertTrue(result.size() > 0); //acierta

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    public void testBuscarMunicipioInvalido() throws Exception {
        HibernateUtil.beginTransaction();
        try {
            Collection result = dao.buscarMunicipio("municipio1");
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

       TestSetup suite = new TestSetup(new TestSuite(LugarDAOTest.class)) {

            protected void setUp(  ) throws Exception {
                // Se ejecuta al inicio de la suite de pruebas

                SchemaExport ddlExport = new SchemaExport(HibernateUtil.getConfiguration());
                ddlExport.create(false, true);

                dao = new LugarDAO();
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
