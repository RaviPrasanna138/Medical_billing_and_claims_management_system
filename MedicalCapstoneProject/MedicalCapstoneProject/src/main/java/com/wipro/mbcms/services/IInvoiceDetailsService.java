package com.wipro.mbcms.services;

import java.util.List;

import com.wipro.mbcms.dto.InvoiceDetailsDTO;
import com.wipro.mbcms.entities.InvoiceDetails;

public interface IInvoiceDetailsService {

	public InvoiceDetails addInvoice(InvoiceDetailsDTO detailsDto, long patientId);

	public List<InvoiceDetails> getAllInvoices();

	public InvoiceDetails getInvoiceById(int invoiceId);
}
