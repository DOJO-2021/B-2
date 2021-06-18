package model;



public class FaceMark  {

	private int facemark_id;
	private String facemark_name;


	public FaceMark(int facemark_id, String facemark_name) {
		super();
		this.facemark_id = facemark_id;
		this.facemark_name = facemark_name;
	}

	public FaceMark() {
		super();
		this.facemark_id = 0;
		this.facemark_name = "";
	}

	public int getFacemark_id() {
		return facemark_id;
	}
	public int getFacemarkid() {
		return facemark_id;
	}
	public void setFacemark_id(int facemark_id) {
		this.facemark_id = facemark_id;
	}
	public String getFacemark_name() {
		return facemark_name;
	}
	public void setFacemark_name(String facemark_name) {
		this.facemark_name = facemark_name;
	}

}
