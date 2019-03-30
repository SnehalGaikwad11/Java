package com.bridgelab.Model;

import javax.persistence.Table;

@Table(name = "LoginAndReg")
	public class PasswordInfo {
	
		private String email;

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		

	}


