import static org.junit.Assert.*;

import org.junit.Test;

public class LCAForDGATest {

	    //add the 
		@Test
		public void testConstructor()
		{
		       new LCAForDGA();
		}
	// the binary tree's shape:
			//          ---------
			//             tree:
			//               1
			//              / \
			//             2   3
			//            /    /
			//           4    5  
		    //            \  /
			//             6        
			//             \         
			//              7         
			
			@Test
			public void testDAG()
			{
				LCAForDGA tree = new LCAForDGA(); 
		        tree.root = new Node(1); 
		        tree.root.left = new Node(2); 
		        tree.root.right =new Node(3);
		        tree.root.left.left = new Node(4);
		        tree.root.right.left =new Node(5);
		        tree.root.left.left.right= new Node(6);
		        tree.root.right.left.left= tree.root.left.left.right;
		        tree.root.left.left.right.right =new Node(7);
		        
		        assertEquals("Find LCA(4,7). Should return 4.",tree.getTheLCA(4,7),4);
		        assertEquals("Find LCA(6,7). Should return 6.",tree.getTheLCA(6,7),6);
		        assertEquals("Find LCA(4,5). Should return 1.",tree.getTheLCA(4,5),1);
		    	assertEquals("Find LCA of non-existent node",tree.getTheLCA(11,12),-1);
			}

}
