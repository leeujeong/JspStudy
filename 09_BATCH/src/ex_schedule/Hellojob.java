package ex_schedule;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Hellojob implements Job {

	/*Scheduler가 수행할 작업 : job*/
	/*Job인터페이스를 구현하면 된다.*/
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("Hello World");
		

	}

}
