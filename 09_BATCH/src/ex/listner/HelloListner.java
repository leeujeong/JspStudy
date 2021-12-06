package ex.listner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Application Lifecycle Listener implementation class HelloListner
 * ServletContextListner : 웹 애플리케이션의 LifeCycle로 동작(톰캣에 애플리케이션이 올라가고 내려올때)
 */
@WebListener // 나는 리스너이다.
public class HelloListner implements ServletContextListener {

	/*field*/
	private Scheduler scheduler;
	
	/*constructor*/
    public HelloListner() {
    	try {
			scheduler = new StdSchedulerFactory().getScheduler();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    //웹 애플리케이션 종료될때 실행되는 메소드(톰캑에서 제거)
    public void contextDestroyed(ServletContextEvent sce)  { 
        try {
        	if(scheduler != null) {
        		scheduler.shutdown();
        	}
			System.out.println("~~~~ 스케쥴러 SHUTDOWN ~~~~");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    //웹 애플리케이션 시작할때 실행되는 메소드(툼캣에 올라감)
    public void contextInitialized(ServletContextEvent sce)  { 
    	try {
			//1) HelloJob
    		JobDetail job = JobBuilder.newJob(HelloJob.class)
    				.withIdentity("job2", "group2")
    				.build();
    		
    		//2) Trigger
    		Trigger trigger = TriggerBuilder.newTrigger()
    				.withIdentity("trigger2", "group2")
    				.withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * 1/1 * ? *")) //cron expression (크론식) : cronMaker.com
    				.build();
    		//3) scheduler에 job, trigger등록
    		scheduler.scheduleJob(job, trigger);
    		
    		//4)scheduler 실행 시작
    		scheduler.start();
    		System.out.println("~~~~ 스케쥴러 START ~~~~");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
}
