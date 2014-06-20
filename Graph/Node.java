package GraphAlgorithms.Graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Node {

	private String name;
	private List<Edge> outgoingEdges;
	private List<Edge> incomingEdges;
	private boolean directedGraph;
	
	protected Node(String name, boolean directedGraph)
	{
		this.name = name;
		this.directedGraph = directedGraph;
		outgoingEdges = new ArrayList<Edge>();
		incomingEdges = new ArrayList<Edge>();
	}
	
	public String getName()
	{
		return name;
	}
	
	protected void addOutgoingEdge(Edge e)
	{
		outgoingEdges.add(e);
	}
	
	protected void addIncomingEdge(Edge e)
	{
		incomingEdges.add(e);
	}
	
	public List<Node> getNeighbors()
	{
		Set<Node> neighbors = new HashSet<Node>();
		
		if (directedGraph)
		{
			for (Edge e : outgoingEdges)
			{
				neighbors.add(e.getTargetNode());
			}
			
			for (Edge e : incomingEdges)
			{
				neighbors.add(e.getSourceNode());
			}
		}
		else
		{
			for (Edge e : outgoingEdges)
			{
				List<Node> edgeNodes = e.getEdgeNodes();
				neighbors.add(edgeNodes.get(0) == this ? edgeNodes.get(1) : edgeNodes.get(0)); 
			}
		}
		
		return new ArrayList<>(neighbors);
		
	}
	
	public List<Edge> getOutgoingEdges()
	{
		if (directedGraph)
			return outgoingEdges;
		else
			throw new RuntimeException("Incorrect Invocation: Graph is Undirected. Call GetAllEdges() instead.");
	}
	
	public List<Edge> getIncomingEdges()
	{
		if (directedGraph)
			return incomingEdges;
		else
			throw new RuntimeException("Incorrect Invocation: Graph is Undirected. Call GetAllEdges() instead.");
		
	}
	
	/*
	 * For directed graph, method returns a list 
	 * that contains all outgoing edges followed
	 * by all incoming edges. For undirected graph
	 * all edges returned will have this.node as the
	 * first node in the edge.
	 */
	
	public List<Edge> getAllEdges()
	{
		List<Edge> edges = new ArrayList<Edge>();
		
		edges.addAll(outgoingEdges);
		
		if (directedGraph)
		{
			edges.addAll(incomingEdges);
		}
		
		return edges;
	}
	
}
