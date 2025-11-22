package com.rays.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.RoleDTO;
import com.rays.form.RoleForm;
import com.rays.service.RoleService;

@RestController
@RequestMapping(value = "Role")
public class RoleCtl extends BaseCtl {

	@Autowired
	public RoleService roleService;

	@PostMapping("save")
	public ORSResponse save(@RequestBody @Valid RoleForm form, BindingResult bindingResult) {

		ORSResponse resp = validate(bindingResult);

		if (!resp.isSuccess()) {
			return resp;
		}

		RoleDTO dto = (RoleDTO) form.getDto();

		long pk = roleService.add(dto);

		resp.addData(pk);
		resp.addMessage("Role added Successfully...!!!!");

		return resp;
	}
}