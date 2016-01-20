package task;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

import view.Config;
import view.uml.ObjectView;

public class SelectTask extends Task {
	public JComponent rec;
	public Point last;
	
	@Override
	public void exit() {
		super.exit();
		editorView.unselect();
	}

	public void mousePressed(MouseEvent e){
		if(e.getComponent()==editorView){
			last=e.getPoint();
			rec=new JComponent() {
				{
					setBorder(BorderFactory.createLineBorder(Color.BLACK));
				}
			};
			editorView.add(rec);
			editorView.repaint();
		}
		else{
			last=e.getPoint();
			//set select
			editorView.select(new ObjectView[]{(ObjectView) e.getComponent()});
			((ObjectView) e.getComponent()).setSelected(true);
			e.getComponent().getParent().repaint();
		}
	}
	public void mouseReleased(MouseEvent e){
		if(e.getComponent()==editorView){
			//remove rec to clear editor view
			editorView.remove(rec);		
			
			//add object in rec into selected
			ArrayList<Component> selectedList=new ArrayList<Component>();
			for(Component component: editorView.getComponentsInLayer(Config.objectLayer))
				if(rec.getBounds().contains(component.getBounds()))
					selectedList.add(component);
			ObjectView selected[]=selectedList.toArray(new ObjectView[selectedList.size()]);
			
			//select
			editorView.select(selected);
			
			//clear last pressed
			last=null;
			
			//update
			editorView.repaint();
		}
	}
	public void mouseDragged(MouseEvent e){
		if(e.getComponent()==editorView){
			Rectangle rectangle=new Rectangle(e.getPoint());
			rectangle.add(last);
			rec.setBounds(rectangle);
			editorView.repaint();
		}
		else{
			ObjectView objectView=(ObjectView)e.getComponent();
			Point point=e.getPoint();
			point.translate(objectView.getX()-last.x, objectView.getY()-last.y);
			objectView.drag(point);
			objectView.getParent().repaint();
		}
	}
}
