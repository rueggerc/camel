package com.rueggerllc.routes;


import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.log4j.Logger;

import com.rueggerllc.processors.MyProcessor1;
import com.rueggerllc.processors.MyProcessor2;
import com.rueggerllc.processors.MyProcessor3;
import com.rueggerllc.processors.MyProcessor4;

public class MyRouteBuilder extends RouteBuilder {
	
	private static final Logger logger = Logger.getLogger(MyRouteBuilder.class);

	@Override
	public void configure() throws Exception {
		try {
			logger.info("MyRouteBuilder.configure BEGIN");
			from("file:c:/data/source")
			.log(LoggingLevel.INFO, "Got File in Source Directory")
			.process(new MyProcessor1())
			.process(new MyProcessor2())
			.to("file:c:/data/dest")
			.process(new MyProcessor3())
			.process(new MyProcessor4());
			logger.info("MyRouteBuilder.configure END");
		} catch (Exception e) {
			logger.error("Error",e);
		}
	}
	

}
