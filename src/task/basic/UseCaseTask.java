package task.basic;

import view.uml.basic.UseCaseView;

public class UseCaseTask extends BasicTask{

	
	@Override
	public UseCaseView getView() {
		UseCaseView useCaseView=new UseCaseView();
		useCaseView.setName("New Use Case");
		return useCaseView;
	}

//	@Override
//	public BasicObject getObject() {
//		BasicObject basicObject=new BasicObject(BasicObject.TYPE.USECASE);
//		basicObject.setName("New Use Case");
//		return basicObject;
//	}



}
