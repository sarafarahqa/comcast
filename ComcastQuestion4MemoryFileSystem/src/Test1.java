import java.io.File;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;


public class Test1 extends Page1 {
   String cfile="/Users/sarafarahmand/Desktop/comcast1/file1.txt";
   String dfile="/Users/sarafarahmand/Desktop/comcast1/file2.txt";
   String pathFile="/Users/sarafarahmand/Desktop/comcast1";
   String fileName="file1.txt";
   Page1 SaraFile=new Page1();
   File f = new File("/Users/sarafarahmand/Desktop/comcast1");
   File file1 = new File("/Users/sarafarahmand/Desktop/comcast1/file1.txt");
   File file2 = new File("/Users/sarafarahmand/Desktop/comcast1/file2.txt");
   String content = "This is the content to write into file"; 
   File dir = new File("/Users/sarafarahmand/Desktop/comcast1");
   File srcFolder = new File("/Users/sarafarahmand/Desktop/comcast1"); 
   File destFolder = new File("/Users/sarafarahmand/Desktop/New"); 
   
   @Before
   public void setUp() {
	   System.out.println("@BeforeClass - setUp");
   }

   @Test
       public void test1() throws IOException{
	   SaraFile.createFolder(f);
   }
   @Test
   public void test2() throws IOException{
	   SaraFile.createFileAndAddContent(file1, file2, content);
   }
   @Test
   public void test3() throws IOException{
       SaraFile.copyAndDisplayFile(cfile, dfile);
   }
   @Test
   public void test4() throws IOException{
	   SaraFile.listFolderContents(f);
   }
   @Test
   public void test5() throws IOException{
	   SaraFile.SearchFileByName(pathFile, fileName);
   }
   @Test
   public void test6() throws IOException{
	   SaraFile.search2(dir);
   }
   @Test
   public void test7() throws IOException{
       SaraFile.copyFolder( srcFolder, destFolder);
   }
   
   @After
   public void tearDown() {
       System.out.println("@AfterClass - tearDown");
   }
}

