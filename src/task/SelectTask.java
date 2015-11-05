package task;

import java.awt.event.MouseEvent;

public class SelectTask extends Task {
	
	@Override
	public void mouseClicked(MouseEvent e) {
		/*	if in object
		 * 		select the object
		 * 	else
		 * 		cancel-> selectedObject=null, update view?
		 * 		depend: cursor in editor, editorView, 
		 * */
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		/*	if in object
		 * 		move
		 * 	else
		 * 		draw rectangle
		 * 
		 * */
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		/*	drag and release:
		 * 		select multiple object
		 * 
		 * */
	}



}
