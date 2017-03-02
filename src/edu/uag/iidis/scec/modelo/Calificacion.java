package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;

public class Calificacion  extends ClaseBase 
        implements Serializable {

    private Long id;
    private int puntaje;
    private String comentario;

    public Calificacion() {
    }

    public Calificacion(Long id){
        this.id = id;
    }

    public Calificacion(int puntaje, String comentario){
        this.puntaje=puntaje;
        this.comentario=comentario;
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
