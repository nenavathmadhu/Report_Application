package in.madhu.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.madhu.entities.Citizenplan;
import in.madhu.repo.CitizenPlanRepository;
@Component
public class DataLoader implements ApplicationRunner  {
   
	@Autowired
	private CitizenPlanRepository repo ;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		// cash plan Data 
		Citizenplan c1 = new Citizenplan();
		c1.setCitizenName("madhu");
		c1.setGender("male");
		c1.setPlanName("cash");
		c1.setPlanStatus("Approved");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenifitAmt(5000.0);
		
		Citizenplan c2 = new Citizenplan();
		c2.setCitizenName("swathi");
		c2.setGender("female") ;
		c2.setPlanName("cash");
		c2.setPlanStatus("Denied");
		c2.setDanialReason("Rental income");
		
		
		Citizenplan c3 = new Citizenplan();
		c3.setCitizenName("Tinku");
		c3.setGender("male") ;
		c3.setPlanName("cash");
		c3.setPlanStatus("Terminated");
		c3.setPlanStartDate(LocalDate.now());
		c3.setPlanEndDate(LocalDate.now().plusMonths(6));
		c3.setBenifitAmt(5000.0);
		c3.setTerminatedDate(LocalDate.now());
		c3.setTerminationRsn("Employed");
		
		
		// food plan Data 
		
		Citizenplan c4 = new Citizenplan();
		c4.setCitizenName("sri");
		c4.setGender("female") ;
		c4.setPlanName("Food");
		c4.setPlanStatus("Approved");
		c4.setPlanStartDate(LocalDate.now());
		c4.setPlanEndDate(LocalDate.now().plusMonths(6));
		c4.setBenifitAmt(6000.0);
		
		
		
		Citizenplan c5 = new Citizenplan();
		c5.setCitizenName("siri");
		c5.setGender("female") ;
		c5.setPlanName("Food");
		c5.setPlanStatus("Denied");
		c5.setDanialReason("property income");
		
		
		Citizenplan c6 = new Citizenplan();
		c6.setCitizenName("Chintu");
		c6.setGender("male") ;
		c6.setPlanName("Food");
		c6.setPlanStatus("Terminated");
		c6.setPlanStartDate(LocalDate.now());
		c6.setPlanEndDate(LocalDate.now().plusMonths(6));
		c6.setBenifitAmt(5000.0);
		c6.setTerminatedDate(LocalDate.now());
		c6.setTerminationRsn("Employed");
		
		
		// medical plan Data 
		
		Citizenplan c7 = new Citizenplan();
		c7.setCitizenName("madhu");
		c7.setGender("female") ;
		c7.setPlanName("medical");
		c7.setPlanStatus("Approved");
		c7.setPlanStartDate(LocalDate.now());
		c7.setPlanEndDate(LocalDate.now().plusMonths(6));
		c7.setBenifitAmt(5000.0);
		
		
		
		Citizenplan c8 = new Citizenplan();
		c8.setCitizenName("swathi");
		c8.setGender("female") ;
		c8.setPlanName("medical");
		c8.setPlanStatus("Denied");
		c8.setDanialReason("Rental income");
		
		
		Citizenplan c9 = new Citizenplan();
		c9.setCitizenName("Bharath");
		c9.setGender("male") ;
		c9.setPlanName("medical");
		c9.setPlanStatus("Terminated");
		c9.setPlanStartDate(LocalDate.now());
		c9.setPlanEndDate(LocalDate.now().plusMonths(6));
		c9.setBenifitAmt(5000.0);
		c9.setTerminatedDate(LocalDate.now());
		c9.setTerminationRsn("Govt job");
		
		
		
		// Employement plan Data 
		
		Citizenplan c10 = new Citizenplan();
		c10.setCitizenName("Anitha");
		c10.setGender("female") ;
		c10.setPlanName("Employement");
		c10.setPlanStatus("Approved");
		c10.setPlanStartDate(LocalDate.now());
		c10.setPlanEndDate(LocalDate.now().plusMonths(6));
		c10.setBenifitAmt(5000.0);
		
		
		
		Citizenplan c11 = new Citizenplan();
		c11.setCitizenName("Sunitha");
		c11.setGender("female") ;
		c11.setPlanName("Employement");
		c11.setPlanStatus("Denied");
		c11.setDanialReason("Rental income");
		
		
		Citizenplan c12 = new Citizenplan();
		c12.setCitizenName("Arun");
		c12.setGender("male") ;
		c12.setPlanName("Employement");
		c12.setPlanStatus("Terminated");
		c12.setPlanStartDate(LocalDate.now());
		c12.setPlanEndDate(LocalDate.now().plusMonths(6));
		c12.setBenifitAmt(5000.0);
		c12.setTerminatedDate(LocalDate.now());
		c12.setTerminationRsn("un-Employed");
		

  List<Citizenplan> list = Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12) ;
    repo.saveAll(list) ;
	}
	}
	

