/*
 * The PatientRetriever class is responsible for retrieving patient data which 
 * is stored as a csv file. 
 * The patient retriever will receive a Patient object and check to see whether the 
 * patient ID is already recorded in data/PatientRecords.csv 
 * If the patient already exists in the records csv, it will pull the records. 
 * If the patient does not exist in the records, it will inform the user 
 * that the patient is not found and informs the user that they will need to create a new 
 * Patient entry. 
 */ 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientRetriever {

    private String patientCsvPath = "archive/iteration_2/data/ConsultingRegisterPatients.csv";

    public Patient retrievePatientById(String patientId) {
        try (BufferedReader br = new BufferedReader(new FileReader(patientCsvPath))) {
            String line;
            br.readLine(); // Skip the header line
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields[0].equals(patientId)) {
                    return parsePatient(fields);
                }
            }
        } catch (IOException | ParseException e) {
            System.err.println("Error reading patient records: " + e.getMessage());
        }
        System.out.println("Patient with ID " + patientId + " not found.");
        return null;
    }

    /**
     * Retrieves all patients from the CSV file.
     *
     * @return A list of Patient objects.
     */
    public List<Patient> retrieveAllPatients() {
        List<Patient> patients = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(patientCsvPath))) {
            String line;
            br.readLine(); // Skip the header line
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                patients.add(parsePatient(fields));
            }
        } catch (IOException | ParseException e) {
            System.err.println("Error reading patient records: " + e.getMessage());
        }
        return patients;
    }

    private Patient parsePatient(String[] fields) throws ParseException {
        String patientId = fields[0];
        Date dateOfBirth = new SimpleDateFormat("M/d/yyyy").parse(fields[1]);
        String name = fields[2];
        String outPatientNumber = fields[3];
        String healthInsuranceNumber = fields[4];
        String nationalIdentificationNumber = fields[5];
        String address = fields[6];
        String sex = fields[7];
        int age = Integer.parseInt(fields[8]);
        String motherId = fields[9];
        List<Record> records = new ArrayList<>(); // Assuming records are not stored in the CSV

        return new GeneralPatient(patientId, dateOfBirth, name, outPatientNumber, healthInsuranceNumber,
                nationalIdentificationNumber, address, sex, age, motherId, records);
    }
}