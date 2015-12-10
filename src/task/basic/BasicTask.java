package task.basic;

import java.awt.event.MouseEvent;

import model.uml.object.BasicObject;
import task.Task;
import view.EditorView;
import view.uml.basic.BasicView;


public abstract class BasicTask extends Task {
	public abstract BasicObject getObject();
	public abstract BasicView getView();
	

	@Override
	public void draggedOnCanvas(MouseEvent e) {
		//nothing
	}

	//add new object
	@Override
	public void releasedOnCanvas(MouseEvent e) {
		EditorView editorView=(EditorView)e.getComponent();

		BasicView basicView=getView();
		basicView.setObject(getObject());
		basicView.setLocation(e.getPoint());
		
		editorView.add(basicView);
		editorView.repaint();
	}


	@Override
	public void releasedOnObject(MouseEvent e) {
		//nothing
	}

	@Override
	public void draggedOnObject(MouseEvent e) {
		//nothing
	}

	@Override
	public void pressedOnObject(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pressedOnCanvas(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
