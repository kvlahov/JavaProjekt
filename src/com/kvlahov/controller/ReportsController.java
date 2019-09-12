/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.controller;

import com.kvlahov.dal.repository.IRepository;
import com.kvlahov.dal.repository.RepositoryFactory;
import com.kvlahov.model.report.DailyReport;
import com.kvlahov.model.report.GeneralReport;
import com.kvlahov.utils.Utilities;
import java.time.LocalDate;

/**
 *
 * @author lordo
 */
public class ReportsController {

    private static final IRepository repo = RepositoryFactory.getRepository();

    public static DailyReport generateDailyReport(LocalDate date) {
        DailyReport dailyReport = new DailyReport();
        
        dailyReport.setDate(date);
        dailyReport.setNewReccuringPatients(repo.getNewRecurringPatients(date));
        dailyReport.setPatientsTreated(repo.getNoOfPatientsTreated(date, date));
        dailyReport.setServicesSummary(repo.getServicesSummary(date));
        
        return dailyReport;
    }

    public static GeneralReport generateWeeklyReport(LocalDate date) {
        LocalDate startOfWeek = Utilities.getStartOfWeek(date);
        LocalDate endOfWeek = startOfWeek.plusDays(6);
        
        return getGeneralReport(startOfWeek, endOfWeek);
    }

    public static GeneralReport generateMonthlyReport(LocalDate date) {
        LocalDate startOfMonth = Utilities.getStartOfMonth(date);
        LocalDate endOfMonth = Utilities.getEndOfMonth(date);
        
        return getGeneralReport(startOfMonth, endOfMonth);
    }
    
    private static GeneralReport getGeneralReport(LocalDate startDate, LocalDate endDate) {
        GeneralReport generalReport = new GeneralReport();
        generalReport.setStartDate(startDate);
        generalReport.setEndDate(endDate);
        generalReport.setNewReccuringPatients(repo.getNewRecurringPatients(startDate, endDate));
        generalReport.setPatientsTreated(repo.getNoOfPatientsTreated(startDate, endDate));
        
        return generalReport;
    }
}
