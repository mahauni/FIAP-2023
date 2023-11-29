package org.mahauni.dao;

import java.util.List;

import org.mahauni.model.MedicalAppoint;
import org.mahauni.model.User;

public interface MedicalAppointDAO {
    void registerAppointment(MedicalAppoint appoint);

    MedicalAppoint getAppointment(int id);

    void updateAppointment(MedicalAppoint appoint);

    List<MedicalAppoint> listRequestAppointments(User user);

    List<MedicalAppoint> listExamAppointments();

    List<MedicalAppoint> listExamAppointmentsFinilized(User user);

    void deleteAppoint(int id);
}
