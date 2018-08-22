package org.arnav.javabrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DrawingApp {

	public static void main(String[] args)  {
//		Triangle triangle = new Triangle();
//		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
//	DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//	BeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
//	reader.loadBeanDefinitions(new FileSystemResource("Spring.xml"));
	
	//initlization of Spring Container(ApplicationContext) by the beans which are in the XML
//	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); //Abstract only when u have a main method, not in the case of web applications 
	context.registerShutdownHook();
	Shape shape = (Shape) context.getBean("circle");
	
	shape.draw();
	
	System.out.println("Data from properties file: " + context.getMessage("greeting", null, "properties file is empty!", null));
	}
}
