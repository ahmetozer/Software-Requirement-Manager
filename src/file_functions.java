
public class file_functions {

	 private String fullPath;
	  private char pathSeparator, extensionSeparator;

	  public file_functions(String str, char sep, char ext) {
	    fullPath = str;
	    pathSeparator = sep;
	    extensionSeparator = ext;
	  }

	  public file_functions(String str) {
		  fullPath = str;
		  extensionSeparator = '.';
		  if (OS_Detection.getOperatingSystemType().toString() == "Linux") {
			  pathSeparator = '/';  
		  } else if (OS_Detection.getOperatingSystemType().toString() == "Windows") {
			  pathSeparator = '\\';
		  } else {
			  System.out.println("Error : OS Type not supported");
			  return;
		  }
	  }
	  public String extension() {
	    int dot = fullPath.lastIndexOf(extensionSeparator);
	    return fullPath.substring(dot + 1);
	  }

	  public String filename() { // gets filename without extension
	    int dot = fullPath.lastIndexOf(extensionSeparator);
	    int sep = fullPath.lastIndexOf(pathSeparator);
	    return fullPath.substring(sep + 1, dot);
	  }

	  public String path() {
	    int sep = fullPath.lastIndexOf(pathSeparator);
	    return fullPath.substring(0, sep);
	  }
	  
	  public String basename() {
		  int dot = fullPath.lastIndexOf(extensionSeparator);
		  int sep = fullPath.lastIndexOf(pathSeparator);
		  return fullPath.substring(sep + 1, dot) +"."+ fullPath.substring(dot + 1);
	  }

	  
	  /**Function TEST
	   
	  public static void main(String[] args) {
		  
		  	if (OS_Detection.getOperatingSystemType().toString() == "Linux") {
		  		
		  		final String FPATH = "/home/ahmet/index.html";
			    file_functions  myHomePage = new file_functions (FPATH);   
			    System.out.println("Extension = " + myHomePage.extension());
			    System.out.println("Filename = " + myHomePage.filename());
			    System.out.println("Path = " + myHomePage.path());
			    System.out.println("Basename = " + myHomePage.basename());
		  	} else if (OS_Detection.getOperatingSystemType().toString() == "Windows") {
		  		final String FPATH = "C:\\Users\\ahmet\\Desktop\\lanspeed\\bridge.png";
			    file_functions  myHomePage = new file_functions (FPATH);
			    System.out.println("Extension = " + myHomePage.extension());
			    System.out.println("Filename = " + myHomePage.filename());
			    System.out.println("Path = " + myHomePage.path());
			    System.out.println("Basename = " + myHomePage.basename());
		  	} else {
		  		System.out.print("Error OS is not supported");
		  	}
		  	
	}
	**/

}
