package edu.uag.iidis.scec.vista;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public final class FormaNuevaCalificacion
        extends ValidatorForm {

    private String nombreAtraccion;
    private int puntaje;
    private String comentario;

    public void setNombreAtraccion(String nombreAtraccion) {
        this.nombreAtraccion = nombreAtraccion;
    }

    public String getNombreAtraccion() {
        return (this.nombreAtraccion);
    }


    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getPuntaje() {
        return (this.puntaje);
    }


    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getComentario() {
        return (this.comentario);
    }


    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        puntaje=0;
        comentario=null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}