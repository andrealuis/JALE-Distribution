package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;

/**
 * Esta clase contiene los atributos y metodos de getter y setter de una calificacion
 * @author: Julio De Buen, Andrea Luis, Lesli Olvera y Enrique Espinosa
 * @version: 23/03/2017
 */

public class Calificacion  extends ClaseBase 
        implements Serializable {

    private Long id;
    private int puntaje;
    private String comentario;
    private String nombreAtraccion;

    public Calificacion() {
    }

    public Calificacion(Long id){
        this.id = id;
    }

    public Calificacion(int puntaje, String comentario, String nombreAtraccion){
        this.puntaje=puntaje;
        this.comentario=comentario;
        this.nombreAtraccion = nombreAtraccion;
    }

    /**
     * Regresa el id de la calificacion.
     * @return Long
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Establece el id de la calificacion.
     * @return void
     */
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreAtraccion(){
        return this.nombreAtraccion;
    }

    public void setNombreAtraccion(String nombreAtraccion){
        this.nombreAtraccion = nombreAtraccion;
    }


    public int getPuntaje(){
		return this.puntaje;
    }

    public void setPuntaje(int puntaje){
    	this.puntaje = puntaje;
    }

    public String getComentario(){
    	return this.comentario;
    }

    public void setComentario(String comentario){
    	this.comentario = comentario;
    }
}
