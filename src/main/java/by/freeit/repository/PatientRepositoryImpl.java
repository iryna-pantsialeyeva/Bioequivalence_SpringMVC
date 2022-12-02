package by.freeit.repository;

import by.freeit.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientRepositoryImpl implements PatientRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private PatientMapper patientMapper;
    private static final String GET_ALL_PATIENTS = "select * from patients";
    private static final String SAVE_PATIENT = "insert into patients(name, medicine, " +
            "blood_conc0, blood_conc15, blood_conc30) values(?,?,?,?,?)";

    private static final String GET_PATIENT_BY_ID = "select * from patients where id=?";

    private static final String UPDATE_PATIENT = "update patients set name=?, medicine=?, blood_conc0=?, " +
            "blood_conc15=?, blood_conc30=? where id=?";

    private static final String DELETE_PATIENT = "delete from patients where id=?";

    @Override
    public List<Patient> getAllPatients() {
        return jdbcTemplate.query(GET_ALL_PATIENTS, (rs, rowNum) -> new Patient
                (rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("medicine"),
                        rs.getInt("blood_conc0"),
                        rs.getInt("blood_conc15"),
                        rs.getInt("blood_conc30")
                )
        );
    }

    @Override
    public int savePatient(Patient patient) {
        return jdbcTemplate.update(SAVE_PATIENT, patient.getLastName(), patient.getMedicine(),
                patient.getBloodConcentration0(), patient.getBloodConcentration15(),
                patient.getBloodConcentration30());
    }

    @Override
    public Patient getPatientByID(int id) {
        return jdbcTemplate.query(GET_PATIENT_BY_ID, patientMapper, id).get(0);
    }

    @Override
    public int updatePatient(Patient patient) {
        return jdbcTemplate.update(UPDATE_PATIENT, patient.getLastName(), patient.getMedicine(),
                patient.getBloodConcentration0(), patient.getBloodConcentration15(), patient.getBloodConcentration30(),
                patient.getId());
    }

    @Override
    public int deletePatient(int id) {
        return jdbcTemplate.update(DELETE_PATIENT, id);
    }
}
