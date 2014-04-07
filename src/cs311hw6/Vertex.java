package cs311hw6;

import java.util.HashMap;

public class Vertex<VertData> {
	
	
	private int GID;
	private VertData data;
	private HashMap<Integer, Edge<?>> outgoingEdges = new HashMap<Integer, Edge<?>>();
	
	public Vertex(VertData data, int GID){
		this.data = data;
		this.GID = GID;
	}
	
	public int getGID() {
		return GID;
	}

	public void setGID(int gID) {
		GID = gID;
	}

	public VertData getData() {
		return data;
	}

	public void setData(VertData data) {
		this.data = data;
	}
	
	public void addOutgoingEdge(Edge<?> e) throws Exception{
		if(!(e.getSourceGID() == this.GID)){
			throw new Exception("Incorrect edge add!");
		}
		else{
			outgoingEdges.put(e.getTargetGID(), e);
		}
	}
	
	public void removeOutgoingEdge(int id){
		outgoingEdges.remove(id);
	}

	public HashMap<Integer, Edge<?>> getOutgoingEdges() {
		return outgoingEdges;
	}

	public void setOutgoingEdges(HashMap<Integer, Edge<?>> outgoingEdges) {
		this.outgoingEdges = outgoingEdges;
	}
	
}