package view.base;

import javax.swing.Icon;
import javax.swing.JRadioButton;


/**
 * to switch task
 *
 */
public class TaskButton extends JRadioButton{
	public TaskButton(){
		super();
	}
	public TaskButton(String name){
		super(name);
	}
	public TaskButton(Icon icon){
		super(icon);
	}
}
