package edu.uag.iidis.scec.vista;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

/**
 * Esta clase contiene getter y setter de los atributos de un nuevo estado
 * @author: Julio De Buen, Andrea Luis, Lesli Olvera y Enrique Espinosa
 * @version: 23/03/2017
 */

public final class FormaNuevoEstado
        extends ValidatorForm {

    private String nombre;
    private String descripcion;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return (this.nombre);
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return (this.descripcion);
    }


    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        nombre=null;
        descripcion=null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
