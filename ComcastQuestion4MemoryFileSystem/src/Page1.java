



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*Create a program that will mimic a file system in a non-persistent way (when program is restarted, your file system is empty).. Your file system should be capable of performing the following tasks:

	Create a new folder - Takes a parameter of absolute folder path
	Create a new file - Take a parameter of absolute file path
	Add content to a file - Take 2 parameters: Content to append to a file; Absolute path to a file
	Copy files - Takes 2 parameters: Absolute path to a source file; Absolute path to a destination file (NOTE: If destination file exists, it will be overwritten)
	Display file contents - Takes absolute path to a file as an input; Prints out file contents as an output
	List folder contents - Takes absolute path to a folder as an input; Prints out folder contents as an output
	Search for a file by name - Takes name of a file to find; Prints out list of absolute paths to files with matching names
	Search for a file by name - Takes 2 parameters: Absolute path to a starting folder and file name; Outputs list of absolute paths to files with matching names
	(Optional) Copy folders - Takes 2 parameters: Absolute path to source folder, Absolute path to destination folder*/

public class Page1 {

	private String fileNameToSearch;
	private List<String> result = new ArrayList<String>();

	// this method returns the fileNameToSearch
	public String getFileNameToSearch() { 

		return fileNameToSearch;
	}

	//this method set the fileNameToSearch
	public void setFileNameToSearch(String fileNameToSearch) { 

		this.fileNameToSearch = fileNameToSearch;
	}
	//this method return result 
	public List<String> getResult() { 

		return result;
	}


	/*this method create folder
	 * *it gets value for f from Test
	 */
	public void createFolder(File f){
		f.mkdirs();	
	}

	/*this method create file and add content to it
	 * *it gets value for file1, file2 and content from Test
	 */
	public void createFileAndAddContent(File file1, File file2, String content) throws IOException{
		file2.createNewFile();
		if (!file1.exists()) {
			file1.createNewFile();
		}

		FileWriter fw = new FileWriter(file1.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(content);
		bw.close();
		System.out.println("Done");
	}

	/*this method copy files and add display file contents
	 * *it gets value for cfile, dfile from Test
	 */
	public void copyAndDisplayFile(String cfile, String dfile) throws IOException{
		FileInputStream fs = new FileInputStream(cfile);
		BufferedReader br = new BufferedReader(new InputStreamReader(fs));
		LinkedList<String> ll = new LinkedList<String>();
		String sline;
		while((sline=br.readLine())!=null)
		{
			ll.add(sline);

		}
		FileOutputStream fout = new FileOutputStream(dfile);
		BufferedWriter brout = new BufferedWriter(new OutputStreamWriter(fout));
		int i;
		int len = ll.size();
		for(i=0;i<=len-1;i++){

			System.out.println(ll.get(i));

			brout.write(ll.get(i));
			brout.newLine();
		}
		brout.close();
		br.close();
	} 

	/*this method list folder s contents
	 * *it gets value for f1 from Test
	 */
	public void listFolderContents(File f1) throws IOException{
		File[] files = f1.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				System.out.print("comcast");
			} else {
				System.out.print("file:");
			}
			System.out.println(file.getCanonicalPath());
		}
	}

	//this method searcheFileByName 
	public void SearchFileByName(String pathFile, String fileName){
		searchDirectory(new File(pathFile), fileName);
		int count =getResult().size(); 
		if(count ==0){ 
			System.out.println("\nNo result found!"); 
		}else{
			System.out.println("\nFound " + count + " result!\n"); 
			for (String matched :getResult()){
			}
		} 
	}


	public void searchDirectory(File directory, String fileNameToSearch) {

		setFileNameToSearch(fileNameToSearch);

		if (directory.isDirectory()) { 

			search(directory); 

		} else { 

			System.out.println(directory.getAbsoluteFile() + " is not a directory!"); 

		}
	}

	private void search(File file) {

		if (file.isDirectory()) { 

			System.out.println("Searching directory ... " + file.getAbsoluteFile()); 

			if (file.canRead()) { 

				for (File temp : file.listFiles()) { 

					if (temp.isDirectory()) { 

					} else { 

						search(temp);

						if (getFileNameToSearch().equals(temp.getName().toLowerCase())) { 

							result.add(temp.getAbsoluteFile().toString()); 

						}
					} 
				}

			}else { 
				System.out.println(file.getAbsoluteFile() + "Permission Denied");
			}
		}
	}


	/*this method Search for file
	 * *it gets value dir from Test
	 */
	public void search2(File dir){

		System.out.println("Directory is : "+ dir); 

		FilenameFilter filter = new FilenameFilter()     { 

			public boolean accept (File dir, String name)    { 

				return name.startsWith("H");          }  }; 

				String[] children = dir.list(filter); 

				if (children == null) { 
					System.out.println("Either dir does not exist or is not a directory"); 
				} 
				else { 
					for (int i=0; i<children.length; i++) { 
						String filename = children[i]; 
						System.out.println(dir+"\\" + filename); 
					} 
				} 
	      }

	/*this method copy folder to new folder
	 * *it gets value for src and dest from Test
	 */
	public void copyFolder(File src, File dest) throws IOException{ 

		if(src.isDirectory()){ 
			if(!dest.exists()){ 
				dest.mkdir(); 
			} 

			String files[] = src.list(); 

			for (String file : files) { 
				File srcFile = new File(src, file); 
				File destFile = new File(dest, file); 
				copyFolder(srcFile,destFile); 
			} 

		}else{ 

			InputStream in = new FileInputStream(src); 

			OutputStream out = new FileOutputStream(dest); 

			byte[] buffer = new byte[1024]; 

			int length; 

			while ((length = in.read(buffer)) > 0){ 

				out.write(buffer, 0, length); 
			} 
			in.close(); 

			out.close(); 

		}

	}
}







