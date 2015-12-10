package task.basic;

import java.awt.event.MouseEvent;

import model.uml.object.BasicObject;
import view.uml.basic.UseCaseView;

public class UseCaseTask extends BasicTask{

	@Override
	public UseCaseView getView() {
		return new UseCaseView();
	}

	@Override
	public BasicObject getObject() {
		BasicObject basicObject=new BasicObject(BasicObject.TYPE.USECASE);
		basicObject.setName("New Use Case");
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
