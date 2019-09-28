import java.util.ArrayList; 
import java.util.List; 
  
// A Binary Tree node 
class Node 
{ 
    int data; 
    Node left, right; 
  
    Node(int value) 
    { 
        data = value; 
        left = right = null; 
    } 
} 
// Lowest Common Ancestor  
public class LCA  
{ 
  
    Node root; 
    private List<Integer> path1 = new ArrayList<>(); 
    private List<Integer> path2 = new ArrayList<>(); 
  
    // Finds the path from root node to given root of the tree. 
    int getTheLCA(int node1, int node2) 
    { 
        path1.clear(); 
        path2.clear(); 
        return searchLCAInternal(root, node1, node2); 
    } 
  
    private int searchLCAInternal(Node root, int node1, int node2) 
    { 
  
        if (!getPath(root, node1, path1) || !getPath(root, node2, path2)) 
        { 
            System.out.println((path1.size() > 0) ? "node1 is present" : "node1 is missing"); 
            System.out.println((path2.size() > 0) ? "node2 is present" : "node2 is missing"); 
            return -1; 
        } 
  
        int i; 
        for (i = 0; i < path1.size() && i < path2.size(); i++) 
        {       
        // System.out.println(path1.get(i) + " " + path2.get(i)); 
            if (!path1.get(i).equals(path2.get(i))) 
                break; 
        } 
  
        return path1.get(i-1); 
    } 
      
    // Finds the path from root node to given root of the tree, Stores the 
    // path in a vector path[], returns true if path exists otherwise false 
    private boolean getPath(Node root, int n, List<Integer> path) 
    { 
        // base case 
        if (root == null) 
            return false; 
         
          
        // Store this node . The node will be removed if 
        // not in path from root to n. 
        path.add(root.data); 
  
        if (root.data == n)  
            return true;  
  
        if (root.left != null && getPath(root.left, n, path)) 
            return true; 
  
        if (root.right != null && getPath(root.right, n, path)) 
            return true;          
  
        // If not present in subtree rooted with root, remove root from 
        // path[] and return false 
        path.remove(path.size()-1); 
  
        return false; 
    } 

    // for testing
//    public static void main(String[] args) 
//    { 
//        LCA tree = new LCA(); 
//        tree.root = new Node(1); 
//        tree.root.left = new Node(2); 
//        tree.root.right = new Node(3); 
//        tree.root.left.left = new Node(4); 
//        tree.root.left.right = new Node(5); 
//        tree.root.right.left = new Node(6); 
//        tree.root.right.right = new Node(7); 
//  
//        System.out.println("LCA(4, 5): " + tree.findLCA(4,5)); 
//        System.out.println("LCA(4, 6): " + tree.findLCA(4,6)); 
//        System.out.println("LCA(3, 4): " + tree.findLCA(3,4)); 
//        System.out.println("LCA(2, 4): " + tree.findLCA(2,4)); 
//      
//    } \
    
} 