package evaluationOneProject;

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

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		ArrayList<String> usersInputs = new ArrayList<>();
		PdfWriterCreator pdfWriterCreatorObj = new PdfWriterCreator();
		ArrayList<String> usersSearch = new ArrayList<>();

		boolean choisesFlag = true;

		while (choisesFlag) {
			System.out.println(
					"what you want you want to do ?\n\na = write new pdfs \nb = sort exiting pdf files according to searching word \n"
							+ "c = sort existing pdf files according to words matching \ncl = close");
			String listChoise = scanner.nextLine().toLowerCase();
			if (listChoise.equals("a")) {

				pdfWriterCreatorObj.writeAParagraphs(true, usersInputs);
				pdfWriterCreatorObj.createWriteOneHundredPdf(pdfWriterCreatorObj.getUsersInputs());
			} else if (listChoise.equals("b")) {
				pdfWriterCreatorObj.searchThis(true, usersSearch);
				pdfWriterCreatorObj.sortAccordingToWord();
			} else if (listChoise.equals("c")) {
				pdfWriterCreatorObj.searchThis(true, usersSearch);
				pdfWriterCreatorObj.sortAccordingToMatch();
			} else if (listChoise.equals("cl")) {
				choisesFlag = false;
				System.out.println("bye !!!!!");
			} else {
				throw new Exception("unvalid input /enter again");

			}

		}
		System.gc();
		Runtime.getRuntime().gc();
		pdfWriterCreatorObj.finalize();
	}
	 
}
