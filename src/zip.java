import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class zip{
	static void unzip() {
		System.out.println("UNZIP: Zip file directory is not defined. Please give a zip file");
	}
	static void unzip(String zipFilePath) {
		System.out.println("UNZIP: Zip output directory is not defined. So files extracted to /get folder");
		unzip(zipFilePath, "/get");
	}

	static void unzip(String zipFilePath, String path)  {
		//file_functions  myHomePage = new file_functions (zipFilePath);
		//System.out.println("UNZIP: output directory is not defined. Using default path" + myHomePage.path());
		//unzip(zipFilePath, myHomePage.path()); // Calling unzip recursive with giving dest dir.
		String command = "powershell -Command Expand-Archive -Force "+zipFilePath+" " + path;
		if (OS_Detection.getOperatingSystemType().toString() == "Linux") {
			command = "unzip "+zipFilePath+" " + path;
		  } else if (OS_Detection.getOperatingSystemType().toString() == "Windows") {
			  command = "powershell -Command Expand-Archive -Force "+zipFilePath+" " + path;
		  } else {
			  System.out.println("Error : OS Type not supported");
			  return;
		  }
		
		 
		try {
			Process process = Runtime.getRuntime().exec(command);
			// deal with OutputStream to send inputs
			process.getOutputStream();
			 
			// deal with InputStream to get ordinary outputs
			process.getInputStream();
			 
			// deal with ErrorStream to get error outputs
			process.getErrorStream();
		    BufferedReader reader = new BufferedReader(
		            new InputStreamReader(process.getInputStream()));
		    String line;
		    while ((line = reader.readLine()) != null) {
		        System.out.println(line);
		    }
		 
		    reader.close();
		 
		} catch (IOException e) {
		    e.printStackTrace();
		}

	}
	

	/* TEST FUNCTION
	public static void main(String[] args) {
		String zipFilePath = "/Users/ahmet/Desktop/tmp.zip";

		String destDir = "/Users/ahmet/Desktop/tmp";

		unzip(zipFilePath, destDir);
	}
	*/

}
