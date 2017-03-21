package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;
import java.util.Date;

/**
 * 
 *  
 *
 * <p><a href="calificacion.java.html"><i>Ver código fuente</i></a></p>
 *
 * @author <a href="mailto:vramos@uag.mx">Victor Ramos</a>
 * @version 1.0
 */
public class Recomendacion extends ClaseBase 
        implements Serializable {

    int id; 
    String nombrePais;
    String nombreEstado;
    String nombreMunicipio;
    int idAtraccion;
    String nombreAtraccion;
    String path;
    int puntaje;


    public Recomendacion() {
    }
  
    public int getId() {
        return this.id;
    }
    public String getNombrePais() {
        return this.nombrePais;
    }
	public String getNombreEstado() {
        return this.nombreEstado;
    }
	public String getNombreMunicipio() {
        return this.nombreMunicipio;
    }
	public int getIdAtraccion() {
        return this.idAtraccion;
    }
    public String getNombreAtraccion() {
        return this.nombreAtraccion;
    }public String getPath() {
        return this.path;
    }
	public int getPuntaje() {
        return this.puntaje;
    }


    public void setId(int id) {
        this.id = id;
    }
    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }
	public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }
	public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }
	public void setIdAtraccion(int idAtraccion) {
        this.idAtraccion = idAtraccion;
    }
	public void setNombreAtraccion(String nombreAtraccion) {
        this.nombreAtraccion = nombreAtraccion;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

}