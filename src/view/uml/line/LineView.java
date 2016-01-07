package view.uml.line;

import view.uml.ObjectView;
import view.uml.basic.PortView;

public class LineView extends ObjectView{
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
//		to.addLine(this);
	}
	@Override
	public void setSelected(boolean isSelected) {
		// TODO Auto-generated method stub
		
	}
}
