package com.wipro.mbcms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.mbcms.dto.InvoiceDetailsDTO;
import com.wipro.mbcms.entities.InvoiceDetails;
import com.wipro.mbcms.services.IInvoiceDetailsService;

@RestController
@RequestMapping("/api/invoicedetails")
public class InvoiceDetailsRestController {
	
	@Autowired
	private IInvoiceDetailsService service;
	
	@PostMapping("/add")
	public InvoiceDetails addInvoice(@RequestBody InvoiceDetailsDTO detailsDto,@PathVariable long patientId) {
		return service.addInvoice(detailsDto, patientId);
	}
	
	@GetMapping("/getAllInvoices")
	public List<InvoiceDetails> getAllInvoices(){
		return service.getAllInvoices();
	}
	
	@GetMapping("/getInvoiceById/{invoiceId}")
	public InvoiceDetails getInvoiceById(@PathVariable int invoiceId) {
		return service.getInvoiceById(invoiceId);
	}
	
	@GetMapping("/getAllByPatientName/{patientName}")
	public List<InvoiceDetails> getAllByPatientName(@PathVariable String patientName){
		return service.getAllByPatientName(patientName);
	}
}
