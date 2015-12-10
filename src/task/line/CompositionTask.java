package task.line;

import java.awt.event.MouseEvent;

import model.uml.line.ConnectionLine;
import view.uml.line.CompositionView;
import view.uml.line.LineView;

public class CompositionTask extends LineTask{

	@Override
	public ConnectionLine getLine() {
		return new ConnectionLine(ConnectionLine.TYPE.COMPOSITION);
	}

	@Override
	public LineView getView() {
		return new CompositionView();
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
