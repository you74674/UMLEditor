package view.uml;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.BorderFactory;

public class CompositeView extends ObjectView{

	public CompositeView(){
		setOpaque(false);
		setBackground(Color.WHITE);
	}

	public Component add(ObjectView comp) {
		addComponentListener(comp);
		return super.add(comp);
	}

	@Override
	public void setSelected(boolean isSelected) {
		setBorder(isSelected?
				BorderFactory.createLineBorder(Color.BLACK):
					BorderFactory.createDashedBorder(null));
	}
	
	@Override
	public void ungroup() {
		for(Component component: getComponents()){
			component.setLocation(component.getX()+getX(), component.getY()+getY());
			remove(component);
			getParent().add(component);
		}
		getParent().remove(this);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
//		g.drawString(getAbsoluteLocation().x+", "+getAbsoluteLocation().y, 5, 40);
	}
	

}
