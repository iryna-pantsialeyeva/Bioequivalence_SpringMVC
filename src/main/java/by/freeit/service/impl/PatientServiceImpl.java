package by.freeit.service.impl;

import by.freeit.model.Patient;
import by.freeit.repository.PatientRepository;
import by.freeit.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.getAllPatients();
    }

    @Override
    public int savePatient(Patient patient) {
        if(patient.getId()==0) {
            return patientRepository.savePatient(patient);
        } else {
            return patientRepository.updatePatient(patient);
        }
    }

    @Override
    public Patient getPatientByID(int id) {
        return patientRepository.getPatientByID(id);
    }

    @Override
    public int deletePatient(int id) {
        return patientRepository.deletePatient(id);
    }
}
