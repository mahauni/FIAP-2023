package org.mahauni.dao;

import org.mahauni.model.AppointResult;
import org.mahauni.model.MedicalAppoint;

public interface AppointResultDAO {
    AppointResult getResult(MedicalAppoint appoint);

    void createResult(AppointResult result);
}
