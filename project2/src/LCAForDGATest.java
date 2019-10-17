import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;


//author:Shengyuan Liu
//the java code solution for the  Lowest Common Ancestor in a directed acylic graphs .
//A DAG node 

public class LCAForDGATest {

	    //add the DAG graph

	LCAForDGA theGraph = new LCAForDGA();
	
	
	// add the binary tree
	LCAForDGA theTree = new LCAForDGA();
	
	// the directed acyclic graphs' shape:
	//---------------------
	//      1
	//     / \
	//    2   4 ->13
  	//   /|\  | X  
	//  3 5 9 8 ->14
	// /  |   | \
	//6   7 - 11 10
	//|  ^
	//v /
	//12
	
	
	// build the DAG graph
	@Before
	public void setup() {
		theGraph.add(1);
		theGraph.add(1,2);
		theGraph.add(1,4);
		theGraph.add(2,3);
		theGraph.add(2,5);
		theGraph.add(2,9);
		theGraph.add(3,6);
		theGraph.add(5,7);
		theGraph.add(6,12);
		theGraph.add(4,8);
		theGraph.add(8,11);
		theGraph.add(8,10);
		theGraph.add(4,13);
		theGraph.add(8,14);
		theGraph.add(4,14);
		theGraph.add(8,13);
		theGraph.add(12,7);
		theGraph.add(7,11);
		theGraph.add(1,10);
		
		
		
		
		
		
		
		// the binary tree's shape:
		//          ---------
		//             tree:
		//               1
		//              / \
		//             2   3
		//            /   / \
		//           4   6   7
	    //              / \   \
		//             8   9  10
		
		
		
		theTree.add(1);
		theTree.add(1,2);
		theTree.add(1,3);
		theTree.add(2,4);
		theTree.add(3,6);
		theTree.add(3,7);
		theTree.add(6,8);
		theTree.add(6,9);
		theTree.add(7,10);

		
		
	}
	
	@Test
	public void testContains() {
		// test the exist node in the graph
		assertTrue(theGraph.contains(9));
	    assertTrue(theGraph.contains(12));
		assertTrue(theGraph.contains(1));
		assertTrue(theGraph.contains(8));
		
        //test the not exist node
		assertFalse(theGraph.contains(20));
		assertFalse(theGraph.contains(-1));
		assertFalse(theGraph.contains(0));
		
		
	}
	
	
	
	
	
	
	// test the depth function
	@Test
	public void testTheDepth() {
		//create map
		Map<Integer, Integer> result = new HashMap<Integer, Integer>();
		result.put(1, 0);
		result.put(2, 1);
		result.put(3, 1);
		result.put(4, 1);
		result.put(5, 1);
		result.put(6, 1);
		result.put(7, 2);
		result.put(8, 1);
		result.put(9, 1);
		result.put(10, 2);
		result.put(11, 2);
		result.put(12, 1);
		result.put(13, 2);
		result.put(14, 2);
		assertNotNull(theGraph.theDepth());
		assertNotNull(result);
		assertEquals(theGraph.theDepth(),result);
		
	}
	
	
	// test the map if it is DAG or not
	@Test
	public void testIsDAG() {
		assertTrue(theGraph.isDAG());
		theGraph.add(14,8);
		assertEquals(false,theGraph.isDAG());
		
		assertTrue(theTree.isDAG());
		theTree.add(9,6);
		assertEquals(false,theTree.isDAG());
		
	}
	
	
	// main test for the LCA of DAG graph
	@Test
	public void testLca() {
		
		
		//create expected result
		List<Integer> expectedResult = new ArrayList<Integer>();
		//create the Result to store the Result
		List theResult;
		expectedResult.add(1);
		theResult=theGraph.getLCA(7, 10);
		assertEquals(theResult,expectedResult);
		expectedResult.clear();
		expectedResult.add(2);
		theResult=theGraph.getLCA(12, 5);
		assertEquals(theResult,expectedResult);
		expectedResult.clear();
		expectedResult.add(8);
		theResult=theGraph.getLCA(11, 8);
		assertEquals(theResult,expectedResult);
		expectedResult.clear();
		expectedResult.add(1);
		theResult=theGraph.getLCA(9, 4);
		assertEquals(theResult,expectedResult);
		expectedResult.clear();
		expectedResult.add(12);
		theResult=theGraph.getLCA(12,11);
		assertEquals(theResult,expectedResult);
		expectedResult.clear();
		expectedResult.add(8);
		theResult=theGraph.getLCA(14, 13);
		assertEquals(theResult,expectedResult); 
		
		//test add node 15, points to 2 and 4
		theGraph.add(15,2);
		theGraph.add(15,4);
		expectedResult.clear();
		expectedResult.add(1);
		expectedResult.add(15);
		// test the graph is DAG or not
		assertTrue(theGraph.isDAG()); 
		theResult=theGraph.getLCA(2, 4);
		assertEquals(theResult,expectedResult);
		theGraph.add(16,15);
		expectedResult.clear();
		expectedResult.add(15);
		// test the graph is DAG or not
		assertTrue(theGraph.isDAG()); 
		theResult=theGraph.getLCA(2, 4);
		assertEquals(theResult,expectedResult);
		
		
		
		
		
		
		
		
		// there are two new nodes add into the DAG graph so just repeat the test to test if there
		// is no change curse the program choose the 15 to be the lowest common ancestor
		
		//repeat test 
		expectedResult.clear();
		expectedResult.add(2);
		theResult=theGraph.getLCA(3, 5);
		assertEquals(theResult,expectedResult);
		expectedResult.clear();
		expectedResult.add(3);
		theResult=theGraph.getLCA(3, 7);
		assertEquals(theResult,expectedResult);
		expectedResult.clear();
		expectedResult.add(8);
		theResult=theGraph.getLCA(10,11);
		assertEquals(theResult,expectedResult);
		expectedResult.clear();
		expectedResult.add(8);// the result is not 4 because the 4 is not the deepest node of the parents of
		                      //these two nodes 
		theResult=theGraph.getLCA(13, 14);
		assertEquals(theResult,expectedResult); 
		
		List<Integer> values = new ArrayList<Integer>();
		
		
		
		
		
		
		// test for the binary tree
        values.add(1);
		assertEquals("Find LCA(4,6). Should return 1.",values,theTree.getLCA(4,6));
		assertEquals("Find LCA(2,7). Should return 1.",values,theTree.getLCA(2,7));
		assertEquals("Find LCA(3,4). Should return 1.",values,theTree.getLCA(3,4));
		assertEquals("Find LCA(4.8). Should return 1.",values,theTree.getLCA(4,8));
		values.clear();
		values.add(2);
		assertEquals("Find LCA(2,4). Should return 2.",values,theTree.getLCA(2,4));
		values.clear();
		values.add(3);
		assertEquals("Find LCA(9,7). Should return 3.",values,theTree.getLCA(9,7));
		assertEquals("Find LCA(3,10). Should return 3.",values,theTree.getLCA(3,10));
		

		
	}
	

}