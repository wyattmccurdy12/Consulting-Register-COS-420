/**
 * Represents an assessment of a child based on various health indicators.
 */
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

    /**
     * Constructs a new ChildAssessment object with the specified attributes and health indicators.
     *
     * @param childAttributes Attributes of the child.
     * @param tempForFever Indicates if the child has a fever.
     * @param respirationForPneumonia Indicates if the child shows signs of pneumonia.
     * @param palmarPallorForAnemia Indicates if the child has palmar pallor for anemia.
     * @param pulseRateForStridor Indicates if the child has an abnormal pulse rate for stridor.
     * @param pulseRateForMalaria Indicates if the child has an abnormal pulse rate for malaria.
     * @param pulseRatePneumonia Indicates if the child has an abnormal pulse rate for pneumonia.
     * @param bloodInStoolForDysentery Indicates if the child has blood in stool for dysentery.
     * @param bulgingFontanelForInfection Indicates if the child has a bulging fontanel for infection.
     * @param elasticityOfSkinForDehydration Indicates if the child shows signs of dehydration.
     * @param skinRashes Indicates if the child has skin rashes.
     * @param reddeningOfCordForCordInfection Indicates if the child has reddening of the cord for cord infection.
     * @param signsOfConvulsionOrHistoryOfConvulsion Indicates if the child has signs or history of convulsion.
     */
    public ChildAssessment(String childAttributes, boolean tempForFever, boolean respirationForPneumonia,
                           boolean palmarPallorForAnemia, boolean pulseRateForStridor, boolean pulseRateForMalaria,
                           boolean pulseRatePneumonia, boolean bloodInStoolForDysentery, boolean bulgingFontanelForInfection,
                           boolean elasticityOfSkinForDehydration, boolean skinRashes, boolean reddeningOfCordForCordInfection,
                           boolean signsOfConvulsionOrHistoryOfConvulsion) {
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

    /**
     * Gets the attributes of the child.
     *
     * @return The attributes of the child.
     */
    public String getChildAttributes() {
        return childAttributes;
    }

    /**
     * Sets the attributes of the child.
     *
     * @param childAttributes The attributes of the child.
     */
    public void setChildAttributes(String childAttributes) {
        this.childAttributes = childAttributes;
    }

    /**
     * Checks if the child has a fever.
     *
     * @return True if the child has a fever, false otherwise.
     */
    public boolean isTempForFever() {
        return tempForFever;
    }

    /**
     * Sets whether the child has a fever.
     *
     * @param tempForFever True if the child has a fever, false otherwise.
     */
    public void setTempForFever(boolean tempForFever) {
        this.tempForFever = tempForFever;
    }

    /**
     * Checks if the child shows signs of pneumonia.
     *
     * @return True if the child shows signs of pneumonia, false otherwise.
     */
    public boolean isRespirationForPneumonia() {
        return respirationForPneumonia;
    }

    /**
     * Sets whether the child shows signs of pneumonia.
     *
     * @param respirationForPneumonia True if the child shows signs of pneumonia, false otherwise.
     */
    public void setRespirationForPneumonia(boolean respirationForPneumonia) {
        this.respirationForPneumonia = respirationForPneumonia;
    }

    /**
     * Checks if the child has palmar pallor for anemia.
     *
     * @return True if the child has palmar pallor for anemia, false otherwise.
     */
    public boolean isPalmarPallorForAnemia() {
        return palmarPallorForAnemia;
    }

    /**
     * Sets whether the child has palmar pallor for anemia.
     *
     * @param palmarPallorForAnemia True if the child has palmar pallor for anemia, false otherwise.
     */
    public void setPalmarPallorForAnemia(boolean palmarPallorForAnemia) {
        this.palmarPallorForAnemia = palmarPallorForAnemia;
    }

    /**
     * Checks if the child has an abnormal pulse rate for stridor.
     *
     * @return True if the child has an abnormal pulse rate for stridor, false otherwise.
     */
    public boolean isPulseRateForStridor() {
        return pulseRateForStridor;
    }

    /**
     * Sets whether the child has an abnormal pulse rate for stridor.
     *
     * @param pulseRateForStridor True if the child has an abnormal pulse rate for stridor, false otherwise.
     */
    public void setPulseRateForStridor(boolean pulseRateForStridor) {
        this.pulseRateForStridor = pulseRateForStridor;
    }

    /**
     * Checks if the child has an abnormal pulse rate for malaria.
     *
     * @return True if the child has an abnormal pulse rate for malaria, false otherwise.
     */
    public boolean isPulseRateForMalaria() {
        return pulseRateForMalaria;
    }

    /**
     * Sets whether the child has an abnormal pulse rate for malaria.
     *
     * @param pulseRateForMalaria True if the child has an abnormal pulse rate for malaria, false otherwise.
     */
    public void setPulseRateForMalaria(boolean pulseRateForMalaria) {
        this.pulseRateForMalaria = pulseRateForMalaria;
    }

    /**
     * Checks if the child has an abnormal pulse rate for pneumonia.
     *
     * @return True if the child has an abnormal pulse rate for pneumonia, false otherwise.
     */
    public boolean isPulseRatePneumonia() {
        return pulseRatePneumonia;
    }

    /**
     * Sets whether the child has an abnormal pulse rate for pneumonia.
     *
     * @param pulseRatePneumonia True if the child has an abnormal pulse rate for pneumonia, false otherwise.
     */
    public void setPulseRatePneumonia(boolean pulseRatePneumonia) {
        this.pulseRatePneumonia = pulseRatePneumonia;
    }

    /**
     * Checks if the child has blood in stool for dysentery.
     *
     * @return True if the child has blood in stool for dysentery, false otherwise.
     */
    public boolean isBloodInStoolForDysentery() {
        return bloodInStoolForDysentery;
    }

    /**
     * Sets whether the child has blood in stool for dysentery.
     *
     * @param bloodInStoolForDysentery True if the child has blood in stool for dysentery, false otherwise.
     */
    public void setBloodInStoolForDysentery(boolean bloodInStoolForDysentery) {
        this.bloodInStoolForDysentery = bloodInStoolForDysentery;
    }

    /**
     * Checks if the child has a bulging fontanel for infection.
     *
     * @return True if the child has a bulging fontanel for infection, false otherwise.
     */
    public boolean isBulgingFontanelForInfection() {
        return bulgingFontanelForInfection;
    }

    /**
     * Sets whether the child has a bulging fontanel for infection.
     *
     * @param bulgingFontanelForInfection True if the child has a bulging fontanel for infection, false otherwise.
     */
    public void setBulgingFontanelForInfection(boolean bulgingFontanelForInfection) {
        this.bulgingFontanelForInfection = bulgingFontanelForInfection;
    }

    /**
     * Checks if the child shows signs of dehydration.
     *
     * @return True if the child shows signs of dehydration, false otherwise.
     */
    public boolean isElasticityOfSkinForDehydration() {
        return elasticityOfSkinForDehydration;
    }

    /**
     * Sets whether the child shows signs of dehydration.
     *
     * @param elasticityOfSkinForDehydration True if the child shows signs of dehydration, false otherwise.
     */
    public void setElasticityOfSkinForDehydration(boolean elasticityOfSkinForDehydration) {
        this.elasticityOfSkinForDehydration = elasticityOfSkinForDehydration;
    }

    /**
     * Checks if the child has skin rashes.
     *
     * @return True if the child has skin rashes, false otherwise.
     */
    public boolean isSkinRashes() {
        return skinRashes;
    }

    /**
     * Sets whether the child has skin rashes.
     *
     * @param skinRashes True if the child has skin rashes, false otherwise.
     */
    public void setSkinRashes(boolean skinRashes) {
        this.skinRashes = skinRashes;
    }

    /**
     * Checks if the child has reddening of the cord for cord infection.
     *
     * @return True if the child has reddening of the cord for cord infection, false otherwise.
     */
    public boolean isReddeningOfCordForCordInfection() {
        return reddeningOfCordForCordInfection;
    }

    /**
     * Sets whether the child has reddening of the cord for cord infection.
     *
     * @param reddeningOfCordForCordInfection True if the child has reddening of the cord for cord infection, false otherwise.
     */
    public void setReddeningOfCordForCordInfection(boolean reddeningOfCordForCordInfection) {
        this.reddeningOfCordForCordInfection = reddeningOfCordForCordInfection;
    }

    /**
     * Checks if the child has signs or history of convulsion.
     *
     * @return True if the child has signs or history of convulsion, false otherwise.
     */
    public boolean isSignsOfConvulsionOrHistoryOfConvulsion() {
        return signsOfConvulsionOrHistoryOfConvulsion;
    }

    /**
     * Sets whether the child has signs or history of convulsion.
     *
     * @param signsOfConvulsionOrHistoryOfConvulsion True if the child has signs or history of convulsion, false otherwise.
     */
    public void setSignsOfConvulsionOrHistoryOfConvulsion(boolean signsOfConvulsionOrHistoryOfConvulsion) {
        this.signsOfConvulsionOrHistoryOfConvulsion = signsOfConvulsionOrHistoryOfConvulsion;
    }

    /**
     * Checks if the child is lethargic.
     *
     * @return True if the child is lethargic, false otherwise.
     */
    public boolean isLethargy() {
        return lethargy;
    }

    /**
     * Sets whether the child is lethargic.
     *
     * @param lethargy True if the child is lethargic, false otherwise.
     */
    public void setLethargy(boolean lethargy) {
        this.lethargy = lethargy;
    }
}
