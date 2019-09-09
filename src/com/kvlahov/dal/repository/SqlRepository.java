package com.kvlahov.dal.repository;

import com.kvlahov.dal.sql.DataSourceSingleton;
import com.kvlahov.model.Appointment;
import com.kvlahov.model.Doctor;
import com.kvlahov.model.Patient;
import com.kvlahov.model.Receipt;
import com.kvlahov.model.ReceiptItem;
import com.kvlahov.model.Service;
import com.kvlahov.model.ServiceAppointment;
import com.kvlahov.model.TypeOfService;
import com.kvlahov.model.User;
import com.kvlahov.model.enums.AddressType;
import com.kvlahov.model.enums.ContactType;
import com.kvlahov.model.enums.Sex;
import com.kvlahov.model.enums.UserRole;
import com.kvlahov.model.patientInfo.ComplaintsInfo;
import com.kvlahov.model.patientInfo.ContactInfo;
import com.kvlahov.model.patientInfo.LifestyleInfo;
import com.kvlahov.model.patientInfo.NextOfKin;
import com.kvlahov.model.patientInfo.PersonalInfo;
import com.kvlahov.utils.Utilities;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
        final String INSERT_DOCTOR = "{ ? = CALL insertDoctor (?,?,?) }";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(INSERT_DOCTOR)) {
            stmt.registerOutParameter(1, Types.INTEGER);
            stmt.setString(2, doctor.getName());
            stmt.setString(3, doctor.getSurname());
            stmt.setInt(4, doctor.getDepartmentID());

            stmt.executeUpdate();
            stmt.getInt(1);
            return stmt.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
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
        final String GET_DOCTORS = "{ CALL getDoctors }";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_DOCTORS);
                ResultSet resultSet = stmt.executeQuery()) {

            List<Doctor> doctors = new ArrayList<>();
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
        return null;
    }

    @Override
    public List<Patient> getPatientsForDoctor(int idDoctor) {
        final String GET_PATIENTS = "{ CALL getPatientsForDoctor (?) }";

        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_PATIENTS)) {
            stmt.setInt(1, idDoctor);

            try (ResultSet resultSet = stmt.executeQuery()) {
                List<Patient> patients = new ArrayList<>();
                while (resultSet.next()) {
                    Patient p = new Patient(
                            resultSet.getInt("IDPatient"),
                            resultSet.getString("Name"),
                            resultSet.getString("Surname"),
                            Sex.getValueForId(resultSet.getInt("SexID")),
                            resultSet.getDate("DateOfBirth").toLocalDate()
                    );
                    patients.add(p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
                while (resultSet.next()) {
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

    //inserts
    @Override
    public void insertComplaint(int pid, ComplaintsInfo complaints) {
        final String INSERT_COMPLAINT = "{ CALL insertComplaint (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(INSERT_COMPLAINT)) {
            stmt.setInt("IDPatient", pid);
            stmt.setString("TreatmentHistory", complaints.getPreviousTreatments());
            stmt.setString("StatementOfComplaint", complaints.getStatementComplaint());
            stmt.setString("HospitalTreated", complaints.getHospitalTreated());
            stmt.setBoolean("IsDiabetic", complaints.getIsDiabetic());
            stmt.setBoolean("IsHypertensive", complaints.getIsHypertensive());
            stmt.setString("CardiacCondition", complaints.getCardiacCondition());
            stmt.setString("RespitoryCondition", complaints.getRespiratoryCondition());
            stmt.setString("DigestiveCondition", complaints.getDigestiveCondition());
            stmt.setString("OrthopedicCondition", complaints.getOrthopedicCondition());
            stmt.setString("MuscularCondition", complaints.getMuscularCondition());
            stmt.setString("NeurologicalCondition", complaints.getNeurologicalCondition());
            stmt.setString("Allergies", complaints.getKnownAllergies());
            stmt.setString("ReactionToDrugs", complaints.getReactionDrugs());
            stmt.setString("SurgeryHistory", complaints.getMajorSurgeries());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void insertLifestyle(int pid, LifestyleInfo lifestyle) {
        final String INSERT_LIFESTYLE = "{ CALL insertLifestyle (?,?,?,?,?,?,?,?,?,?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(INSERT_LIFESTYLE)) {
            stmt.setInt("IDPatient", pid);
            stmt.setBoolean("IsSmoker", lifestyle.getIsSmoker());
            stmt.setBoolean("IsVegetarian", lifestyle.getIsVegetarian());
            stmt.setInt("CigarretesPerDay", lifestyle.getAverageCigarettesPerDay());
            stmt.setBoolean("ConsumesAlcohol", lifestyle.getConsumesAlcohol());
            stmt.setInt("AlcoholPerDay", lifestyle.getAverageDrinksPerDay());
            stmt.setString("UsesStimulants", lifestyle.getUsesStimulants());
            stmt.setInt("CaffeineDrinkPerDay", lifestyle.getCoffeineDrinkPerDay());
            stmt.setInt("SoftDrinkPerDay", lifestyle.getSoftDrinkPerDay());
            stmt.setString("EatingHabits", lifestyle.getEatingHabits());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertNextOfKin(int pid, NextOfKin nok) {
        final String INSERT_NOK = "{ ? = CALL insertNextOfKin (?,?,?,?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(INSERT_NOK)) {
            stmt.registerOutParameter(1, Types.INTEGER);
            stmt.setInt("PatientID", pid);
            stmt.setString("FirstName", nok.getName());
            stmt.setString("LastName", nok.getSurname());
            stmt.setString("RelationshipToPatient", nok.getRelationshipToPatient());

            stmt.executeUpdate();
            return stmt.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void insertNextOfKinAdd(int nokId, ContactInfo.Address add) {
        final String INSERT_NOKADD = "{ CALL insertNokAddress (?,?,?,?,?,?,?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(INSERT_NOKADD)) {
            stmt.setInt("NextOfKinID", nokId);
            stmt.setString("Street", add.getStreet());
            stmt.setString("Area", add.getArea());
            stmt.setString("City", add.getCity());
            stmt.setString("State", add.getState());
            stmt.setString("ZipCode", add.getZipCode());
            stmt.setInt("AddressTypeID", 1);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertNextOfKinContact(int nokId, int contactType, String contact) {
        final String INSERT_NOKCONTACT = "{ CALL insertNokContact (?,?,?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(INSERT_NOKCONTACT)) {
            stmt.setInt(1, nokId);
            stmt.setInt(2, contactType);
            stmt.setString(3, contact);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertPatientAddress(int pid, ContactInfo.Address add, int addType) {
        final String INSERT_PADD = "{ CALL insertPatientAddress (?,?,?,?,?,?,?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(INSERT_PADD)) {
            stmt.setInt("PatientID", pid);
            stmt.setString("Street", add.getStreet());
            stmt.setString("Area", add.getArea());
            stmt.setString("City", add.getCity());
            stmt.setString("State", add.getState());
            stmt.setString("ZipCode", add.getZipCode());
            stmt.setInt("AddressTypeID", addType);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertPatientContact(int pid, int contactType, String contact) {
        final String INSERT_PCONTACT = "{ CALL insertPatientContact (?,?,?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(INSERT_PCONTACT)) {
            stmt.setInt(1, pid);
            stmt.setInt(2, contactType);
            stmt.setString(3, contact);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertPersonalInfo(int pid, PersonalInfo personalInfo) {
        final String INSERT_PERSONAL = "{ CALL insertPersonalInfo (?,?,?,?,?,?,?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(INSERT_PERSONAL)) {
            stmt.setInt("IDPatient", pid);
            stmt.setInt("NoOfDependents", personalInfo.getNoOFDependents());
            stmt.setFloat("Height", personalInfo.getHeight());
            stmt.setFloat("PWeight", personalInfo.getWeight());
            stmt.setString("BloodType", personalInfo.getBloodType());
            stmt.setString("Occupation", personalInfo.getOccupation());
            stmt.setString("AnnualIncome", personalInfo.getAnnualIncome());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //getters
    @Override
    public ComplaintsInfo getComplaint(int pid) {
        final String GET_COMPLAINTS = "{ CALL getComplaints (?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_COMPLAINTS)) {
            stmt.setInt(1, pid);

            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    ComplaintsInfo ci = new ComplaintsInfo();

                    ci.setCardiacCondition(resultSet.getString("CardiacCondition"));
                    ci.setDigestiveCondition(resultSet.getString("DigestiveCondition"));
                    ci.setHospitalTreated(resultSet.getString("HospitalTreated"));
                    ci.setIsDiabetic(resultSet.getBoolean("IsDiabetic"));
                    ci.setIsHypertensive(resultSet.getBoolean("IsHypertensive"));
                    ci.setKnownAllergies(resultSet.getString("Allergies"));
                    ci.setMajorSurgeries(resultSet.getString("SurgeryHistory"));
                    ci.setMuscularCondition(resultSet.getString("MuscularCondition"));
                    ci.setNeurologicalCondition(resultSet.getString("NeurologicalCondition"));
                    ci.setOrthopedicCondition(resultSet.getString("OrthopedicCondition"));
                    ci.setPreviousTreatments(resultSet.getString("TreatmentHistory"));
                    ci.setReactionDrugs(resultSet.getString("ReactionToDrugs"));
                    ci.setRespiratoryCondition(resultSet.getString("RespitoryCondition"));
                    ci.setStatementComplaint(resultSet.getString("StatementOfComplaint"));

                    return ci;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public LifestyleInfo getLifestyle(int pid) {
        final String GET_LIFESTYLE = "{ CALL getLifestyle (?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_LIFESTYLE)) {
            stmt.setInt(1, pid);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    LifestyleInfo li = new LifestyleInfo();

                    li.setAverageCigarettesPerDay(resultSet.getInt("CigarretesPerDay"));
                    li.setAverageDrinksPerDay(resultSet.getInt("AlcoholPerDay"));
                    li.setCoffeineDrinkPerDay(resultSet.getInt("CaffeineDrinkPerDay"));
                    li.setConsumesAlcohol(resultSet.getBoolean("ConsumesAlcohol"));
                    li.setEatingHabits(resultSet.getString("EatingHabits"));
                    li.setIsSmoker(resultSet.getBoolean("IsSmoker"));
                    li.setIsVegetarian(resultSet.getBoolean("IsVegetarian"));
                    li.setSoftDrinkPerDay(resultSet.getInt("SoftDrinkPerDay"));
                    li.setUsesStimulants(resultSet.getString("UsesStimulants"));

                    return li;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public NextOfKin getNextOfKin(int pid) {
        final String GET_NOK = "{ CALL getNextOfKin (?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_NOK)) {
            stmt.setInt(1, pid);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    NextOfKin nok = new NextOfKin(
                            resultSet.getString("FirstName"),
                            resultSet.getString("LastName"),
                            resultSet.getString("RelationshipToPatient")
                    );

                    nok.setId(resultSet.getInt("IDNextOfKin"));
                    return nok;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ContactInfo.Address getNextOfKinAdd(int nok) {
        final String GET_NOK = "{ CALL getAddressesForNok (?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_NOK)) {
            stmt.setInt(1, nok);
            try (ResultSet resultSet = stmt.executeQuery()) {
                ContactInfo.Address add = new ContactInfo.Address();
                while (resultSet.next()) {

                    add.setArea(resultSet.getString("Area"));
                    add.setCity(resultSet.getString("City"));
                    add.setState(resultSet.getString("State"));
                    add.setStreet(resultSet.getString("Street"));
                    add.setZipCode(resultSet.getString("ZipCode"));

                }
                return add;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ContactInfo getNextOfKinContact(int nok) {
        final String GET_NOKCONTACT = "{ CALL getContactsForNok (?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_NOKCONTACT)) {
            stmt.setInt(1, nok);
            try (ResultSet resultSet = stmt.executeQuery()) {
                ContactInfo contact = new ContactInfo();
                while (resultSet.next()) {
                    contact.addPhoneNumber(
                            ContactType.valueOf(resultSet.getString("Type").toUpperCase()),
                            resultSet.getString("ContactNumber"));

                }
                return contact;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<ContactInfo.Address> getPatientAddress(int pid) {
        final String GET_PADDRESS = "{ CALL getAddressesForPatient (?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_PADDRESS)) {
            stmt.setInt(1, pid);
            try (ResultSet resultSet = stmt.executeQuery()) {
                List<ContactInfo.Address> addList = new ArrayList<>();
                while (resultSet.next()) {
                    ContactInfo.Address addr = new ContactInfo.Address();

                    addr.setArea(resultSet.getString("Area"));
                    addr.setCity(resultSet.getString("City"));
                    addr.setState(resultSet.getString("State"));
                    addr.setStreet(resultSet.getString("Street"));
                    addr.setZipCode(resultSet.getString("ZipCode"));
                    addr.setType(AddressType.valueOf(resultSet.getString("Type").toUpperCase()));

                }

                return addList;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ContactInfo getPatientContact(int pid) {
        final String GET_PCONTACT = "{ CALL getContactsForPatient (?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_PCONTACT)) {
            stmt.setInt(1, pid);
            try (ResultSet resultSet = stmt.executeQuery()) {
                ContactInfo contact = new ContactInfo();
                while (resultSet.next()) {
                    contact.addPhoneNumber(
                            ContactType.valueOf(resultSet.getString("Type").toUpperCase()),
                            resultSet.getString("ContactNumber"));

                }
                return contact;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public PersonalInfo getPersonalInfo(int pid) {
        final String GET_PERSONAL = "{ CALL getPersonalInfo (?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_PERSONAL)) {
            stmt.setInt(1, pid);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    PersonalInfo pi = new PersonalInfo();

                    pi.setAnnualIncome(resultSet.getString("AnnualIncome"));
                    pi.setBloodType(resultSet.getString("BloodType"));
                    pi.setHeight(resultSet.getFloat("Height"));
                    pi.setNoOFDependents(resultSet.getInt("NoOfDependents"));
                    pi.setOccupation(resultSet.getString("Occupation"));
                    pi.setWeight(resultSet.getFloat("PWeight"));

                    return pi;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int getContactTypeId(ContactType type) {
        final String GET_CTID = "{ CALL getContactTypeId (?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_CTID)) {
            stmt.setString(1, type.toString());
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("IDContactType");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;

    }

    @Override
    public void updateComplaints(int pid, ComplaintsInfo complaints) {
        final String UPDATE_COMPLAINT = "{ CALL updateComplaint (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_COMPLAINT)) {
            stmt.setInt("IDPatient", pid);
            stmt.setString("TreatmentHistory", complaints.getPreviousTreatments());
            stmt.setString("StatementOfComplaint", complaints.getStatementComplaint());
            stmt.setString("HospitalTreated", complaints.getHospitalTreated());
            stmt.setBoolean("IsDiabetic", complaints.getIsDiabetic());
            stmt.setBoolean("IsHypertensive", complaints.getIsHypertensive());
            stmt.setString("CardiacCondition", complaints.getCardiacCondition());
            stmt.setString("RespitoryCondition", complaints.getRespiratoryCondition());
            stmt.setString("DigestiveCondition", complaints.getDigestiveCondition());
            stmt.setString("OrthopedicCondition", complaints.getOrthopedicCondition());
            stmt.setString("MuscularCondition", complaints.getMuscularCondition());
            stmt.setString("NeurologicalCondition", complaints.getNeurologicalCondition());
            stmt.setString("Allergies", complaints.getKnownAllergies());
            stmt.setString("ReactionToDrugs", complaints.getReactionDrugs());
            stmt.setString("SurgeryHistory", complaints.getMajorSurgeries());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateLifestyle(int pid, LifestyleInfo lifestyle) {
        final String UPDATE_LIFESTYLE = "{ CALL updateLifestyle (?,?,?,?,?,?,?,?,?,?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_LIFESTYLE)) {
            stmt.setInt("IDPatient", pid);
            stmt.setBoolean("IsSmoker", lifestyle.getIsSmoker());
            stmt.setBoolean("IsVegetarian", lifestyle.getIsVegetarian());
            stmt.setInt("CigarretesPerDay", lifestyle.getAverageCigarettesPerDay());
            stmt.setBoolean("ConsumesAlcohol", lifestyle.getConsumesAlcohol());
            stmt.setInt("AlcoholPerDay", lifestyle.getAverageDrinksPerDay());
            stmt.setString("UsesStimulants", lifestyle.getUsesStimulants());
            stmt.setInt("CaffeineDrinkPerDay", lifestyle.getCoffeineDrinkPerDay());
            stmt.setInt("SoftDrinkPerDay", lifestyle.getSoftDrinkPerDay());
            stmt.setString("EatingHabits", lifestyle.getEatingHabits());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePersonalInfo(int pid, PersonalInfo personalInfo) {
        final String UPDATE_PERSONAL = "{ CALL updatePersonalInfo (?,?,?,?,?,?,?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_PERSONAL)) {
            stmt.setInt("IDPatient", pid);
            stmt.setInt("NoOfDependents", personalInfo.getNoOFDependents());
            stmt.setFloat("Height", personalInfo.getHeight());
            stmt.setFloat("PWeight", personalInfo.getWeight());
            stmt.setString("BloodType", personalInfo.getBloodType());
            stmt.setString("Occupation", personalInfo.getOccupation());
            stmt.setString("AnnualIncome", personalInfo.getAnnualIncome());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateNextOfKin(int pid, NextOfKin nok) {
        final String UPDATE_NOK = "{ CALL updateNextOfKin (?,?,?,?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_NOK)) {
            stmt.registerOutParameter(1, Types.INTEGER);
            stmt.setInt("PatientID", pid);
            stmt.setString("FirstName", nok.getName());
            stmt.setString("LastName", nok.getSurname());
            stmt.setString("RelationshipToPatient", nok.getRelationshipToPatient());

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateNextOfKinAdd(int nokId, ContactInfo.Address add) {
        final String UPDATE_NOKADD = "{ CALL updateNokAddress (?,?,?,?,?,?,?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_NOKADD)) {
            stmt.setInt("NextOfKinID", nokId);
            stmt.setString("Street", add.getStreet());
            stmt.setString("Area", add.getArea());
            stmt.setString("City", add.getCity());
            stmt.setString("State", add.getState());
            stmt.setString("ZipCode", add.getZipCode());
            stmt.setInt("AddressTypeID", 1);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateNextOfKinContact(int nokId, int contactType, String contact) {
        final String UPDATE_NOKCONTACT = "{ CALL updateNokContact (?,?,?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_NOKCONTACT)) {
            stmt.setInt(1, nokId);
            stmt.setInt(2, contactType);
            stmt.setString(3, contact);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePatientAddress(int pid, ContactInfo.Address add, int addType) {
        final String UPDATE_PADD = "{ CALL updatePatientAddress (?,?,?,?,?,?,?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_PADD)) {
            stmt.setInt("PatientID", pid);
            stmt.setString("Street", add.getStreet());
            stmt.setString("Area", add.getArea());
            stmt.setString("City", add.getCity());
            stmt.setString("State", add.getState());
            stmt.setString("ZipCode", add.getZipCode());
            stmt.setInt("AddressTypeID", addType);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePatientContact(int pid, int contactType, String contact) {
        final String UPDATE_PCONTACT = "{ CALL updatePatientContact (?,?,?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_PCONTACT)) {
            stmt.setInt(1, pid);
            stmt.setInt(2, contactType);
            stmt.setString(3, contact);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        final String UPDATE_DOCTOR = "{ CALL updateDoctor (?,?,?,?) }";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_DOCTOR)) {
            stmt.setInt(1, doctor.getId());
            stmt.setString(2, doctor.getName());
            stmt.setString(3, doctor.getSurname());
            stmt.setInt(4, doctor.getDepartmentID());

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDoctor(int doctorId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertAppointment(Appointment appointment) {
        final String INSERT_APPOINTMENT = "{ CALL insertAppointment (?,?,?,?,?,?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(INSERT_APPOINTMENT)) {
            stmt.setTimestamp(1, Timestamp.valueOf(appointment.getStartTime()));
            stmt.setTimestamp(2, Timestamp.valueOf(appointment.getEndTime()));
            stmt.setInt(3, appointment.getPatientId());
            stmt.setInt(4, appointment.getDoctorId());
            stmt.setString(5, appointment.getAnamnesis());
            stmt.setString(6, appointment.getDiagnosis());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Appointment> getScheduledAppointments(int doctorId) {
        final String GET_APPFORDOCTOR = "{ CALL getAppointmentsForDoctor (?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_APPFORDOCTOR)) {
            stmt.setInt(1, doctorId);
            try (ResultSet resultSet = stmt.executeQuery()) {
                List<Appointment> appointments = new ArrayList<>();
                while (resultSet.next()) {
                    Appointment app = new Appointment();
                    app.setId(resultSet.getInt("IDAppointment"));
                    app.setAnamnesis(resultSet.getString("Anamnesis"));
                    app.setDiagnosis(resultSet.getString("Diagnosis"));
                    app.setDoctorId(resultSet.getInt("DoctorID"));
                    app.setEndTime(resultSet.getTimestamp("EndTime").toLocalDateTime());
                    app.setPatientId(resultSet.getInt("PatientID"));
                    app.setStartTime(resultSet.getTimestamp("StartTime").toLocalDateTime());

                    appointments.add(app);
                }
                return appointments;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Appointment getAppointment(int id) {
        final String GET_APPOINTMENT = "{ CALL getAppointment (?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_APPOINTMENT)) {
            stmt.setInt(1, id);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    Appointment app = new Appointment();
                    app.setId(resultSet.getInt("IDAppointment"));
                    app.setAnamnesis(resultSet.getString("Anamnesis"));
                    app.setDiagnosis(resultSet.getString("Diagnosis"));
                    app.setDoctorId(resultSet.getInt("DoctorID"));
                    app.setEndTime(resultSet.getTimestamp("EndTime").toLocalDateTime());
                    app.setPatientId(resultSet.getInt("PatientID"));
                    app.setStartTime(resultSet.getTimestamp("StartTime").toLocalDateTime());

                    return app;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteAppointment(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateAppointment(Appointment appointment) {
        final String UPDATE_APPOINTMENT = "{ CALL updateAppointment (?,?,?,?,?,?,?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_APPOINTMENT)) {
            stmt.setInt(1, appointment.getId());
            stmt.setTimestamp(2, Timestamp.valueOf(appointment.getStartTime()));
            stmt.setTimestamp(3, Timestamp.valueOf(appointment.getEndTime()));
            stmt.setInt(4, appointment.getPatientId());
            stmt.setInt(5, appointment.getDoctorId());
            stmt.setString(6, appointment.getAnamnesis());
            stmt.setString(7, appointment.getDiagnosis());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertReceipt(Receipt receipt) {
        final String INSERT_RECEIPT = "{ CALL insertReceipt (?,?,?,?,?) }";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(INSERT_RECEIPT)) {
            stmt.setString(1, receipt.getReceiptNumber());
            stmt.setString(2, receipt.getDate().toString());
            stmt.setInt(3, receipt.getPaymentMethodId());
            stmt.setString(4, receipt.getComment());
            stmt.setInt(5, receipt.getPatientId());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Receipt getReceipt(int id) {
        final String GET_RECEIPT = "{ CALL getReceipt (?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_RECEIPT)) {
            stmt.setInt(1, id);
            try (ResultSet resultSet = stmt.executeQuery()) {
                List<ReceiptItem> items = new ArrayList<>();
                while (resultSet.next()) {
                    Receipt receipt = new Receipt();
                    receipt.setId(resultSet.getInt("IDReceipt"));
                    receipt.setComment(resultSet.getString("Comment"));
                    receipt.setDate(resultSet.getDate("Date").toLocalDate());
                    receipt.setPatientId(resultSet.getInt("PatientID"));
                    receipt.setPaymentMethodId(resultSet.getInt("PaymentMethodID"));
                    receipt.setReceiptNumber(resultSet.getString("ReceiptNumber"));

                    return receipt;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Receipt> getReceiptsforPatient(int pid) {
        final String GET_RECEIPTS = "{ CALL getReceiptsForPatient (?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_RECEIPTS)) {
            stmt.setInt(1, pid);
            try (ResultSet resultSet = stmt.executeQuery()) {
                List<Receipt> receipts = new ArrayList<>();
                while (resultSet.next()) {
                    Receipt receipt = new Receipt();
                    receipt.setId(resultSet.getInt("IDReceipt"));
                    receipt.setComment(resultSet.getString("Comment"));
                    receipt.setDate(resultSet.getDate("Date").toLocalDate());
                    receipt.setPatientId(resultSet.getInt("PatientID"));
                    receipt.setPaymentMethodId(resultSet.getInt("PaymentMethodID"));
                    receipt.setReceiptNumber(resultSet.getString("ReceiptNumber"));

                    receipts.add(receipt);
                }
                return receipts;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateReceipt(Receipt receipt) {
        final String UPDATE_RECEIPT = "{ CALL updateReceipt (?,?,?,?,?,?) }";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_RECEIPT)) {
            stmt.setInt(1, receipt.getId());
            stmt.setString(2, receipt.getReceiptNumber());
            stmt.setString(3, receipt.getDate().toString());
            stmt.setInt(4, receipt.getPaymentMethodId());
            stmt.setString(5, receipt.getComment());
            stmt.setInt(6, receipt.getPatientId());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteReceipt(int receiptId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertService(Service service) {
        final String INSERT_SERVICE = "{ CALL insertService (?,?,?,?) }";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(INSERT_SERVICE)) {

            stmt.setString(1, service.getType());
            stmt.setDouble(2, service.getPrice());
            stmt.setInt(3, service.getTypeOfServiceId());
            stmt.setString(4, service.getDescription());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Service getService(int serviceId) {
        final String GET_SERVICE = "{ CALL getService (?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_SERVICE)) {
            stmt.setInt(1, serviceId);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    Service service = new Service();

                    service.setId(resultSet.getInt("IDService"));
                    service.setDescription(resultSet.getString("Description"));
                    service.setPrice(resultSet.getDouble("Price"));
                    service.setType(resultSet.getString("Type"));
                    service.setTypeOfServiceId(resultSet.getInt("TypeOfServiceID"));

                    return service;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Service> getServices() {
        final String GET_SERVICES = "{ CALL getAllServices }";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_SERVICES);
                ResultSet resultSet = stmt.executeQuery()) {
            List<Service> services = new ArrayList<>();
            while (resultSet.next()) {
                Service service = new Service();

                service.setId(resultSet.getInt("IDService"));
                service.setDescription(resultSet.getString("Description"));
                service.setPrice(resultSet.getDouble("Price"));
                service.setType(resultSet.getString("Type"));
                service.setTypeOfServiceId(resultSet.getInt("TypeOfServiceID"));

                services.add(service);
            }
            return services;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateService(Service service) {
        final String UPDATE_SERVICE = "{ CALL updateService (?,?,?,?,?) }";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_SERVICE)) {
            stmt.setInt(1, service.getId());
            stmt.setString(2, service.getType());
            stmt.setDouble(3, service.getPrice());
            stmt.setInt(4, service.getTypeOfServiceId());
            stmt.setString(5, service.getDescription());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteService(int serviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertServiceForAppointment(ServiceAppointment sa) {
        final String INSERT_SERVICE = "{ CALL insertServiceAppointment (?,?,?,?) }";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(INSERT_SERVICE)) {

            stmt.setInt(1, sa.getServiceId());
            stmt.setInt(2, sa.getAppointmentId());
            stmt.setInt(3, sa.getQuantity());
            stmt.setString(4, sa.getDescription());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ServiceAppointment> getServicesForAppointment(int id) {
        final String GET_SERVICE_FOR_APPOINTMENT = "{ CALL getServicesForAppointment (?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_SERVICE_FOR_APPOINTMENT)) {
            stmt.setInt(1, id);
            try (ResultSet resultSet = stmt.executeQuery()) {
                List<ServiceAppointment> services = new ArrayList<>();
                while (resultSet.next()) {
                    ServiceAppointment service = new ServiceAppointment();

                    service.setId(resultSet.getInt("IDServiceForAppointment"));
                    service.setServiceId(resultSet.getInt("ServiceID"));
                    service.setAppointmentId(resultSet.getInt("AppointmentID"));
                    service.setQuantity(resultSet.getInt("Quantity"));
                    service.setDescription(resultSet.getString("Description"));

                    services.add(service);
                }
                return services;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateServiceForAppointment(ServiceAppointment sa) {
        final String UPDATE_SERVICE = "{ CALL updateServiceForAppointment (?,?,?,?,?) }";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_SERVICE)) {

            stmt.setInt(1, sa.getId());
            stmt.setInt(2, sa.getServiceId());
            stmt.setInt(3, sa.getAppointmentId());
            stmt.setInt(4, sa.getQuantity());
            stmt.setString(5, sa.getDescription());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteServiceForAppointment(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertReceiptItem(ReceiptItem item) {
        final String INSERT_RITEM = "{ CALL insertReceiptItem (?,?,?,?,?,?) }";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(INSERT_RITEM)) {

            stmt.setInt(1, item.getReceiptId());
            stmt.setInt(2, item.getServiceId());
            stmt.setDouble(3, item.getPricePerItem());
            stmt.setDouble(4, item.getDiscount());
            stmt.setDouble(5, item.getTotalPrice());
            stmt.setInt(6, item.getQuantity());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ReceiptItem> getReceiptItems(int receiptId) {
        final String GET_RITEM = "{ CALL getReceiptItemsForReceipt (?)}";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_RITEM)) {
            stmt.setInt(1, receiptId);
            try (ResultSet resultSet = stmt.executeQuery()) {
                List<ReceiptItem> receiptItems = new ArrayList<>();
                while (resultSet.next()) {
                    ReceiptItem item = new ReceiptItem();

                    item.setId(resultSet.getInt("IDReceiptItem"));
                    item.setReceiptId(resultSet.getInt("ReceiptID"));
                    item.setServiceId(resultSet.getInt("ServiceID"));
                    item.setPricePerItem(resultSet.getDouble("PricePerItem"));
                    item.setDiscount(resultSet.getDouble("DiscountPercentage"));
                    item.setTotalPrice(resultSet.getDouble("TotalPrice"));
                    item.setQuantity(resultSet.getInt("Quantity"));

                    receiptItems.add(item);
                }
                return receiptItems;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateReceiptItem(ReceiptItem item) {
        final String UPDATE_RITEM = "{ CALL updateReceiptItem (?,?,?,?,?,?,?) }";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_RITEM)) {

            stmt.setInt(1, item.getId());
            stmt.setInt(2, item.getReceiptId());
            stmt.setInt(3, item.getServiceId());
            stmt.setDouble(4, item.getPricePerItem());
            stmt.setDouble(5, item.getDiscount());
            stmt.setDouble(6, item.getTotalPrice());
            stmt.setInt(7, item.getQuantity());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteReceiptItem(int itemId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Doctor> getGeneralPhysicians() {
        final String GET_DOCTORS = "{ CALL getGeneralPhysicians }";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_DOCTORS);
                ResultSet resultSet = stmt.executeQuery()) {

            List<Doctor> doctors = new ArrayList<>();
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
        return null;
    }

    @Override
    public Doctor getDoctorForPatient(int pid) {
        final String GET_DOCTOR = "{ CALL getDoctorForPatient (?) }";

        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_DOCTOR)) {
            stmt.setInt(1, pid);
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
    public void assignDoctorForPatient(int pid, int doctorId) {
        final String ASSIGN_DOCTOR = "{ CALL assignPatientToDoctor (?,?,?) }";
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(ASSIGN_DOCTOR)) {
            stmt.setInt(1, pid);
            stmt.setInt(2, doctorId);
            stmt.setString(3, LocalDateTime.now().toString());

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TypeOfService> getTypesOfService() {
        final String GET_TYPES_OF_SERVICE = "{ CALL getTypesOfService }";

        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_TYPES_OF_SERVICE)) {
            try (ResultSet resultSet = stmt.executeQuery()) {
                List<TypeOfService> types = new ArrayList<>();
                while (resultSet.next()) {
                    TypeOfService type = new TypeOfService();
                    type.setId(resultSet.getInt("IDTypeOfService"));
                    type.setType(resultSet.getString("Type"));
                    types.add(type);
                }
                return types;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
