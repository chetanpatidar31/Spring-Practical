package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.UserDTO;

public class UserForm extends BaseForm {

	@NotEmpty(message = "First Name is Required")
	private String firstName;

	@NotEmpty(message = "Last Name is Required")
	private String lastName;

	@NotEmpty(message = "email is Required")
	@Email(message = "Enter valid email")
	private String login;

	@NotEmpty(message = "Password is required")
	@Pattern(
	    regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$",
	    message = "Password must contain at least 1 uppercase, 1 lowercase, 1 number, and 1 special character"
	)
	private String password;

	@NotNull(message = "DOB is Required")
	private Date dob;

	@NotNull(message = "roleId is required")
	@Range(min = 1, max = 5, message = "roleId must be between 1 and 5")
	private Long roleId;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Override
	public BaseDTO getDto() {

		UserDTO dto = (UserDTO) initDTO(new UserDTO());

		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setLogin(login);
		dto.setPassword(password);
		dto.setDob(dob);
		dto.setRoleId(roleId);

		return dto;
	}
}
