package task.basic;

import java.awt.event.MouseEvent;

import model.uml.object.BasicObject;
import view.uml.basic.ClassView;

public class ClassTask extends BasicTask{
	
	@Override
	public ClassView getView() {
		return new ClassView();
	}

	@Override
	public BasicObject getObject() {
		BasicObject basicObject=new BasicObject(BasicObject.TYPE.CLASS);
		basicObject.setName("New Class");
		return basicObject;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
