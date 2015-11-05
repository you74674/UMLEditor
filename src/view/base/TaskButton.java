package view.base;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		setActionCommand(name);
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getParent().dispatchEvent(e);
			}
		});
	}
	public TaskButton(Icon icon){
		super(icon);
	}
}
