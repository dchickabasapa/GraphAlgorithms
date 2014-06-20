package GraphAlgorithms.Graph;

import java.util.List;
import java.util.ArrayList;


public class Edge {

	private boolean directedEdge;
	private double weight;
	private Node sourceNode;
	private Node targetNode;
	private List<Node> edgeNodes;
	
	
	protected Edge(boolean directedEdge, double weight, Node node1, Node node2)
	{
		this.directedEdge = directedEdge;
		this.weight = weight;
		
		if (directedEdge)
		{
			this.sourceNode = node1;
			this.targetNode = node2;
		}
		else
		{
			edgeNodes = new ArrayList<Node>();
			edgeNodes.add(node1);
			edgeNodes.add(node2);
		}
	}
	
	public boolean isDirected()
	{
		return directedEdge;
	}
	
	public double getWeight()
	{
		return weight;
	}
	
	public Node getSourceNode()
	{
		if (directedEdge)
		{
			return sourceNode;
		}
		else
		{
			throw new RuntimeException("Incorrect Invocation. Graph is Undirected. Call getEdgeNodes() instead ");
		}
	}
	
	public Node getTargetNode()
	{
		if (directedEdge)
		{
			return targetNode;
		}
		else
		{
			throw new RuntimeException("Incorrect Invocation. Graph is Undirected. Call getEdgeNodes() instead ");
		}
		
	}
	
	public List<Node> getEdgeNodes()
	{
		if (directedEdge)
		{
			throw new RuntimeException("Incorrect Invocation. Graph is Undirected. Call getSourceNode() or getTargetNode() instead ");
		}
		else
		{
			return edgeNodes;
		}
	}
	
}
