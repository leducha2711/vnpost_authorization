package vn.vnpost.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.vnpost.entity.GroupEntity;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, Integer>{
	@Query(value = "select * from rolegroup g, user u where u.groupid = g.id and u.username =:username", nativeQuery = true)
	GroupEntity findByUsername(@Param(value = "username")String username);
	
	GroupEntity findByCode(String code);
	
	@Query(value="select * from rolegroup where code like %:code% and name like %:name%", nativeQuery = true)
	List<GroupEntity> findByCodeAndName(@Param(value = "code")String code,@Param(value = "name")String name);
}
