package model;

import model.object.BasicObject;
import model.object.CompositeObject;
import model.object.ConnectionLine;
import model.object.Coord;
import model.object.Object;

public class Editor {
	private UML uml;//file
	private Object[] selected;//cursor
	public Editor(){
		setUML(new UML());
	}
	public Editor(UML uml){
		setUML(uml);
	}
	//file
	public UML getUML() {
		return uml;
	}
	public void setUML(UML uml) {
		this.uml = uml;
	}
	
	//select
	public void select(Object[] objects){
		selected=objects;
	}
	public void unselect(){
		selected=null;
	}
	public Object[] getSelected(){
		return selected;
	}
	
	//component
	public void add(Object object){
		uml.add(object);
	}
	public void composite(){
		uml.removeAll(selected);
		uml.add(new CompositeObject(selected));
	}
	public void move(Object object, Coord coord){
		object.setLocation(coord);
	}

	//line: connect basic objects
	public void connect(BasicObject from, BasicObject to, ConnectionLine connectionLine){
		connectionLine.connect(from, to);
	}

}
