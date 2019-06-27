package com.kvlahov.dal.repository;

import com.kvlahov.dal.sql.DataSourceSingleton;
import com.kvlahov.model.Doctor;
import com.kvlahov.model.Patient;
import com.kvlahov.model.User;
import com.kvlahov.model.enums.Sex;
import com.kvlahov.model.enums.UserRole;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

class SqlRepository implements IRepository {
    //    @Override
//    public int insertDoctor(Doctor doctor) {
//        final String INSERT_DOCTOR = "{ CALL insertDoctor (?,?,?,?) }";
//        try(Connection con = dataSource.getConnection();
//                CallableStatement stmt = con.prepareCall(INSERT_DOCTOR)) {
//            stmt.setString(1, doctor.getName());
//            stmt.setString(2, doctor.getSurname());
//            stmt.setString(3, doctor.getTitle());
//            stmt.registerOutParameter(4, Types.INTEGER);
//            
//            stmt.executeUpdate();
//            return stmt.getInt(4);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return -1;
//    }
//
//    @Override
//    public void updateDoctor(Doctor dummy, int idDoctor) {
//        final String UPDATE_DOCTOR = "{ CALL updateDoctor (?,?,?,?) }";
//        
//        try(Connection con = dataSource.getConnection();
//                CallableStatement stmt = con.prepareCall(UPDATE_DOCTOR)) {
//            stmt.setString(1, dummy.getName());
//            stmt.setString(2, dummy.getSurname());
//            stmt.setString(3, dummy.getTitle());
//            stmt.setInt(4, idDoctor);
//            stmt.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }        
//    }
//
//    
//    @Override
//    public void deleteDoctor(int idDoctor) {
//        final String DELETE_DOCTOR = "{ CALL deleteDoctor (?) }";
//        
//        try(Connection con = dataSource.getConnection();
//                CallableStatement stmt = con.prepareCall(DELETE_DOCTOR)) {
//            stmt.setInt(1, idDoctor);
//            stmt.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }        
//    }
//
//    @Override
//    public Doctor getDoctor(int idDoctor) {
//        final String GET_DOCTOR = "{ CALL getDoctor (?) }";
//        
//        try (Connection con = dataSource.getConnection();
//                CallableStatement stmt = con.prepareCall(GET_DOCTOR)){
//                stmt.setInt(1, idDoctor);
//            try(ResultSet resultSet = stmt.executeQuery()) {
//                if (resultSet.next()) {
//                    return new Doctor(
//                                resultSet.getInt("IDDoctor"), 
//                                resultSet.getString("Name"), 
//                                resultSet.getString("Surname"),
//                                resultSet.getString("Title"));
//                }
//            }   
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public List<Doctor> getDoctors() {
//        List<Doctor> doctors = new ArrayList<>();
//        final String GET_DOCTORS = "{ CALL getDoctors }";
//        
//        try (Connection con = dataSource.getConnection();
//                CallableStatement stmt = con.prepareCall(GET_DOCTORS);
//                ResultSet resultSet = stmt.executeQuery()){
//                    while (resultSet.next()) {
//                        doctors.add(
//                                new Doctor(
//                                    resultSet.getInt("IDDoctor"), 
//                                    resultSet.getString("Name"), 
//                                    resultSet.getString("Surname"),
//                                    resultSet.getString("Title")));
//                    }
//            return doctors;
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return doctors;
//    }
//
//    @Override
//    public List<Patient> getPatientsForDoctor(int idDoctor) {
//        List<Patient> patients = new ArrayList<>();
//        final String GET_PATIENTS_FOR_DOCTOR = "{ CALL getPatientsForDoctor (?) }";
//        
//        try(Connection con = dataSource.getConnection();
//                CallableStatement stmt = con.prepareCall(GET_PATIENTS_FOR_DOCTOR)) {
//            stmt.setInt(1, idDoctor);
//           try(ResultSet resultSet = stmt.executeQuery()) {
//                while (resultSet.next()) {
//                    patients.add(
//                            new Patient(
//                                resultSet.getInt("IDPatient"), 
//                                resultSet.getString("Name"), 
//                                resultSet.getString("Surname"),
//                                resultSet.getString("Diagnosis")));
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }        
//        return patients;
//    }

//    String connectionUrl = "jdbc:sqlserver://localhost:1433; databaseName=JavaProjekt;integratedSecurity=true"; 
    DataSource dataSource = DataSourceSingleton.getInstance();

