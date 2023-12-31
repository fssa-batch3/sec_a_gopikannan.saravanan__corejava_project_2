package com.fssa.pin.service;

import java.sql.SQLException;

import com.fssa.pin.dao.UserDAO;
import com.fssa.pin.dao.exceptions.DAOException;
import com.fssa.pin.model.User;
import com.fssa.pin.service.exception.ServiceException;
import com.fssa.pin.validation.UserValidator;
import com.fssa.pin.validation.exceptions.InvalidUserException;


/**
 * Manages user-related services like register,login,update,delete user .
 */
public class UserService {
	/**
	 * Registers a new user.
	 *
	 * @param user The User object containing user information.
	 * @return True if user registration is successful, otherwise false.
	 * @throws ServiceException If a service-related issue occurs.
	 */
	public boolean registerUser(User user) throws ServiceException {

		UserDAO userDAO = new UserDAO();

		try {

			UserValidator.validateUser(user);
			if (userDAO.isEmailAlreadyRegistered(user.getMail())) {
				throw new DAOException("Email already exists");
			}
			if (userDAO.createUser(user)) {
				return true;
			} else {
				throw new ServiceException("Registration was not Successful");
			}

		} catch (DAOException | InvalidUserException e) {

			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Logs in a user.
	 *
	 * @param user The User object containing user login details.
	 * @return True if login is successful, otherwise false.
	 * @throws ServiceException If a service-related issue occurs.
	 */
	public boolean loginUser(User user) throws ServiceException {
		try {

			UserValidator.validLoginCredentials(user);

			UserDAO userDAO = new UserDAO();
			if (userDAO.loginUser(user) && (userDAO.getUserPasswordFromDb().equals(user.getPassword()))) {
				return true;
			}
			else {
				
				throw new ServiceException("Check Your Email And Password that you entered while you registered");
			}
		} catch (DAOException | InvalidUserException e) {

			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Updates user information.
	 *
	 * @param user The User object containing updated user information.
	 * @return True if user information is successfully updated, otherwise false.
	 * @throws ServiceException If a service-related issue occurs.
	 */
	public boolean updateUser(User user) throws ServiceException {

		UserDAO userDAO = new UserDAO();

		try {
			UserValidator.validateUpdateUser(user);

			if (userDAO.updateUser(user)) {
				return true;
			} else {
				throw new ServiceException("Update was not successful");

			}

		} catch (DAOException | InvalidUserException | SQLException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	/**
	 * Deletes a user.
	 *
	 * @param email The email of the user to be deleted.
	 * @return True if user is successfully deleted, otherwise false.
	 * @throws ServiceException If a service-related issue occurs.
	 */
	public boolean deleteUser(String email) throws ServiceException {

		UserDAO userDAO = new UserDAO();

		try {
			return userDAO.deleteUser(email);
		} catch (DAOException  e) {
			throw new ServiceException(e.getMessage());
		}
 
	}

	 
	 public User findUserByEmailService(String email) throws ServiceException {
		 UserDAO userDAO = new UserDAO();
	        try {
	            return userDAO.findUserByEmail(email);
	        } catch (DAOException e) {
	            throw new ServiceException(e.getMessage());
	        }
	    }	
	 
	 
	 public User findUserByIdService(int id) throws ServiceException {
		 UserDAO userDAO = new UserDAO();
	        try {
	            return userDAO.findUserById(id);
	        } catch (DAOException e) {
	            throw new ServiceException(e.getMessage());
	        }
	    }	
	 
	 
	
	
	 
	 
}