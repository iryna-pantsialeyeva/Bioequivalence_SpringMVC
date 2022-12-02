package by.freeit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    private int id;
    private String lastName;
    private String medicine;
    private int bloodConcentration0;
    private int bloodConcentration15;
    private int bloodConcentration30;

    public Patient(String lastName, String medicine, int bloodConcentration0,
                   int bloodConcentration15, int bloodConcentration30) {
        this.lastName = lastName;
        this.medicine = medicine;
        this.bloodConcentration0 = bloodConcentration0;
        this.bloodConcentration15 = bloodConcentration15;
        this.bloodConcentration30 = bloodConcentration30;
    }
}
