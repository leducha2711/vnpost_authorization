package vn.vnpost.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.vnpost.convert.ActionDetailConvert;
import vn.vnpost.convert.GroupConvert;
import vn.vnpost.dto.ActionDetailDTO;
import vn.vnpost.dto.GroupDTO;
import vn.vnpost.entity.ActionDetailEntity;
import vn.vnpost.repository.ActionDetailRepository;
import vn.vnpost.service.ActionDetailService;

@Service
@Transactional
public class ActionDetailServiceImpl implements ActionDetailService{

	@Autowired
	ActionDetailRepository actionDetailRepository;
	@Autowired
	ActionDetailConvert actionDetailConvert;
	@Autowired
	GroupConvert  groupConvert;
	
	@Override
	public List<ActionDetailDTO> findByActionIdAndGroupId(int actionid, int groupid) {
		List<ActionDetailEntity> actionDetailEntities = actionDetailRepository.findByActionIdAndRoleGroupId(actionid, groupid);
		List<ActionDetailDTO> actionDetailDTOs = new ArrayList<ActionDetailDTO>();
		for (ActionDetailEntity actionDetailEntity : actionDetailEntities) {
			actionDetailDTOs.add(actionDetailConvert.toDTO(actionDetailEntity));
		}
		return actionDetailDTOs;
	}
	
	@Override
	public ActionDetailDTO findById(int id) {
		
		return actionDetailConvert.toDTO(actionDetailRepository.findById(id).get());
	}

	@Override
	public Boolean existRoleGroupAndId(GroupDTO groupDTO, int id) {
		
		return actionDetailRepository.existsActionDetailEntityByGroupsAndId(groupConvert.toEntity(groupDTO), id);
	}

}
