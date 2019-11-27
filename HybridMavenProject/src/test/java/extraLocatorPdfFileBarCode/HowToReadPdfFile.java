package extraLocatorPdfFileBarCode;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.annotations.Test;

public class HowToReadPdfFile {
	
	@Test
	public void pdfReadTest() throws IOException {
		//URL url=new URL("https://www.betterteam.com/downloads/employee-information-form-download-20170810.pdf");
		URL url=new URL("http://www.pdf995.com/samples/pdf.pdf");
		InputStream is=url.openStream();
		BufferedInputStream bis=new BufferedInputStream(is);
		
		PDDocument document=PDDocument.load(bis);
		
		String pdfContent=new PDFTextStripper().getText(document);
		
		System.out.println(pdfContent);
		
		
	}

}
