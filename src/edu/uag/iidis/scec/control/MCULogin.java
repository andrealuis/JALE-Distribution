package edu.uag.iidis.scec.control;

import edu.uag.iidis.scec.vista.*;
import edu.uag.iidis.scec.modelo.*;
import edu.uag.iidis.scec.servicios.*;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

/**
 * Esta clase contiene las acciones para poder loguearse y desloguearse
 * @author: Julio De Buen, Andrea Luis, Lesli Olvera y Enrique Espinosa
 * @version: 23/03/2017
 */

public final class MCULogin 
        extends MappingDispatchAction {

    private Log log = LogFactory.getLog(MCULogin.class);

    /**
     * Accion que permite solicitar el login
     * @param: mapping ActionMapping
     * @param: form ActionForm
     * @param: request HttpServletRequest
     * @param: response HttpServletResponse
     * @return: ActionForward
     * @see: solicitarLogin
     */
    public ActionForward solicitarLogin(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {
		ActionMessages errores = new ActionMessages();
		//String username = loginForm.getUsername();
        if (log.isDebugEnabled()) {
            log.debug(">solicitarLogin");
        }
        FormaLogin forma = (FormaLogin) form;
        ManejadorLogin mr = new ManejadorLogin();

        Collection resultado = mr.buscarLogin(forma.getUser(),forma.getPassword());
		//User user = new User("Victor", "1234");
// simulamos que no se autentico	
	   //request.getSession().setAttribute("user", user);
        User user = null;
        if (resultado.size() != 0) {
            if ( resultado.isEmpty()) {
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.registroVacio"));
                saveErrors(request, errores);
            }
            user = new User(forma.getUser(), forma.getPassword());
            request.getSession().setAttribute("user", user);
            return (mapping.findForward("exito"));
        } else {
            log.error("El usuario no existe");
            errores.add(ActionMessages.GLOBAL_MESSAGE,
                        new ActionMessage("errors.NoExisteUsuario"));                
            saveErrors(request, errores);
            return ( mapping.findForward("fracaso"));
        }
  
    }

    /**
     * Accion que permite cerrar sesion
     * @param: mapping ActionMapping
     * @param: form ActionForm
     * @param: request HttpServletRequest
     * @param: response HttpServletResponse
     * @return: ActionForward
     * @see: cerrarSesion
     */
    public ActionForward cerrarSesion(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {
        ActionMessages errores = new ActionMessages();
        //String username = loginForm.getUsername();
        if (log.isDebugEnabled()) {
            log.debug(">cerrarSesion");
        }

        return (mapping.findForward("exito"));  
    } 
}