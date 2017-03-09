package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;

public class Atraccion extends ClaseBase 
        implements Serializable {
	
	private int idMunicipio;
	private int idAtraccion;
	private int idImagen;
	private String nombreAtraccion;

	public Atraccion() {

	}

	public Atraccion(String nombreAtraccion) {
		this.nombreAtraccion = nombreAtraccion;
	}

	public Atraccion(int idMunicipio, int idAtraccion, int idImagen, String nombreAtraccion) {
		this.idMunicipio = idMunicipio;
		this.idAtraccion = idAtraccion;
		this.idImagen = idImagen;
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

	public int getIdImagen() {
		return this.idImagen;
	}

	public void setIdImagen(int idImagen) {
		this.idImagen = idImagen;
	}


}
