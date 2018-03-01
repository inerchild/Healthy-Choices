package hello;

import java.io.Serializable;
//import javax.persistence.*;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the healthy_choices database table.
 * 
 */
@Entity
@Table(name="choices_tbl")
@NamedQuery(name="HealthyChoice.findAll", query="SELECT c FROM healthy_choice c")

public class HealthyChoice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String description;

	//@Column(name="product_picture")
	//private String product_picture;

	//private String picture;

	public HealthyChoice() {
	}

	public HealthyChoice(String id, String description) {
		this.id=id;
		this.description=description;
	}
	
	
	
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	//public String getproduct_Picture() {
		//return this.product_picture;
	//}

	/*public void setmeal_picture(String meal_picture) {
		this.meal_picture = meal_picture;
	}*/

	/*public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}*/

	@Override
	public String toString()
	{
		
		//return String.format(int)finish this
				
  return "" + 	id + ": "	+ description;
	}

	
}