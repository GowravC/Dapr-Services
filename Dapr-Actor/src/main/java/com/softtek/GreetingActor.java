package com.softtek;

import io.dapr.actors.ActorMethod;
import io.dapr.actors.ActorType;

@ActorType(name = "GreetingActor")
public interface GreetingActor {

	@ActorMethod(returns = String.class)
	String sayHello(String name);

}
