package task;

import java.awt.event.MouseEvent;

import view.EditorView;

/*
 *on canvas
 * 		select:
 * 			click:
 * 				cancel any select
 * 			drag:
 * 				draw rectangle
 * 				release:
 * 					 try to select multiple object
 * 		association line, generalization line, composition line:
 * 			click:
 * 				no effect
 * 			drag:
 * 				no effect
 * 		class, use case:
 * 			click:
 * 				add new object
 * 			drag:
 * 				no effect
 * 		
 * on objects
 * 		select:
 * 			click:
 * 				select the object
 * 			drag:
 * 				move the object
 * 				release:
 * 					stop moving
 * 		association line, generalization line, composition line:
 * 			click:
 * 				no effect
 * 			drag:
 * 				from object to object
 * 				release:
 * 					add line
 * 		class, use case:
 * 			click:
 * 				add new object?
 * 			drag:
 * 				no effect
 * 
 * */
public class Task {

	public void mousePressed(MouseEvent e){};
	public void mouseReleased(MouseEvent e){};
	public void mouseDragged(MouseEvent e){};
	
	public void pressedOnObject(MouseEvent e){};
	public void releasedOnObject(MouseEvent e){};
	public void draggedOnObject(MouseEvent e){};
	
	public void pressedOnCanvas(MouseEvent e){};
	public void releasedOnCanvas(MouseEvent e){};
	public void draggedOnCanvas(MouseEvent e){};
	public void exit(EditorView editorView){};
	public void enter(EditorView editorView){};
}
