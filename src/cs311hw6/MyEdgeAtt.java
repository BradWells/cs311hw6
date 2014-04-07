package cs311hw6;

public class MyEdgeAtt {
	private int sourceID;
	private int targetID;
	private double weight;
	private String address;
	
	public MyEdgeAtt(int sourceID, int targetID, double weight,
			String address) {
		super();
		this.sourceID = sourceID;
		this.targetID = targetID;
		this.weight = weight;
		this.address = address;
	}
	
	public int getSourceID() {
		return sourceID;
	}
	public void setSourceID(int sourceID) {
		this.sourceID = sourceID;
	}
	public int getTargetID() {
		return targetID;
	}
	public void setTargetID(int targetID) {
		this.targetID = targetID;
	}
	public double getIsThisWeight() {
		return weight;
	}
	public void setIsThisWeight(double weight) {
		this.weight = weight;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
