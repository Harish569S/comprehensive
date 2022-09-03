package com.mindtree.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mindtree.doctor.entity.DoctorDetails;


@Repository
public interface DoctorRepository extends JpaRepository<DoctorDetails, Integer>{
	
	
	@Query(value="select * from doctor where doc_name=:str",nativeQuery = true)
	DoctorDetails getDetailsByName(@Param("str") String str);
	
	DoctorDetails findById(int id);
}
