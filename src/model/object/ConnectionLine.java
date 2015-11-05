package model.object;

public class ConnectionLine{
	private BasicObject from, to;
	private int type;
	
	public static int ASSOCIATION_LINE=0;
	public static int GENERALIZATION_LINE=1;
	public static int COMPOSITION_LINE=2;
	
	public void connect(BasicObject from, BasicObject to) {
		this.from=from;
		this.to=to;
	}
	public BasicObject getFrom() {
		return from;
	}
	public void setFrom(BasicObject from) {
		this.from = from;
	}
	public BasicObject getTo() {
		return to;
	}
	public void setTo(BasicObject to) {
		this.to = to;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

}
