package com.wipro.mbcms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.mbcms.dto.InvoiceDetailsDTO;
import com.wipro.mbcms.entities.InvoiceDetails;
import com.wipro.mbcms.entities.Patients;
import com.wipro.mbcms.repositories.InvoiceDetailsRepository;
import com.wipro.mbcms.repositories.PatientRepository;
@Service
public class InvoiceDetailsServiceImp implements IInvoiceDetailsService {

	@Autowired
	private PatientRepository patientRepo;

	@Autowired
	private InvoiceDetailsRepository invoiceRepo;

	@Override
	public InvoiceDetails addInvoice(InvoiceDetailsDTO detailsDto, long patientId) {
		InvoiceDetails details = new InvoiceDetails();
		Patients patients = patientRepo.findById(patientId).orElse(new Patients());
		details.setInvoiceDate(detailsDto.getInvoiceDate());
		details.setInvoiceTax(detailsDto.getInvoiceTax());
		details.setConsultationFee(detailsDto.getConsultationFee());
		details.setDiagnosticsTestsFee(detailsDto.getDiagnosticsTestsFee());
		details.setDiagnoticsScanFee(detailsDto.getDiagnoticsScanFee());
		details.setInvoiceTotalAmount(detailsDto.getInvoiceTotalAmount());
		details.setTotalBillAmount(detailsDto.getTotalBillAmount());
		details.setPatient(patients);
		return invoiceRepo.save(details);
	}

	@Override
	public List<InvoiceDetails> getAllInvoices() {
		return invoiceRepo.findAll();
	}

	@Override
	public InvoiceDetails getInvoiceById(int invoiceId) {
		return invoiceRepo.findById(invoiceId).orElse(null);
	}

}
