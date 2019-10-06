import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//author: Shengyuan Liu, Student Number: 16341982
//lius8@tcd.ie
// the LCA¡¡java code test
// using the JUnit4 mode
@RunWith(JUnit4.class)
public class LCATest {
    
	//add the 
	@Test
	public void testConstructor()
	{
	       new LCA();
	}
	
	// the binary tree's shape:
	//  --------
	//   empty tree
	@Test
	public void testEmpty() {
		LCA tree = new LCA();
		assertEquals("LCA¡¡can't search empty tree", -1, tree.getTheLCA(2, 3));
	}
	
	
	// the binary tree's shape:
	//    ------
	//     tree:
	//      5
	
	@Test
	public void testN1Tree ()
	{
		LCA tree = new LCA();
		tree.root = new Node (5);
		assertEquals("LCA can't search one side tree", -1, tree.getTheLCA(5, 3));
	}
	
	// the binary tree's shape:
	//         ------
	//          tree:
	//           1
	//          /
	//         2
	
	@Test
	public void testLeft1SideTree()
	{
		LCA tree =new LCA();
		tree.root=new Node(1);
		tree.root.left=new Node(2);
		assertEquals("LCA of the(1,2) is", 1, tree.getTheLCA(1, 2));
	}
	
	// the binary tree's shape:
	//        -------
	//          tree:
	//           2
	//            \
	//             5
	
	@Test
	public void testRight1SideTree()
	{
		LCA tree = new LCA();
		tree.root =new Node(2);
		tree.root.right=new Node(5);
		assertEquals("LCA of the(2,5) is", 2, tree.getTheLCA(2, 5));
	}
	
	// the binary tree's shape:
	//          ---------
	//             tree:
	//               1
	//              / \
	//             2   3
	//            / \  / \
	//           4   56   7
	
	@Test
	public void testStandardTree ()
	{
        LCA tree = new LCA(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7); 
  
        assertEquals("Find LCA(4,5). Should return 2.",tree.getTheLCA(4,5),2);
		assertEquals("Find LCA(4,6). Should return 1.",tree.getTheLCA(4,6),1);
		assertEquals("Find LCA(2,7). Should return 1.",tree.getTheLCA(2,7),1);
		assertEquals("Find LCA(3,4). Should return 1.",tree.getTheLCA(3,4),1);
		assertEquals("Find LCA(2,4). Should return 2.",tree.getTheLCA(2,4),2);
		assertEquals("Find LCA of non-existent node",tree.getTheLCA(8,7),-1);
	}

	// the binary tree's shape:
	//          ---------
	//             tree:
	//               1
	//              / \
	//             2   3
	//            / \  
	//           4   5
	//          / \
	//         6   7
	
	
	@Test 
	public void testLeftSideTree ()
	{
        LCA tree = new LCA(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.left.left.left = new Node(6);
        tree.root.left.left.right = new Node(7);
  
        assertEquals("Find LCA(4,5). Should return 2.",tree.getTheLCA(4,5),2);
		assertEquals("Find LCA(4,6). Should return 4.",tree.getTheLCA(4,6),4);
		assertEquals("Find LCA(2,7). Should return 2.",tree.getTheLCA(2,7),2);
		assertEquals("Find LCA(3,4). Should return 1.",tree.getTheLCA(3,4),1);
		assertEquals("Find LCA(2,4). Should return 2.",tree.getTheLCA(2,4),2);
		assertEquals("Find LCA(6,3). Should return 1.",tree.getTheLCA(6,3),1);
		assertEquals("Find LCA(7,5). Should return 2.",tree.getTheLCA(2,4),2);
		assertEquals("Find LCA of non-existent node",tree.getTheLCA(8,7),-1);
	}
	
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
	
	@Test
	public void testRightSideTree ()
	{
        LCA tree = new LCA(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7); 
        tree.root.right.left.left = new Node(8);
        tree.root.right.left.right = new Node(9);
        tree.root.right.right.right = new Node(10);
  
		assertEquals("Find LCA(4,6). Should return 1.",tree.getTheLCA(4,6),1);
		assertEquals("Find LCA(2,7). Should return 1.",tree.getTheLCA(2,7),1);
		assertEquals("Find LCA(3,4). Should return 1.",tree.getTheLCA(3,4),1);
		assertEquals("Find LCA(2,4). Should return 2.",tree.getTheLCA(2,4),2);
		assertEquals("Find LCA(4.8). Should return 1.",tree.getTheLCA(4,8),1);
		assertEquals("Find LCA(9,7). Should return 3.",tree.getTheLCA(9,7),3);
		assertEquals("Find LCA(3,10). Should return 3.",tree.getTheLCA(3,10),3);
		assertEquals("Find LCA of non-existent node",tree.getTheLCA(11,12),-1);
	}

	// the binary tree's shape:
	//          ---------
	//             tree:
	//               1
	//              / 
	//             2   
	//            /
	//           3
    //          /
	//         4    
	//        /
	//       5
	
	@Test
	public void testOnlyLeftTree ()
	{
		LCA tree = new LCA(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.left.left =new Node(3);
        tree.root.left.left.left = new Node(4);
        tree.root.left.left.left.left =new Node(5);
        
        assertEquals("Find LCA(1,2). Should return 1.",tree.getTheLCA(1,2),1);
        assertEquals("Find LCA(2,3). Should return 2.",tree.getTheLCA(2,3),2);
        assertEquals("Find LCA(3,5). Should return 3.",tree.getTheLCA(3,5),3);
    	assertEquals("Find LCA of non-existent node",tree.getTheLCA(11,12),-1);
	}
	
	
	//          ---------
	//             tree:
	//               1
	//                \
	//                 2
	//                  \
	//                   3
    //                    \
	//                     4
	//                      \
	//                       5
	
	@Test
	public void testOnlyRightTree ()
	{
		LCA tree = new LCA(); 
        tree.root = new Node(1); 
        tree.root.right = new Node(2); 
        tree.root.right.right =new Node(3);
        tree.root.right.right.right = new Node(4);
        tree.root.right.right.right.right =new Node(5);
        
        assertEquals("Find LCA(1,2). Should return 1.",tree.getTheLCA(1,2),1);
        assertEquals("Find LCA(2,3). Should return 2.",tree.getTheLCA(2,3),2);
        assertEquals("Find LCA(2,4). Should return 2.",tree.getTheLCA(2,4),2);
    	assertEquals("Find LCA of non-existent node",tree.getTheLCA(11,12),-1);
	}
	
	

}
