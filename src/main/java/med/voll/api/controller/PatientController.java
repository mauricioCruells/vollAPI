package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.patient.CreatePatientDto;
import med.voll.api.patient.Patient;
import med.voll.api.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/patients")
public class PatientController {
  @Autowired
  private PatientRepository patientRepository;

  @PostMapping
  public void createOnePatient(
    @RequestBody @Valid CreatePatientDto patientInfo
  ) {
    Patient patient = new Patient(patientInfo);
    patientRepository.save(patient);
  }
}
