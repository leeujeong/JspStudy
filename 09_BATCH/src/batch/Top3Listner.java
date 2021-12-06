package batch;

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

@WebListener
public class Top3Listner implements ServletContextListener {

	/*field*/
	private Scheduler scheduler;
	
	/*constructor*/
    public Top3Listner() {
    	try {
			scheduler  = new StdSchedulerFactory().getScheduler();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    /*method*/
    public void contextDestroyed(ServletContextEvent sce)  { 
    	try {
			if(scheduler != null) {
				scheduler.shutdown();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    public void contextInitialized(ServletContextEvent sce)  { 

    	try {
			// Top3 Job
    		JobDetail job = JobBuilder.newJob(Top3Job.class)
    				.withIdentity("job3", "group3")
    				.build();
    		
    		//Trigger
    		Trigger trigger = TriggerBuilder.newTrigger()
    				.withIdentity("trigger3", "group3")
    				.withSchedule(CronScheduleBuilder.cronSchedule("0 29 11 1/1 * ? *"))
    				.build();
    		
    		//scheduler 에 job과 trigger등록
    		scheduler.scheduleJob(job, trigger);
    		//scheduler실행시작
    		scheduler.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
}
