package view.uml.line;

import javax.swing.JComponent;

import view.uml.basic.PortView;

public class LineView extends JComponent{
	private PortView from, to;
	
	public PortView getFrom() {
		return from;
	}
	public PortView getTo() {
		return to;
	}

	public void connect(PortView from, PortView to) {
		this.from=from;
		this.to=to;
		from.addLine(this);
	}
}
