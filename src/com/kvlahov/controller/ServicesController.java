/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.controller;

import com.kvlahov.dal.repository.IRepository;
import com.kvlahov.dal.repository.RepositoryFactory;
import com.kvlahov.exceptions.InvalidModelException;
import com.kvlahov.model.Appointment;
import com.kvlahov.model.Service;
import com.kvlahov.model.ServiceAppointment;
import com.kvlahov.model.TypeOfService;
import java.util.List;

/**
 *
 * @author programer10
 */
public class ServicesController {

    private static final IRepository repo = RepositoryFactory.getRepository();

    public static List<Service> getServices() {
        return repo.getServices();
    }

    public static List<ServiceAppointment> getServicesForAppointment(Appointment appointment) {
        return repo.getServicesForAppointment(appointment.getId());
    }

    public static List<TypeOfService> getTypesOfService() {
        return repo.getTypesOfService();
    }

    public static Service getService(int serviceId) {
        return repo.getService(serviceId);
    }

    public static void insertService(Service service) throws InvalidModelException {
        if (!service.isValid()) {
            throw new InvalidModelException();
        }

        repo.insertService(service);
    }

    public static void insertServiceForAppointment(ServiceAppointment sa) throws InvalidModelException {
        if (!sa.isValid()) {
            throw new InvalidModelException();
        }

        repo.insertServiceForAppointment(sa);
    }

    public static void updateService(Service service) throws InvalidModelException {
        if (!service.isValid()) {
            throw new InvalidModelException();
        }

        repo.updateService(service);
    }

    public static void updateServiceForAppointment(ServiceAppointment sa) throws InvalidModelException {
        if (!sa.isValid()) {
            throw new InvalidModelException();
        }

        repo.updateServiceForAppointment(sa);
    }

    public static void deleteService(Service service) {
        repo.deleteService(service.getId());
    }

    public static void deleteServiceForAppointment(ServiceAppointment sa) {
        repo.deleteServiceForAppointment(sa.getId());
    }

    public static void addServicesForAppointment(List<ServiceAppointment> servicesForAppointment) throws InvalidModelException {
        for (ServiceAppointment sa : servicesForAppointment) {
            if (!sa.isValid()) {
                throw new InvalidModelException();
            }
            if(sa.getId() > 0) {
                repo.updateServiceForAppointment(sa);
            } else {
                repo.insertServiceForAppointment(sa);
            }
        }
    }

}
