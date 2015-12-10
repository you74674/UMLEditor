package view.listener;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

import task.Task;
import view.EditorView;

//listener as controller?
public class DrawListener extends MouseInputAdapter{
	private EditorView editorView;
	private Task task;
	
	public DrawListener(EditorView editorView) {
		this.editorView=editorView;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource()==editorView){
			System.out.println("pressed on canvas "+getTask().getClass().getSimpleName());
			getTask().pressedOnCanvas(e);
		}
		else{
			System.out.println("pressed on object "+getTask().getClass().getSimpleName());
			getTask().pressedOnObject(e);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getSource()==editorView){
			System.out.println("released on canvas");
			getTask().releasedOnCanvas(e);
		}
		else{
			System.out.println("released on object");
			getTask().releasedOnObject(e);
		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		if(e.getSource()==editorView){
			System.out.println("dragged on canvas");
			getTask().draggedOnCanvas(e);
		}
		else{
			getTask().draggedOnObject(e);
			System.out.println("dragged on object");
		}
	}

	
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
}
