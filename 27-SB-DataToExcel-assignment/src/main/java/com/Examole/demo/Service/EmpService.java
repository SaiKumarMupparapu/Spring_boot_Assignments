package com.Examole.demo.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Examole.demo.Entity.Employee;
import com.Examole.demo.Repo.EmpRepo;

@Service
public class EmpService {

	@Autowired
	private EmpRepo er;
	
	public void dataToExcel() throws IOException {
		List<Employee> list = er.findAll();
		
		
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("emp");
		Row rowHead = sheet.createRow(0);
		String[] columns= {"id","name","salary"};
		
		for(int i=0;i<columns.length;i++) {
			Cell cell = rowHead.createCell(i);
			cell.setCellValue(columns[i]);
			
		}
		
		int rowNum=1;
		
		for(Employee e: list) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(e.getId());
			row.createCell(1).setCellValue(e.getName());
			row.createCell(2).setCellValue(e.getSalary());
			
		}
		try (
			FileOutputStream file = new FileOutputStream("emp.xls")){
			workbook.write(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		workbook.close();
		
	}
	
	public void dataToPdf() throws IOException {
		List<Employee> list = er.findAll();
		 PDDocument document = new PDDocument();
		 PDPage page = new PDPage();
		 
		 document.addPage(page);
		 
		 PDPageContentStream contentStream = new PDPageContentStream(document,page);
		 contentStream.beginText();
		 contentStream.newLineAtOffset(100, 700);
		 contentStream.showText("Employes list");
		 contentStream.newLine();
		 
		 for(Employee e: list) {
			 contentStream.showText("Id :"+e.getId());
			 contentStream.showText("Name :"+e.getName());
			 contentStream.showText("Salary :"+e.getSalary());
		 }
		 contentStream.endText();
		 contentStream.close();
		 
		 document.save("emp.pdf");
		 
		 
	}

	
}
