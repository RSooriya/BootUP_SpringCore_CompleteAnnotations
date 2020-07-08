package com.sooriya;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new
        		ClassPathXmlApplicationContext("applicationContext.xml");
        BaseballCoach theCoach = context.getBean("baseballCoach",BaseballCoach.class);
        BaseballCoach alphaCoach = context.getBean("baseballCoach",BaseballCoach.class);
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        System.out.println(theCoach.getName());
        System.out.println(theCoach.getEmail());
        System.out.println("Singleton "+(theCoach==alphaCoach));
        context.close();
	}

}
