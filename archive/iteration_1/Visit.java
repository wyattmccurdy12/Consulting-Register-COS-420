public class Visit {
    private String patientId;
    private String clinicId;
    private String date;
    private String bloodPressure;
    private String pulse;
    private String temperature;
    private String weight;
    private String respiration;
    private String conditionHistory;
    private String principalDiagnosis;
    private String additionalDiagnosis;
    private String treatmentGiven;
    private String referred;
    private String outcomeOfReferral;
    private String costOfTreatment;
    private String remarks;
    private String child;
    private String childAttributes;
    private String childTempForFever;
    private String childRespirationForPneumonia;
    private String childPalmarPallorForAnemia;
    private String childPulseRateForStridor;
    private String childPulseRateForMalaria;
    private String childPulseRatePneumonia;
    private String childBloodInStoolForDysentery;
    private String childBulgingFontanelForInfection;
    private String childElasticityOfSkinForDehydration;
    private String childSkinRashes;
    private String childReddeningOfCordForCordInfection;
    private String childSignsOfConvulsionOrHistoryOfConvulsion;
    private String childLethargy;

    // Constructor
    public Visit(String patientId, String clinicId, String date, String bloodPressure, String pulse, String temperature,
                 String weight, String respiration, String conditionHistory, String principalDiagnosis,
                 String additionalDiagnosis, String treatmentGiven, String referred, String outcomeOfReferral,
                 String costOfTreatment, String remarks, String child, String childAttributes, String childTempForFever,
                 String childRespirationForPneumonia, String childPalmarPallorForAnemia, String childPulseRateForStridor,
                 String childPulseRateForMalaria, String childPulseRatePneumonia, String childBloodInStoolForDysentery,
                 String childBulgingFontanelForInfection, String childElasticityOfSkinForDehydration, String childSkinRashes,
                 String childReddeningOfCordForCordInfection, String childSignsOfConvulsionOrHistoryOfConvulsion,
                 String childLethargy) {
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
        this.child = child;
        this.childAttributes = childAttributes;
        this.childTempForFever = childTempForFever;
        this.childRespirationForPneumonia = childRespirationForPneumonia;
        this.childPalmarPallorForAnemia = childPalmarPallorForAnemia;
        this.childPulseRateForStridor = childPulseRateForStridor;
        this.childPulseRateForMalaria = childPulseRateForMalaria;
        this.childPulseRatePneumonia = childPulseRatePneumonia;
        this.childBloodInStoolForDysentery = childBloodInStoolForDysentery;
        this.childBulgingFontanelForInfection = childBulgingFontanelForInfection;
        this.childElasticityOfSkinForDehydration = childElasticityOfSkinForDehydration;
        this.childSkinRashes = childSkinRashes;
        this.childReddeningOfCordForCordInfection = childReddeningOfCordForCordInfection;
        this.childSignsOfConvulsionOrHistoryOfConvulsion = childSignsOfConvulsionOrHistoryOfConvulsion;
        this.childLethargy = childLethargy;
    }
}