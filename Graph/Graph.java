package GraphAlgorithms.Graph;

import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Graph {

	private boolean directedGraph;
	private Map<String, Node> nodes;
	private Set<Edge> edges;
	private boolean weightedGraph;
		
	public Graph(boolean directedGraph, boolean weightedGraph)
	{
		this.directedGraph = directedGraph;
		this.weightedGraph = weightedGraph;
		nodes = new HashMap<String, Node>();
		edges = new HashSet<Edge>();
	}
	
	
	public boolean isDirectedGraph()
	{
		return directedGraph;
	}
	
	public boolean isWeightedGraph()
	{
		return weightedGraph;
	}
	
	public List<Node> getAllNodes()
	{
		return new ArrayList<Node>(nodes.values());
	}
	
	public List<Edge> getAllEdges()
	{
		return new ArrayList<Edge>(edges);
	}
	
	public Node getNode(String nodeName)
	{
		return nodes.get(nodeName);
	}
	
	private Node formNode(String nodeName)
	{
		if (!nodes.containsKey(nodeName))
		{
			Node node = new Node(nodeName, directedGraph);
			nodes.put(nodeName, node);
			return node;
		}
		else
		{
			return nodes.get(nodeName);
		}
	}
	
	public void buildGraph(List<GraphComponent> components)
	{
		for (GraphComponent component : components)
		{
			Node node1 = formNode(component.node1);
			Node node2 = formNode(component.node2);
			
			Edge e = new Edge(directedGraph, component.weight, node1, node2);
			edges.add(e);
			
			node1.addOutgoingEdge(e);
			node2.addIncomingEdge(e);
			
			if (!directedGraph)
			{
				node1.addIncomingEdge(e);
				node2.addOutgoingEdge(e);
			}
		}
	}
	
	
}


class GraphComponent {

	String node1;
	String node2;
	double weight;
	
	GraphComponent(String node1, String node2, double weight)
	{
		this.node1 = node1;
		this.node2 = node2;
		this.weight = weight;
	}		
}
