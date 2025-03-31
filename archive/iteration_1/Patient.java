public class Patient {
    private String patientId;
    private String dateOfBirth;
    private String name;
    private String outPatientNumber;
    private String healthInsuranceNumber;
    private String nationalIdentificationNumber;
    private String address;
    private String sex;

    // Constructor
    public Patient(String patientId, String dateOfBirth, String name, String outPatientNumber, 
                   String healthInsuranceNumber, String nationalIdentificationNumber, 
                   String address, String sex) {
        this.patientId = patientId;
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.outPatientNumber = outPatientNumber;
        this.healthInsuranceNumber = healthInsuranceNumber;
        this.nationalIdentificationNumber = nationalIdentificationNumber;
        this.address = address;
        this.sex = sex;
    }

    // Getters and Setters (optional, if needed)
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOutPatientNumber() {
        return outPatientNumber;
    }

    public void setOutPatientNumber(String outPatientNumber) {
        this.outPatientNumber = outPatientNumber;
    }

    public String getHealthInsuranceNumber() {
        return healthInsuranceNumber;
    }

    public void setHealthInsuranceNumber(String healthInsuranceNumber) {
        this.healthInsuranceNumber = healthInsuranceNumber;
    }

    public String getNationalIdentificationNumber() {
        return nationalIdentificationNumber;
    }

    public void setNationalIdentificationNumber(String nationalIdentificationNumber) {
        this.nationalIdentificationNumber = nationalIdentificationNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}