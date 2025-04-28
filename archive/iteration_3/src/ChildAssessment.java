package src;
public class ChildAssessment {
    private String childAttributes;
    private boolean tempForFever;
    private boolean respirationForPneumonia;
    private boolean palmarPallorForAnemia;
    private boolean pulseRateForStridor;
    private boolean pulseRateForMalaria;
    private boolean pulseRatePneumonia;
    private boolean bloodInStoolForDysentery;
    private boolean bulgingFontanelForInfection;
    private boolean elasticityOfSkinForDehydration;
    private boolean skinRashes;
    private boolean reddeningOfCordForCordInfection;
    private boolean signsOfConvulsionOrHistoryOfConvulsion;
    private boolean lethargy;

    // Constructor
    public ChildAssessment(String childAttributes, boolean tempForFever, boolean respirationForPneumonia,
                           boolean palmarPallorForAnemia, boolean pulseRateForStridor, boolean pulseRateForMalaria,
                           boolean pulseRatePneumonia, boolean bloodInStoolForDysentery, boolean bulgingFontanelForInfection,
                           boolean elasticityOfSkinForDehydration, boolean skinRashes, boolean reddeningOfCordForCordInfection,
                           boolean signsOfConvulsionOrHistoryOfConvulsion, boolean lethargy) {
        this.childAttributes = childAttributes;
        this.tempForFever = tempForFever;
        this.respirationForPneumonia = respirationForPneumonia;
        this.palmarPallorForAnemia = palmarPallorForAnemia;
        this.pulseRateForStridor = pulseRateForStridor;
        this.pulseRateForMalaria = pulseRateForMalaria;
        this.pulseRatePneumonia = pulseRatePneumonia;
        this.bloodInStoolForDysentery = bloodInStoolForDysentery;
        this.bulgingFontanelForInfection = bulgingFontanelForInfection;
        this.elasticityOfSkinForDehydration = elasticityOfSkinForDehydration;
        this.skinRashes = skinRashes;
        this.reddeningOfCordForCordInfection = reddeningOfCordForCordInfection;
        this.signsOfConvulsionOrHistoryOfConvulsion = signsOfConvulsionOrHistoryOfConvulsion;
        this.lethargy = lethargy;
    }

    // Getters and Setters
    public String getChildAttributes() {
        return childAttributes;
    }

    public void setChildAttributes(String childAttributes) {
        this.childAttributes = childAttributes;
    }

    public boolean isTempForFever() {
        return tempForFever;
    }

    public void setTempForFever(boolean tempForFever) {
        this.tempForFever = tempForFever;
    }

    public boolean isRespirationForPneumonia() {
        return respirationForPneumonia;
    }

    public void setRespirationForPneumonia(boolean respirationForPneumonia) {
        this.respirationForPneumonia = respirationForPneumonia;
    }

    public boolean isPalmarPallorForAnemia() {
        return palmarPallorForAnemia;
    }

    public void setPalmarPallorForAnemia(boolean palmarPallorForAnemia) {
        this.palmarPallorForAnemia = palmarPallorForAnemia;
    }

    public boolean isPulseRateForStridor() {
        return pulseRateForStridor;
    }

    public void setPulseRateForStridor(boolean pulseRateForStridor) {
        this.pulseRateForStridor = pulseRateForStridor;
    }

    public boolean isPulseRateForMalaria() {
        return pulseRateForMalaria;
    }

    public void setPulseRateForMalaria(boolean pulseRateForMalaria) {
        this.pulseRateForMalaria = pulseRateForMalaria;
    }

    public boolean isPulseRatePneumonia() {
        return pulseRatePneumonia;
    }

    public void setPulseRatePneumonia(boolean pulseRatePneumonia) {
        this.pulseRatePneumonia = pulseRatePneumonia;
    }

    public boolean isBloodInStoolForDysentery() {
        return bloodInStoolForDysentery;
    }

    public void setBloodInStoolForDysentery(boolean bloodInStoolForDysentery) {
        this.bloodInStoolForDysentery = bloodInStoolForDysentery;
    }

    public boolean isBulgingFontanelForInfection() {
        return bulgingFontanelForInfection;
    }

    public void setBulgingFontanelForInfection(boolean bulgingFontanelForInfection) {
        this.bulgingFontanelForInfection = bulgingFontanelForInfection;
    }

    public boolean isElasticityOfSkinForDehydration() {
        return elasticityOfSkinForDehydration;
    }

    public void setElasticityOfSkinForDehydration(boolean elasticityOfSkinForDehydration) {
        this.elasticityOfSkinForDehydration = elasticityOfSkinForDehydration;
    }

    public boolean isSkinRashes() {
        return skinRashes;
    }

    public void setSkinRashes(boolean skinRashes) {
        this.skinRashes = skinRashes;
    }

    public boolean isReddeningOfCordForCordInfection() {
        return reddeningOfCordForCordInfection;
    }

    public void setReddeningOfCordForCordInfection(boolean reddeningOfCordForCordInfection) {
        this.reddeningOfCordForCordInfection = reddeningOfCordForCordInfection;
    }

    public boolean isSignsOfConvulsionOrHistoryOfConvulsion() {
        return signsOfConvulsionOrHistoryOfConvulsion;
    }

    public void setSignsOfConvulsionOrHistoryOfConvulsion(boolean signsOfConvulsionOrHistoryOfConvulsion) {
        this.signsOfConvulsionOrHistoryOfConvulsion = signsOfConvulsionOrHistoryOfConvulsion;
    }

    public boolean isLethargy() {
        return lethargy;
    }

    public void setLethargy(boolean lethargy) {
        this.lethargy = lethargy;
    }
}
