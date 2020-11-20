package com.example.EmployeeManagementPOC.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.EmployeeManagementPOC.entity.Employee;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFGenerator {

	private static Logger logger = LoggerFactory.getLogger(PDFGenerator.class);

	public static ByteArrayInputStream employeePDFReport(List<Employee> employeeList) {

		Document document = new Document();

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			PdfWriter.getInstance(document, out);
			document.open();

//			for selecting a font style,size and color
			Font font = FontFactory.getFont(FontFactory.TIMES_ITALIC, 14, BaseColor.BLACK);
			Paragraph paragraph = new Paragraph("Employee Table", font);
			paragraph.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph);
			document.add(Chunk.NEWLINE);

			PdfPTable table = new PdfPTable(8);
			table.setWidthPercentage(100);

//			Adding header for table
			Stream.of("EmpId", "Name", "Age", "Gender", "Salary", "Designation", "Department","Adress").forEach(headerTitle -> {
				PdfPCell header = new PdfPCell();
				Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
				header.setBackgroundColor(BaseColor.LIGHT_GRAY);
				header.setHorizontalAlignment(Element.ALIGN_CENTER);
				header.setBorderWidth(2);

				header.setPhrase(new Phrase(headerTitle, headerFont));
				table.addCell(header);
			});

			for (Employee employee : employeeList) {
				PdfPCell empIdCell = new PdfPCell(new Phrase(Integer.toString(employee.getEmpId())));
				empIdCell.setPaddingLeft(4);
				empIdCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				empIdCell.setHorizontalAlignment((Element.ALIGN_CENTER));
				table.addCell(empIdCell);

				PdfPCell nameCell = new PdfPCell(new Phrase(employee.getName().toString()));
				nameCell.setPaddingLeft(4);
				nameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				nameCell.setHorizontalAlignment((Element.ALIGN_CENTER));
				table.addCell(nameCell);

				PdfPCell ageCell = new PdfPCell(new Phrase(Integer.toString(employee.getAge())));
				ageCell.setPaddingLeft(4);
				ageCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ageCell.setHorizontalAlignment((Element.ALIGN_CENTER));
				table.addCell(ageCell);

				PdfPCell genderCell = new PdfPCell(new Phrase(employee.getGender().toString()));
				genderCell.setPaddingLeft(4);
				genderCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				genderCell.setHorizontalAlignment((Element.ALIGN_CENTER));
				table.addCell(genderCell);

				PdfPCell salCell = new PdfPCell(new Phrase(Long.toString(employee.getSal())));
				salCell.setPaddingLeft(4);
				salCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				salCell.setHorizontalAlignment((Element.ALIGN_CENTER));
				table.addCell(salCell);

				PdfPCell desCell = new PdfPCell(new Phrase(employee.getDesignation().toString()));
				desCell.setPaddingLeft(4);
				desCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				desCell.setHorizontalAlignment((Element.ALIGN_CENTER));
				table.addCell(desCell);

				PdfPCell depCell = new PdfPCell(new Phrase(employee.getDepartment().getDepName().toString()));
				depCell.setPaddingLeft(4);
				depCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				depCell.setHorizontalAlignment((Element.ALIGN_CENTER));
				table.addCell(depCell);

				PdfPCell adressCell = new PdfPCell(new Phrase(employee.getAdress().toString()));
				adressCell.setPaddingLeft(4);
				adressCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				adressCell.setHorizontalAlignment((Element.ALIGN_CENTER));
				table.addCell(adressCell);

			}

			document.add(table);

			document.close();
		}

		catch (DocumentException e) {
			logger.error(e.toString());
		}
		return new ByteArrayInputStream(out.toByteArray());

	}

}
