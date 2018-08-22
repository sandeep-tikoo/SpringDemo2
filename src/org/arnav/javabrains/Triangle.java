package org.arnav.javabrains;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle  implements ApplicationContextAware, BeanNameAware, InitializingBean, DisposableBean, Shape{

	private Point pointA;
	private Point pointB;
	private Point pointC;
	private List<Point> points;
	private ApplicationContext context;
	private String beanName;
	
	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public void draw()	{
		System.out.println("Drawing Traingle");
		System.out.println("Point A = (" + getPointA().getX() + ", " + getPointA().getY() + ")");
		System.out.println("Point B = (" + getPointB().getX() + ", " + getPointB().getY() + ")");
		System.out.println("Point C = (" + getPointC().getX() + ", " + getPointC().getY() + ")");
		
//		for(Point point : points)	{
//			System.out.println("Point = (" + point.getX() + ", " + point.getY() + ")");
//		}
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}

	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
		System.out.println("");
		System.out.println("Hooray!!! I can pull the bean name from the Bean Factory : " + beanName);
		System.out.println("");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean method needs to be executed first when Triangle bean is initilized before anything else");
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean method needs to be executed at end");
		
	}
}