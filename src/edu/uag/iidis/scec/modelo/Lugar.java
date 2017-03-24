package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;

/**
 * Esta clase contiene los atributos y metodos de getter y setter de un lugar
 * @author: Julio De Buen, Andrea Luis, Lesli Olvera y Enrique Espinosa
 * @version: 23/03/2017
 */

public class Lugar extends ClaseBase 
        implements Serializable {

    private Long id;
    private String municipio;
	private String estado;
    private String pais;

    public Lugar() {
    }

    public Lugar(Long id){
        this.id = id;
    }

    public Lugar(String municipio, String estado, String pais) {
        this.municipio = municipio;
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
    public String getMunicipio() {
        return this.municipio;
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
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
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