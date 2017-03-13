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
public final class FormaAtraccion
        extends ValidatorForm {

    private Collection atraccion;
    private int contador;


    public void setAtraccion(Collection atraccion) {
        this.atraccion = atraccion;
        if (atraccion != null) {
          this.contador = atraccion.size();
        } else
          this.contador = -1;
    }

    public Collection getAtraccion() {
        return (this.atraccion);
    }
  
    public int getContador() {
        return (this.contador);
    }


    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        contador=0;
        atraccion=null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}