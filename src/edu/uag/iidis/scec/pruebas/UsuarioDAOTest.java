package edu.uag.iidis.scec.pruebas;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.extensions.TestSetup;
import junit.textui.TestRunner;

import org.hibernate.cfg.Environment;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import edu.uag.iidis.scec.modelo.*;
import edu.uag.iidis.scec.persistencia.*;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;

import java.util.*;


public class UsuarioDAOTest extends TestCase {

    private static UsuarioDAO dao = null;
    private static RolDAO rolDAO = null;

    protected void setUp() throws Exception {
        // se ejecuta al inicio de cada método de prueba
    }

    protected void tearDown() {
        // se ejecuta al final de cada método de prueba
    }

    public void testCrearUsuarioInvalido() throws Exception {
        Usuario usuario = new Usuario(
                    new NombrePersona("Ing.",
                                      "Gonzalo",
                                      "Osuna", "Millán", 
                                      "", "gom"),
                    new Credencial("","123"));

        try {
            HibernateUtil.beginTransaction();
            dao.hazPersistente(usuario);
            HibernateUtil.commitTransaction();
            fail("Falló");
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
        } finally{
            HibernateUtil.closeSession();
        }
    }

    public void testCrearUsuario() throws Exception {
        Usuario usuario = new Usuario(
                    new NombrePersona("Ing.",
                                      "Gonzalo",
                                      "Osuna", "Millán", 
                                      "", "gom"),
                    new Credencial("gosuna","123"));
        try {
            HibernateUtil.beginTransaction();
            dao.hazPersistente(usuario);
            HibernateUtil.commitTransaction();

            assertTrue(usuario.getId() != null);
            assertTrue(usuario.getNombre()
                              .getApellidoPaterno()
                              .equals("Osuna"));
            assertTrue(usuario.getCredencial()
                              .getNombreUsuario()
                              .equals("gosuna"));
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }


    public void testBuscarTodos() throws Exception {
        Collection usuarios;

        try {
            usuarios = dao.buscarTodos();
            assertTrue(usuarios.size() > 0);
        } catch (Exception e) {
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    public void testBuscarTodosInvalido() throws Exception {
        Collection usuarios;

        try {
            usuarios = dao.buscarTodos();
            assertTrue("Si no hay datos en la tabla success",usuarios.size() == 0);
        } catch (Exception e) {
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    public void testExisteUsuario() throws Exception {
        boolean usuarios;

        try {
            usuarios = dao.existeUsuario("root");
            assertTrue(usuarios == true);
        } catch (Exception e) {
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    public void testExisteUsuarioInvalido() throws Exception {
        boolean usuarios;

        try {
            usuarios = dao.existeUsuario("noname");
            assertTrue(usuarios == false);
        } catch (Exception e) {
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    public void testBuscarPorNombre() throws Exception {
        Usuario usuarios;

        try {
            usuarios = dao.buscarPorNombreUsuario("root");
            assertTrue(usuarios.getCredencial().getNombreUsuario().equals("root"));
        } catch (Exception e) {
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    public void testBuscarPorNombreInvalido() throws Exception {
        Usuario usuarios;

        try {
            usuarios = dao.buscarPorNombreUsuario("rooto");
            assertTrue(usuarios== null);
        } catch (Exception e) {
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }


    public static Test suite() {

       TestSetup suite = new TestSetup(new TestSuite(UsuarioDAOTest.class)) {

            protected void setUp(  ) throws Exception {
                // Se ejecuta al inicio de la suite
                dao = new UsuarioDAO();
                rolDAO = new RolDAO();
            }

            protected void tearDown(  ) throws Exception {
                // se ejecuta al final de la suite
                dao = null;
                rolDAO = null;
            }
        };

        return suite;
    }

    public static void main(String[] args) throws Exception {
        TestRunner.run( suite() );
    }

}
