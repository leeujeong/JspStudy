package dto;

public class Roard {

	private String title;
	private String wroter;
	private int vaew;
	
	public Roard(String title, String wroter, int vaew) {
		super();
		this.title = title;
		this.wroter = wroter;
		this.vaew = vaew;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWroter() {
		return wroter;
	}
	public void setWroter(String wroter) {
		this.wroter = wroter;
	}
	public int getVaew() {
		return vaew;
	}
	public void setVaew(int vaew) {
		this.vaew = vaew;
	}
	
}
