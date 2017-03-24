package edu.uag.iidis.scec.vista;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

/**
 * Esta clase contiene getter y setter de los atributos de paises
 * @author: Julio De Buen, Andrea Luis, Lesli Olvera y Enrique Espinosa
 * @version: 23/03/2017
 */

public final class FormaListadoPaises
        extends ValidatorForm {

    private Collection paises;
    private int contador;


    public void setPaises(Collection paises) {
        this.paises = paises;
        if (paises != null) {
          this.contador = paises.size();
        } else
          this.contador = -1;
    }

    public Collection getPaises() {
        return (this.paises);
    }
  
    public int getContador() {
        return (this.contador);
    }


    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        contador=0;
        paises =null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
