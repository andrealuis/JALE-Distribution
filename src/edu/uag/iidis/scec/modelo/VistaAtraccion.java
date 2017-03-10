package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;

public class VistaAtraccion extends ClaseBase 
        implements Serializable {
	
	//private int idMunicipio;	
	private String nombreAtraccion;
	private String descripcion;
	private String direccion;
	private String path;
	private int id;

	public VistaAtraccion() {

	}

	public VistaAtraccion(String nombreAtraccion) {
		this.nombreAtraccion = nombreAtraccion;
	}

/*	public VistaAtraccion(int idMunicipio, String nombreAtraccion, String descripcion, String direccion, String path) {
		this.idMunicipio = idMunicipio;
		this.nombreAtraccion = nombreAtraccion;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.path = path;
	}
*/
	public VistaAtraccion(String nombreAtraccion, String descripcion, String direccion, String path) {
		this.nombreAtraccion = nombreAtraccion;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.path = path;
	}
	
	public int getId(){
		return this.id;
	}

	public void setId(int id){
		this.id = id;
	}
 
	public String getNombreAtraccion() {
		return this.nombreAtraccion;
	}

	public void setNombreAtraccion(String nombreAtraccion) {
		this.nombreAtraccion = nombreAtraccion;
	}

	public String getDescripcion(){
		return this.descripcion;
	}

	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}

	public String getDireccion(){
		return this.direccion;
	}

	public void setDireccion(String direccion){
		this.direccion = direccion;
	}

	public String getPath(){
		return this.path;
	}

	public void setPath(String path){
		this.path = path;
	}

/*	public int getIdMunicipio() {
		return this.idMunicipio;
	}

	public void setIdMunicipio(int idMunicipio) {
		this.idMunicipio = idMunicipio;
	}*/
		


}
