package model;

public class FaceMarks {

	private int facemark_good;
	private int facemark_soso;
	private int facemark_bad;

	public FaceMarks(int facemark_good, int facemark_soso,int facemark_bad) {

		this.facemark_good = facemark_good;
		this.facemark_soso = facemark_soso;
		this.facemark_bad = facemark_bad;
	}

	public FaceMarks() {
		this.facemark_good = 0;
		this.facemark_soso = 0;
		this.facemark_bad = 0;
	}

	public int getFacemark_good() {
		return facemark_good;
	}

	public void setFacemark_good(int facemark_good) {
		this.facemark_good = facemark_good;
	}

	public int getFacemark_soso() {
		return facemark_soso;
	}

	public void setFacemark_soso(int facemark_soso) {
		this.facemark_soso = facemark_soso;
	}

	public int getFacemark_bad() {
		return facemark_bad;
	}

	public void setFacemark_bad(int facemark_bad) {
		this.facemark_bad = facemark_bad;
	}

}
