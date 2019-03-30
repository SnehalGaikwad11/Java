package com.bridgelab.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelab.Model.LoginInfo;
import com.bridgelab.Model.PasswordInfo;
import com.bridgelab.Model.User;
import com.bridgelab.Util.ValidationUtility;
import com.bridgelab.dao.LoginUser;

public class UserService {
	@Autowired
	LoginUser loginUserDao;
	
	/**
	 * registers a new user
	 * @param user new user instance
	 * @return a positive number if user got registered else zero
	 */
	public int register(User user) {
		return loginUserDao.addUser(user);
	}
	
	public boolean login(LoginInfo loginInfo) {
		return loginUserDao.checkUserIsPresent(loginInfo);
	}
	public boolean forgot(PasswordInfo passwordInfo)
	{
		return loginUserDao.checkIsUserEmailPresent(passwordInfo);
	}
	
	/**
	 * validates user details
	 * @param user User instance
	 * @return ModelAndView object if user details are not valid else null
	 */
	public ModelAndView validateUser(User user) {
		ModelAndView mav = new ModelAndView();
		if(user.getFirstName().contentEquals("") || user.getFirstName() == null || !ValidationUtility.validateStringForAlphanumericOflength(user.getFirstName(),20))
			return mav.addObject("message","invalid first name...!");
		else if(user.getLastName().contentEquals("") || user.getLastName() == null || !ValidationUtility.validateStringForAlphanumericOflength(user.getLastName(), 20))
			return mav.addObject("message","invalid lastst name...!");
		else if(user.getPhoneNumber().contentEquals("") || user.getPhoneNumber() == null || !ValidationUtility.validateMobileNumber(user.getPhoneNumber()))
			return mav.addObject("message","invalid mobile number...!");
		else if(user.getEmail().contentEquals("") || user.getEmail() == null || !ValidationUtility.validateEmail(user.getEmail()))
			return mav.addObject("message","invalid email...!");
		else if(user.getUserName().contentEquals("") || user.getUserName() == null || !ValidationUtility.validateStringForAlphanumericOflength(user.getUserName(), 20))
			return mav.addObject("message", "invalid username");
		else if(user.getPassword().contentEquals("") || user.getPassword() == null || !ValidationUtility.validateStringForAlphanumericOflength(user.getPassword(),20))
			return mav.addObject("message", "invalid password");
		
		return null;
	}
	
	/**
	 * validates the login credentials
	 * @param loginInfo login credentials
	 * @return ModelAndView object if user details are not valid else null
	 */
	public ModelAndView validateLoginInfo(LoginInfo loginInfo)
	{
		ModelAndView mav = new ModelAndView();
		if(loginInfo.getEmail().contentEquals("") || loginInfo.getEmail() == null )
			return mav.addObject("message", "invalid email");
		else if(loginInfo.getPassword().contentEquals("") || loginInfo.getPassword() == null || !ValidationUtility.validateStringForAlphanumericOflength(loginInfo.getPassword(),20))
			return mav.addObject("message", "invalid password");
		else return null;
	}
}