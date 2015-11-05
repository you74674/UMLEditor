package view;

import javax.swing.JPanel;

import model.Editor;
import task.Task;
import view.listener.DrawListener;

/**
 * 
 * handle only showing editor and get user control
 *
 */
public class EditorView extends JPanel{
	private DrawListener drawListener;
	private Task task;
	private Editor editor;
	
	public void setComponents(){
		setLayout(null);
		setBackground(Config.editorBackgroundColor);
		
		setComponentPopupMenu(new PopupMenu());
		
		//listener
		drawListener=new DrawListener(this);
		addMouseListener(drawListener);
		addMouseMotionListener(drawListener);
	}
	public EditorView(){
		setComponents();
	}
	public void setEditor(Editor editor){
		this.editor=editor;
	}
	public Editor getEditor() {
		return editor;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
}
