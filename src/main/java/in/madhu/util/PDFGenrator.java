package in.madhu.util;



import java.io.FileOutputStream;
import java.util.List;

import javax.swing.text.AbstractDocument;
import javax.swing.text.ParagraphView;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.madhu.entities.Citizenplan;

@Component
public class PDFGenrator {
	
	public void generatePDF(List<Citizenplan> plans,FileOutputStream fos) {

		Document doc = new Document(PageSize.A4);

		PdfWriter.getInstance(doc, fos);

		doc.open();

		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setSize(20);

		Paragraph paragraph1 = new Paragraph("Citizen Plans",fontTitle);

		paragraph1.setAlignment(Paragraph.ALIGN_CENTER);

		doc.add(paragraph1);

		PdfPTable table = new PdfPTable(11);

		table.setWidthPercentage(100f);
		table.setWidths(new int[] {3,3,3,3,3,3,3,3,3,3,3});
		table.setSpacingBefore(5);

		PdfPCell cell = new PdfPCell();

		cell.setBackgroundColor(CMYKColor.BLUE);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setColor(CMYKColor.WHITE);

		cell.setPhrase(new Phrase("CitizenId",font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("CitizenName",font));
		table.addCell(cell);
		cell.setPhrase(new Phrase(" gender",font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("PlanName",font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("PlanStatus",font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("PlanStartdate",font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("PlanEnddate",font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("benefitAmt",font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("DenailRsn",font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("TerminatedDate",font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("TerminatedReason",font));
		table.addCell(cell);

		for(Citizenplan c : plans) {
			table.addCell(String.valueOf(c.getCitizenId()));
			table.addCell(c.getCitizenName());
			table.addCell(c.getGender());
			table.addCell(c.getPlanName());
			table.addCell(c.getPlanStatus());
			table.addCell(String.valueOf(c.getPlanStartDate()));
			table.addCell(String.valueOf(c.getPlanEndDate()));
			table.addCell(String.valueOf(c.getBenifitAmt()));
			table.addCell(c.getDanialReason());
			table.addCell(String.valueOf(c.getTerminatedDate()));
			table.addCell(c.getTerminationRsn());
			
		}

		doc.add(table);

		doc.close();

	}

}

