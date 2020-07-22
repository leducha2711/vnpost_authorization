package vn.vnpost.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.vnpost.dto.ActionDetailDTO;
import vn.vnpost.dto.GroupDTO;

@Service
public interface ActionDetailService {
	public List<ActionDetailDTO> findByActionIdAndGroupId(int actionid, int groupid);
	public Boolean existRoleGroupAndId(GroupDTO groupDTO, int id);
	public ActionDetailDTO findById(int id);
}
