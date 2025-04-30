/**
 * Represents a medical record associated with a patient, clinic, and visit.
 * This is an abstract class that can be extended for specific types of records.
 */
public abstract class Record {
    protected String recordId;
    protected Patient patient;
    protected Clinic clinic;
    protected Visit visit;
    protected ChildAssessment childAssessment;  // Add a ChildAssessment attribute.

    /**
     * Constructs a Record object with the specified patient, clinic, and visit.
     * Automatically generates a unique record ID and initializes a ChildAssessment
     * if the patient's age is less than 5.
     *
     * @param patient The patient associated with the record.
     * @param clinic The clinic where the record was created.
     * @param visit The visit associated with the record.
     */
    public Record(Patient patient, Clinic clinic, Visit visit) {
        this.recordId = IDGenerator.getInstance().generateRecordId();
        this.patient = patient;
        this.clinic = clinic;
        this.visit = visit;

        if (patient.getAge() < 5) {
            this.childAssessment = new ChildAssessment("Default Attributes", false, false, false, false, false, false, false, false, false, false, false, false);
        } else {
            this.childAssessment = null;
        }
    }

    /**
     * Gets the unique record ID.
     *
     * @return The record ID.
     */
    public String getRecordId() {
        return recordId;
    }

    /**
     * Gets the patient associated with the record.
     *
     * @return The patient.
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Gets the clinic associated with the record.
     *
     * @return The clinic.
     */
    public Clinic getClinic() {
        return clinic;
    }

    /**
     * Gets the visit associated with the record.
     *
     * @return The visit.
     */
    public Visit getVisit() {
        return visit;
    }

    /**
     * Gets the child assessment associated with the record.
     *
     * @return The child assessment, or null if not applicable.
     */
    public ChildAssessment getChildAssessment() {
        return childAssessment;
    }

    /**
     * Sets the child assessment for the record.
     *
     * @param childAssessment The child assessment to set.
     */
    public void setChildAssessment(ChildAssessment childAssessment) {
        this.childAssessment = childAssessment;
    }
}