package com.wipro.mbcms.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.wipro.mbcms.dto.InvoiceDetailsDTO;
import com.wipro.mbcms.entities.InvoiceDetails;
import com.wipro.mbcms.entities.Patients;
import com.wipro.mbcms.exceptions.NoSuchInvoiceGeneratedException;
import com.wipro.mbcms.repositories.InvoiceDetailsRepository;
import com.wipro.mbcms.repositories.PatientRepository;
@Service
public class InvoiceDetailsServiceImp implements IInvoiceDetailsService {

	Logger logger = LoggerFactory.getLogger(InvoiceDetailsServiceImp.class);
	
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
		details.setDiagnosticsScanFee(detailsDto.getDiagnosticsScanFee());
		details.setInvoiceTotalAmount(detailsDto.getInvoiceTotalAmount());
		details.setTotalBillAmount(detailsDto.getTotalBillAmount());
		details.setPatient(patients);
		logger.info("Invoice Added Successfully for patient "+patientId);
		return invoiceRepo.save(details);
	}

	@Override
	public List<InvoiceDetails> getAllInvoices() {
		logger.info("All the Invoices Details Fetched Successfully");
		return invoiceRepo.findAll();
	}

	@Override
	public InvoiceDetails getInvoiceById(int invoiceId) {
		invoiceRepo.findById(invoiceId).orElseThrow(() -> new NoSuchInvoiceGeneratedException(HttpStatus.NO_CONTENT,
				"No such Invoice with Id :" + invoiceId + " Found"));
		logger.info("Fetched the Invoice by Id " + invoiceId);
		return invoiceRepo.findById(invoiceId).orElse(null);
	}

	@Override
	public List<InvoiceDetails> getAllByPatientName(String patientName) {
		return invoiceRepo.getByPatientName(patientName);
	}

}
