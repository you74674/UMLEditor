package view;


import javax.swing.ButtonGroup;
import javax.swing.JToolBar;

import view.base.TaskButton;

public class TaskBar extends JToolBar{
	private MainFrame parent;
	
	private ButtonGroup buttonGroup;
	
	private TaskButton taskButtons[];
	private void setTask(){
		parent.getEditorView();
	}
	private void setComponents() {
		taskButtons=new TaskButton[]{
			new TaskButton("Select"){
				{
					setTask();
				}
			},
			new TaskButton("Association Line"){
				
			},
			new TaskButton("Generalization Line"){
				
			},
			new TaskButton("Composition Line"){
				
			},
			new TaskButton("Class"){
				
			},
			new TaskButton("Use Case"){
				
			},
		};
		
		buttonGroup=new ButtonGroup();
		
		
		for(TaskButton taskButton: taskButtons){
			buttonGroup.add(taskButton);
			add(taskButton);
		}
		buttonGroup.setSelected(taskButtons[0].getModel(), true);
		
		
	}
	public TaskBar(MainFrame parent){
		this.parent=parent;
		setOrientation(VERTICAL);
		
		setComponents();
	}

}
