package task;

import task.basic.ClassTask;
import task.basic.UseCaseTask;
import task.line.AssociationTask;
import task.line.CompositionTask;
import task.line.GeneralizationTask;

public class TaskFactory {
	public Task getTask(String taskName){
		if(taskName.startsWith("Select"))
			return new SelectTask();
		else if(taskName.startsWith("Association"))
			return new AssociationTask();
		else if(taskName.startsWith("Composition"))
			return new CompositionTask();
		else if(taskName.startsWith("Generalization"))
			return new GeneralizationTask();
		else if(taskName.startsWith("Class"))
			return new ClassTask();
		else 
			return new UseCaseTask();
	}
}
