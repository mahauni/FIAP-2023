package org.mahauni.dao;

import org.mahauni.model.BiometricData;
import org.mahauni.model.MedicalAppoint;
import org.mahauni.model.User;

import java.util.List;

public interface BiometricDataDAO {
    void registerBioData(BiometricData biometric);

    List<BiometricData> getAppointBioData(MedicalAppoint appoint);
}
