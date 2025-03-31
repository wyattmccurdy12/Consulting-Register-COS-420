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
    private boolean child;
    private String childAttributes;
    private boolean childTempForFever;
    private boolean childRespirationForPneumonia;
    private boolean childPalmarPallorForAnemia;
    private boolean childPulseRateForStridor;
    private boolean childPulseRateForMalaria;
    private boolean childPulseRatePneumonia;
    private boolean childBloodInStoolForDysentery;
    private boolean childBulgingFontanelForInfection;
    private boolean childElasticityOfSkinForDehydration;
    private boolean childSkinRashes;
    private boolean childReddeningOfCordForCordInfection;
    private boolean childSignsOfConvulsionOrHistoryOfConvulsion;
    private boolean childLethargy;

    // Constructor
    public Visit(String patientId, String clinicId, Date date, String bloodPressure, String pulse, float temperature,
                 float weight, String respiration, String conditionHistory, String principalDiagnosis,
                 String additionalDiagnosis, String treatmentGiven, boolean referred, String outcomeOfReferral,
                 float costOfTreatment, String remarks, boolean child, String childAttributes, boolean childTempForFever,
                 boolean childRespirationForPneumonia, boolean childPalmarPallorForAnemia, boolean childPulseRateForStridor,
                 boolean childPulseRateForMalaria, boolean childPulseRatePneumonia, boolean childBloodInStoolForDysentery,
                 boolean childBulgingFontanelForInfection, boolean childElasticityOfSkinForDehydration, boolean childSkinRashes,
                 boolean childReddeningOfCordForCordInfection, boolean childSignsOfConvulsionOrHistoryOfConvulsion,
                 boolean childLethargy) {
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