import java.text.SimpleDateFormat;
import java.util.List;

/**
 * CSModel serves as the model in the MVC architecture for the Consulting Register application.
 * It holds the currently selected patient and provides methods to update or retrieve it.
 */
public class CSModel {
    private Patient selectedPatient;
    private final SimpleDateFormat df = new SimpleDateFormat("M/d/yyyy");
    private final SimpleDateFormat dtf = new SimpleDateFormat("M/d/yyyy HH:mm:ss");
    private List<String> clinicList;

    /**
     * Gets the currently selected patient.
     *
     * @return The currently selected patient, or null if no patient is selected.
     */
    public Patient getSelectedPatient() {
        return selectedPatient;
    }

    /**
     * Sets the currently selected patient.
     *
     * @param selectedPatient The patient to set as the currently selected patient.
     */
    public void setSelectedPatient(Patient selectedPatient) {
        this.selectedPatient = selectedPatient;
    }

    /**
     * Clears the currently selected patient.
     */
    public void clearSelectedPatient() {
        this.selectedPatient = null;
    }

    /**
     * Gets the date formatter for dates without time.
     *
     * @return The SimpleDateFormat instance for dates.
     */
    public SimpleDateFormat getDateFormatter() {
        return df;
    }

    /**
     * Gets the date formatter for dates with time.
     *
     * @return The SimpleDateFormat instance for date and time.
     */
    public SimpleDateFormat getDateTimeFormatter() {
        return dtf;
    }

    /**
     * Gets the list of clinics.
     *
     * @return The list of clinic names.
     */
    public List<String> getClinicList() {
        return clinicList;
    }

    /**
     * Sets the list of clinics.
     *
     * @param clinicList The list of clinic names to set.
     */
    public void setClinicList(List<String> clinicList) {
        this.clinicList = clinicList;
    }
}
