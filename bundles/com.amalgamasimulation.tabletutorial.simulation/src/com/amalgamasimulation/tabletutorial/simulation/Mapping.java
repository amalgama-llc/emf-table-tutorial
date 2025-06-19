package com.amalgamasimulation.tabletutorial.simulation;

import com.amalgamasimulation.tabletutorial.simulation.graph.Arc;
import com.amalgamasimulation.tabletutorial.simulation.graph.Node;
import com.amalgamasimulation.tabletutorial.simulation.graph.agents.Agent;
import com.amalgamasimulation.utils.container.BiMap;

/**
 * This class represents the 2-way mapping between data model entities and
 * simulation model entities.
 *
 */
public class Mapping {

		public BiMap<com.amalgamasimulation.tabletutorial.datamodel.Node, Node> nodesMap = new BiMap<>();
		public BiMap<com.amalgamasimulation.tabletutorial.datamodel.Arc, Arc> forwardArcsMap = new BiMap<>();
		public BiMap<com.amalgamasimulation.tabletutorial.datamodel.Agent, Agent> agentsMap = new BiMap<>();

}

