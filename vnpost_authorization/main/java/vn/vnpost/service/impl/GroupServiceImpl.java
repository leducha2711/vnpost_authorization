package vn.vnpost.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.vnpost.convert.GroupConvert;
import vn.vnpost.dto.ActionDTO;
import vn.vnpost.dto.ActionDetailDTO;
import vn.vnpost.dto.AssignmentGroupDTO;
import vn.vnpost.dto.GroupDTO;
import vn.vnpost.dto.PermissonDTO;
import vn.vnpost.entity.GroupEntity;
import vn.vnpost.repository.GroupRepository;
import vn.vnpost.service.ActionDetailService;
import vn.vnpost.service.ActionService;
import vn.vnpost.service.GroupService;
import vn.vnpost.service.PermissonService;

@Service
@Transactional
public class GroupServiceImpl implements GroupService{
	@Autowired
	GroupRepository  groupRepository;
	@Autowired
	PermissonService permissonService;
	@Autowired
	GroupConvert groupConvert;
	@Autowired
	ActionDetailService actionDetailService;
	@Autowired
	ActionService actionService;
	@Override
	public GroupDTO findByUsername(String username) {
		GroupEntity groupEntity = groupRepository.findByUsername(username);
		
		return groupConvert.toDTO(groupEntity);
	}

	@Override
	public GroupDTO findByCode(String code) {
		GroupEntity groupEntity = groupRepository.findByCode(code);
		return groupConvert.toDTO(groupEntity);
	}

	@Override
	public List<GroupDTO> findAll() {
		List<GroupEntity> groupEntities = groupRepository.findAll();
		List<GroupDTO> groupDTOs = new ArrayList<GroupDTO>();
		for (GroupEntity groupEntity : groupEntities) {
			groupDTOs.add(groupConvert.toDTO(groupEntity));
		}
		return groupDTOs;
	}

	@Override
	public GroupDTO findById(int id) {
		GroupEntity groupEntity = groupRepository.findById(id).get();
		
		return groupConvert.toDTO(groupEntity);
	}

	@Override
	public void DeleteById(int id) {
		groupRepository.deleteById(id);
	}

	@Override
	public void add(GroupDTO groupDTO) {
		GroupEntity groupEntity = groupConvert.toEntity(groupDTO);
		groupRepository.save(groupEntity);
	}

	@Override
	public void update(GroupDTO groupDTO) {
		
		GroupEntity groupEntity = groupConvert.toEntity(groupDTO);
		GroupEntity groupEntity2 = groupRepository.findById(groupDTO.getId()).get();
		groupEntity.setPermissons(groupEntity2.getPermissons());
		groupEntity.setActiondetails(groupEntity2.getActiondetails());
		groupRepository.save(groupEntity);
	}

	@Override
	public GroupDTO getByCode(String code) {
		GroupDTO groupDTO = findByCode(code);
		GroupDTO groupDTO2 = new GroupDTO();
		groupDTO2.setPermissons(permissonService.findAll());
		groupDTO2.setName(groupDTO.getName());
		groupDTO2.setCode(groupDTO.getCode());
		
		for(PermissonDTO permissonDTO :groupDTO2.getPermissons()) {
			for(ActionDTO actionDTO : permissonDTO.getActions()) {
				for(ActionDetailDTO actionDetailDTO : actionDTO.getActiondetails()) {
					if(actionDetailService.existRoleGroupAndId(groupDTO, actionDetailDTO.getId()) ) {
						actionDetailDTO.setChecked("checked");
					}else {
						actionDetailDTO.setChecked("");
					}
				}
			}
		}
		
		
		for(PermissonDTO permissonDTO: groupDTO2.getPermissons()) {
			for(ActionDTO actionDTO : permissonDTO.getActions()) {
				for( ActionDetailDTO actionDetailDTO: groupDTO.getActiondetails() ) {
					if(actionDetailDTO.getAction().getCode().equals(actionDTO.getCode())) {
						actionDTO.setChecked("checked");
						System.out.println(actionDTO.getName());
						break;
					}else {
						actionDTO.setChecked("");
					}
				}
			}
				
		}
		
		for(PermissonDTO permissonDTO :groupDTO2.getPermissons()) {
			for(PermissonDTO permissonDTO2: groupDTO.getPermissons()) {
				if(permissonDTO.getId() == permissonDTO2.getId()) {
					permissonDTO.setChecked("checked");
					break;
				}
			}
		}
		return groupDTO2;
	}

	@Override
	public void assignmentGroup(AssignmentGroupDTO assignmentGroupDTO) {
		
		GroupDTO groupDTO = findByCode(assignmentGroupDTO.getCode());
		groupDTO.getPermissons().clear();
		System.out.println(groupDTO.getId()+" "+groupDTO.getName());
		for (String id : assignmentGroupDTO.getPermissList()) {
			System.out.println(id);
			groupDTO.getPermissons().add(permissonService.findById(Integer.parseInt(id)));
		}
		groupDTO.getActiondetails().clear();
		for (String id : assignmentGroupDTO.getActionDetailList()) {
			groupDTO.getActiondetails().add(actionDetailService.findById(Integer.parseInt(id)));
		}
		
		GroupEntity groupEntity = groupConvert.toEntity(groupDTO);
		groupRepository.save(groupEntity);
	}

	@Override
	public List<GroupDTO> findByCodeAndName(String code, String name) {
		List<GroupEntity> groupEntities = groupRepository.findByCodeAndName(code, name);
		List<GroupDTO> groupDTOs = new ArrayList<GroupDTO>();
		for (GroupEntity groupEntity : groupEntities) {
			groupDTOs.add(groupConvert.toDTO(groupEntity));
		}
		return groupDTOs;
	}
	
}
