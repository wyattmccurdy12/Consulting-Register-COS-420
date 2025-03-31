public class Clinic {
    private String clinicId;
    private String facility;
    private String chpsZone;
    private String subDistrict;
    private String district;

    // Constructor
    public Clinic(String clinicId, String facility, String chpsZone, String subDistrict, String district) {
        this.clinicId = clinicId;
        this.facility = facility;
        this.chpsZone = chpsZone;
        this.subDistrict = subDistrict;
        this.district = district;
    }

    // Getters and Setters (optional, if needed)
    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public String getChpsZone() {
        return chpsZone;
    }

    public void setChpsZone(String chpsZone) {
        this.chpsZone = chpsZone;
    }

    public String getSubDistrict() {
        return subDistrict;
    }

    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}