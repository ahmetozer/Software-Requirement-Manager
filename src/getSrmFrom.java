import java.io.*;
public class getSrmFrom {

	public static String[] File(String filepath)
	{
		String myrequirements[] = {null} ;
		try
		{
			File file=new File(filepath);    //creates a new file instance
			FileReader fr=new FileReader(file);   //reads the file
			BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream
			StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters
			String line;
			while((line=br.readLine())!=null)
			{
				myrequirements= addX(myrequirements, line);
				sb.append(line);      //appends line to string buffer
				sb.append("\n");     //line feed
				//Repository.add;
			}
			fr.close();    //closes the stream and release the resources
			//System.out.println("Contents of File: ");
			//System.out.println(sb.toString());   //returns a string that textually represents the object
		} catch(IOException e)	{
			e.printStackTrace();
		}

		return myrequirements;
	}
	public static String[] addX(String arr[], String x) 
    { 
		
        int i; 
        int n = arr.length;
        // create a new array of size n+1 
        if ( arr[0]==null ) {
        	// This if is added because of JAVA ERROR when the arr set to null java get to exception error.
			String newarr[] = new String[1];
			newarr[0] = x;
			return newarr;
		} else {
        String newarr[] = new String[n + 1]; 
        
        for (i = 0; i < n; i++) 
            newarr[i] = arr[i]; 
  
        newarr[n] = x; 
  
        return newarr; 
    }

    }
}
