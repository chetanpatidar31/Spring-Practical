package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.AttachmentDAO;
import com.rays.dto.AttachmentDTO;

@Service
@Transactional
public class AttachmentService {

	@Autowired
	public AttachmentDAO attachDao;

	@Transactional(propagation = Propagation.REQUIRED)
	public long add(AttachmentDTO dto) {
		return attachDao.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(AttachmentDTO dto) {
		attachDao.update(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		AttachmentDTO dto = findByPk(id);
		attachDao.delete(dto);
	}

	@Transactional(readOnly = true)
	public AttachmentDTO findByPk(long pk) {
		return attachDao.findByPk(pk);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public long save(AttachmentDTO dto) {
		Long id = dto.getId();
		if (id != null && id > 0) {
			update(dto);
		} else {
			id = add(dto);
		}
		return id;
	}
}
