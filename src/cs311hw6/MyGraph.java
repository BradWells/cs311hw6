package cs311hw6;

import java.util.HashMap;
import java.util.Set;

public class MyGraph<VertData, EdgeAtt> implements Graph<VertData, EdgeAtt>{
	
	//I am denoting GID for vertices in my graph, and ID for the ID's given in the text document
	private int nextVertexGID = 0;
	private int nextEdgeGID = 0;
	
	private HashMap<Integer, Vertex<VertData>> vertexHash = new HashMap<Integer, Vertex<VertData>>();
	private HashMap<Integer, Edge<EdgeAtt>> edgeHash = new HashMap<Integer, Edge<EdgeAtt>>();

	
	public MyGraph(){
	}


	@Override
	public int addVertex(VertData d) {
		Vertex<VertData> v = new Vertex<VertData>(d, nextVertexGID);
		vertexHash.put(nextVertexGID, v);
		int temp = nextVertexGID;
		nextVertexGID++;
		return temp;
	}

	@Override
	public int addEdge(int srcGID, int targetGID, EdgeAtt attr)
			throws IllegalArgumentException {
		
		//Exception Checking
		if(!vertexHash.containsKey(srcGID)){
			throw new IllegalArgumentException("Vertex not found when adding:" + srcGID);
		}
		else if(!vertexHash.containsKey(targetGID)){
			throw new IllegalArgumentException("Vertex not found when adding:" + targetGID);
		}
		
		Edge<EdgeAtt> e = new Edge<EdgeAtt>(srcGID, targetGID, attr, nextEdgeGID);
		edgeHash.put(nextEdgeGID, e);
		
		Vertex<VertData> v = vertexHash.get(srcGID);
		try{
			v.addOutgoingEdge(e);
		}
		catch(Exception ex){
			//Do nothing
		}
		
		int temp = nextEdgeGID;
		nextEdgeGID++;
		return temp;
		
	}

	@Override
	public Set<Integer> getVertices() {
		return vertexHash.keySet();
	}

	@Override
	public Set<Integer> getEdges() {
		return edgeHash.keySet();
	}

	@Override
	public EdgeAtt getAttribute(int id) throws IllegalArgumentException {
		Edge<EdgeAtt> edge = edgeHash.get(id);
		return edge.getAtt();
	}

	@Override
	public VertData getData(int id) throws IllegalArgumentException {
		Vertex<VertData> vert = vertexHash.get(id);
		return vert.getData();
	}

	@Override
	public int getSource(int id) throws IllegalArgumentException {
		Edge<EdgeAtt> edge = edgeHash.get(id);
		return edge.getSourceGID();
	}

	@Override
	public int getTarget(int id) throws IllegalArgumentException {
		Edge<EdgeAtt> edge = edgeHash.get(id);
		return edge.getTargetGID();
	}

	@Override
	public Set<Integer> getEdgesOf(int id) throws IllegalArgumentException {
		Vertex<VertData> vert = vertexHash.get(id);
		return vert.getOutgoingEdges().keySet();
	}

}
