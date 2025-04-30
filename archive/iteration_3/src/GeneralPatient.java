import java.util.Date;
import java.util.List;

/**
 * Represents a general patient in the system. This class extends the Patient class
 * and can be used for patients who do not require specialized assessments.
 */
public class GeneralPatient extends Patient {

    /**
     * Constructs a GeneralPatient object with the specified details.
     *
     * @param dateOfBirth The date of birth of the patient.
     * @param name The name of the patient.
     * @param outPatientNumber The outpatient number of the patient.
     * @param healthInsuranceNumber The health insurance number of the patient.
     * @param nationalIdentificationNumber The national identification number of the patient.
     * @param address The address of the patient.
     * @param sex The sex of the patient.
     * @param age The age of the patient.
     * @param motherId The ID of the patient's mother (if applicable).
     * @param records The list of medical records associated with the patient.
     */
    public GeneralPatient(Date dateOfBirth, String name, String outPatientNumber,
                          String healthInsuranceNumber, String nationalIdentificationNumber,
                          String address, String sex, int age, String motherId, List<Record> records) {
        super(dateOfBirth, name, outPatientNumber, healthInsuranceNumber, nationalIdentificationNumber,
                address, sex, age, motherId, records);
    }

    // No extra fields yet, but can be added later if needed
}
