package entity;

public class Phone {
	private int id;
	private String model;
	private float price;
	
	
	public Phone(int id, String model, float price) {
		super();
		this.id = id;
		this.model = model;
		this.price = price;
	}
	public Phone() {
		this(0,"",0.0f);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Phone [id=" + id + ", model=" + model + ", price=" + price + "]";
	}
	
	

}
