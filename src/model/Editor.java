package model;

import java.awt.Point;

import model.uml.UML;
import model.uml.line.ConnectionLine;
import model.uml.object.BasicObject;
import model.uml.object.CompositeObject;
import model.uml.object.Object;

public class Editor {
	private UML uml;//file
	private Object[] selected;//cursor
	
	//
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
	public void move(Object object, Point point){
		object.setLocation(point);
	}	
	
	//component
	public void add(Object object){
		uml.add(object);
	}
	public void remove(Object object){
		uml.remove(object);
	}
	public void composite(){//move to controller?
		uml.removeAll(selected);
		uml.add(new CompositeObject(selected));
	}

//	//line: connect basic objects
//	public void connect(BasicObject from, BasicObject to, ConnectionLine connectionLine){
//		connectionLine.connect(from, to);
//		from.addLine(connectionLine);
//	}

}
