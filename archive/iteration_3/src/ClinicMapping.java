import java.util.*;
import java.io.*;

public class ClinicMapping {

    /**
     * Parses the provided CSV file and returns a mapping between clinicId and facility (clinic name).
     *
     * @param filePath The path to the CSV file
     * @return A map of clinicId to facility
     * @throws IOException If there is an issue reading the file
     */
    public static Map<String, String> parseClinicData(String filePath) throws IOException {
        Map<String, String> clinicMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); // Skip header line
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1); // Split on comma, allow empty fields
                if (parts.length > 1) {
                    String clinicId = parts[0].trim(); // First column: clinicId
                    String clinicName = parts[1].trim(); // Second column: facility (clinic name)
                    clinicMap.put(clinicId, clinicName);
                }
            }
        }
        return clinicMap;
    }
}