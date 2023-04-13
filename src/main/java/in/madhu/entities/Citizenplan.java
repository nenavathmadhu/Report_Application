package in.madhu.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CITIZEN_PLAN_INFO")
public class Citizenplan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer citizenId ;
	private String citizenName ;
	private String gender ;
	private String planName ;
	private String planStatus ;
	private LocalDate planStartDate ;
	private LocalDate planEndDate ;
	private Double benifitAmt ;
	private String danialReason ;
	private LocalDate terminatedDate ;
	private String terminationRsn ;
	

}
