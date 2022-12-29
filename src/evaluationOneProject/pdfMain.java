package evaluationOneProject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
public class pdfMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("sffffdddddddsss");

Scanner sc = new Scanner(System.in);
ArrayList<String> usersInput = new ArrayList<>();
Random random = new Random();
boolean listFlag=true;



System.out.println("enter words you want to add to your list and then to file ");
while(listFlag) {
usersInput.add(sc.nextLine());
System.out.print("do you want to add another word y/n?   ");
if(sc.nextLine().toLowerCase().endsWith("y")) {
listFlag=true;
System.out.println("type the new word");
}else {
listFlag=false;
}
}



for(Integer i =0 ;i<100;i++) {
	
	try {
	   	//Create Document instance.
	Document document = new Document();

	//Create OutputStream instance.
	OutputStream outputStream = 
		new FileOutputStream(new File("File"+i+".pdf"));

	//Create PDFWriter instance.
	    PdfWriter.getInstance(document, outputStream);

	    //Open the document.
	    document.open();
	    int index = random.nextInt(usersInput.size());
	    //Add content to the document.
	    document.add(new Paragraph(usersInput.get(index)));

	    //Close document and outputStream.
	    document.close();
	    outputStream.close();

	    System.out.println("Pdf created successfully.");
	} catch (Exception e) {
	e.printStackTrace();
	}
	
	
}
	}}

