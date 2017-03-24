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

import net.webservicex.*;

/**
 * Esta clase contiene las acciones para listar lugares
 * @author: Julio De Buen, Andrea Luis, Lesli Olvera y Enrique Espinosa
 * @version: 23/03/2017
 */

public final class MCUListarLugares
        extends MappingDispatchAction {

    private Log log = LogFactory.getLog(MCURegistrarUsuario.class);


    /**
     * Accion que permite solicitar estados
     * @param: mapping ActionMapping
     * @param: form ActionForm
     * @param: request HttpServletRequest
     * @param: response HttpServletResponse
     * @return: ActionForward
     * @see: solicitarListarEstados
     */
    public ActionForward solicitarListarEstados(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">solicitarListarEstados");
        }

        FormaListadoEstados forma = (FormaListadoEstados)form;

        ManejadorLugares mr = new ManejadorLugares();
        Object obj = request.getParameter("idPais");
        Collection resultado = mr.buscaEstado(obj.toString());

        ActionMessages errores = new ActionMessages();
        if (resultado != null) {
            if ( resultado.isEmpty() ) {
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.registroVacio"));
                saveErrors(request, errores);
            } else {
                forma.setEstados(resultado);
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

    /**
     * Accion que permite solicitar municipios
     * @param: mapping ActionMapping
     * @param: form ActionForm
     * @param: request HttpServletRequest
     * @param: response HttpServletResponse
     * @return: ActionForward
     * @see: solicitarListarMunicipios
     */
    public ActionForward solicitarListarMunicipios(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">solicitarListarMunicipios");
        }

        FormaListadoMunicipios forma = (FormaListadoMunicipios)form;

        ManejadorLugares mr = new ManejadorLugares();
        Object obj = request.getParameter("idEstado");
        Collection resultado = mr.buscaMunicipio(obj.toString());

        ActionMessages errores = new ActionMessages();
        if (resultado != null) {
            if ( resultado.isEmpty() ) {
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.registroVacio"));
                saveErrors(request, errores);
            } else {
                forma.setMunicipios(resultado);
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


    /**
     * Accion que permite solicitar paises
     * @param: mapping ActionMapping
     * @param: form ActionForm
     * @param: request HttpServletRequest
     * @param: response HttpServletResponse
     * @return: ActionForward
     * @see: solicitarListarLugares
     */
    public ActionForward solicitarListarLugares(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">solicitarListarLugares");
        }

        // Verifica si la acción fue cancelada por el usuario
        if (isCancelled(request)) {
            if (log.isDebugEnabled()) {
                log.debug("<La acción fue cancelada");
            }
            return (mapping.findForward("cancelar"));
        }

        FormaListadoPaises forma = (FormaListadoPaises)form;

        ManejadorLugares mr = new ManejadorLugares();
        Collection resultado = mr.buscaPaises();
        ActionMessages errores = new ActionMessages();
        if (resultado != null) {
            if ( resultado.isEmpty() ) {
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.registroVacio"));
                saveErrors(request, errores);
            } else {
                forma.setPaises(resultado);
               // log.debug(forma.getPaises());
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

    /**
     * Accion que permite buscar un lugar
     * @param: mapping ActionMapping
     * @param: form ActionForm
     * @param: request HttpServletRequest
     * @param: response HttpServletResponse
     * @return: ActionForward
     * @see: buscarLugar
     */
	 public ActionForward buscarLugar(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">solicitarListarLugares");
        }

        // Verifica si la acción fue cancelada por el usuario
        if (isCancelled(request)) {
            if (log.isDebugEnabled()) {
                log.debug("<La acción fue cancelada");
            }
            return (mapping.findForward("cancelar"));
        }

        FormaListadoLugares forma = (FormaListadoLugares)form;

        ManejadorLugares mr = new ManejadorLugares();
        Collection resultado = mr.listarLugaresPorNombre(forma.getNombre());

        ActionMessages errores = new ActionMessages();
        if (resultado != null) {
            if ( resultado.isEmpty() ) {
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.registroVacio"));
                saveErrors(request, errores);
            } else {
                forma.setLugares(resultado);
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