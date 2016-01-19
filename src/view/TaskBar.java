package view;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import task.SelectTask;
import task.Task;
import task.basic.ClassTask;
import task.basic.UseCaseTask;
import task.line.AssociationTask;
import task.line.CompositionTask;
import task.line.GeneralizationTask;

public class TaskBar extends JToolBar implements ItemListener{
	private MainFrame parent;
	
	private ButtonGroup buttonGroup;
	
	private TaskButton taskButtons[];
	private void setComponents() {
		taskButtons=new TaskButton[]{
			new TaskButton("Select", SelectTask.class),
			new TaskButton("Association Line", AssociationTask.class),
			new TaskButton("Generalization Line", GeneralizationTask.class),
			new TaskButton("Composition Line", CompositionTask.class),
			new TaskButton("Class",ClassTask.class),
			new TaskButton("Use Case", UseCaseTask.class),
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
		public TaskButton(String name, Class<? extends Task> taskClass){
			super(name);
			setName(name);
			setActionCommand(taskClass.getName());
		}
		
		public String toString(){
			return getActionCommand();
		}
	}
}
