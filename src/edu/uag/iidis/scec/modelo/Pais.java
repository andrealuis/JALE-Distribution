package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;

/**
 * Esta clase contiene los atributos y metodos de getter y setter de un pais
 * @author: Julio De Buen, Andrea Luis, Lesli Olvera y Enrique Espinosa
 * @version: 23/03/2017
 */

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