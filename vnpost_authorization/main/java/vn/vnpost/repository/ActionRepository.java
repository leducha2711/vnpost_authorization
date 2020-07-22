package vn.vnpost.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.vnpost.entity.ActionEntity;

@Repository
public interface ActionRepository extends JpaRepository<ActionEntity, Integer>{
	ActionEntity findByCode(String code);
	Boolean existsByIdIn(List<Integer> list );
	ActionEntity findByUrl(String url);
}
