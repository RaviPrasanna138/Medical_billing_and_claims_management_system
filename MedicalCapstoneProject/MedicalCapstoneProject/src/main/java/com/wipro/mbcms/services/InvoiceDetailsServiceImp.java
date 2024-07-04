package com.wipro.mbcms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wipro.mbcms.dto.InvoiceDetailsDTO;
import com.wipro.mbcms.entities.InvoiceDetails;
import com.wipro.mbcms.entities.Patients;
import com.wipro.mbcms.repositories.InvoiceDetailsRepository;
import com.wipro.mbcms.repositories.PatientRepository;

public class InvoiceDetailsServiceImp implements IInvoiceDetailsService {

	@Autowired
	private PatientRepository patientRepo;

	@Autowired
	private InvoiceDetailsRepository invoiceRepo;

	@Override
	public InvoiceDetails addInvoice(InvoiceDetailsDTO detailsdto, long patientId) {
		InvoiceDetails details = new InvoiceDetails();
		Patients patients = patientRepo.findById(patientId).orElse(new Patients());
		details.setInvoiceDate(detailsdto.getInvoiceDate());
		details.setInvoiceTax(detailsdto.getInvoiceTax());
		details.setConsultationFee(detailsdto.getConsultationFee());
		details.setDiagnosticsTestsFee(detailsdto.getDiagnosticsTestsFee());
		details.setDiagnoticsScanFee(detailsdto.getDiagnoticsScanFee());
		details.setInvoiceTotalAmount(detailsdto.getInvoiceTotalAmount());
		details.setTotalBillAmount(detailsdto.getTotalBillAmount());
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
