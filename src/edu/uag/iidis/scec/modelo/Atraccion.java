package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;

/**
 * Esta clase contiene los atributos y metodos de getter y setter de una atraccion
 * @author: Julio De Buen, Andrea Luis, Lesli Olvera y Enrique Espinosa
 * @version: 23/03/2017
 */

public class Atraccion extends ClaseBase 
        implements Serializable {
	
	private int idMunicipio;
	private int idAtraccion;
	private String nombreAtraccion;

	public Atraccion() {

	}

	public Atraccion(String nombreAtraccion) {
		this.nombreAtraccion = nombreAtraccion;
	}

	public Atraccion(int idMunicipio, int idAtraccion, String nombreAtraccion) {
		this.idMunicipio = idMunicipio;
		this.idAtraccion = idAtraccion;
		this.nombreAtraccion = nombreAtraccion;
	}
	
 
	public String getNombreAtraccion() {
		return this.nombreAtraccion;
	}

	public void setNombreAtraccion(String nombreAtraccion) {
		this.nombreAtraccion = nombreAtraccion;
	}

	public int getIdMunicipio() {
		return this.idMunicipio;
	}

	public void setIdMunicipio(int idMunicipio) {
		this.idMunicipio = idMunicipio;
	}
		
	public int getIdAtraccion() {
		return this.idAtraccion;
	}

	public void setIdAtraccion(int idAtraccion) {
		this.idAtraccion = idAtraccion;
	}

}
