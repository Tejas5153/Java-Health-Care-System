package com.DoctorAPI.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.DoctorAPI.dto.DoctorDTO;
import com.DoctorAPI.services.DoctorService;


@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@PostMapping
	public ResponseEntity<DoctorDTO> createDoctor(@Validated @RequestBody DoctorDTO doctorDTO) {
		DoctorDTO createdDoctor = doctorService.createDoctor(doctorDTO);
		return ResponseEntity.ok(createdDoctor);
	}

	@GetMapping("/{doctorId}")
	public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable Long doctorId) {
		DoctorDTO doctorDTO = doctorService.getDoctorById(doctorId);
		return ResponseEntity.ok(doctorDTO);
	}

	@GetMapping
	public ResponseEntity<List<DoctorDTO>> getAllDoctors() {
		List<DoctorDTO> doctors = doctorService.getAllDoctors();
		return ResponseEntity.ok(doctors);
	}
}