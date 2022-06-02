package com.ssg.Jasmine.domain;

import java.io.Serializable;


@SuppressWarnings("serial")
public class User implements Serializable {

	/* Private Fields */
	int userId;
	private String username;
	private String password;
	private String email;
	private String address;
	private String phone;
	private String favouriteCategoryId;
	private String languagePreference;
	private boolean listOption;
	private boolean bannerOption;
	private String bannerName;

	/* JavaBeans Properties */

	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }

	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public String getAddress() { return address; }
	public void setAddress(String address) { this.address = address; }

	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }

	public String getFavouriteCategoryId() { return favouriteCategoryId; }
	public void setFavouriteCategoryId(String favouriteCategoryId) { this.favouriteCategoryId = favouriteCategoryId; }

	public String getLanguagePreference() { return languagePreference; }
	public void setLanguagePreference(String languagePreference) { this.languagePreference = languagePreference; }

	public boolean isListOption() { return listOption; }
	public void setListOption(boolean listOption) { this.listOption = listOption; }
	public int getListOptionAsInt() { return listOption ? 1 : 0; }

	public boolean isBannerOption() { return bannerOption; }
	public void setBannerOption(boolean bannerOption) { this.bannerOption = bannerOption; }
	public int getBannerOptionAsInt() { return bannerOption ? 1 : 0; }

	public String getBannerName() { return bannerName; }
	public void setBannerName(String bannerName) { this.bannerName = bannerName; }

	public boolean matchPassword(String inputPassword) {
		return password.equals(inputPassword);
	}


}