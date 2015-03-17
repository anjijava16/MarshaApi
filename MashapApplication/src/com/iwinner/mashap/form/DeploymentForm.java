package com.iwinner.mashap.form;

public class DeploymentForm implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tags;
	private String id;
	private String logo;
	private String details;
	private String website;
	private String name;
	public DeploymentForm(){
		
	}
	public DeploymentForm(String tags, String id, String logo, String details,
			String website, String name) {
		super();
		this.tags = tags;
		this.id = id;
		this.logo = logo;
		this.details = details;
		this.website = website;
		this.name = name;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "DeploymentForm [tags=" + tags + ", id=" + id + ", logo=" + logo
				+ ", details=" + details + ", website=" + website + ", name="
				+ name + "]";
	}

}
