package com.bridgelab.dao;

import com.bridgelab.Model.LoginInfo;
import com.bridgelab.Model.User;

public interface UserDao 
{
	  int addUser(User user);
	  boolean checkUserIsPresent(LoginInfo login);
}