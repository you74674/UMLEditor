package view.listener;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

import view.EditorView;

//listener as controller?
public class DrawListener extends MouseInputAdapter{
	private EditorView editorView;
	
	public DrawListener(EditorView editorView) {
		this.editorView=editorView;
	}

	@Override
	public void mousePressed(MouseEvent e) {
//		if(e.getSource()==editorView){
//			System.out.println("pressed on canvas "+editorView.getTask().getClass().getSimpleName());
//			editorView.getTask().pressedOnCanvas(e);
//		}
//		else{
//			System.out.println("pressed on object "+editorView.getTask().getClass().getSimpleName());
//			editorView.getTask().pressedOnObject(e);
//		}
		System.out.println("pressed at "+e.getPoint().toString());
		editorView.getTask().mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
//		if(e.getSource()==editorView){
//			System.out.println("released on canvas");
//			editorView.getTask().releasedOnCanvas(e);
//		}
//		else{
//			System.out.println("released on object");
//			editorView.getTask().releasedOnObject(e);
//		}
		System.out.println("released at "+e.getPoint().toString());
		editorView.getTask().mouseReleased(e);
	}
	@Override
	public void mouseDragged(MouseEvent e) {
//		if(e.getSource()==editorView){
//			System.out.println("dragged on canvas");
//			editorView.getTask().draggedOnCanvas(e);
//		}
//		else{
//			editorView.getTask().draggedOnObject(e);
//			System.out.println("dragged on object");
//		}
		System.out.println("dragged at "+e.getPoint().toString());
		editorView.getTask().mouseDragged(e);
	}
}
