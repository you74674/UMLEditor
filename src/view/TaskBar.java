package view;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

public class TaskBar extends JToolBar implements ItemListener{
	private MainFrame parent;
	
	private ButtonGroup buttonGroup;
	
	private TaskButton taskButtons[];
	private void setComponents() {
		taskButtons=new TaskButton[]{
			new TaskButton("Select"),
			new TaskButton("Association Line"),
			new TaskButton("Generalization Line"),
			new TaskButton("Composition Line"),
			new TaskButton("Class"),
			new TaskButton("Use Case"),
		};
		
		buttonGroup=new ButtonGroup();
		
		for(TaskButton taskButton: taskButtons){
			taskButton.addItemListener(this);
			buttonGroup.add(taskButton);
			add(taskButton);
		}
		buttonGroup.setSelected(taskButtons[0].getModel(), true);//select first button
	}
	public TaskBar(MainFrame parent){
		this.parent=parent;
		
		setOrientation(VERTICAL);
		
		setComponents();
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange()==ItemEvent.SELECTED){
			parent.fireItemEvent(e);
		}
	}
	
	
	private class TaskButton extends JToggleButton{
//		public TaskButton(){
//			super();
//		}
		public TaskButton(String name){
			super(name);
			setName(name);
			setActionCommand(name);
		}
//		public TaskButton(Icon icon){
//			super(icon);
//		}
		
		public String toString(){
			return getName();
		}
	}
}
