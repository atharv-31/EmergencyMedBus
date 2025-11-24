package com.emergency.dao;

import java.util.List;
import com.emergency.model.Patient;

public interface PatientDAO {
    boolean addPatient(Patient p);
    boolean updatePatient(Patient p);
    boolean deletePatient(int id);
    Patient getPatientById(int id);
    List<Patient> getAllPatients();
}
