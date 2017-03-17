package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;


public class Pais extends ClaseBase 
        implements Serializable {

    private int idPais;
    private String nombrePais;


    public Pais() {
    }

    public Pais(int idPais){
        this.idPais = idPais;
    }

    public Pais(String nombrePais){
        this.nombrePais=nombrePais;
    }

    public int getidPais() {
        return this.idPais;
    }

    public void setidPais(int idPais) {
        this.idPais = idPais;
    }


    public String getNombrePais() {
        return this.nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }
}