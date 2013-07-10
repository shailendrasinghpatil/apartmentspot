package com.viraneel.apartmentspot.entities;

import java.util.List;

public class Section extends BaseEntity {

	private int sectionID;
	private List<Section> subSections;
	private String sectionName;
	private String url;
	private String contentURL;

	public String getContentURL() {
		return contentURL;
	}

	public void setContentURL(String contentURL) {
		this.contentURL = contentURL;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Section(int id, String sectionName, String url, String contentURL) {
		this.sectionID = id;
		this.sectionName = sectionName;
		this.url = url;
		this.contentURL = contentURL;
	}

	public List<Section> getSubSections() {
		return subSections;
	}

	public void setSubSections(List<Section> subSections) {
		this.subSections = subSections;
	}

	public int getSectionID() {
		return sectionID;
	}

	public void setSectionID(int sectionID) {
		this.sectionID = sectionID;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public PermissionLevel getPermissionLevelForSection(Role userRole) {

		PermissionLevel level = new PermissionLevel(PermissionLevel.NONE);
		if (null != userRole) {
			List<Permission> permissions = userRole.getPermissions();
			if (permissions != null) {
				for (Permission permission : permissions)
					if (permission.getSection().getSectionID() == this
							.getSectionID()) {
						level = permission.getLevel();
					}
			}
		}
		return level;

	}
}
