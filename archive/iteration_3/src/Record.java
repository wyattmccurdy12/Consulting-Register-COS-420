public abstract class Record {
    protected String recordId;
    protected Patient patient;
    protected Clinic clinic;
    protected Visit visit;
    protected ChildAssessment childAssessment;  // Add a ChildAssessment attribute.

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

    public String getRecordId() {
        return recordId;
    }

    public Patient getPatient() {
        return patient;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public Visit getVisit() {
        return visit;
    }

    public ChildAssessment getChildAssessment() {
        return childAssessment;
    }

    public void setChildAssessment(ChildAssessment childAssessment) {
        this.childAssessment = childAssessment;
    }
}