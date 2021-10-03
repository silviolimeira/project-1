package com.sl.batch;

import java.io.IOException;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sl.batch.model.TemperatureSensor;

public class MonitorClientJob implements Job {
	
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();

        //String jobSays = dataMap.getString("jobSays");
        //float myFloatValue = dataMap.getFloat("myFloatValue");
        Communicator communicator = (Communicator) dataMap.get("communicator");
        
        try {
			communicator.execute();

			ObjectMapper mapper = new ObjectMapper();
            TemperatureSensor[] temperatureSensors = communicator.temperatureSensors;
            String json = mapper.writeValueAsString(temperatureSensors);
            System.out.println("From job: " + json);

		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        //System.out.println("Job says: " + jobSays + ", and val is: " + myFloatValue);
        
        //System.out.println("Time: " + dataMap.get("Hora").toString());
        System.out.print(".");
    }
}
