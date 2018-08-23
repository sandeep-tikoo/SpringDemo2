package org.arnav.javabrains;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component //Tells sping that this class is a normal object bean
//@Service // Tells spring that this class is a service bean
//@Repository // Tells spring that this class is a data bean
//@Controller // Tells spring that this class is a controller bean (**C of MVC)
public class Circle implements Shape, ApplicationEventPublisherAware {

	private Point center;
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private MessageSource messageSource; //Reading data from properties file

	public void draw() {
		System.out.println((messageSource.getMessage("drawing.circle", null, "not found", null)) + center.getX() + " ," + center.getY());
		System.out.println((messageSource.getMessage("drawing.point", new Object[] {center.getX(),center.getY()}, "not found", null)));
		System.out.println(messageSource.getMessage("greeting", null, "not found", null));
		
		DrawEvent drawEvent = new DrawEvent(this);
		publisher.publishEvent(drawEvent);
	}

	public Point getCenter() {
		return center;
	}

//	@Autowired
//	@Qualifier("forCircle")
	@Resource
	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher=publisher;
	}
	
}
