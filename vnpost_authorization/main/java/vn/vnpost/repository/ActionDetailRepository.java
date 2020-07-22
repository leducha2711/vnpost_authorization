package vn.vnpost.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.vnpost.entity.ActionDetailEntity;
import vn.vnpost.entity.GroupEntity;

@Repository
public interface ActionDetailRepository extends JpaRepository<ActionDetailEntity, Integer>{
	
	@Query(value = "SELECT * FROM actiondetail d "
			+ "JOIN action a ON d.actionid = a.id " + 
			"JOIN group_actiondetail g ON d.id = g.actiondetailid "
			+ "WHERE a.id=:actionid AND g.groupid=:groupid  ", nativeQuery = true)
	List<ActionDetailEntity> findByActionIdAndRoleGroupId(@Param("actionid") int actionid,@Param("groupid")  int groupid);
	
	Boolean existsActionDetailEntityByGroupsAndId(GroupEntity groupEntity, int id );
}
