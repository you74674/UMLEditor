package model.uml.object;

import java.util.ArrayList;

import model.uml.line.ConnectionLine;

/**
 * class, use case, ...
 *
 */
public class BasicObject extends Object{
	private ArrayList<ConnectionLine> lines;
	private TYPE type;
	
	public static enum TYPE{CLASS, USECASE};
	
	public BasicObject(){
		setLines(new ArrayList<ConnectionLine>());
	}
	public BasicObject(TYPE type){
		this();
		setType(type);
	}
	
	//line
	public ArrayList<ConnectionLine> getLines() {
		return lines;
	}
	public void setLines(ArrayList<ConnectionLine> lines) {
		this.lines = lines;
	}
	public void addLine(ConnectionLine connectionLine) {
		lines.add(connectionLine);
	}
	
	//type
	public TYPE getType() {
		return type;
	}
	public void setType(TYPE type) {
		this.type = type;
	}

}
