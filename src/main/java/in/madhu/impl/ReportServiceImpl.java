package in.madhu.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.madhu.entities.Citizenplan;
import in.madhu.repo.CitizenPlanRepository;
import in.madhu.request.SearchRequest;
import in.madhu.service.ReportService;
import in.madhu.util.EmailGenerator;
import in.madhu.util.ExcelGenerator;
import in.madhu.util.PDFGenrator;

@Service
public class ReportServiceImpl  implements ReportService {

	@Autowired
	private CitizenPlanRepository repo;

	@Autowired
	private ExcelGenerator egenerator;

	@Autowired
	private EmailGenerator utils;

	@Autowired
	private PDFGenrator pgenerator;

	@Override
	public List<Citizenplan> search(SearchRequest request) {

		Citizenplan c1 = new Citizenplan();

		if(null != request.getPlanName() && !"".equals(request.getPlanName())) {
			c1.setPlanName(request.getPlanName());
		}

		if(null != request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			c1.setPlanStatus(request.getPlanStatus());
		}

		if(null != request.getGender() && !"".equals(request.getGender())) {
			c1.setGender(request.getGender());
		}

		if(null != request.getPlanStartDate() && !"".equals(request.getPlanStartDate())) {
			String date = request.getPlanStartDate();
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(date,dateTimeFormatter);
			c1.setPlanStartDate(localDate);
		}

		if(null != request.getPlanEndDate() && !"".equals(request.getPlanEndDate())) {
			String date = request.getPlanEndDate();
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(date,dateTimeFormatter);
			c1.setPlanEndDate(localDate);
		}

		Example<Citizenplan> exmp = Example.of(c1);
		List<Citizenplan> plans = repo.findAll(exmp);
		return plans;
	}

	@Override
	public List<String> getplanNames() {
		List<String> planNames = repo.getplaname();
		return planNames;
	}

	@Override
	public List<String> getplanStatuses(){		
	  List<String> statusNames = repo.getplanStatus();
		return statusNames;
	}

	@Override
	public boolean exportPdf() {		
	File f = new File("Plans.pdf");
	//	String filePath = "C:\\jrtp\\PlansData.pdf";
		try {
			List<Citizenplan> plans = repo.findAll();
			FileOutputStream fos = new FileOutputStream(f);
			pgenerator.generatePDF(plans, fos);
			utils.sendEmailWithAttachment("nenavathmadhu2000@gmail.com",
					"Citizen Plans Report","Here is the pdf of plans.", f);
			fos.close();
			f.delete();
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean exportExcel() {
		File f = new File("Plans.xls");
		//String filePath = "D:\\19-JFSD\\Java RealTime Project\\Mini project Workspace\\PlansData.xls";
		try {

			List<Citizenplan> plans = repo.findAll();
			FileOutputStream fos = new FileOutputStream(f);
			egenerator.generateExcel(fos, plans);
			utils.sendEmailWithAttachment("nenavathmadhu2000@gmail.com",
					"Citizen Plans Report","Here is the excelsheet of plans.", f);
			
			fos.close();
			f.delete();

		} catch (MessagingException | IOException e) {
			e.printStackTrace();
		}
		return true;
	}

}