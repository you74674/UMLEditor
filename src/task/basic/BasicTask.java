package task.basic;

import java.awt.event.MouseEvent;

import task.Task;
import view.EditorView;
import view.uml.basic.BasicView;


public abstract class BasicTask extends Task {
//	public abstract BasicObject getObject();
	public abstract BasicView getView();
	
	//add new object
	@Override
	public void releasedOnCanvas(MouseEvent e) {
		EditorView editorView=(EditorView)e.getComponent();

		BasicView basicView=getView();
		basicView.setLocation(e.getPoint());
		
		editorView.add(basicView);
		editorView.repaint();
	}


}
