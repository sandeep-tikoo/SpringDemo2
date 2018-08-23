package org.arnav.javabrains;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;


public class DrawEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DrawEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

	public String toString()	{
		return"Draw Event Occured";
	}
	
}
