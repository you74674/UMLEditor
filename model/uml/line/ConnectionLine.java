package model.uml.line;

import model.uml.object.BasicObject;
import model.uml.object.Object;

public class ConnectionLine extends Object{
	private Connection from, to;
	private TYPE type;
	
	public static enum TYPE{ASSOCIATION, GENERALIZATION, COMPOSITION};
	
	public ConnectionLine(){
		
	}
	public ConnectionLine(TYPE type){
		setType(type);
	}
	
	public void connect(BasicObject from, int fromPort, BasicObject to, int toPort) {
		this.from=new Connection(from, fromPort);
		this.to=new Connection(to, toPort);
		from.addLine(this);
	}
	public Connection getFrom() {
		return from;
	}
	public Connection getTo() {
		return to;
	}

	//type
	public TYPE getType() {
		return type;
	}
	public void setType(TYPE type) {
		this.type = type;
	}
	

	
	public class Connection{
		private BasicObject object;
		private int port;
		public Connection(BasicObject from, int fromPort) {
			setObject(from);
			setPort(fromPort);
		}
		public BasicObject getObject() {
			return object;
		}
		public void setObject(BasicObject object) {
			this.object = object;
		}
		public int getPortNum() {
			return port;
		}
		public void setPort(int port) {
			this.port = port;
		}
	}
}
