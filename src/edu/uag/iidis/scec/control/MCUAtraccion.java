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



public final class MCUAtraccion
        extends MappingDispatchAction {

    private Log log = LogFactory.getLog(MCUAtraccion.class);


    public ActionForward solicitarAtraccion(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {
		ActionMessages errores = new ActionMessages();
		//String username = loginForm.getUsername();
        if (log.isDebugEnabled()) {
            log.debug(">solicitarAtraccion");
        }

        FormaAtraccion forma = (FormaAtraccion) form;
        ManejadorAtraccion mr = new ManejadorAtraccion();

        Object obj = request.getParameter("atractionName");
        Collection resultado = mr.buscarAtraccion(obj.toString());
        if (resultado != null) {
            if ( resultado.isEmpty() ) {
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.registroVacio"));
                saveErrors(request, errores);
            } else {
                forma.setAtraccion( resultado );
            }
            return (mapping.findForward("exito"));
        } else {
            log.error("Ocurrió un error de infraestructura");
            errores.add(ActionMessages.GLOBAL_MESSAGE,
                        new ActionMessage("errors.infraestructura"));                
            saveErrors(request, errores);
            return ( mapping.findForward("fracaso") );
        }
  
    }

    
}