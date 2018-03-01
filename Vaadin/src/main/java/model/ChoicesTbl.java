package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the choices_tbl database table.
 * 
 */
@Entity
@Table(name="choices_tbl")
@NamedQuery(name="ChoicesTbl.findAll", query="SELECT c FROM ChoicesTbl c")
public class ChoicesTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CHOICES_TBL_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CHOICES_TBL_ID_GENERATOR")
	private int id;

	private String description;

	@Column(name="meal_picture")
	private String mealPicture;

	@Column(name="product_picture")
	private String productPicture;

	public ChoicesTbl() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMealPicture() {
		return this.mealPicture;
	}

	public void setMealPicture(String mealPicture) {
		this.mealPicture = mealPicture;
	}

	public String getProductPicture() {
		return this.productPicture;
	}

	public void setProductPicture(String productPicture) {
		this.productPicture = productPicture;
	}

}