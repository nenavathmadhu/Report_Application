package in.madhu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.madhu.entities.Citizenplan;
import in.madhu.repo.CitizenPlanRepository;
import in.madhu.request.SearchRequest;

@Service
	public interface ReportService {

	public List<String> getplanNames();

		public List<String> getplanStatuses();
		
		public List<Citizenplan> search(SearchRequest request);
		
		public boolean exportExcel();
		
		public boolean exportPdf();
	}
	


