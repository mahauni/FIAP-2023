package org.mahauni.factory;

import org.mahauni.dao.UserDAO;
import org.mahauni.dao.impl.*;

public class DAOFactory {
    public static UserDAO getUserDAO() {
        return new OracleUserDAO();
    }

    public static OracleAppointExamDAO getAppointExamDAO() {
        return new OracleAppointExamDAO();
    }

    public static OracleBiometricDataDAO getBiometricDataDAO() {
        return new OracleBiometricDataDAO();
    }

    public static OracleHealthTechDAO getHealthTechDAO() {
        return new OracleHealthTechDAO();
    }

    public static OracleMedicalAppointDAO getMedicalAppointDAO() {
        return new OracleMedicalAppointDAO();
    }

    public static OracleExamTypeDAO getExamTypeDAO() {
        return new OracleExamTypeDAO();
    }

    public static OracleRatingDAO getRatingDAO() {
        return new OracleRatingDAO();
    }

    public static OracleAppointResultDAO getAppointResultDAO() {
        return new OracleAppointResultDAO();
    }
}
