import java.util.Date;

/**
 * Represents a visit to a clinic by a patient. It includes details about the visit,
 * such as the patient's condition, diagnosis, treatment, and optional child assessment.
 */
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
    
    /**
     * Constructs a Visit object for non-child patients without a child assessment.
     *
     * @param patientId The ID of the patient.
     * @param clinicId The ID of the clinic.
     * @param date The date of the visit.
     * @param bloodPressure The blood pressure reading during the visit.
     * @param pulse The pulse reading during the visit.
     * @param temperature The temperature reading during the visit.
     * @param weight The weight of the patient during the visit.
     * @param respiration The respiration rate during the visit.
     * @param conditionHistory The history of the patient's condition.
     * @param principalDiagnosis The principal diagnosis made during the visit.
     * @param additionalDiagnosis Any additional diagnoses made during the visit.
     * @param treatmentGiven The treatment provided during the visit.
     * @param referred Whether the patient was referred to another facility.
     * @param outcomeOfReferral The outcome of the referral, if applicable.
     * @param costOfTreatment The cost of the treatment provided.
     * @param remarks Additional remarks about the visit.
     */
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

    /**
     * Constructs a Visit object for child patients with a child assessment.
     *
     * @param patientId The ID of the patient.
     * @param clinicId The ID of the clinic.
     * @param date The date of the visit.
     * @param bloodPressure The blood pressure reading during the visit.
     * @param pulse The pulse reading during the visit.
     * @param temperature The temperature reading during the visit.
     * @param weight The weight of the patient during the visit.
     * @param respiration The respiration rate during the visit.
     * @param conditionHistory The history of the patient's condition.
     * @param principalDiagnosis The principal diagnosis made during the visit.
     * @param additionalDiagnosis Any additional diagnoses made during the visit.
     * @param treatmentGiven The treatment provided during the visit.
     * @param referred Whether the patient was referred to another facility.
     * @param outcomeOfReferral The outcome of the referral, if applicable.
     * @param costOfTreatment The cost of the treatment provided.
     * @param remarks Additional remarks about the visit.
     * @param childAssessment The child assessment details for the visit.
     */
    public Visit(String patientId, String clinicId, Date date, String bloodPressure, String pulse, float temperature,
                 float weight, String respiration, String conditionHistory, String principalDiagnosis,
                 String additionalDiagnosis, String treatmentGiven, boolean referred, String outcomeOfReferral,
                 float costOfTreatment, String remarks, ChildAssessment childAssessment) {
        this(patientId, clinicId, date, bloodPressure, pulse, temperature, weight, respiration, conditionHistory,
             principalDiagnosis, additionalDiagnosis, treatmentGiven, referred, outcomeOfReferral, costOfTreatment, remarks);
        this.childAssessment = childAssessment;
    }
    /**
     * Gets the ID of the patient associated with the visit.
     *
     * @return The patient ID.
     */
    public String getPatientId() {
        return patientId;
    }

    /**
     * Sets the ID of the patient associated with the visit.
     *
     * @param patientId The patient ID to set.
     */
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    /**
     * Gets the ID of the clinic where the visit occurred.
     *
     * @return The clinic ID.
     */
    public String getClinicId() {
        return clinicId;
    }

    /**
     * Sets the ID of the clinic where the visit occurred.
     *
     * @param clinicId The clinic ID to set.
     */
    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }

    /**
     * Gets the date of the visit.
     *
     * @return The date of the visit.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the visit.
     *
     * @param date The date to set.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets the blood pressure reading during the visit.
     *
     * @return The blood pressure reading.
     */
    public String getBloodPressure() {
        return bloodPressure;
    }

    /**
     * Sets the blood pressure reading during the visit.
     *
     * @param bloodPressure The blood pressure reading to set.
     */
    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    /**
     * Gets the pulse reading during the visit.
     *
     * @return The pulse reading.
     */
    public String getPulse() {
        return pulse;
    }

    /**
     * Sets the pulse reading during the visit.
     *
     * @param pulse The pulse reading to set.
     */
    public void setPulse(String pulse) {
        this.pulse = pulse;
    }

    /**
     * Gets the temperature reading during the visit.
     *
     * @return The temperature reading.
     */
    public float getTemperature() {
        return temperature;
    }

    /**
     * Sets the temperature reading during the visit.
     *
     * @param temperature The temperature reading to set.
     */
    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    /**
     * Gets the weight of the patient during the visit.
     *
     * @return The weight of the patient.
     */
    public float getWeight() {
        return weight;
    }

    /**
     * Sets the weight of the patient during the visit.
     *
     * @param weight The weight to set.
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     * Gets the respiration rate during the visit.
     *
     * @return The respiration rate.
     */
    public String getRespiration() {
        return respiration;
    }

    /**
     * Sets the respiration rate during the visit.
     *
     * @param respiration The respiration rate to set.
     */
    public void setRespiration(String respiration) {
        this.respiration = respiration;
    }

    /**
     * Gets the history of the patient's condition.
     *
     * @return The condition history.
     */
    public String getConditionHistory() {
        return conditionHistory;
    }

    /**
     * Sets the history of the patient's condition.
     *
     * @param conditionHistory The condition history to set.
     */
    public void setConditionHistory(String conditionHistory) {
        this.conditionHistory = conditionHistory;
    }

    /**
     * Gets the principal diagnosis made during the visit.
     *
     * @return The principal diagnosis.
     */
    public String getPrincipalDiagnosis() {
        return principalDiagnosis;
    }

    /**
     * Sets the principal diagnosis made during the visit.
     *
     * @param principalDiagnosis The principal diagnosis to set.
     */
    public void setPrincipalDiagnosis(String principalDiagnosis) {
        this.principalDiagnosis = principalDiagnosis;
    }

    /**
     * Gets any additional diagnoses made during the visit.
     *
     * @return The additional diagnoses.
     */
    public String getAdditionalDiagnosis() {
        return additionalDiagnosis;
    }

    /**
     * Sets any additional diagnoses made during the visit.
     *
     * @param additionalDiagnosis The additional diagnoses to set.
     */
    public void setAdditionalDiagnosis(String additionalDiagnosis) {
        this.additionalDiagnosis = additionalDiagnosis;
    }

    /**
     * Gets the treatment provided during the visit.
     *
     * @return The treatment provided.
     */
    public String getTreatmentGiven() {
        return treatmentGiven;
    }

    /**
     * Sets the treatment provided during the visit.
     *
     * @param treatmentGiven The treatment provided to set.
     */
    public void setTreatmentGiven(String treatmentGiven) {
        this.treatmentGiven = treatmentGiven;
    }

    /**
     * Gets whether the patient was referred to another facility.
     *
     * @return True if the patient was referred, false otherwise.
     */
    public boolean isReferred() {
        return referred;
    }

    /**
     * Sets whether the patient was referred to another facility.
     *
     * @param referred True if the patient was referred, false otherwise.
     */
    public void setReferred(boolean referred) {
        this.referred = referred;
    }

    /**
     * Gets the outcome of the referral, if applicable.
     *
     * @return The outcome of the referral.
     */
    public String getOutcomeOfReferral() {
        return outcomeOfReferral;
    }

    /**
     * Sets the outcome of the referral, if applicable.
     *
     * @param outcomeOfReferral The outcome of the referral to set.
     */
    public void setOutcomeOfReferral(String outcomeOfReferral) {
        this.outcomeOfReferral = outcomeOfReferral;
    }

    /**
     * Gets the cost of the treatment provided.
     *
     * @return The cost of the treatment.
     */
    public float getCostOfTreatment() {
        return costOfTreatment;
    }

    /**
     * Sets the cost of the treatment provided.
     *
     * @param costOfTreatment The cost of the treatment to set.
     */
    public void setCostOfTreatment(float costOfTreatment) {
        this.costOfTreatment = costOfTreatment;
    }

    /**
     * Gets additional remarks about the visit.
     *
     * @return Additional remarks about the visit.
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Sets additional remarks about the visit.
     *
     * @param remarks Additional remarks about the visit to set.
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * Gets the child assessment associated with the visit.
     *
     * @return The child assessment, or null if not applicable.
     */
    public ChildAssessment getChildAssessment() {
        return childAssessment;
    }

    /**
     * Sets the child assessment for the visit.
     *
     * @param childAssessment The child assessment to set.
     */
    public void setChildAssessment(ChildAssessment childAssessment) {
        this.childAssessment = childAssessment;
    }

    @Override
    public String toString() {
        return String.format(
            "Visit Date: %s, Clinic ID: %s, Blood Pressure: %s, Pulse: %s, Temperature: %.1f, Weight: %.1f, Respiration: %s, " +
            "Condition History: %s, Principal Diagnosis: %s, Additional Diagnosis: %s, Treatment Given: %s, Referred: %b, " +
            "Outcome of Referral: %s, Cost of Treatment: %.2f, Remarks: %s",
            date, clinicId, bloodPressure, pulse, temperature, weight, respiration, conditionHistory, principalDiagnosis,
            additionalDiagnosis, treatmentGiven, referred, outcomeOfReferral, costOfTreatment, remarks
        );
    }
}