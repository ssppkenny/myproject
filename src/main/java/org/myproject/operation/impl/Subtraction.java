package org.myproject.operation.impl;

import org.myproject.operation.Operation;
import org.myproject.state.State;

public class Subtraction implements Operation {

private State state;
	
	public Subtraction(State state)
	{
		this.state = state;
	}
	
	@Override
	public State apply() {
		
		Double returnValue = 0.0;
		
		double rx = state.getRx();
		double ry = state.getRy();
		
		returnValue = ry - rx;
		State newState = new State(returnValue, state.getRz(), state.getRt(), 0, state.getOperation());
		
		return newState;
	}


}
