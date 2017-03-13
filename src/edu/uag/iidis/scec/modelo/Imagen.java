package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;

public class Imagen extends ClaseBase 
        implements Serializable {
    private int id;
	private int idAtraccion;
	private String path;

	public Imagen() {

	}

	public Imagen(String path) {
		this.path = path;
	}

	public Imagen(int idAtraccion, String path) {
		this.idAtraccion = idAtraccion;
		this.path = path;
	}
	
 
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getIdAtraccion() {
		return this.idAtraccion;
	}

	public void setIdAtraccion(int idAtraccion) {
		this.idAtraccion = idAtraccion;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
