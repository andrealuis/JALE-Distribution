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



public final class MCUCalificacion extends MappingDispatchAction {
    private Log log = LogFactory.getLog(MCURegistrarUsuario.class);


    public ActionForward solicitarCalificacion(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">solicitarCalificacion");
        }

        return (mapping.findForward("exito"));
    }

    public ActionForward procesarCalificacion(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">procesarCalificacion");
        }

        // Se obtienen los datos para procesar el registro
        FormaNuevaCalificacion forma = (FormaNuevaCalificacion)form;

        Calificacion calificacion = new Calificacion(forma.getPuntaje(), forma.getComentario(), forma.getNombreAtraccion());

        ManejadorCalificaciones mr = new ManejadorCalificaciones();

        int resultado = mr.crearCalificacion(calificacion);

        ActionMessages errores = new ActionMessages();

        switch (resultado) {
            case 0:   
                return (mapping.findForward("exito"));
            case 3:
                log.error("Ocurrió un error de infraestructura");
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.infraestructura"));                
                saveErrors(request, errores);
                return (mapping.getInputForward());
            default:
                log.warn("ManejadorUsuario.crearUsuario regresó reultado inesperado");
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.infraestructura"));                
                saveErrors(request, errores);
                return (mapping.getInputForward());
        }
    }

}
