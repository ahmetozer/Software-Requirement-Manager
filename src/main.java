import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Scanner;

import linkedlist.UrlLinkedList;
import linkedlist.UrlLinkedList.Node;
import tree.Tree;
import tree.Tree.treeNode;
public class main {

	
	// Todo
	// Proccess Prio with tree
	// Check duplication with linked list
	static UrlLinkedList llistWithPrio = new UrlLinkedList();

	public static void main(String[] args) {
		 
		SRMNode SRVLinkedlist;
		File tmpDir = new File("required.srm");
		
		
		//print_from_web();
		boolean exists = tmpDir.exists();
		String[] mymainsrm;
		//file procces part
		if (exists) {
			mymainsrm = getSrmFrom.File("required.srm");
			for (int i = 0; i < mymainsrm.length; i++) { 
				//echo(mymainsrm[i]);
				String filename = mymainsrm[i];
				if (llistWithPrio.contains(mymainsrm[i])) {
					System.out.println(mymainsrm[i]+" is duplicated.");
				} else {
					llistWithPrio.push(mymainsrm[i]); 
				}
				
				
			//	file_functions  myHomePage = new file_functions (mymainsrm[i]);  
			//	System.out.println("Filename = " + myHomePage.projetName());
	        } 
		} else {
			System.out.print("ERR:This project does not contain required.srm");
			return;
		}
		
		
		
		// Ask for Print URL list 
		Scanner s = new Scanner(System.in);
		System.out.println("Do you want to see your requirement list ?");
		String answer = s.nextLine();
		if ( 0 == answer.compareTo("yes")) {
			llistWithPrio.printList(); 
		}
		
		//Ask Loop for adding url
		System.out.println("Do you want to add new repository ?");
		answer = s.nextLine();
		while (0 == answer.compareTo("yes")) {
			
			Scanner ScannerurlFromscanner = new Scanner(System.in);
			System.out.println("Please enter repo url :");
			String urlFromscanner = ScannerurlFromscanner.nextLine();
			System.out.println("Please enter repo priority :");
			int urlPrioFromscanner = ScannerurlFromscanner.nextInt();
			
			if (UrlLinkedList.contains(urlFromscanner+","+urlPrioFromscanner)) {
				 System.out.println(urlFromscanner+" url is found in url list");
			 } else {
				 llistWithPrio.push(urlFromscanner+","+urlPrioFromscanner); 
			 }
			
			System.out.println("Do you want to add new repository ?");
			answer = s.nextLine();
		}
		
		
		
		
		
		
		
		echo("Download list");
		llistWithPrio.printList();
		Tree btree = new Tree();
		treeNode root = new treeNode(0, null);
		
			
		
		System.out.println("Tree stat ok");
		
		Node tnode = llistWithPrio.returnnode();
	      int i = 0;
	      //tnode = tnode.next;
	      while (tnode != null)      { 
	        i = i + 1;
	        System.out.print(". "+tnode.data+"\n");
	        String filename = tnode.data;
			int iend = filename.indexOf(",");
			String subString;
			int prio;
			if (iend != -1) 
			{
			    subString= filename.substring(0 , iend); //to remove prio
			    prio = Integer.parseInt(filename.substring(iend+1));
			    btree.insert(root, prio, subString);
			}
	          
	          tnode = tnode.next;
	          
	      }
	      btree.proccessDownload(root);
	//	llist.treeDownload();
		
		System.out.println("Here is downloaded files");
		listDirectoryGet();
		
		
		System.out.println("Everythink is done.");
		
   
       
				
	}


	
	
	/**
	 * some funtions
	 */

	
	public static void addtolinkedlist(String Repostoryurl, int depth) {
		llistWithPrio.push(Repostoryurl); 
		int Rdepth = depth*100; //Set priotory
		addtolinkedlist(Repostoryurl, Rdepth);
		
	}
	
	
	public static void listDirectory() {
		try {
			Files.list(new File(pwd()).toPath())
			.limit(10)
			.forEach(path -> {
			    System.out.println(path);
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void listDirectoryGet() {
		try {
			Files.list(new File(pwdGet()).toPath())
			.limit(10)
			.forEach(path -> {
			    System.out.println(path);
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static void listDirectory(String dirName) {
		try {
			Files.list(new File(dirName).toPath())
			.limit(10)
			.forEach(path -> {
			    System.out.println(path);
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void echo(String echo) {
		System.out.println(echo);
	}
	
	// To get current directory
	public static String pwd() {
		return System.getProperty("user.dir");
	}
	
	public static String pwdGet() {
		return pwd()+"\\get";
	}
	

	
	
	public static void print_from_web() { // Get 403 Because of Cloudflare firewall

		try (Scanner s = new Scanner(new URL("https://gitlab.com/ahmetozer/srm-example-repo-2/-/raw/master/required.srm").openStream())) {
			      System.out.println(s.useDelimiter("\\A").next());
			    } catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}
	

	
}

/*		 try {
FileWriter myWriter = new FileWriter("filename.txt");
myWriter.write("Files in Java might be tricky, but it is fun enough!");
myWriter.close();
System.out.println("Successfully wrote to the file.");
} catch (IOException e) {
System.out.println("An error occurred.");
e.printStackTrace();
}*/