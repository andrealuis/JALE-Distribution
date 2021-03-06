package edu.uag.iidis.scec.control;

import edu.uag.iidis.scec.vista.*;
import edu.uag.iidis.scec.modelo.*;
import edu.uag.iidis.scec.servicios.*;

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
import java.util.*;

/**
 * Esta clase contiene las acciones para listar recomendaciones de atracciones
 * @author: Julio De Buen, Andrea Luis, Lesli Olvera y Enrique Espinosa
 * @version: 23/03/2017
 */

public final class MCURecomendacion extends MappingDispatchAction {
    private Log log = LogFactory.getLog(MCURegistrarUsuario.class);

    /**
     * Accion que permite solicitar recomendaciones de atracciones
     * @param: mapping ActionMapping
     * @param: form ActionForm
     * @param: request HttpServletRequest
     * @param: response HttpServletResponse
     * @return: ActionForward
     * @see: solicitarListarRecomendaciones
     */
    public ActionForward solicitarRecomendaciones(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">solicitarRecomendacion");
        }
        FormaRecomendaciones   forma = (FormaRecomendaciones)form;

        ManejadorRecomendaciones mr = new ManejadorRecomendaciones();
        Object obj = request.getParameter("atractionName");
        Collection resultado = mr.listarRecomendaciones();

        ActionMessages errores = new ActionMessages();
        if (resultado != null) {
            if ( resultado.isEmpty() ) {
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.registroVacio"));
                saveErrors(request, errores);
            } else {
                forma.setRecomendaciones( resultado );
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
