import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.print.attribute.standard.MediaSize.Other;

public class Clinic {
    private String clinicId;
    private String facility;
    private String chpsZone;
    private String subDistrict;
    private String district;
    private ArrayList<Patient> patients;
    private ArrayList<Visit> visits;

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

    public void addPatient(Patient patient) {
        patients.add(patient);
    }
    /**
     * Creates a Morbidity report from the information collected during the months visits.
     */
    public void generateMorbidityReport() {
        String[] diseases = {"Acute Ear infection","Acute Eye infection","Acute Psychosis",
        "Acute Urinary Tract Infection","AFP (Polio)","All Other Diseases","Anaemia",
        "Aneamia in Pregnancy","Asthma","Buruli Ulcer","Cataract","Chicken Pox","Cholera","CSM",
        "Dental Caries","Diabetes Mellitus","Diarrhoea Diseases","Diphtheria","Domestic Violence",
        "Epilepsy","Genital Ulcer Disease","Gonorrhoea","Guinea worm","Gynaecological conditions",
        "HIV/AIDS","Home Accidents and Injuries","Home Poisonings","Hypertension",
        "Infectious Hepatitis","Intestinal worms","Kidney Related Diseases","Leprosy","Liver Diseases",
        "Malaria in Pregnancy Lab Confirmed","Malaria in Pregnancy Non-Lab Confirmed","Malnutrition",
        "Measles","Mumps","Neonatal Tetanus","Neurosis","Occupational Injuries","Occupational Poisonings",
        "Onchocercaisis","Other Animal Bites","Other ARI(Acute Respiratory Infection)","Other Cardiac Diseases",
        "Other Disease of the Female Reproductive System","Other Disease of the Male Reproductive System",
        "Other Meningitis","Other Nutritional Diseases","Other oral Conditions","Pertussis","Pneumonia",
        "Pregnancy and Related Complications","PUO (not Malaria)","Rheumatism and Joint Paints",
        "Road Traffic Accidents","Schistosomiasis (Bilharzia)","Septicaemia","Severe Malaria Lab Confirmed",
        "Severe Malaria Non-Lab Confirmed","Sexual abuse","Sickle cell Disease","Simple Malaria Lab Confirmed",
        "Simple Malaria Non-Lab Confirmed","Skin Diseases & Ulcers","Snake Bite","Substance Abuse","Tetanus",
        "Trachoma","Tuberculosis","Typhoid/Enteric Fever(Typhoid)","Urethral Discharge","Vaginal Discharge",
        "Yaws","Yellow Fever","Re-Attendance","Referrals Out"};
        Calendar cal = Calendar.getInstance(null);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        String fileName = "Morbidity_Report_" + month + "-" + year + ".csv";
       
        int[][] maleData = new int[diseases.length][11]; // FIXME: based on diseases, might not be problem
        int[][] femaleData = new int[diseases.length][11];
        for (Visit visit: visits) {
            if (visit.getDate().getMonth() == month && visit.getDate().getYear() == year) { //FIXME: problem with the date class
                int i = 0;
                Boolean notFound = true;
                while (i < diseases.length && notFound) { // FIXME: not sure if we want diseases in and array could be a map
                    if (diseases[i] == visit.getPrincipalDiagnosis()){ // FIXME: visit connection not finalized
                        notFound = false;
                    } else {
                        i++;
                    }
                }
                int j;
                int age = visit.getPatient().getAge(); // FIXME: probably doesn't work
                if (age >= 70) {
                    j = 10;
                } else if (age >= 60) {
                    j = 9;
                } else if (age >= 50) {
                    j = 8;
                } else if (age >= 35) {
                    j = 7;
                } else if (age >= 20) {
                    j = 6;
                } else if (age >= 18) {
                    j = 5;
                } else if (age >= 15) {
                    j = 4;
                } else if (age >= 10) {
                    j = 3;
                } else if (age >= 5) {
                    j = 2;
                } else if (age >= 1) {
                    j = 1;
                } else {
                    j = 0;
                }

                String sex = visit.getPatient().getSex(); // FIXME: probably doesn't work
                if (sex.equals("Male")) {
                    maleData[i][j]++;
                } else {
                    femaleData[i][j]++;
                }

                StringBuilder sb = new StringBuilder();
                sb.append("Month").append(",").append(month).append("\n");

                sb.append("Facility Name").append(",").append(facility).append("\n");
                sb.append("District").append(",").append(district).append("\n");
                sb.append("Region").append(",").append(subDistrict).append("\n");

                sb.append("\n");

                sb.append("Disease\t").append(",").append("Male <1").append(",").append("Male 1-4").append(",").append("Male 5-9").append(",")
                .append("Male 10-14").append(",").append("Male 15-17").append(",").append("Male 18-19").append(",").append("Male 20-34").append(",")
                .append("Male 35-49").append(",").append("Male 50-59").append(",").append("Male 60-69").append(",").append("Male 70+").append(",")
                .append("Male Total").append(",");

                sb.append("Female <1").append(",").append("Female 1-4").append(",").append("Female 5-9").append(",")
                .append("Female 10-14").append(",").append("Female 15-17").append(",").append("Female 18-19").append(",").append("Female 20-34").append(",")
                .append("Female 35-49").append(",").append("Female 50-59").append(",").append("Female 60-69").append(",").append("Female 70+").append(",")
                .append("Female Total").append(",").append("\n");
                for(int k = 0; k < diseases.length; k++) {
                    sb.append(diseases[k]).append(",");
                    int maleTotal = 0;
                    for(int l = 0; l < 11; l++) {
                        sb.append(maleData[k][l]).append(",");
                        maleTotal += maleData[k][l];
                    }
                    sb.append(maleTotal).append(",");
                    int femaleTotal = 0;
                    for(int m = 0; m < 11; m++) {
                        sb.append(femaleData[k][m]).append(",");
                        femaleTotal += femaleData[k][m];
                    }
                    sb.append(femaleTotal).append("\n");
                }
                sb.append("Total").append(",");
                for (int x = 0; x < 11; x++) {
                    int ageTotal = 0;
                    for (int y = 0; y < diseases.length; y++) {
                        ageTotal += maleData[y][x];
                    }
                    sb.append(ageTotal).append(",");
                }
                sb.append(",");
                for (int g = 0; g < 11; g++) {
                    ageTotal = 0;
                    for (int h = 0; h < diseases.length; h++) {
                        ageTotal += femaleData[h][g];
                    }
                    sb.append(ageTotal).append(",");
                }
            }
        }
        
    }
}