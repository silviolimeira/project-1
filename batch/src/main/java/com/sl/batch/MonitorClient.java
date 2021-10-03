package com.sl.batch;

import java.util.Map;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.sl.batch.model.OperationMode;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import java.util.HashMap;

public class MonitorClient {
	
	public static final Integer INTERVAL = 10;

	public static void main(String[] args) throws SchedulerException {
		
		System.out.println("Monitor Client. OK");
		SchedulerFactory schedFact = new StdSchedulerFactory();
		Scheduler scheduler = schedFact.getScheduler();
        Map<String, Object> dados = new HashMap<>();
        Communicator communicator = new Communicator();
        dados.put("communicator", communicator);
        
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("monitorTrigger", "group1")
            .startNow().withSchedule(
                SimpleScheduleBuilder.simpleSchedule()
                    .withIntervalInSeconds(INTERVAL).repeatForever()).build();        

        JobDataMap jobDataMap = new JobDataMap(dados);
        JobDetail job = JobBuilder.newJob(MonitorClientJob.class).withIdentity("monitorClientJob", "group1")
                .setJobData(jobDataMap)
                .build();
                //.usingJobData("jobSays", "Hello World!");
        
        dados = new HashMap<>();
        communicator = new Communicator(OperationMode.POST);
        dados.put("communicator", communicator);
        jobDataMap = new JobDataMap(dados);
        JobDetail jobPOST = JobBuilder.newJob(MonitorClientJob.class).withIdentity("monitorClientJobPOST", "group1")
                .setJobData(jobDataMap)
                .build();
        
		scheduler.scheduleJob(job, trigger);
		
        Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity("monitorTrigger1", "group1")
                .startNow().withSchedule(
                    SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(INTERVAL).repeatForever()).build();        

        scheduler.scheduleJob(jobPOST, trigger1);
		
		scheduler.start();

	}

}
