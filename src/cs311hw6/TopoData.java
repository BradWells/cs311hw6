package cs311hw6;

public class TopoData {
	private int ID;
	private String name;
	private boolean DISCOVERED = false;
	private int parent = -1;
	
	public TopoData(int ID, String name) {
		super();
		this.ID = ID;
		this.name = name;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDiscovered() {
		return DISCOVERED;
	}

	public void setDiscovered(boolean DISCOVERED) {
		this.DISCOVERED = DISCOVERED;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}
	
	
	

}
