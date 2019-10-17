import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;


//author:Shengyuan Liu
//the java code solution for the  Lowest Common Ancestor in a binary tree.
// A Binary Tree node 
public class LCAForDGA<V> {

    private Map<V,List<V>> map = new HashMap<V,List<V>>();

    //Add a vertex to the graph.  Nothing happens if vertex is already in graph.
    public void add(V vertex) {
        if (map.containsKey(vertex)) return;
        map.put(vertex, new ArrayList<V>());
    }

    public Map<V,List<V>> getMap() {
		return map;
	}
    
    //check if the vertex is already in graph
    public boolean contains (V vertex) {
        return map.containsKey(vertex);
    }

    //Add an edge to the graph
    public void add(V from, V to) {
        if(from != to) {
        	this.add(from); 
        	this.add(to);
        	map.get(from).add(to);
        }
    }

    //crate report(as a Map) the depth of each vertex.
    public Map<V,Integer> theDepth () {
        Map<V,Integer> result = new HashMap<V,Integer>();
        for (V v: map.keySet()) result.put(v, 0);       // All in-degrees are 0
        for (V from: map.keySet()) {
            for (V to: map.get(from)) {
                result.put(to, result.get(to) + 1);           // Increment in-degree
            }
        }
        return result;
    }

    //create report(as a List) the topological sort of the vertices; null for no such sort.
    public List<V> topSort () {
        Map<V, Integer> degree = theDepth();
        
        //Push all the 0 degree vertices to the stack
        Stack<V> stack = new Stack<V>();       
        for (V v: degree.keySet()) {
            if (degree.get(v) == 0) stack.push(v);
        }
        
        // Determine the topological order
        List<V> result = new ArrayList<V>();
        while (!stack.isEmpty()) {
            V v = stack.pop();                  
            result.add(v);                   // put 0 degree vertics in topol order
            //deal with other vertices whose degree are not 0
            for (V neighbor: map.get(v)) {
                degree.put(neighbor, degree.get(neighbor) - 1);
                if (degree.get(neighbor) == 0) stack.push(neighbor);
            }
        }
        
        // Check that we have used the entire graph (if not, there was a cycle)
        if (result.size() != map.size()) return null;
        return result;
    }
    
    //check if the graph is a DAG, return false if there is a cycle
    public boolean isDAG () {
        return topSort() != null;
    }
    
    
    
    
    public Map parents(V a) {
    	Map<V, Integer> parent = new HashMap<V, Integer>();
    	Map<V, Integer> degree = theDepth();
    	int depth = 0;
    	
    	for(V v: map.keySet()) {
    		//find the root, a root is a vertex whose indegree is 0
    		if(degree.get(v) == 0) {
    			parent.put(v, 0);
    			getParent(v, parent, a, depth);
    		}
    	}
    	return parent;
    }
    
    private V getParent(V root, Map<V, Integer> parent, V a, int depth) {
    	V vertic = null;
    	if(root == null) return null;
    	if(root.equals(a)) {
    		parent.put(root, depth);
    		return root;
    	}
    	List<V> child = new ArrayList<V>();
    	for(int i = 0; i<map.get(root).size(); i++) {
    		child.add(null);
    	}
    	for(int i = 0; i<map.get(root).size();i++) {
    		child.set(i, getParent(map.get(root).get(i),parent,a,depth+1));
    	}
    	for(int i=0; i<map.get(root).size(); i++) {
    		if(child.get(i) != null) {
    			//if(!parent.containsKey(root)) {
    			parent.put(root, depth);
    			return getParent(map.get(root).get(i),parent,a,depth+1);
    			//}
    		}
    	}
    	return vertic;
    }
    
     //find the LCA 
    public List<V> getLCA(V x, V y) {
    	List<V> theLCA = new ArrayList<V>();
    	int depth = 0;
    	Map<V, Integer> parentA = parents(x);
    	Map<V, Integer> parentB = parents(y);
    	
    	//compare the parents of the two nodes
    	for(V va: parentA.keySet()) {
    		for(V vb: parentB.keySet()) {
    			
    			//if there are same nodes in both maps, choose the deepest one and add the parents to the LCA list
    			// the number of LCA could be 1 or more
    			if(va.equals(vb) && depth <= parentA.get(va)) {
    				if(depth < parentA.get(va)) {
    					theLCA.clear();
    				}
    				theLCA.add(va);
    				depth = parentA.get(va);
    			}
    		}
    	}
    	return theLCA;
    }

}