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
 * @author Victor Ramos
 */
public final class FormaListadoAtracciones
        extends ValidatorForm {

    private Collection atracciones;
    private int contador;
    private String nombreAtraccion;
    private int idMunicipio;
    private int idAtraccion;


    public void setAtracciones(Collection atracciones) {
        this.atracciones = atracciones;
        if (atracciones != null) {
          this.contador = atracciones.size();
        } else
          this.contador = -1;
    }

    public Collection getAtracciones() {
        return atracciones;
    }
    
    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public String getNombreAtraccion() {
        return nombreAtraccion;
    }

    public void setNombreAtraccion(String nombreAtraccion) {
        this.nombreAtraccion = nombreAtraccion;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public int getIdAtraccion() {
        return idAtraccion;
    }

    public void setIdAtraccion(int idAtraccion) {
        this.idAtraccion = idAtraccion;
    }

     
    
    

    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        contador=0;
        atracciones =null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
