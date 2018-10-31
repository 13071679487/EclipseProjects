package com.rifu.activiti.tasklistener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class MultiPersonalTaskListener  implements TaskListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void notify(DelegateTask delegateTask) {
		// TODO Auto-generated method stub
		delegateTask.addCandidateUser("rifu");
		delegateTask.addCandidateUser("lili");
	}

}
