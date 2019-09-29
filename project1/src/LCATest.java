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
	@Test
	public void testEmpty() {
		LCA tree = new LCA();
		assertEquals("LCA¡¡can't search empty tree", -1, tree.getTheLCA(2, 3));
	}
	
	@Test
	public void testN1Tree ()
	{
		LCA tree = new LCA();
		tree.root = new Node (5);
		assertEquals("LCA can't search one side tree", -1, tree.getTheLCA(5, 3));
	}
	
	@Test
	public void testLeft1SideTree()
	{
		LCA tree =new LCA();
		tree.root=new Node(1);
		tree.root.left=new Node(2);
		assertEquals("LCA of the(1,2) is", 1, tree.getTheLCA(1, 2));
	}
	@Test
	public void testRight1SideTree()
	{
		LCA tree = new LCA();
		tree.root =new Node(2);
		tree.root.right=new Node(5);
		assertEquals("LCA of the(2,5) is", 2, tree.getTheLCA(2, 5));
	}
	
	

}
