package com.rueggerllc.app;

import java.util.Scanner;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.log4j.Logger;

import com.rueggerllc.routes.MyRouteBuilder;

public class CamelStarter {

	private static final Logger logger = Logger.getLogger(CamelStarter.class);
	
	public static void main(String args[]) throws Exception {
		logger.info("CamelStarter BEGIN");
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new MyRouteBuilder());
		context.start();
		System.out.println("Enter Data to Stop");
		Scanner scanner = new Scanner(System.in);
		
		// WAIT
		String input = scanner.nextLine();
		context.stop();
	}

}
