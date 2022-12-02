package by.freeit.service;

import by.freeit.model.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getAllPatients();

    int savePatient(Patient patient);

    Patient getPatientByID(int id);

    int deletePatient(int id);
}
