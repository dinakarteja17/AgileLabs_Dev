package com.agilelabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agilelabs.entity.StudentEntity;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
    Optional<StudentEntity> findById(int id);
    Optional<StudentEntity> findByEmailAndPassword(String email, String password);
    Optional<StudentEntity> findByEmail(String email);
    StudentEntity getStudentByEmail(String email);
    StudentEntity findByEmailOrPhoneNumber(String email, long phoneNumber);
}
