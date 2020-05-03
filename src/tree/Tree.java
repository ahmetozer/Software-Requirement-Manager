package tree;

public class Tree { 
    public static class treeNode {    
    public int value;
    String URL;
        treeNode left, right; 
          
        public treeNode(int value, String URL){ 
            this.value = value; 
            left = null; 
            right = null;
            this.URL =URL;
        } 
    } 
       
    public void insert(treeNode node, int value, String url) {
        if (value < node.value) {
        	if (node.left != null) {
        		insert(node.left, value, url); 
        		} else {
        			System.out.println(" Inserted " + value + " to left of " + node.value + "| " + value +" url is "+ url);
        			node.left = new treeNode(value, url); 
        			//node.URL = url;
        			}
        	} else if (value > node.value) {
          if (node.right != null) {
            insert(node.right, value, url);
          } else {
            System.out.println("  Inserted " + value + " to right of "
                + node.value +"| " + value +" url is "+ url);
            node.right = new treeNode(value, url);
            //node.URL = url;
          }
        }
      }
    
     public static void traverseReverseInOrder(treeNode node) {
        if (node != null) {
        	traverseReverseInOrder(node.right);
            System.out.print(" " + node.value + node.URL);
            traverseReverseInOrder(node.left);
        }
     }
     
   
 }