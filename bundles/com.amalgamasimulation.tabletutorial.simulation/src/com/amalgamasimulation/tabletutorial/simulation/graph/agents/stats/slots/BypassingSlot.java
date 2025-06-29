package com.amalgamasimulation.tabletutorial.simulation.graph.agents.stats.slots;

import com.amalgamasimulation.tabletutorial.simulation.graph.agents.Agent;
import com.amalgamasimulation.tabletutorial.simulation.graph.agents.Agent.AgentState;

/**
 * Slot representing a time interval when an agent was bypassing another agent
 * and thus moved with the reduced velocity
 *
 */
public class BypassingSlot extends AgentStatsSlot {

	public BypassingSlot(double beginTime, Agent agent, AgentState state) {
		super(beginTime, agent, state);
	}
}

