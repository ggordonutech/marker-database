package entity;

import java.io.Serializable;
import java.util.Date;

abstract public class Item implements Serializable{
	
	private static final long serialVersionUID = 1L;
	protected int id;
	protected String name;
	protected Date dateCreated;
	
	

	public Item() {
		this(0,"");
	}

	public Item(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName()+ " [id=" + id + ", name=" + name + ", dateCreated="
				+ dateCreated + "]";
	}
	
	

}
