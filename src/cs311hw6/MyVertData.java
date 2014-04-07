package cs311hw6;

public class MyVertData {
	int ID;
	double lat;
	double lon;
	
	public MyVertData(int ID, double lat, double lon) {
		super();
		this.ID = ID;
		this.lat = lat;
		this.lon = lon;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	
}
