package washo.gmd.app.client.model;

import java.io.Serializable;

public class Game implements Serializable 
{
	private static final long serialVersionUID = -7336373024783400984L;

	private Integer id;
	private String fieldName;
	private String location;
	private String dateTime;
	private String coachName;
	private String color;
	
	public Game() {}
	
	public Game(Integer id, String fieldName, String location, String dateTime, String coachName, String color) {
		super();
		this.id = id;
		this.fieldName = fieldName;
		this.location = location;
		this.dateTime = dateTime;
		this.coachName = coachName;
		this.setColor(color);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getCoachName() {
		return coachName;
	}
	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
