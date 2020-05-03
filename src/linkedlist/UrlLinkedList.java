package linkedlist;

import tree.Tree;
import tree.Tree.treeNode;

//A complete working Java program to demonstrate deletion in singly 
//linked list 
public class UrlLinkedList { 
 static Node head; // head of list 

 /* Linked list Node*/
 public class Node 
 { 
     public String data; 
     public Node next; 
     Node(String d) 
     { 
         data = d; 
         next = null; 
     } 
 } 

 /* Given a key, deletes the first occurrence of key in linked list */
 public void deleteNode(String key) 
 { 
     // Store head node 
     Node temp = head, prev = null; 

     // If head node itself holds the key to be deleted 
     if (temp != null && temp.data == key) 
     { 
         head = temp.next; // Changed head 
         return; 
     } 

     // Search for the key to be deleted, keep track of the 
     // previous node as we need to change temp.next 
     while (temp != null && temp.data != key) 
     { 
         prev = temp; 
         temp = temp.next; 
     }     

     // If key was not present in linked list 
     if (temp == null) return; 

     // Unlink the node from linked list 
     prev.next = temp.next; 
 } 

 /* Inserts a new Links at front of the list. */
 public void push(String new_data) 
 { 
	 if (contains(new_data)) {
		 System.out.println(new_data+" url is already added");
	 } else {
     Node new_node = new Node(new_data); 
     new_node.next = head; 
     head = new_node;
	 }
 } 

 /* print the list*/
 public void printList() 
 { 
     Node tnode = head; 
     while (tnode != null) 
     { 
         System.out.println(tnode.data+" "); 
         tnode = tnode.next; 
     } 
 }
 


 
 public Node returnnode() {
	 return head;
 }

 public static boolean contains(String index) 
 { 
     Node current = head; 

     while (current != null) 
     { 
         // if (current.data == index) this method has a issue with scanner.
    	 if (0 == current.data.compareTo(index))
             return true; 
         current = current.next; 
     } 


     //assert(false); 
     return false; 
 } 

 /* Drier program to test above functions. Ideally this function 
 should be in a separate user class. It is kept here to keep 
 code compact */

} 