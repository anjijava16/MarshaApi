package com.iwinner.mashap.form;

public class BookingStatusForm {
	private String passengerNo;
	private String currentStatus;
	private String bookingStatus;

	public String getPassengerNo() {
		return passengerNo;
	}

	public void setPassengerNo(String passengerNo) {
		this.passengerNo = passengerNo;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	@Override
	public String toString() {
		return "BookingStatusForm [passengerNo=" + passengerNo
				+ ", currentStatus=" + currentStatus + ", bookingStatus="
				+ bookingStatus + "]";
	}

}
