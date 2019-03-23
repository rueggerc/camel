package com.rueggerllc.processors;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;

public class MyProcessor1 implements Processor {

	private static final Logger logger = Logger.getLogger(MyProcessor1.class);

	public void process(Exchange exchange) throws Exception {
		try {
			logger.info("MyProcessor1 BEGIN");
			showProperties(exchange);
			Object body = exchange.getIn().getBody();
			logger.info("body=" + body);
			logger.info("body class=" + body.getClass().getName());
			exchange.setProperty("name", "fred");
		} catch (Exception e) {
			logger.error("ERROR",e);
		}
	}
	
	private void showProperties(Exchange exchange) {
		for (String key : exchange.getProperties().keySet()) {
			Object value = exchange.getProperties().get(key);
			logger.info("Property " + key + "=" + value);
		}		
	}

}
