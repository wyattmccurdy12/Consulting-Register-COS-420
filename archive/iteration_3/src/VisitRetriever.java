import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The VisitRetriever class is responsible for retrieving visit data from a CSV file.
 * It supports lookup by patient ID.
 */
public class VisitRetriever {
    private String visitsCsvPath = "archive/iteration_3/data/ConsultingRegisterVisits.csv";
    private SimpleDateFormat dtf = new SimpleDateFormat("M/d/yyyy HH:mm:ss");

    /**
     * Retrieves all visits for a given patient ID.
     *
     * @param patientId The ID of the patient whose visits are to be retrieved.
     * @return A list of Visit objects for the specified patient.
     */
    public List<Visit> retrieveVisitsByPatientId(String patientId) {
        List<Visit> visits = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(visitsCsvPath))) {
            String line;
            br.readLine(); // Skip the header line
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",", -1);
                if (fields[0].equalsIgnoreCase(patientId)) {
                    visits.add(parseVisit(fields));
                }
            }
        } catch (IOException | ParseException e) {
            System.err.println("Error reading visit records: " + e.getMessage());
        }
        return visits;
    }

    /**
     * Parses a CSV fields array into a Visit object.
     *
     * @param fields The CSV columns: [0]=patientId, [1]=clinicId, [2]=date, etc.
     * @return A new Visit instance.
     * @throws ParseException If date parsing fails.
     */
    private Visit parseVisit(String[] fields) throws ParseException {
        return new Visit(
            fields[0], // patientId
            fields[1], // clinicId
            dtf.parse(fields[2]), // date
            fields[3], // bloodPressure
            fields[4], // pulse
            Float.parseFloat(fields[5]), // temperature
            Float.parseFloat(fields[6]), // weight
            fields[7], // respiration
            fields[8], // conditionHistory
            fields[9], // principalDiagnosis
            fields[10], // additionalDiagnosis
            fields[11], // treatmentGiven
            Boolean.parseBoolean(fields[12]), // referred
            fields[13], // outcomeOfReferral
            Float.parseFloat(fields[14]), // costOfTreatment
            fields[15] // remarks
        );
    }
}
