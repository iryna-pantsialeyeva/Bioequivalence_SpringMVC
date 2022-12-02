package by.freeit.repository;

import by.freeit.model.Patient;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component("patientMapper")
public class PatientMapper implements RowMapper<Patient> {

    @Override
    public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
        Patient patient = new Patient();
        patient.setId(rs.getInt("id"));
        patient.setLastName(rs.getString("name"));
        patient.setMedicine(rs.getString("medicine"));
        patient.setBloodConcentration0(rs.getInt("blood_conc0"));
        patient.setBloodConcentration15(rs.getInt("blood_conc15"));
        patient.setBloodConcentration30(rs.getInt("blood_conc30"));
        return patient;
    }
}
