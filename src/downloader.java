import java.io.IOException;

import com.sun.org.apache.xerces.internal.util.URI;
import com.sun.org.apache.xerces.internal.util.URI.MalformedURIException;

public class downloader {
	public static void run(String repourl) {
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
}
