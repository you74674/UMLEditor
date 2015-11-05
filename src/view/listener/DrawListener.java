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
	public void mouseClicked(MouseEvent e) {
		editorView.getTask().mouseClicked(e);
	}
	/*
	@Override
	public void mouseEntered(MouseEvent e) {

	}
	@Override
	public void mouseExited(MouseEvent e) {

	}
	@Override
	public void mousePressed(MouseEvent e) {

	}*/

	@Override
	public void mouseReleased(MouseEvent e) {
		editorView.getTask().mouseReleased(e);
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		editorView.getTask().mouseDragged(e);
	}
	@Override
	public void mouseMoved(MouseEvent e) {
	}


}
