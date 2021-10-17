package com.sl.jwt.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sl.jwt.controller.dto.AppointmentFormDto;
import com.sl.jwt.domain.Appointment;
import com.sl.jwt.domain.Patient;
import com.sl.jwt.repository.AppointmentRepo;
import com.sl.jwt.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@Transactional
public class BookAppointmentService {

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private AppointmentRepo appointmentRepo;

    public String bookAppointment(AppointmentFormDto appointmentFormDto) {

        Patient patient = new ObjectMapper().convertValue(appointmentFormDto, Patient.class);
        Long patientNo = patientRepo.save(patient).getPatientNo();
        System.out.println(">>>>>>>> patient saved successfully !");

        System.out.println(10/0);

        Appointment appointment = Appointment.builder()
                .date(LocalDate.now())
                .doctorNo(101L)
                .patinentNo(patientNo)
                .build();
        Long appointmentNo = appointmentRepo.save(appointment).getAppointmentNo();
        System.out.println(">>>>>>>> appointment saved successfully ! with: " + appointmentNo);

        return "Appointment saved successfully ! with: " + appointmentNo;

    }
}
