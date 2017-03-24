package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;

/**
 * Esta clase contiene los atributos y metodos de getter y setter de un municipio
 * @author: Julio De Buen, Andrea Luis, Lesli Olvera y Enrique Espinosa
 * @version: 23/03/2017
 */

public class Municipio extends ClaseBase 
        implements Serializable {

    private int idEstado;
    private int idMunicipio;
    private String nombreMunicipio;


    public Municipio() {
    }

    public Municipio(int idMunicipio){
        this.idMunicipio = idMunicipio;
    }

    public Municipio(String nombreMunicipio){
        this.nombreMunicipio=nombreMunicipio;
    }

    public int getIdEstado(){
        return this.idEstado;
    }

    public void setIdEstado(int idEstado){
        this.idEstado = idEstado;
    }

    public int getidMunicipio() {
        return this.idMunicipio;
    }

    public void setidMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }


    public String getNombreMunicipio() {
        return this.nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }
}