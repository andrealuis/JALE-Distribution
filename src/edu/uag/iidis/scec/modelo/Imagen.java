package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;

public class Imagen extends ClaseBase 
        implements Serializable {
    private int id;
	private int idImagen;
	private String path;

	public Imagen() {

	}

	public Imagen(String path) {
		this.path = path;
	}

	public Imagen(int idImagen, String path) {
		this.idImagen = idImagen;
		this.path = path;
	}
	
 
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getIdImagen() {
		return this.idImagen;
	}

	public void setIdImagen(int idImagen) {
		this.idImagen = idImagen;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
