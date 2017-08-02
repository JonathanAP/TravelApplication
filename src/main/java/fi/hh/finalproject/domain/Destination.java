package fi.hh.finalproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fi.hh.finalproject.domain.Category;

//adding entity and unique id
@Entity
public class Destination {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	/*@NotNull //adding bean validation telling id cannot be null */
	private long id;
	private String destinationName;
	private String province;
	private String mainAttraction;
	private int rating;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="categoryId")
	private Category category;
	
	public Destination() {
		
	}
	
	public Destination(String destinationName, String province, String mainAttraction, int rating, Category category) {
		super();
		this.destinationName = destinationName;
		this.province = province;
		this.mainAttraction = mainAttraction;
		this.rating = rating;
		this.category = category;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getMainAttraction() {
		return mainAttraction;
	}

	public void setMainAttraction(String mainAttraction) {
		this.mainAttraction = mainAttraction;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		if(this.category != null) {
			return "\nDestination: " + destinationName + "\nProvince: " + province + "\nMain attractions: " + mainAttraction + "\nRating: " + rating + "\nCategory: " + this.getCategory();
		} else {
			return "\nDestination: " + destinationName + "\nProvince: " + province + "\nMain attractions: " + mainAttraction + "\nRating: " + rating;
		}
	}
	
}
