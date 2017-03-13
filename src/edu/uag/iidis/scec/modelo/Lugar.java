package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;


/**
 * 
 *  
 *
 * <p><a href="Estado.java.html"><i>Ver código fuente</i></a></p>
 *
 * @author <a href="mailto:vramos@uag.mx">Victor Ramos</a>
 * @version 1.0
 */
public class Lugar extends ClaseBase 
        implements Serializable {

    private Long id;
    private String nombre;
	private String estado;
    private String pais;

    public Lugar() {
    }

    public Lugar(Long id){
        this.id = id;
    }

    public Lugar(String nombre, String estado, String pais) {
        this.nombre = nombre;
        this.estado = estado;
        this.pais = pais;
    }

    

    /**
     * Regresa el id del Lugar.
     * @return Long
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Establece el id del Lugar.
     * @return void
     */
    public void setId(Long id) {
        this.id = id;
    }


    /**
     * Regresa el nombre del Lugar.
     * @return String
     */
    public String getNombre() {
        return this.nombre;
    }
	public String getEstado() {
        return this.estado;
    }
         public String getPais() {
        return this.pais;
    }
    /**
     * Establece el nombre del Lugar.
     * @return void
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
	public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    /**
     * Regresa la descripción del Lugar.
     * @return String
     */
    

    /**
     * Establece la descripción del Lugar.
     * @return void
     */
    


}