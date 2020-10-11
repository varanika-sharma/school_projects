//Name: Varanika Sharma
//UID: 115851306
//Directory ID: vsharma2
//Discussion Section: 0204
//Honor Pledge: I pledge on my honor that I have not given nor 
//received any unauthorized 
//assistance on this assignment or examination
package dirGraph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author varanikasharma This class is creating a graph and has methods that
 *         are able to manipulate the different parts of the graph. Methods in
 *         this class include createVertex and isVertex, createEdge, getEdge()
 *         among others. All of these methods help to create a graph and change
 *         it to what we want at a particular point
 * @param <V>
 */
public class DirGraph<V> {
	// Initalizing variables

	Map<V, HashMap<V, Integer>> datMap;
	private boolean lastTimeLow;
	private int temporary;
	// Count of vertices
	private int Count;

	public DirGraph() {
		// Constructor for creating the adjacent Map and
		// the DataMap for the vertices
		datMap = new HashMap<V, HashMap<V, Integer>>();
	}

	public boolean createVertex(V vertexData) {
		// First we check if vertexData is null. If it is
		// then we throw an Illegal Argument Exception. Next,
		// we check if our map contains vertexData and if it
		// does we return false. Else, we put vertexData and a
		// new HashMap into the datMap that is storing the vertices
		// We increase Count, and return true
		if (vertexData == null) {
			throw new IllegalArgumentException();
		}
		if (datMap.containsKey(vertexData)) {
			return false;
		} else {
			datMap.put(vertexData, new HashMap<V, Integer>());
			Count++;
			return true;
		}
	}

	public boolean isVertex(V vertexData) {
		// First we check if vertexData is null. If it is
		// then we throw an Illegal Argument Exception.
		// If vertexData is not null, then we return true or
		// false depending on if the datMap contains the vertex
		if (vertexData == null) {
			throw new IllegalArgumentException();
		}
		return datMap.containsKey(vertexData);
	}

	public Collection<V> getVertices() {
		// First we check if the size of the datMap is equal to 0.
		// If it is, then we return a new HashSet. Else, we return the
		// key set of datMap
		if (datMap.size() == 0) {
			return new HashSet<V>();
		}
		return datMap.keySet();
	}

	public boolean deleteVertexWithEdges(V vertexData) {
		// First, we check if datMap does not contain vertexData.
		// If that is true, then we return false. We decrement Count
		// and remove the vertexData from datMap. We then create a Set
		// with datMap's keySet. We also create a Iterator and check a
		// while loop checks if the iterator has Next, then you create a
		// value with i.next().
		// We then create a HashMap with the datMap.get(x). We then have a
		// for loop that goes through the size of the the new HashMap and check
		// if the HashMap contains the vertexData. If it does, then you remove
		// the HashMap and return true
		if (!datMap.containsKey(vertexData)) {
			return false;
		}
		Count--;
		datMap.remove(vertexData);
		Set<V> sV = datMap.keySet();
		Iterator<V> i = sV.iterator();
		while (i.hasNext()) {
			V x = i.next();
			HashMap<V, Integer> VL = datMap.get(x);
			for (int i1 = 0; i1 < VL.size(); i1++) {
				if (VL.containsKey(vertexData)) {
					VL.remove(VL);
				}
			}
		}
		return true;
	}

	public boolean createEdge(V sourceVertex, V destVertex, int weight) {
		// First we check if weight is less than 0, then we return false
		// After that, we check if datMap does not contain sourceVertex, then
		// we put sourceVertex and a new HashMap into datMap. However, if
		// datMap does not contain destVertex, we put destVertex and a new
		// HashMap into the datMap. Else, we check if the edgeTrue method
		// is true, then we return false. We then get the sourceVertex and
		// put the destVerterx and weight in the map and then return true
		if (weight < 0) {
			return false;
		}
		{
			if (!datMap.containsKey(sourceVertex)) {
				datMap.put(sourceVertex, new HashMap<V, Integer>());
			}
			if (!datMap.containsKey(destVertex)) {
				datMap.put(destVertex, new HashMap<V, Integer>());
			} else if (edgeTrue(sourceVertex, destVertex)) {
				return false;
			}
			datMap.get(sourceVertex).put(destVertex, weight);
			return true;
		}
	}

