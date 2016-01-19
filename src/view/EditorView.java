package view;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;

import task.Task;
import view.base.EditArea;
import view.listener.DrawListener;
import view.uml.CompositeView;
import view.uml.ObjectView;


/**
 * 
 * handle only showing editor and get user control: drawListener
 *
 */
public class EditorView extends EditArea implements ActionListener, ItemListener{
	private Task task;
	private DrawListener drawListener;
	private ObjectView[] selected;
	
	private void setComponents(){
		setLayout(null);
		setBackground(Config.editorBackgroundColor);
		
		setComponentPopupMenu(new PopupMenu());
	}
	public EditorView(MainFrame parent){
		super();
		//listen to event from parent
		parent.addItemListener(this);
		parent.addActionListener(this);
		
		setComponents();
		
		//listener
		drawListener=new DrawListener(this);
		addMouseListener(drawListener);
		addMouseMotionListener(drawListener);
		
		selected=new ObjectView[]{};
	}
	
	
	//task
	public void setTask(Task task){
		if(this.task!=null)
			this.task.exit();
		this.task=task;
		task.enter();
	}
	public Task getTask() {
		return task;
	}
	
	//select
	public ObjectView[] getSelected() {
		return selected;
	}
	public void select(ObjectView[] selected) {
		for(ObjectView objectView: this.selected){
			objectView.setSelected(false);
			setLayer(objectView, objectView.getLayer(), 0);
		}
		this.selected = selected;
		for(ObjectView objectView: selected){
			objectView.setSelected(true);
			setLayer(objectView, DRAG_LAYER);
		}
		repaint();
	}
	public void select(ObjectView selected){
		select(new ObjectView[]{selected});
	}
	public void unselect(){
		select(new ObjectView[]{});
	}
	
	//name
	public void changeName(ObjectView[] selected){
		if(selected.length==1){
			String newName=JOptionPane.showInputDialog("Enter new name:");
			if(newName!=null){
				((ObjectView)selected[0]).setName(newName);
				selected[0].repaint();
			}
		}
	}
	
	//group
	public void group(ObjectView[] selected){
		//don't make group with only one object
		if(selected.length>1){
			CompositeView compositeView=new CompositeView();;
			
			//setBounds
			Rectangle rectangle=new Rectangle(-1, -1);//(-1, -1) for non-existent
			for(Component component: selected)
				rectangle.add(component.getBounds());
			compositeView.setBounds(rectangle);

			//add components
			for(Component component: selected){
				remove(component);
				component.setLocation(component.getX()-compositeView.getX(), component.getY()-compositeView.getY());
				compositeView.add(component);
			}
			compositeView.repaint();
			
			//add to editorView
			add(compositeView);
			repaint();
			
			//select the group
			select(compositeView);
		}
	}
	public void ungroup(ObjectView[] selected){
		for(ObjectView objectView: selected)
			objectView.ungroup();
	}	
	
	//listen to task change
	@Override
	public void itemStateChanged(ItemEvent e) {
		try {
			Task task=(Task) Class.forName(e.getItem().toString()).newInstance();
			task.setEditorView(this);
			setTask(task);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SecurityException e1) {
			e1.printStackTrace();
		}
	}
	
	//listen to menu action
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().startsWith("change"))
			changeName(selected);
		else if(e.getActionCommand().startsWith("group"))
			group(selected);
		else if(e.getActionCommand().startsWith("ungroup"))
			ungroup(selected);
	}

}
