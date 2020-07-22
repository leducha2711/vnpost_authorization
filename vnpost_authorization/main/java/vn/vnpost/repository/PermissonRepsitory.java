package vn.vnpost.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.vnpost.entity.PermissonEntity;

@Repository
public interface PermissonRepsitory extends JpaRepository<PermissonEntity, Integer>{

}