	public int getEdge(V sourceVertex, V destVertex) {
		// If the edgeTrue method is not true, then we return -1.
		// Else if we check if the datMap does not contain the sourceVertex
		// or the destVertex and return -1. Else if sourceVertex is equal to
		// this, then we return 0. We then return a private method called
		// AdjVertices and get the sourceVertex and the destVertex
		if (!edgeTrue(sourceVertex, destVertex)) {
			return -1;
		} else if (!datMap.containsKey(sourceVertex) ||
				!datMap.containsKey(destVertex)) {
			return -1;
		} else if (sourceVertex == this) {
			return 0;
		}
		return AdjVertices(sourceVertex).get(destVertex);
	}

	private int size() {
		// return the size of datMap
		return Count;
	}

	private Map<V, Integer> AdjVertices(V sourceVertex) {
		// A private method that check if the the datMap does not
		// contain the sourceVertex and returns a new HashMap.
		// If it does not, we return datMap.get(sourceVertex
		if (!datMap.containsKey(sourceVertex)) {
			return new HashMap<V, Integer>();
		}
		return datMap.get(sourceVertex);
	}

	private boolean edgeTrue(V sourceVertex, V destVertex) {
		// We check if the datMap does not contain either the sourceVertex
		//or the
		// destVertex. If the datMap doesn't contain either of those, then 
		//we return
		// false. We return whether the datMap contains the destVertex at 
		//the end
		if (!datMap.containsKey(sourceVertex) ||
				!datMap.containsKey(destVertex)) {
			return false;
		}
		return datMap.get(sourceVertex).containsKey(destVertex);
	}

	public boolean changeEdge(V sourceVertex, V destVertex, int newWeight) {
		// First, we create a boolean check. Then we check if the newWeight
		// parameter is greater than 0. If it is, then we check if edgeTrue is
		// true. If both of those are true, then we put destVertrc and newWeight
		// into the datMap and set check to true. Else, we set check to false
		// Else, we check if datMap contains either the sourceVertex or the
		// destVertex. If all of that is true, then we set the check to false.
		// Else if, the edgeTRue method is false, we set check equal to false.
		// Else,
		// after all of that, we remove destVertex from datMap and set check to
		// true. Then, we return true
		boolean check = false;
		if (newWeight > 0) {
			if (edgeTrue(sourceVertex, destVertex)) {
				datMap.get(sourceVertex).put(destVertex, newWeight);
				check = true;
			} else {
				check = false;
			}
		} else {
			if (!datMap.containsKey(sourceVertex) ||
					!datMap.containsKey(destVertex)) {
				check = false;
			} else if (!edgeTrue(sourceVertex, destVertex)) {
				check = false;
			} else {
				datMap.get(sourceVertex).remove(destVertex);
				check = true;
			}
		}
		return check;

	}

	public Collection<V> neighborsOfVertex(V vertexData) {
		// First, we check if the datMap does not contain vertexData. If it
		//does
		// not, then we return null. Else if, the size of the datMap is 0, then
		//we
		// return a new HashSet. We return the keySet of the datMap at the end
		//of
		// the method
		if (!datMap.containsKey(vertexData)) {
			return null;
		} else if (datMap.size() == 0) {
			return new HashSet<V>();
		}
		return datMap.get(vertexData).keySet();
	}

	public DirGraph<V> divideGraph(Collection<V> verticesOfNewGraph) {
		// First we create a new Directed Graph object. We then go
		// through the verticesOfNewGraph and check if the vertices were in
		// the current map. If that is true, we create a vertex in the new Map.
		// Then we go through the neighboring vertices and check if the
		// verticesOfNewGraph contains those neighboring vertices. If they do,
		// then we create a new Edge, and get that same Edge.
		// Lastly, we delete the vertices that are in both the new vertex and 
		//the
		// vertices of the new graph. At the end, we just return the map that we
		// created above
		DirGraph<V> cMap = new DirGraph<V>();
		for (V iV : verticesOfNewGraph) {
			if (this.isVertex(iV)) {
				cMap.createVertex(iV);

				for (V nV : neighborsOfVertex(iV)) {
					if (verticesOfNewGraph.contains(nV)) {
						cMap.createEdge(iV, nV, getEdge(iV, nV));
					}
				}

			}
		}

		for (V d : verticesOfNewGraph) {
			if (this.isVertex(d) && verticesOfNewGraph.contains(d)) {
				this.deleteVertexWithEdges(d);
			}
		}
		return cMap;
	}
}
