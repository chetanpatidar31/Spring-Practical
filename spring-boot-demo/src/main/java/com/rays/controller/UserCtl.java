package com.rays.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.AttachmentDTO;
import com.rays.dto.UserDTO;
import com.rays.form.UserForm;
import com.rays.service.AttachmentService;
import com.rays.service.UserService;

@RestController
@RequestMapping(value = "User")
public class UserCtl extends BaseCtl {

	@Autowired
	public UserService userService;

	@Autowired
	public AttachmentService attachService;

	@PostMapping("save")
	public ORSResponse save(@RequestBody @Valid UserForm form, BindingResult bindingResult) {

		ORSResponse resp = validate(bindingResult);

		if (!resp.isSuccess()) {
			return resp;
		}

		UserDTO dto = (UserDTO) form.getDto();

		if (dto.getId() != null && dto.getId() > 0) {
			userService.update(dto);
			resp.addData(dto.getId());
			resp.addMessage("Data updated successfully..!!");
			resp.setSuccess(true);

		} else {
			long pk = userService.add(dto);
			resp.addData(pk);
			resp.addMessage("User added successfully..!!");
			resp.setSuccess(true);
		}

		return resp;
	}

	@PostMapping("delete/{ids}")
	public ORSResponse delete(@PathVariable long[] ids) {
		ORSResponse resp = new ORSResponse();

		for (long id : ids) {
			userService.delete(id);
		}

		resp.addMessage("data deleted successfully");
		resp.setSuccess(true);

		return resp;
	}

	@GetMapping("get/{id}")
	public ORSResponse get(@PathVariable long id) {

		ORSResponse resp = new ORSResponse();

		UserDTO dto = userService.findByPk(id);

		if (dto != null) {
			resp.addData(dto);
			resp.setSuccess(true);
		}

		return resp;
	}

	@PostMapping("/profilePic/{userId}")
	public ORSResponse uploadPic(@PathVariable Long userId, @RequestParam("file") MultipartFile file,
			HttpServletRequest req) {

		AttachmentDTO attachDto = new AttachmentDTO(file);

		attachDto.setDescription("Profile Pic");
		attachDto.setUserId(userId);

		UserDTO userDto = userService.findByPk(userId);

		if (userDto.getImageId() != null && userDto.getImageId() > 0) {

			attachDto.setId(userDto.getImageId());

		}

		Long imageId = attachService.save(attachDto);

		if (userDto.getImageId() == null) {

			userDto.setImageId(imageId);

			userService.update(userDto);
		}

		ORSResponse resp = new ORSResponse();

		resp.addResult("imageId", imageId);
		resp.setSuccess(true);

		return resp;
	}

}
