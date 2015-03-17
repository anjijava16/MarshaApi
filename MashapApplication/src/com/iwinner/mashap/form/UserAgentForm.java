package com.iwinner.mashap.form;

public class UserAgentForm {
	private String mobileModel;
	private String browserName;
	private String operatingSystem;
	private String mobileBrand;
	private String mobileScreenHeight;
	private String producer;
	private String type;
	private String mobileScreenWidth;
	private String mobileBrowser;
	private String isMobile;
	private String version;

	public String getMobileModel() {
		return mobileModel;
	}

	public void setMobileModel(String mobileModel) {
		this.mobileModel = mobileModel;
	}

	public String getBrowserName() {
		return browserName;
	}

	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public String getMobileBrand() {
		return mobileBrand;
	}

	public void setMobileBrand(String mobileBrand) {
		this.mobileBrand = mobileBrand;
	}

	public String getMobileScreenHeight() {
		return mobileScreenHeight;
	}

	public void setMobileScreenHeight(String mobileScreenHeight) {
		this.mobileScreenHeight = mobileScreenHeight;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMobileScreenWidth() {
		return mobileScreenWidth;
	}

	public void setMobileScreenWidth(String mobileScreenWidth) {
		this.mobileScreenWidth = mobileScreenWidth;
	}

	public String getMobileBrowser() {
		return mobileBrowser;
	}

	public void setMobileBrowser(String mobileBrowser) {
		this.mobileBrowser = mobileBrowser;
	}

	public String getIsMobile() {
		return isMobile;
	}

	public void setIsMobile(String isMobile) {
		this.isMobile = isMobile;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "UserAgentForm [mobileModel=" + mobileModel + ", browserName="
				+ browserName + ", operatingSystem=" + operatingSystem
				+ ", mobileBrand=" + mobileBrand + ", mobileScreenHeight="
				+ mobileScreenHeight + ", producer=" + producer + ", type="
				+ type + ", mobileScreenWidth=" + mobileScreenWidth
				+ ", mobileBrowser=" + mobileBrowser + ", isMobile=" + isMobile
				+ ", version=" + version + "]";
	}

}
