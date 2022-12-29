package evaluationOneProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.*;

import java.nio.file.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.Path;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.clipper.Paths;

public class pdfMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		ArrayList<String> usersInput = new ArrayList<>();
		Random random = new Random();
		boolean listFlag = true;

		System.out.println("enter words you want to add to your list and then to file ");
		while (listFlag) {
			usersInput.add(sc.nextLine());
			System.out.print("do you want to add another word y/n?   ");
			if (sc.nextLine().toLowerCase().endsWith("y")) {
				listFlag = true;
				System.out.println("type the new word");
			} else {
				listFlag = false;
			}
		}

		for (Integer i = 0; i < 100; i++) {

			try { // Create Document instance
				Document document = new Document();

				// Create OutputStream instance.
				OutputStream outputStream = new FileOutputStream(new File("File" + i + ".pdf"));

				// Create PDFWriter instance.
				PdfWriter.getInstance(document, outputStream);

				// Open the document.
				document.open();
				int index = random.nextInt(usersInput.size()); // Add content to the document.
				document.add(new Paragraph(usersInput.get(index)));

				// Close document and outputStream.
				document.close();
				outputStream.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		ArrayList<String> usersSearch = new ArrayList<>();
		boolean searchFlag = true;
		  System.out.println("add words to search");
		  while (searchFlag) {
		 usersSearch.add(sc.nextLine());
		 System.out.print("do you want to add another word to seach y/n?   ");
		 if(sc.nextLine().toLowerCase().endsWith("y")) {
			 searchFlag = true;
		  System.out.println("type the new word");
		  } else
		  { searchFlag = false; } }
		  int count = 0; 
		  for (int i = 0; i < 100; i++) {
			  
			  PdfReader search = new PdfReader("File" + i + ".pdf"); 
			  int pages = search.getNumberOfPages();
		  
		  String[] words=null; // Iterate the pdf through pages. 
		  for (int ii = 1; ii <=pages; ii++) { // Extract the page content using PdfTextExtractor.
		  
		  String pageContent = PdfTextExtractor.getTextFromPage(search, ii);
		  
		  
		  words=pageContent.split(" ");
		  
		 
		  for (String word : usersSearch) { for (String n : words) {
		 System.out.println(word);
		  
		  if (word.equals(word)) {
		  
		  count++; } } }
		  
		  
		  
		  
		  if (count > 0) { new File(pageContent).mkdirs(); InputStream in = null;
		  OutputStream out = null;
		  
		  File oldFile = new File("File" + i + ".pdf"); File newFile = new File(
		  "C:\\Users\\Lenovo\\eclipse-workspace\\evaluationOneProject\\"+pageContent+"\\"+"File" + i + ".pdf");
		 
		 in = new FileInputStream(oldFile); out = new FileOutputStream(newFile);
		 
		 byte[] moveBuff = new byte[1024];
		  
		 int butesRead;
		 
		  while ((butesRead = in.read(moveBuff)) > 0) { out.write(moveBuff, 0,
		  butesRead); }
		  
		  in.close(); out.close();
		 
		 
		  
		  } System.out.println(i + "= " + count + pageContent); } count = 0; }
		  
		  }

}
