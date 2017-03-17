package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;


public class Estado extends ClaseBase 
        implements Serializable {

    private int idPais;
    private int idEstado;
    private String nombreEstado;


    public Estado() {
    }

    public Estado(int idPais){
        this.idPais = idPais;
    }

    public Estado(int idEstado, String nombreEstado){
        this.idEstado=idEstado;
        this.nombreEstado=nombreEstado;
    }

    public int getIdPais(){
        return this.idPais;
    }

    public int getIdEstado(){
        return this.idEstado;
    }

    public String getNombreEstado(){
        return this.nombreEstado;
    }

    public void setIdPais(int idPais){
        this.idPais = idPais;
    }

    public void setIdEstado(int idEstado){
        this.idEstado = idEstado;
    }

    public void setNombreEstado(String nombreEstado){
        this.nombreEstado = nombreEstado;
    }
}
