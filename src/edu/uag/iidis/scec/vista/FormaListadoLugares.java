package edu.uag.iidis.scec.vista;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

/**
 * Esta clase contiene getter y setter de los atributos de lugares
 * @author: Julio De Buen, Andrea Luis, Lesli Olvera y Enrique Espinosa
 * @version: 23/03/2017
 */

public final class FormaListadoLugares
        extends ValidatorForm {

    private Collection lugares;
    private int contador;
    private String nombre;
    private String pais;
    private String estado;
    private int id;

    public void setLugares(Collection lugares) {
        this.lugares = lugares;
        if (lugares != null) {
          this.contador = lugares.size();
        } else
          this.contador = -1;
    }

    public Collection getLugares() {
        return (this.lugares);
    }
  
    public int getContador() {
        return (this.contador);
    }
	public String getNombre(){
        return(this.nombre);
    }

	public void setNombre(String nombre){
         this.nombre = nombre;
    }

    public String getPais(){
        return(this.pais);
    }

    public void setPais(String pais){
         this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        contador=0;
        lugares =null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
