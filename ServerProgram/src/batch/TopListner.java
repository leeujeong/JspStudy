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
public class TopListner implements ServletContextListener {


	private Scheduler scheduler;

    public TopListner() {
    	try {
			scheduler  = new StdSchedulerFactory().getScheduler();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
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
    		JobDetail job = JobBuilder.newJob(Top.class)
    				.withIdentity("job", "group")
    				.build();
    		
    		//일분마다 cron식 "0 0/1 * 1/1 * ? *"
    		Trigger trigger = TriggerBuilder.newTrigger()
    				.withIdentity("trigger", "group")
    				.withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *"))
    				.build();
    		scheduler.scheduleJob(job, trigger);
    		scheduler.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
}
