package cs311hw6;

public class Edge<EdgeAtt> {
	
	private int GID;
	private int sourceGID;
	private int targetGID;
	private EdgeAtt att;
	
	public Edge(int sourceGID, int targetGID, EdgeAtt att, int GID){
		this.GID = GID;
		this.sourceGID = sourceGID;
		this.targetGID = targetGID;
		this.att = att;
	}

	public int getGID() {
		return GID;
	}

	public void setGID(int gID) {
		GID = gID;
	}


	public EdgeAtt getAtt() {
		return att;
	}

	public void setAtt(EdgeAtt att) {
		this.att = att;
	}

	public int getSourceGID() {
		return sourceGID;
	}

	public void setSourceGID(int sourceGID) {
		this.sourceGID = sourceGID;
	}

	public int getTargetGID() {
		return targetGID;
	}

	public void setTargetGID(int targetGID) {
		this.targetGID = targetGID;
	}
	
	

}
