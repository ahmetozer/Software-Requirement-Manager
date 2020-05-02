import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class zip{
	static void unzip() {
		System.out.println("UNZIP: Zip file directory is not defined. Please give a zip file");
	}
	static void unzip(String zipFilePath) {
		file_functions  myHomePage = new file_functions (zipFilePath);
		System.out.println("UNZIP: output directory is not defined. Using default path" + myHomePage.path());
		unzip(zipFilePath, myHomePage.path()); // Calling unzip recursive with giving dest dir.
		
	}
	static void unzip(String zipFilePath, String destDir) {
		File dir = new File(destDir);
		// create output directory if it doesn't exist
		if(!dir.exists()) dir.mkdirs();
		FileInputStream fis;
		//buffer for read and write data to file
		byte[] buffer = new byte[1024];
		try {
			fis = new FileInputStream(zipFilePath);
			ZipInputStream zis = new ZipInputStream(fis);
			ZipEntry ze = zis.getNextEntry();
			while(ze != null){
				String fileName = ze.getName();
				File newFile = new File(destDir + File.separator + fileName);
				System.out.println("Unzipping to "+newFile.getAbsolutePath());
				//create directories for sub directories in zip
				new File(newFile.getParent()).mkdirs();
				FileOutputStream fos = new FileOutputStream(newFile);
				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				fos.close();
				//close this ZipEntry
				zis.closeEntry();
				ze = zis.getNextEntry();
			}
			//close last ZipEntry
			zis.closeEntry();
			zis.close();
			fis.close();
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
