/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.dal.repository;

import com.kvlahov.model.Appointment;
import com.kvlahov.model.Doctor;
import com.kvlahov.model.Patient;
import com.kvlahov.model.PaymentMethod;
import com.kvlahov.model.Receipt;
import com.kvlahov.model.ReceiptItem;
import com.kvlahov.model.Service;
import com.kvlahov.model.ServiceAppointment;
import com.kvlahov.model.TypeOfService;
import com.kvlahov.model.User;
import com.kvlahov.model.enums.AddressType;
import com.kvlahov.model.enums.ContactType;
import com.kvlahov.model.enums.UserRole;
import com.kvlahov.model.patientInfo.ComplaintsInfo;
import com.kvlahov.model.patientInfo.Contact;
import com.kvlahov.model.patientInfo.ContactInfo;
import com.kvlahov.model.patientInfo.LifestyleInfo;
import com.kvlahov.model.patientInfo.NextOfKin;
import com.kvlahov.model.patientInfo.PersonalInfo;
import com.kvlahov.model.report.DailyReport;
import com.kvlahov.model.report.StatNewRecurringPatients;
import com.kvlahov.model.report.StatPatientsTreated;
import com.kvlahov.model.report.StatServiceSummary;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author dnlbe
 */
public interface IRepository {
    //Patient CRUD
    int insertPatient(Patient patient);
    Patient getPatient(int id);
    List<Patient> getPatients();
    List<Patient> getPatientsForDoctor(int idDoctor);
    void updatePatient(Patient newPatient, int idPatient);
        
    //Patient info
    void insertComplaint(int pid, ComplaintsInfo complaints);
    void insertLifestyle(int pid, LifestyleInfo lifestyle);
    void insertPersonalInfo(int pid, PersonalInfo personal);
    int insertNextOfKin(int pid, NextOfKin nok);
    void insertNextOfKinAdd(int nokId, ContactInfo.Address add);
    void insertNextOfKinContact(int nokId, Contact contact);
    
    void insertPatientAddress(int pid, ContactInfo.Address add);
    void insertPatientContact(int pid, Contact contact);
    
    //Patient info get
    ComplaintsInfo getComplaint(int pid);
    LifestyleInfo getLifestyle(int pid);
    NextOfKin getNextOfKin(int pid);
    ContactInfo.Address getNextOfKinAdd(int nok);
    List<Contact> getNextOfKinContact(int nok);
    
    List<ContactInfo.Address> getPatientAddress(int pid);
    List<Contact> getPatientContact(int pid);
    PersonalInfo getPersonalInfo(int pid);
    List<ContactType> getContactTypes();
    List<AddressType> getAddressTypes();
    
    //Patient info update
    void updateComplaints(int pid, ComplaintsInfo c);
    void updateLifestyle(int pid, LifestyleInfo lifestyle);
    void updatePersonalInfo(int pid, PersonalInfo personalInfo);
    
    void updateNextOfKin(int pid, NextOfKin nok);        
    void updateAddress(ContactInfo.Address add);
    void updateContact(Contact contact);
    
    //Doctors CRUD
    int insertDoctor(Doctor doctor);
    Doctor getDoctor(int idDoctor);
    List<Doctor> getDoctors();
    void updateDoctor(Doctor doctor);
    void deleteDoctor(int doctorId);
    
    List<Doctor> getGeneralPhysicians();
    Doctor getDoctorForPatient(int pid);
    void assignDoctorForPatient(int pid, int doctorId);
    
    //Users
    boolean isValidUser(User user);
    UserRole getUserRole(int id);
    public UserRole getRoleForUser(User user);

    //Appointment CRUD
    public void insertAppointment(Appointment appointment);
    public List<Appointment> getScheduledAppointments(int doctorId);
    public Appointment getAppointment(int id);
    public void deleteAppointment(int id);
    public void updateAppointment(Appointment appointment);
    public List<Appointment> getAppointmentsForPatient(int pid);

    //Receipt CRUD
    public int insertReceipt(Receipt receipt);
    public Receipt getReceipt(int id);
    public List<Receipt> getReceiptsForPatient(int pid);
    public void updateReceipt(Receipt receipt);
    public void deleteReceipt(int receiptId);
    
    public void insertReceiptItem(ReceiptItem item);
    public List<ReceiptItem> getReceiptItems(int receiptId);
    public void updateReceiptItem(ReceiptItem item);
    public void deleteReceiptItem(int itemId);
    
    public List<PaymentMethod> getAllPaymentMethods();
    
    //Service CRUD
    public void insertService(Service service);
    public Service getService(int serviceId);
    public List<Service> getServices();
    public void updateService(Service service);
    public void deleteService(int serviceId);
    
    public void insertServiceForAppointment(ServiceAppointment sa);
    public List<ServiceAppointment> getServicesForAppointment(int id);
    public void updateServiceForAppointment(ServiceAppointment sa);
    public void deleteServiceForAppointment(int id);

    public List<TypeOfService> getTypesOfService();
    
    //Stats
    
    public StatNewRecurringPatients getNewRecurringPatients(LocalDate date);
    public List<StatNewRecurringPatients> getNewRecurringPatients(LocalDate startDate, LocalDate endDate);
    
    public List<StatPatientsTreated> getNoOfPatientsTreated(LocalDate startDate, LocalDate endDate);
    public List<StatServiceSummary> getServicesSummary(LocalDate date);
    
}
