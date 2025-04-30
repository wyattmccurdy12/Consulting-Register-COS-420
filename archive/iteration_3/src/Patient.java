import java.util.Date;
import java.util.List;

/**
 * Represents a patient in the system. This is an abstract class that serves as a base
 * for different types of patients, such as general patients or specialized patients.
 */
public abstract class Patient {
    private String patientId;
    private Date dateOfBirth;
    private String name;
    private String outPatientNumber;
    private String healthInsuranceNumber;
    private String nationalIdentificationNumber;
    private String address;
    private String sex;
    private int age;
    private String motherId;
    private List<Record> records;

    /**
     * Constructs a Patient object with the specified details.
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
    public Patient(Date dateOfBirth, String name, String outPatientNumber,
                   String healthInsuranceNumber, String nationalIdentificationNumber, 
                   String address, String sex, int age, String motherId, List<Record> records) {
        this.patientId = IDGenerator.getInstance().generatePatientId();
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.outPatientNumber = outPatientNumber;
        this.healthInsuranceNumber = healthInsuranceNumber;
        this.nationalIdentificationNumber = nationalIdentificationNumber;
        this.address = address;
        this.sex = sex;
        this.age = age;
        this.motherId = motherId;
        this.records = records;
    }

    /**
     * Gets the unique patient ID.
     *
     * @return The patient ID.
     */
    public String getPatientId() {
        return patientId;
    }

    /**
     * Throws an exception as the patient ID is system-generated and cannot be manually set.
     *
     * @param patientId The patient ID to set (not allowed).
     */
    public void setPatientId(String patientId) {
        throw new UnsupportedOperationException("Patient ID can only be system-generated and cannot be manually set.");
    }

    /**
     * Gets the date of birth of the patient.
     *
     * @return The date of birth.
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of birth of the patient.
     *
     * @param dateOfBirth The date of birth to set.
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets the name of the patient.
     *
     * @return The name of the patient.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the patient.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the outpatient number of the patient.
     *
     * @return The outpatient number.
     */
    public String getOutPatientNumber() {
        return outPatientNumber;
    }

    /**
     * Sets the outpatient number of the patient.
     *
     * @param outPatientNumber The outpatient number to set.
     */
    public void setOutPatientNumber(String outPatientNumber) {
        this.outPatientNumber = outPatientNumber;
    }

    /**
     * Gets the health insurance number of the patient.
     *
     * @return The health insurance number.
     */
    public String getHealthInsuranceNumber() {
        return healthInsuranceNumber;
    }

    /**
     * Sets the health insurance number of the patient.
     *
     * @param healthInsuranceNumber The health insurance number to set.
     */
    public void setHealthInsuranceNumber(String healthInsuranceNumber) {
        this.healthInsuranceNumber = healthInsuranceNumber;
    }

    /**
     * Gets the national identification number of the patient.
     *
     * @return The national identification number.
     */
    public String getNationalIdentificationNumber() {
        return nationalIdentificationNumber;
    }

    /**
     * Sets the national identification number of the patient.
     *
     * @param nationalIdentificationNumber The national identification number to set.
     */
    public void setNationalIdentificationNumber(String nationalIdentificationNumber) {
        this.nationalIdentificationNumber = nationalIdentificationNumber;
    }

    /**
     * Gets the address of the patient.
     *
     * @return The address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the patient.
     *
     * @param address The address to set.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the sex of the patient.
     *
     * @return The sex.
     */
    public String getSex() {
        return sex;
    }

    /**
     * Sets the sex of the patient.
     *
     * @param sex The sex to set.
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Gets the age of the patient.
     *
     * @return The age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the patient.
     *
     * @param age The age to set.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the ID of the patient's mother.
     *
     * @return The mother ID.
     */
    public String getMotherId() {
        return motherId;
    }

    /**
     * Sets the ID of the patient's mother.
     *
     * @param motherId The mother ID to set.
     */
    public void setMotherId(String motherId) {
        this.motherId = motherId;
    }

    /**
     * Links the mother's medical records to the patient's records.
     *
     * @param motherRecords The list of the mother's medical records.
     */
    public void linkMotherRecords(List<Record> motherRecords) {
        if (motherRecords != null && !motherRecords.isEmpty()) {
            this.records.addAll(motherRecords);
        }
    }

    /**
     * Gets the list of medical records associated with the patient.
     *
     * @return The list of medical records.
     */
    public List<Record> getRecords() {
        return records;
    }

    /**
     * Sets the list of medical records associated with the patient.
     *
     * @param records The list of medical records to set.
     */
    public void setRecords(List<Record> records) {
        this.records = records;
    }
}