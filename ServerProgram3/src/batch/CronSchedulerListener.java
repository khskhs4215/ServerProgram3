package batch;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.quartz.SchedulerException;

@WebListener
public class CronSchedulerListener implements ServletContextListener {
    
	// field
	CronScheduler cronScheduler;
	
	// constructor
	public CronSchedulerListener() { }
	
	// method
	@Override
    public void contextDestroyed(ServletContextEvent sce)  { 
    	
    	try {
    		cronScheduler.scheduler.clear();
    		cronScheduler.scheduler.shutdown();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
    }
	@Override
    public void contextInitialized(ServletContextEvent sce)  { 
    	
    	cronScheduler = new CronScheduler("0 0/1 * 1/1 ? *", Hit.class);
    	cronScheduler.execute();
    }
	
}