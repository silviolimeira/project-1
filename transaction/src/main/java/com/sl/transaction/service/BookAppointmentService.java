package com.sl.transaction.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sl.transaction.controller.dto.AppointmentFormDto;
import com.sl.transaction.entity.Appointment;
import com.sl.transaction.entity.Patient;
import com.sl.transaction.repository.AppointmentRepo;
import com.sl.transaction.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


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
