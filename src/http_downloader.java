import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class http_downloader {
	public static void http_downloader() {
		System.out.println("URL is not defined. Please give a download url");
	}
	
	public static void http_downloader(String URL) {
		String  FILE_NAME = URL;
	try (BufferedInputStream in = new BufferedInputStream(new URL(URL).openStream());
			  FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME)) {
			    byte dataBuffer[] = new byte[1024]; // Buffers is setted to 1 Kilobayt
			    int bytesRead;
			    while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
			        fileOutputStream.write(dataBuffer, 0, bytesRead);
			    }
	} catch (IOException e) {
			    // handle exception
		System.out.println("Error. Some think happened while downloading" + URL + "\n" + e);
		
	}
  }
}
