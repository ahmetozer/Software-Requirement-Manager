import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class http_downloader {
	private static final int HTTP_BUFFER_SIZE = 4096;
	public static void get(String URL) throws IOException { //function proxy
		get(URL, pwd()+"/dl");
	}
	public static void get() {
		System.out.println("URL is not defined. Please give a download url");
	}
	
	public static void get(String fileURL, String saveDir) throws IOException {
		File file = new File(saveDir);
		
		 if (file.exists() && file.isDirectory()) {
		        // directory is already exist
		    } else {
		    	// Create Directory
		    	boolean bool = file.mkdir();
				if(bool){
			        System.out.println("Download directory created successfully: " + saveDir);
			     }else{
			        System.out.println("Sorry couldn’t create specified directory" + saveDir);
			     } 
		    }
		 
	    
		
        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        
        // Simulate http header. If its not simulated Cloudflare Firewall block the requests.
        // Gitlab uses Cloudflare
        httpConn.setRequestProperty("Accept", "*/*");
        httpConn.setRequestProperty("User-Agent", "curl/7.55.1");
        // Java default request headers. 
        // Tested with ahmet@Workstation:~# sudo nc -l -p 80 command
        //GET /test.file HTTP/1.1
        //User-Agent: Java/1.8.0_241
        //Host: 127.0.0.1
        //Accept: text/html, image/gif, image/jpeg, *; q=.2, */*; q=.2
        //Connection: keep-alive
        
        int httpResponsecode = httpConn.getResponseCode();
 
        // always check HTTP response code first
        if (httpResponsecode == HttpURLConnection.HTTP_OK) {
            String fileName = "";
            String disposition = httpConn.getHeaderField("Content-Disposition");
            String contentType = httpConn.getContentType();
            int contentLength = httpConn.getContentLength();
 
            if (disposition != null) {
                // extracts file name from header field
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                	
                	
                    //fileName = disposition.substring(index + 10, disposition.length() - 1); //Normal function. This function is not work with github because github is not add quto mark in filename output
                	fileName = disposition.substring(index + 9, disposition.length());
                	if (fileName.charAt(0) == '"') { // This if added for github servers
                		fileName = disposition.substring(index + 10, disposition.length() - 1);
                	} else {
                		fileName = disposition.substring(index + 9, disposition.length());
                	}
                	
                	
                    //System.out.print("filename given by server" + fileName); To test filename header response

                }
            } else {
                // extracts file name from URL
                fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1,
                        fileURL.length());
            }
            System.out.println("\t *** File is downloading :" + fileURL);
            
            /* Some Debug functions
            System.out.println("\\n \\t *** HTTP server response:\nContent-Type = " + contentType);
            System.out.println("Content-Disposition = " + disposition);
            System.out.println("Content-Length = " + contentLength);
            System.out.println("fileName = " + fileName);
             */
            // HTTP stream open
            InputStream inputFromHttpServer = httpConn.getInputStream();
            String saveFilePath = saveDir + File.separator + fileName;
             
            // Save file
            FileOutputStream toSaveFile = new FileOutputStream(saveFilePath);
 
            int bytesRead = -1;
            byte[] buffer = new byte[HTTP_BUFFER_SIZE];
            while ((bytesRead = inputFromHttpServer.read(buffer)) != -1) {
                toSaveFile.write(buffer, 0, bytesRead);
            }
 
            toSaveFile.close();
            inputFromHttpServer.close();
 
            System.out.println("\tFile downloaded Successfully.");
        } else {
            System.out.println("\tFile is cant download. Server response code: " + httpResponsecode);
        }
        httpConn.disconnect();
        System.out.print("\n \n");
    }
  
	// To get domain name. For ex. ahmetozer.org or github.org
	public static String getDomainName(String URL) throws Exception {
	    URL aURL = new URL(URL);
	    return aURL.getHost().toString();
	}
	
	// My is Terminal command in linux to get current directory. My favorite command java imlemention to easy use.
	public static String pwd() {
		return System.getProperty("user.dir");
	}
}
