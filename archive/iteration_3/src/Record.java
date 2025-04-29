/**
 * @author mandyho
 * abstract record class
 */
public abstract class Record {
    protected String recordId;
    protected Patient patient;
    protected Clinic clinic;
    protected Visit visit;

    public Record(Patient patient, Clinic clinic, Visit visit) {
        this.recordId = IDGenerator.getInstance().generateRecordId();
        this.patient = patient;
        this.clinic = clinic;
        this.visit = visit;
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
}