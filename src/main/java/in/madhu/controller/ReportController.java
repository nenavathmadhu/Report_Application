package in.madhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.madhu.entities.Citizenplan;
import in.madhu.request.SearchRequest;
import in.madhu.service.ReportService;

@Controller
public class ReportController {


		@Autowired
		private ReportService service;
		
		@PostMapping("/search")
		public String handleSearch(@ModelAttribute ("search") SearchRequest search,Model model) {
		    System.out.println(search);
			List<Citizenplan> plans = service.search(search) ;
			model.addAttribute("plans",plans) ;
			init(model);
			
			return "index";
		}
		
		@GetMapping("/excel")
		public String exportExcel(@ModelAttribute("search")SearchRequest search ,Model model) {
			boolean status = service.exportExcel();
			init(model);
			if(status) {
				model.addAttribute("export","Excel Exported");
			}else {
				model.addAttribute("export","Excel not Exported");
			}
			return "index";
			
		}
		
		@GetMapping("/pdf")
		public String exportGenerate(@ModelAttribute("search")SearchRequest search ,Model model) {
			boolean status = service.exportPdf();
			init(model);
			if(status) {
				model.addAttribute("export","Pdf Exported");
			}else {
				model.addAttribute("export","Pdf not Exported");
			}
			return "index";
			
		}
	 
		@GetMapping("/")
		public String indexPage(Model model) {
			
	      model.addAttribute("search", new SearchRequest());
			init(model);
			return "index";
		}
		
		
		private void init(Model model) {
	        model.addAttribute("names", service.getplanNames());
			model.addAttribute("status", service.getplanStatuses());
		}
	}
