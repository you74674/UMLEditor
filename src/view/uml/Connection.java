package view.uml;

import view.uml.basic.PortView;

public class Connection {
	private PortView from;
	private PortView to;
	
	public PortView getFrom() {
		return from;
	}
	public void setFrom(PortView from) {
		this.from = from;
	}
	public PortView getTo() {
		return to;
	}
	public void setTo(PortView to) {
		this.to = to;
	}
}
