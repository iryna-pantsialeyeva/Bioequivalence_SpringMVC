package by.freeit.repository;

import by.freeit.model.Patient;

import java.util.List;

public interface PatientRepository {
    List<Patient> getAllPatients();

    int savePatient(Patient patient);

    Patient getPatientByID(int id);

    int updatePatient(Patient patient);

    int deletePatient(int id);
}
