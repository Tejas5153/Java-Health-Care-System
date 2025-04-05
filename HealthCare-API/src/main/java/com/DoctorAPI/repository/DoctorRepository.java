package com.DoctorAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DoctorAPI.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Long>
{

    
}