package com.DoctorAPI.services;

import java.util.List;

import com.DoctorAPI.dto.DoctorDTO;

public interface DoctorService 
{

    DoctorDTO createDoctor(DoctorDTO doctorDTO);

    DoctorDTO getDoctorById(Long doctorId);

    List<DoctorDTO> getAllDoctors();
}
