package boot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="tennis")
public class Tenni implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=30)
	private String type;
	@Column(length=50)
	private String color;
	@Column(length=30)
	private String brand;
	@Column
	private int size;
	
	public Tenni(String type, String color, String brand, int size) {
		super();
		this.type = type;
		this.color = color;
		this.brand = brand;
		this.size = size;
	}
	
	public Tenni() {
		this("","","",0);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Tennis [id=" + id + ", type=" + type + ", color=" + color + ", brand=" + brand + ", size=" + size + "]";
	}

	
	

}
