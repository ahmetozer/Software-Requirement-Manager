

public class Repository {
	private double RepoId;
	private String RepoName;
	private String[] Download_list;

	public Repository(int id, String RepoName, String[] Download_list) {
		this.RepoId = id;
		this.RepoName = RepoName;
		this.Download_list = Download_list;
	}


	@Override
	public String toString() {
		return "RepoName: " + RepoName + " with id: " + RepoId + " and Download_List: " + Download_list;
	}



	public double getid() {
		return RepoId;
	}
	
	public void setid(double id) {
		RepoId = id;
	}
			
	public String getRepoName() {
		return RepoName;
	}

	public void setRepoName(String name) {
		RepoName= name;
	}

	public String[] getDownload_list() {
		return Download_list;
	}

	public void setDownload_list(String[] list) {
		Download_list = list;
	}
	
	public void addDownload_list(String url) {
		//list.contains("20")
		Download_list = addX(Download_list, url);
	}
	
	public String[] addX(String arr[], String x) 
    { 
        int i; 
        int n = Download_list.length;
        // create a new array of size n+1 
        String newarr[] = new String[n + 1]; 
  
        // insert the elements from 
        // the old array into the new array 
        // insert all elements till n 
        // then insert x at n+1 
        for (i = 0; i < n; i++) 
            newarr[i] = arr[i]; 
  
        newarr[n] = x; 
  
        return newarr; 
    }
	
}
