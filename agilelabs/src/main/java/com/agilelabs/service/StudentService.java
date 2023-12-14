package com.agilelabs.service;

import com.agilelabs.dto.StudentDTO;
import com.agilelabs.entity.StudentEntity;

public interface StudentService {

    StudentEntity signup(StudentEntity student);

    StudentEntity getStudentById(int id);

    StudentEntity studentLogin(String email, String password);

    StudentEntity getStudentByEmail(String email);

    void storeOtp(String email, String otp);

    String getStoredOtp(String email);
    void updatePassword(StudentEntity studentEntity);
    void updatePassword(StudentDTO studentDTO);
}
