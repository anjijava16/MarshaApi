package com.iwinner.mashap.form;

import java.util.List;

public class PNRStatusForm {
	private String lastUpdated;
	private String pnr;
	private String chartingStatus;
	private List<PNRJounrneyDeteailsForm> jounryDetailsForm;
	private List<BookingStatusForm> bookingStatus;

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public String getChartingStatus() {
		return chartingStatus;
	}

	public void setChartingStatus(String chartingStatus) {
		this.chartingStatus = chartingStatus;
	}

	public List<PNRJounrneyDeteailsForm> getJounryDetailsForm() {
		return jounryDetailsForm;
	}

	public void setJounryDetailsForm(
			List<PNRJounrneyDeteailsForm> jounryDetailsForm) {
		this.jounryDetailsForm = jounryDetailsForm;
	}

	public List<BookingStatusForm> getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(List<BookingStatusForm> bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	@Override
	public String toString() {
		return "PNRStatusForm [lastUpdated=" + lastUpdated + ", pnr=" + pnr
				+ ", chartingStatus=" + chartingStatus + ", jounryDetailsForm="
				+ jounryDetailsForm + ", bookingStatus=" + bookingStatus + "]";
	}
	

}
