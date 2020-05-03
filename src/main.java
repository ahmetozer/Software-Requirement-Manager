import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.util.URI;
import com.sun.org.apache.xerces.internal.util.URI.MalformedURIException;

import java.io.FileWriter;
import java.io.IOException;

public class main {

	public static void main(String[] args) {
		
		SRMNode SRVLinkedlist;
		File tmpDir = new File("required.srm");
		print_from_web();
		boolean exists = tmpDir.exists();
		String[] mymainsrm;
		//file procces part
		if (exists) {
			mymainsrm = getSrmFrom.File("required.srm");
			for (int i = 0; i < mymainsrm.length; i++) { 
				echo(mymainsrm[i]);
				download_and_extract(mymainsrm[i]);
			//	file_functions  myHomePage = new file_functions (mymainsrm[i]);  
			//	System.out.println("Filename = " + myHomePage.projetName());
	        } 
		} else {
			System.out.print("ERR:This project does not contain required.srm");
			return;
		}
		
		
		
		
		
		
		// download tree
		
		
		
		
		
	}

	
	
	
	/**
	 * some funtions
	 */
	
	public static void addtolinkedlist(String Repostoryurl, int depth) {
		
		
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
	
	
	public static void download_and_extract(String repourl) {
		//String repourl = "https://gitlab.com/ahmetozer/srm-example-repo-2";
		URI uri = null;
		try {
			uri = new URI(repourl);
		} catch (MalformedURIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] segments = uri.getPath().split("/");
		String repoName = segments[segments.length-1];
		String domain = uri.getHost();
		//echo(domain);
		
		String fileURL = "";
		switch(domain) {
		  case "gitlab.com":
			  fileURL = repourl+"/-/archive/master/"+repoName+"-master.zip";
			  try {
		        	http_downloader.get(fileURL);
		        } catch (IOException ex) {
		            ex.printStackTrace();
		        }
		    break;
		  case "github.com":
		    fileURL = repourl+"/archive/master.zip";
		    try {
	        	http_downloader.get(fileURL);
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
		    break;
		  default:
			  System.out.println("\t"+domain+" is not supported.");
			  return;
		    // code block
		}
		zip.unzip("dl/"+repoName+"-master.zip");
		 
		 
	}
	
	
	public static void print_from_web() {
//		try {
//			   URL url = new URL("");
//			   URLConnection urlCon = url.openConnection();
//			   urlCon.setRequestProperty("Accept", "*/*");
//			   urlCon.setRequestProperty("User-Agent", "curl/7.55.1");
//			   Scanner s = new Scanner(url.openStream());
//			   System.out.println(s);
//			   // read from your scanner
//			}
//			catch(IOException ex) {
//			   // there was some connection problem, or the file did not exist on the server,
//			   // or your URL was not in the right format.
//			   // think about what to do now, and put it here.
//			   ex.printStackTrace(); // for now, simply output it.
//			}
		
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