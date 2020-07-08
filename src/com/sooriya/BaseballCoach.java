package com.sooriya;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton") // bean scope
public class BaseballCoach implements Coach {
	
	@Value("${name}")    // to read values from property file
	private String name;
	@Value("${email}")
	private String email;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Autowired
	@Qualifier("RESTFortuneService")        // to choose which implementation for injection
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		return "Practice batting for daily 30 mins";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
    @PostConstruct           // init method
    public void initmethod()
    {
    	System.out.println("Inside init method");
    }
    @PreDestroy        // destroy method
    public void destroymethod()
    {
    	System.out.println("Inside destroy method");
    }
}
