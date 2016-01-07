package task.basic;

import view.uml.basic.ClassView;

public class ClassTask extends BasicTask{
	
	@Override
	public ClassView getView() {
		ClassView classView=new ClassView();
		classView.setName("New Class");
		return classView;
	}

//	@Override
//	public BasicObject getObject() {
//		BasicObject basicObject=new BasicObject(BasicObject.TYPE.CLASS);
//		basicObject.setName("New Class");
//		return basicObject;
//	}

}
