package cs311hw6;

public class TopoAtt {
	private int sourceID;
	private int targetID;
	
	public TopoAtt(int sourceID, int targetID){
		super();
		this.sourceID = sourceID;
		this.targetID = targetID;
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
	
}
