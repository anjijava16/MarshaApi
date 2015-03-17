package com.iwinner.mashap.form;

public class PNRJounrneyDeteailsForm {
	private String toAddress;
	private String boardingPoint;
	private String boardingDate;
	private String reservedUpto;
	private String classId;
	private String from;
	private String trainNumber;
	private String trainName;

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getBoardingPoint() {
		return boardingPoint;
	}

	public void setBoardingPoint(String boardingPoint) {
		this.boardingPoint = boardingPoint;
	}

	public String getBoardingDate() {
		return boardingDate;
	}

	public void setBoardingDate(String boardingDate) {
		this.boardingDate = boardingDate;
	}

	public String getReservedUpto() {
		return reservedUpto;
	}

	public void setReservedUpto(String reservedUpto) {
		this.reservedUpto = reservedUpto;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	@Override
	public String toString() {
		return "PNRJounrneyDeteailsForm [toAddress=" + toAddress
				+ ", boardingPoint=" + boardingPoint + ", boardingDate="
				+ boardingDate + ", reservedUpto=" + reservedUpto
				+ ", classId=" + classId + ", from=" + from + ", trainNumber="
				+ trainNumber + ", trainName=" + trainName + "]";
	}

}
