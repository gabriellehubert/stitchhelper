package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Entity
public class Floss implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6894991871553973333L;
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private FlossBrand brand;
	private int numCode;
	private String colourName;
	private String colourHex;
	
	public Floss() {
		this(FlossBrand.NONE, -1, "", "");
	}
	
	public Floss(FlossBrand brand, int numCode, String colourName, String colourHex) {
		this.brand = brand;
		this.numCode = numCode;
		this.colourName = colourName;
		this.colourHex = colourHex;
	}
	
	public FlossBrand getBrand() {
		return brand;
	}
	public void setBrand(FlossBrand brand) {
		this.brand = brand;
	}
	public int getNumCode() {
		return numCode;
	}
	public void setNumCode(int numCode) {
		this.numCode = numCode;
	}
	public String getColourName() {
		return colourName;
	}
	public void setColourName(String colourName) {
		this.colourName = colourName;
	}
	public String getColourHex() {
		return colourHex;
	}
	public void setColourHex(String colourHex) {
		this.colourHex = colourHex;
	}
	public Long getID() {
		return id;
	}

}
