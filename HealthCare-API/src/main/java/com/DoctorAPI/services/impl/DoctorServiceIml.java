package com.DoctorAPI.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.DoctorAPI.dto.DoctorDTO;
import com.DoctorAPI.entity.Doctor;
import com.DoctorAPI.repository.DoctorRepository;
import com.DoctorAPI.services.DoctorService;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorServiceIml implements DoctorService
{
    
	@Autowired
	private  DoctorRepository doctorRepository;

   
	@Override
	public DoctorDTO createDoctor(DoctorDTO doctorDTO) {
		Doctor doctor = convertToEntity(doctorDTO);
		doctor = doctorRepository.save(doctor);
		return convertToDTO(doctor);
	}

	@Override
    public DoctorDTO getDoctorById(Long doctorId) {
    Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorId);
    return optionalDoctor
        .map(this::convertToDTO)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor not found with id " + doctorId));
    }


	@Override
	public List<DoctorDTO> getAllDoctors() {
		List<Doctor> doctors = doctorRepository.findAll();
		return doctors.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	private DoctorDTO convertToDTO(Doctor doctor) {
		DoctorDTO doctorDTO = new DoctorDTO();
		doctorDTO.setId(doctor.getId());
		doctorDTO.setName(doctor.getName());
		doctorDTO.setSpecialty(doctor.getSpecialty());
		return doctorDTO;
	}

	private Doctor convertToEntity(DoctorDTO doctorDTO) {
		Doctor doctor = new Doctor();
		doctor.setId(doctorDTO.getId());
		doctor.setName(doctorDTO.getName());
		doctor.setSpecialty(doctorDTO.getSpecialty());
		return doctor;
	}
    
}
