package com.pravin.component;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Pravin Pachbhai
 * 
 */
@Component
public class ControllerHelper {

	public <R> R handleMessage(final HttpServletResponse response, final Integer code, final String message){
		
		try{
			response.sendError(code, message);
		}catch(final IOException e){
			e.printStackTrace();
			response.setStatus(code);
		}
		
		return null;
	}
	
}
