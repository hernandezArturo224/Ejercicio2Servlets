package modelos;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "roles")
public class Roles implements Serializable{
	
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "rol", nullable = false)
	private String rol;
	
	public Roles() {
		
	}

	@Override
	public String toString() {
		return "Roles [id=" + id + ", rol=" + rol + "]";
	}

	public Roles(int id, String rol) {
		this.id = id;
		this.rol = rol;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}