    @Override
    public int insertPatient(Patient patient) {
        final String INSERT_PATIENT = "{ ? = CALL insertPatient (?,?,?,?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(INSERT_PATIENT)) {
            stmt.registerOutParameter(1, Types.INTEGER);
            stmt.setString(2, patient.getName());
            stmt.setString(3, patient.getSurname());
            stmt.setString(4, patient.getDateOfBirth().toString());
            stmt.setInt(5, patient.getSex().getId());

            stmt.executeUpdate();
            return stmt.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int insertDoctor(Doctor doctor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Doctor getDoctor(int idDoctor) {
        final String GET_DOCTOR = "{ CALL getDoctor (?) }";

        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_DOCTOR)) {
            stmt.setInt(1, idDoctor);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    return new Doctor(
                            resultSet.getInt("IDDoctor"),
                            resultSet.getString("Name"),
                            resultSet.getString("Surname"),
                            resultSet.getInt("DepartmentID"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Doctor> getDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        final String GET_DOCTORS = "{ CALL getDoctors }";

        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_DOCTORS);
                ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                doctors.add(
                        new Doctor(
                                resultSet.getInt("IDDoctor"),
                                resultSet.getString("Name"),
                                resultSet.getString("Surname"),
                                resultSet.getInt("DepartmentID")));
            }
            return doctors;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctors;
    }

    @Override
    public List<Patient> getPatientsForDoctor(int idDoctor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValidUser(User user) {
        final String IS_VALID_USER = "{ ? = CALL isValidUser (?,?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(IS_VALID_USER)) {
            stmt.registerOutParameter(1, Types.BIT);
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());

            stmt.executeUpdate();
            return stmt.getInt(1) == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public UserRole getUserRole(int id) {
        final String GET_USER_ROLE = "{ CALL getUserRole (?) }";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_USER_ROLE)) {
            stmt.setInt(1, id);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    return UserRole.getRole(resultSet.getString("Type"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserRole getRoleForUser(User user) {
        final String GET_USER_ROLE = "{ CALL getRoleForUser (?,?) }";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_USER_ROLE)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    return UserRole.getRole(resultSet.getString("Type"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updatePatient(Patient patient, int id) {
        final String UPDATE_PATIENT = "{ CALL updatePatient (?,?,?,?,?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_PATIENT)) {
            stmt.setInt(1, id);
            stmt.setString(2, patient.getName());
            stmt.setString(3, patient.getSurname());
            stmt.setString(4, patient.getDateOfBirth().toString());
            stmt.setInt(5, patient.getSex().getId());

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Patient getPatient(int id) {
        final String GET_PATIENT = "{ CALL getPatient (?)}";

        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_PATIENT)) {
            stmt.setInt(1, id);

            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    return new Patient(
                        resultSet.getInt("IDPatient"),
                            resultSet.getString("Name"),
                            resultSet.getString("Surname"),
                            Sex.getValueForId(resultSet.getInt("SexID")),                           
                            resultSet.getDate("DateOfBirth").toLocalDate()
                    );

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }

    @Override
    public List<Patient> getPatients() {
        List<Patient> patients = new ArrayList<>();
        final String GET_PATIENTS = "{ CALL getPatients ()}";

        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_PATIENTS)) {

            try (ResultSet resultSet = stmt.executeQuery()) {
                while(resultSet.next()) {
                    Patient temp = new Patient(
                        resultSet.getInt("IDPatient"),
                            resultSet.getString("Name"),
                            resultSet.getString("Surname"),
                            Sex.getValueForId(resultSet.getInt("SexID")),                           
                            resultSet.getDate("DateOfBirth").toLocalDate()
                    );
                    
                    patients.add(temp);
                }
                return patients;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }

}
