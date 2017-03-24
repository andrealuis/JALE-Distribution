package edu.uag.iidis.scec.vista;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

/**
 * Esta clase contiene getter y setter de los atributos de municipios
 * @author: Julio De Buen, Andrea Luis, Lesli Olvera y Enrique Espinosa
 * @version: 23/03/2017
 */

public final class FormaListadoMunicipios
        extends ValidatorForm {

    private Collection municipios;
    private int contador;


    public void setMunicipios(Collection municipios) {
        this.municipios = municipios;
        if (municipios != null) {
          this.contador = municipios.size();
        } else
          this.contador = -1;
    }

    public Collection getMunicipios() {
        return (this.municipios);
    }
  
    public int getContador() {
        return (this.contador);
    }


    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        contador=0;
        municipios =null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
