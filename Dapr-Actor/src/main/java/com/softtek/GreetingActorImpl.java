package com.softtek;

import io.dapr.actors.ActorId;
import io.dapr.actors.runtime.AbstractActor;
import io.dapr.actors.runtime.ActorRuntimeContext;

public class GreetingActorImpl extends AbstractActor implements GreetingActor {

	public GreetingActorImpl(ActorRuntimeContext runtimeContext, ActorId actorId) {
		super(runtimeContext, actorId);
	}

	@Override
	public String sayHello(String name) {
		return "Hello, " + name + "!";
	}
}
