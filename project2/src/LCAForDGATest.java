import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LCAForDGATest {

	    //add the 

	LCAForDGA theGraph = new LCAForDGA();
	
	//      1
	//     / \
	//    2   4
	//   /|\  |
	//  3 5 9 8
	// /  |   | \
	//6   7   11 10
	//|   
	//12
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
		theGraph.add(1,7);
		theGraph.add(3,12);
		theGraph.add(2,12);
		theGraph.add(8,10);
		theGraph.add(4,10);
		theGraph.add(1,12);
	}
	
	@Test
	public void testContains() {
		//to test if the vertex 9 is in the graph
		assertTrue(theGraph.contains(9));
		//to test if the vertex 12 is in the graph
	    assertTrue(theGraph.contains(12));
		//to test if the vertex 1 is in the graph
		assertTrue(theGraph.contains(1));
		//to test if the vertex 8 is in the graph
		assertTrue(theGraph.contains(8));
		
        //test the not exist node
		assertFalse(theGraph.contains(15));

		assertFalse(theGraph.contains(-1));
		
		assertFalse(theGraph.contains(0));
	}

}
