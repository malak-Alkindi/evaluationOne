package evaluationOneProject;

import java.util.ArrayList;
import java.util.Scanner;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;

import java.util.Random;

import java.io.*;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.text.pdf.parser.Path;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class PdfWriterCreator {
	private ArrayList<String> usersInputs;
	Scanner scanner = new Scanner(System.in);
	ArrayList<String> usersSearch;

	public ArrayList<String> getUsersInputs() {
		return usersInputs;
	}

	public ArrayList<String> getUsersSearch() {
		return usersSearch;
	}

	public void setUsersSearch(ArrayList<String> usersSearch) {
		this.usersSearch = usersSearch;
	}

	public void setUsersInputs(ArrayList<String> usersInputs) {
		this.usersInputs = usersInputs;
	}

	void writeAParagraphs(boolean pdfWordsListFlag, ArrayList<String> usersInputsArg) {

		System.out.println("write AParagraphs you want to add to your pdfFiles : ");
		while (pdfWordsListFlag) {
			usersInputsArg.add(scanner.nextLine());
			System.out.print("do you want to add another word y/n?   ");
			if (scanner.nextLine().toLowerCase().endsWith("y")) {
				pdfWordsListFlag = true;
				System.out.println("type the new word");
			} else {
				pdfWordsListFlag = false;
			}
		}
		this.setUsersInputs(usersInputsArg);
	}

	void createWriteOneHundredPdf(ArrayList<String> usersInputsArg) {
		Random random = new Random();
		for (Integer i = 0; i < 100; i++) {

			try {
				Document document = new Document();
				OutputStream outputStream = new FileOutputStream(new File("File" + i + ".pdf"));

				PdfWriter.getInstance(document, outputStream);

				document.open();
				int index = random.nextInt(usersInputsArg.size());
				document.add(new Paragraph(usersInputsArg.get(index)));
				document.close();
				outputStream.close();
				System.out.println("File" + i + ".pdf created successfully.");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	void searchThis(boolean searchFlag, ArrayList<String> usersSearchArg) {
		System.out.println("what do you want to search about ?");
		while (searchFlag) {
			usersSearchArg.add(scanner.nextLine());
			System.out.println("do you want to add another word to search y/n?   ");
			if (scanner.nextLine().toLowerCase().endsWith("y")) {
				searchFlag = true;
				System.out.println("type the new word to search");
			} else {
				searchFlag = false;
			}
		}
		this.setUsersSearch(usersSearchArg);
	}

	void sortAccordingToWord() {
		for (int i = 0; i < 100; i++) {

			PdfReader search;
			try {
				search = new PdfReader("File" + i + ".pdf");

				int pages = search.getNumberOfPages();

				String[] words = null; // Iterate the pdf through pages.

				try {
					for (int ii = 1; ii <= pages; ii++) { // Extract the page content using
						// PdfTextExtractor.
						String pageContent;
						pageContent = PdfTextExtractor.getTextFromPage(search, ii);
						words = pageContent.split(" ");
						for (String word : this.getUsersSearch()) {
							for (String n : words) {
								System.out.println(word);

								if (n.equals(word)) {

									new File(word).mkdirs();
									InputStream in = null;
									OutputStream out = null;
									File oldFile = new File("File" + i + ".pdf");
									File newFile = new File(word + "\\" + "File" + i + ".pdf");

									in = new FileInputStream(oldFile);
									out = new FileOutputStream(newFile);

									byte[] moveBuff = new byte[1024];

									int butesRead;

									while ((butesRead = in.read(moveBuff)) > 0) {
										out.write(moveBuff, 0, butesRead);
									}

									in.close();
									out.close();

								} // System.out.println(i + "= " + count + pageContent);
							}
						}

					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	void sortAccordingToMatch() {
		Integer count = 0;
		for (int i = 0; i < 100; i++) {
			try {
				PdfReader search = new PdfReader("File" + i + ".pdf");
				int pages = search.getNumberOfPages();

				String[] words = null;
				try {
					// Iterate the pdf through pages.
					for (int ii = 1; ii <= pages; ii++) { // Extract the page content using
						// PdfTextExtractor.

						String pageContent = PdfTextExtractor.getTextFromPage(search, ii);

						words = pageContent.split(" ");
						count = 0;

						for (String word : this.getUsersSearch()) { // sql
							for (String n : words) {

								if (n.equals(word)) {
									count++;

								}

							}
						}
					}

					new File(count.toString() + "_matches out of " + this.getUsersSearch().size()).mkdirs();
					InputStream in = null;
					OutputStream out = null;
					File oldFile = new File("File" + i + ".pdf");
					File newFile = new File((count.toString() + "_matches out of " + this.getUsersSearch().size())
							+ "\\" + "File" + i + ".pdf");

					in = new FileInputStream(oldFile);
					out = new FileOutputStream(newFile);
					System.out.println(i + " = " + count);
					byte[] moveBuff = new byte[1024];

					int butesRead;

					while ((butesRead = in.read(moveBuff)) > 0) {
						out.write(moveBuff, 0, butesRead);
					}
					in.close();
					out.close();
				}

				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	 @SuppressWarnings("deprecation")
	protected void finalize() throws Throwable
	    {
	        try {
	 
	            System.out.println("inside demo's finalize()");
	        }
	        catch (Throwable e) {
	 
	            throw e;
	        }
	        finally {
	 
	            System.out.println("Calling finalize method"
	                               + " of the Object class");
	 
	            // Calling finalize() of Object class
	            super.finalize();
	        }
	    }
}
