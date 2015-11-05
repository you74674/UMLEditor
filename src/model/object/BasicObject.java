package model.object;

import java.util.ArrayList;

/**
 * class, use case, ...
 *
 */
public class BasicObject extends Object{
	private ArrayList<ConnectionLine> lines;
	private int type;
	
	public static int CLASS_OBJECT=0;
	public static int USECASE_OBJECT=1;
	
	public BasicObject(){
		setLines(new ArrayList<ConnectionLine>());
	}
	public ArrayList<ConnectionLine> getLines() {
		return lines;
	}
	public void setLines(ArrayList<ConnectionLine> lines) {
		this.lines = lines;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
