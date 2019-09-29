import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class LCATest {
    
	
	@Test
	public void testConstructor()
	{
	       new LCA();
	}
	
	//  --------
	//   empty tree
	@Test
	public void testEmpty() {
		LCA tree = new LCA();
		assertEquals("LCA¡¡can't search empty tree", -1, tree.getTheLCA(2, 3));
	}
	
	
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

}
