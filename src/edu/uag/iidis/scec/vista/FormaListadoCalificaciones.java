package edu.uag.iidis.scec.vista;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;


/**
 * Form bean para el registro de una nueva persona.
 *
 * @author Julio
 */
public final class FormaListadoCalificaciones
        extends ValidatorForm {

    private Collection calificaciones;
    private int contador;


    public void setCalificaciones(Collection calificaciones) {
        this.calificaciones = calificaciones;
        if (calificaciones != null) {
          this.contador = calificaciones.size();
        } else
          this.contador = -1;
    }

    public Collection getCalificaciones() {
        return (this.calificaciones);
    }
  
    public int getContador() {
        return (this.contador);
    }


    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        contador=0;
        calificaciones=null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}