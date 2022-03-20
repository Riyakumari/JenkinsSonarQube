package maven_project2.TShirt_App;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TshirtDetails {
	@Id
	private String SID;
	private String Name;
	private String Color;
	private String Gender;
	private String Size;
	private String Price;
	private String Rating;
	private String Availability;
	public String getID() {
		return SID;
	}
	public void setID(String iD) {
		SID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getSize() {
		return Size;
	}
	public void setSize(String size) {
		Size = size;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getRating() {
		return Rating;
	}
	public void setRating(String rating) {
		Rating = rating;
	}
	public String getAvailability() {
		return Availability;
	}
	public void setAvailability(String availability) {
		Availability = availability;
	}
	@Override
	public String toString() {
		return "TshirtDetails [SID=" + SID + ", Name=" + Name + ", Color=" + Color + ", Gender=" + Gender + ", Size="
				+ Size + ", Price=" + Price + ", Rating=" + Rating  + "]";
	}
	
	
	

}
