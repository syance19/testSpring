package com.bolsadeideas.springboot.backend.apirest.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long usrid;
	@Column
	@NotEmpty
	private String nombre;
	@Column
	private String apellido;
	@Column
	@Email
	private String email;
	@Column
	private Integer rol;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat (pattern = "dd-MM-yyyy")
	private Date fechamodificacion;
	
	
	
	public Long getUsrid() {
		return usrid;
	}



	public void setUsrid(Long usrid) {
		this.usrid = usrid;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Integer getRol() {
		return rol;
	}



	public void setRol(Integer rol) {
		this.rol = rol;
	}



	public Date getFechamodificacion() {
		return fechamodificacion;
	}



	public void setFechamodificacion(Date fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	private static final long serialVersionUID = 1L;
}
