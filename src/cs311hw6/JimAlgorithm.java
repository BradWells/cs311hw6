package cs311hw6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class JimAlgorithm {
	public static void main(String args[]) throws FileNotFoundException{
				
		Graph<MyVertData, MyEdgeAtt> graph = new MyGraph<MyVertData, MyEdgeAtt>();
		//ID is given by the text file, GID is my internal representation.
		HashMap<Integer, Integer> IDtoGID = new HashMap<Integer, Integer>();
		
		File file = new File("ames.txt");
		Scanner scanner = new Scanner(file);
		if(!(scanner.next().equals("VERTICES:"))){
			scanner.close();
			throw new IllegalArgumentException("Invalid input file");
		}
		int vertNum = scanner.nextInt();
		scanner.nextLine();
		for(int i=0; i<vertNum; i++){
			Scanner lnScan = new Scanner(scanner.nextLine());
			lnScan.useDelimiter(",");
			int id = lnScan.nextInt();
			double lat = lnScan.nextDouble();
			double lon = lnScan.nextDouble();
			MyVertData data = new MyVertData(id, lat, lon);
			int GID = graph.addVertex(data);
			IDtoGID.put(id, GID);
			lnScan.close();
		}
		
		if(!(scanner.next().equals("EDGES:"))){
			scanner.close();
			throw new IllegalArgumentException("Invalid input file");
		}
		int edgeNum = scanner.nextInt();
		scanner.nextLine();
		for(int i=0; i<edgeNum; i++){
			Scanner lnScan = new Scanner(scanner.nextLine());
			lnScan.useDelimiter(",");
			int srcid = lnScan.nextInt();
			int targid = lnScan.nextInt();
			int srcGID = IDtoGID.get(srcid);
			int targGID = IDtoGID.get(targid);
			double weight = lnScan.nextDouble();
			String address = null;
			if(lnScan.hasNext()){
				//The rest is the address, the substring removes the comma
				address = lnScan.nextLine().substring(1);
			}
			//Undirected, so both ways work
			MyEdgeAtt att = new MyEdgeAtt(srcid, targid, weight, address);
			graph.addEdge(srcGID, targGID, att);
			att = new MyEdgeAtt(targid, srcid, weight, address);
			graph.addEdge(targGID, srcGID, att);
			lnScan.close();
		}
		
		scanner.close();
		
		
		//Topological sort
		Graph<TopoData, TopoAtt> topoGraph = new MyGraph<TopoData, TopoAtt>();
		
		//Manually typed topological graph, could easily be given as data.
		String[] letters = {"A","B","C","D","E","F","G","You"};
		int[] IDs = {1055, 371, 2874, 2351, 2956, 1171, 1208, 2893};
		HashMap<String, Integer> letterToID = new HashMap<String, Integer>();
		
		for(int i=0; i<letters.length; i++){
			letterToID.put(letters[i], topoGraph.addVertex(new TopoData(IDs[i],letters[i])));
		}
		
		String[] pickedUpBefore = {"A","A","B","B","C","C","F","F",  "A","B","C","D","E","F","You"};
		String[] pickedUpAfter = {"C","F","C","D","D","E","C","E",   "G","G","G","G","G","G","G"};
		
		for(int i=0; i<pickedUpBefore.length; i++){
			TopoAtt attr = new TopoAtt(letterToID.get(pickedUpBefore[i]), letterToID.get(pickedUpAfter[i]));
			topoGraph.addEdge(letterToID.get(pickedUpBefore[i]), letterToID.get(pickedUpAfter[i]), attr);
		}
		
		Stack<Integer> ordering = new Stack<Integer>();
		
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		//graph presets all nodes to undiscovered
		Integer firstID = letterToID.get("You");
		queue.add(firstID);
		//Set the first node to DISCOVERED
		topoGraph.getData(firstID).setDiscovered(true);
		
		while(!queue.isEmpty()){
			int ID = queue.remove();
			//PROCESS VERTEX EARLY
			//ID.state = processed if necessary
			for(Integer edge : topoGraph.getEdgesOf(ID)){
				//PROCESS EDGE
				//TODO if backedge, ordering is null, then break.
				Integer target = topoGraph.getAttribute(edge).getTargetID();
				if(!(topoGraph.getData(target).isDiscovered())){
					queue.add(target);
					topoGraph.getData(target).setDiscovered(true);
					//Do I need to use this here?
					topoGraph.getData(target).setParent(ID);
				}
			}
			//PROCESS VERTEX LATE
			ordering.push(ID);
		}
		
		while(!ordering.isEmpty()){
			System.out.println(topoGraph.getData(ordering.pop()).getName());
		}
		
		System.out.println("done");
	}
	
}
