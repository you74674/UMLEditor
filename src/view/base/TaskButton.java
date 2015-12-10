package view.base;

import javax.swing.Icon;
import javax.swing.JToggleButton;

/**
 * to switch task
 * describe only the look!
 */
public class TaskButton extends JToggleButton{
	public TaskButton(){
		super();
	}
	public TaskButton(String name){
		super(name);
		setName(name);
		setActionCommand(name);
	}
	public TaskButton(Icon icon){
		super(icon);
	}
	
	public String toString(){
		return getName();
	}
}
