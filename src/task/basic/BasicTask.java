package task.basic;

import java.awt.event.MouseEvent;

import task.Task;
import view.uml.basic.BasicView;


public abstract class BasicTask extends Task {
//	public abstract BasicObject getObject();
	public abstract BasicView getView();
	
	//add new object
	@Override
	public void releasedOnCanvas(MouseEvent e) {
		BasicView basicView=getView();
		basicView.setLocation(e.getPoint());
		
		editorView.add(basicView);
		editorView.repaint();
	}

	public void mousePressed(MouseEvent e){
	}
	public void mouseReleased(MouseEvent e){
		if(e.getComponent()==editorView){
			BasicView basicView=getView();
			basicView.setLocation(e.getPoint());
			
			editorView.add(basicView);
			editorView.repaint();
		}
	}
	public void mouseDragged(MouseEvent e){}
}
