package src;
import java.util.Date;
public class Visit {
    private String patientId;
    private String clinicId;
    private Date date;
    private String bloodPressure;
    private String pulse;
    private float temperature;
    private float weight;
    private String respiration;
    private String conditionHistory;
    private String principalDiagnosis;
    private String additionalDiagnosis;
    private String treatmentGiven;
    private boolean referred;
    private String outcomeOfReferral;
    private float costOfTreatment;
    private String remarks;
    // Instead of many child-specific fields, we now use a ChildAssessment object.
    private ChildAssessment childAssessment;
    
    // Constructor for Visit without child assessment for non-child patients
    public Visit(String patientId, String clinicId, Date date, String bloodPressure, String pulse, float temperature,
                 float weight, String respiration, String conditionHistory, String principalDiagnosis,
                 String additionalDiagnosis, String treatmentGiven, boolean referred, String outcomeOfReferral,
                 float costOfTreatment, String remarks) {
        this.patientId = patientId;
        this.clinicId = clinicId;
        this.date = date;
        this.bloodPressure = bloodPressure;
        this.pulse = pulse;
        this.temperature = temperature;
        this.weight = weight;
        this.respiration = respiration;
        this.conditionHistory = conditionHistory;
        this.principalDiagnosis = principalDiagnosis;
        this.additionalDiagnosis = additionalDiagnosis;
        this.treatmentGiven = treatmentGiven;
        this.referred = referred;
        this.outcomeOfReferral = outcomeOfReferral;
        this.costOfTreatment = costOfTreatment;
        this.remarks = remarks;
    }

    // constructor for Visit with child assessment details
    public Visit(String patientId, String clinicId, Date date, String bloodPressure, String pulse, float temperature,
                 float weight, String respiration, String conditionHistory, String principalDiagnosis,
                 String additionalDiagnosis, String treatmentGiven, boolean referred, String outcomeOfReferral,
                 float costOfTreatment, String remarks, ChildAssessment childAssessment) {
        this(patientId, clinicId, date, bloodPressure, pulse, temperature, weight, respiration, conditionHistory,
             principalDiagnosis, additionalDiagnosis, treatmentGiven, referred, outcomeOfReferral, costOfTreatment, remarks);
        this.childAssessment = childAssessment;
    }
    // Getters and Setters
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getPulse() {
        return pulse;
    }

    public void setPulse(String pulse) {
        this.pulse = pulse;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getRespiration() {
        return respiration;
    }

    public void setRespiration(String respiration) {
        this.respiration = respiration;
    }

    public String getConditionHistory() {
        return conditionHistory;
    }

    public void setConditionHistory(String conditionHistory) {
        this.conditionHistory = conditionHistory;
    }

    public String getPrincipalDiagnosis() {
        return principalDiagnosis;
    }

    public void setPrincipalDiagnosis(String principalDiagnosis) {
        this.principalDiagnosis = principalDiagnosis;
    }

    public String getAdditionalDiagnosis() {
        return additionalDiagnosis;
    }

    public void setAdditionalDiagnosis(String additionalDiagnosis) {
        this.additionalDiagnosis = additionalDiagnosis;
    }

    public String getTreatmentGiven() {
        return treatmentGiven;
    }

    public void setTreatmentGiven(String treatmentGiven) {
        this.treatmentGiven = treatmentGiven;
    }

    public boolean isReferred() {
        return referred;
    }

    public void setReferred(boolean referred) {
        this.referred = referred;
    }

    public String getOutcomeOfReferral() {
        return outcomeOfReferral;
    }

    public void setOutcomeOfReferral(String outcomeOfReferral) {
        this.outcomeOfReferral = outcomeOfReferral;
    }

    public float getCostOfTreatment() {
        return costOfTreatment;
    }

    public void setCostOfTreatment(float costOfTreatment) {
        this.costOfTreatment = costOfTreatment;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public ChildAssessment getChildAssessment() {
        return childAssessment;
    }

    public void setChildAssessment(ChildAssessment childAssessment) {
        this.childAssessment = childAssessment;
    }
}