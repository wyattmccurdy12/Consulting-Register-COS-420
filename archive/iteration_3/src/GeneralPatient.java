package src;
import java.util.Date;
import java.util.List;

public class GeneralPatient extends Patient {

    public GeneralPatient(String patientId, Date dateOfBirth, String name, String outPatientNumber,
                          String healthInsuranceNumber, String nationalIdentificationNumber,
                          String address, String sex, int age, String motherId, List<Record> records) {
        super(patientId, dateOfBirth, name, outPatientNumber, healthInsuranceNumber,
              nationalIdentificationNumber, address, sex, age, motherId, records);
    }

    // No extra fields yet, but can be added later if needed
}
