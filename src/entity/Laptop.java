package entity;

public class Laptop {
	private int id;
	private String model;
	private ScreenSize screenSize;
	
	public Laptop() {
		this(0,"",ScreenSize.SIZE_12INCH);
	}
	public Laptop(int id, String model, ScreenSize screenSize) {
		super();
		this.id = id;
		this.model = model;
		this.screenSize = screenSize;
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
	public ScreenSize getScreenSize() {
		return screenSize;
	}
	public void setScreenSize(ScreenSize screenSize) {
		this.screenSize = screenSize;
	}
	@Override
	public String toString() {
		return "Laptop [id=" + id + ", model=" + model + ", screenSize=" + screenSize + "]";
	}
	
	

}
