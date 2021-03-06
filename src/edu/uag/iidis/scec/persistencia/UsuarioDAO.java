package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.criterion.Example;
import org.hibernate.type.*;
import org.hibernate.classic.*;

import edu.uag.iidis.scec.modelo.Usuario;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.*;

/**
 * Esta clase contiene metodos con acceso a la base de datos de usuario
 * @author: Julio De Buen, Andrea Luis, Lesli Olvera y Enrique Espinosa
 * @version: 23/03/2017
 */

public class UsuarioDAO {

    private Log log = LogFactory.getLog(UsuarioDAO.class);


    public UsuarioDAO() {
    }

    /**
     * Metodo que busca a un usuario por su nombre
     * @param: nombreUsuario String
     * @return: Usuario
     * @see: buscarPorNombreUsuario
     */
    public Usuario buscarPorNombreUsuario(String nombreUsuario)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorNombreUsuario(" + nombreUsuario + ")");
        }

        Usuario usuario = null;
        try {
            List usuarios = HibernateUtil.getSession()
                    .createQuery("from Usuario u where u.credencial.nombreUsuario=:nombreUsuario")
                    .setString("nombreUsuario", nombreUsuario)
                    .list();

            if ((usuarios != null) && (usuarios.size() > 0)) {
                usuario = (Usuario)usuarios.get(0);
            }

            if (usuario == null) {
                if (log.isDebugEnabled()) {
                    log.debug(">buscarPorNombreUsuario(" + nombreUsuario + ")");
                }
            }
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }

        return usuario;
    }


    /**
     * Metodo que busca todos los usuarios
     * @return: Collection
     * @see: buscarTodos
     */
    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection usuarios;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            usuarios = HibernateUtil.getSession()
                                    .createCriteria(Usuario.class)
                                    .list();
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(ex);
        }
        return usuarios;
    }

    /**
     * Metodo que verifica si un usuario está existente por medio de su nombre
     * @param: nombreUsuario String
     * @return: boolean
     * @see: existeUsuario
     */
    public boolean existeUsuario(String nombreUsuario)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeUsuario(nombreUsuario)");
        }

        try {
//            String consultaCuentaUsuarios =
//            "select count(*) from Usuario u where u.credencial.nombreUsuario=?";
//
//            int resultado =
//            ((Integer) HibernateUtil.getSession()
//                           .find(consultaCuentaUsuarios, 
//                                 nombreUsuario,
//                                 StringType.INSTANCE)
//                           .iterator()
//                           .next()).intValue();

			String hql = "select u.credencial.nombreUsuario from Usuario u where u.credencial.nombreUsuario =:nombreUsuario";
			Query query = HibernateUtil.getSession().createQuery(hql);
			query.setParameter("nombreUsuario",nombreUsuario);
			List results = query.list();
			int resultado = results.size();


            if (resultado == 0) {
               return false;
            }
            
            return true;

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }

    public void hazPersistente(Usuario usuario)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(usuario)");
        }

        try {

            HibernateUtil.getSession()
                         .saveOrUpdate(usuario);

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }

}
