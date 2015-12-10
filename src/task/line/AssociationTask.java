package task.line;

import java.awt.event.MouseEvent;

import model.uml.line.ConnectionLine;
import view.uml.line.AssociationView;
import view.uml.line.LineView;

public class AssociationTask extends LineTask{

	@Override
	public ConnectionLine getLine() {
		// TODO Auto-generated method stub
		return new ConnectionLine(ConnectionLine.TYPE.ASSOCIATION);
	}

	@Override
	public LineView getView() {
		return new AssociationView();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
