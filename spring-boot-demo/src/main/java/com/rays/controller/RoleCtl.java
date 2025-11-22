package com.rays.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@PostMapping("update")
	public ORSResponse update(@RequestBody @Valid RoleForm form, BindingResult bindingResult) {

		ORSResponse resp = validate(bindingResult);

		if (!resp.isSuccess()) {
			return resp;
		}

		RoleDTO dto = (RoleDTO) form.getDto();

		roleService.update(dto);

		resp.addMessage("Role updated successfully....");

		return resp;
	}

	@PostMapping("delete/{ids}")
	public ORSResponse delete(@PathVariable long[] ids) {

		ORSResponse resp = new ORSResponse();

		for (long id : ids) {
			System.out.println("id: " + id);
			roleService.delete(id);
		}

		resp.addMessage("Role Deleted successfully.....");
		resp.setSuccess(true);

		return resp;
	}

	@GetMapping("get/{id}")
	public ORSResponse get(@PathVariable long id) {

		ORSResponse resp = new ORSResponse();

		RoleDTO dto = roleService.findByPk(id);

		if (dto != null) {
			resp.setSuccess(true);
		}

		resp.addData(dto);

		return resp;
	}

	@PostMapping("search/{pageNo}")
	public ORSResponse search(@RequestBody RoleForm form, @PathVariable int pageNo) {

		ORSResponse resp = new ORSResponse();

		RoleDTO dto = (RoleDTO) form.getDto();

		List<RoleDTO> list = roleService.search(dto, pageNo, 3);

		if (list != null && list.size() > 0) {
			resp.setSuccess(true);
		}

		resp.addData(list);

		return resp;
	}

}