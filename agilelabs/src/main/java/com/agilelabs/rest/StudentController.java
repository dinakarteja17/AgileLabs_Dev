package com.agilelabs.rest;

import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.agilelabs.dto.StudentDTO;
import com.agilelabs.exception.UserAlreadyExistsException;
import com.agilelabs.serviceImpl.EmailServiceImpl;
import com.agilelabs.serviceImpl.StudentServiceImpl;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private final StudentServiceImpl studentServiceImpl;

    @Autowired
    private EmailServiceImpl emailService;

    public StudentController(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody StudentDTO studentDTO) {
        try {
            studentServiceImpl.signup(studentDTO);
            return new ResponseEntity<>("created successfully", HttpStatus.CREATED);
        } catch (UserAlreadyExistsException e) {
            return new ResponseEntity<>("User with the same email or phone number already exists", HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable int id) {
        StudentDTO student = studentServiceImpl.getStudentById(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//   @GetMapping("/login")
    @PostMapping("/login")
    
    public ResponseEntity<StudentDTO> getStudent(@RequestBody StudentDTO studentDTO) {
        StudentDTO student = studentServiceImpl.studentLogin(studentDTO.getEmail(), studentDTO.getPassword());
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


//    @PostMapping("/login")
//    public ResponseEntity<StudentDTO> getStudent(@RequestBody StudentDTO studentDTO) {
//
//        StudentDTO student = studentServiceImpl.studentLogin(studentDTO.getEmail(), studentDTO.getPassword());
//
//        if (student != null) {
//            return ResponseEntity.ok(student);
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
//        }
//    }









//@PostMapping("/login")
//public ResponseEntity<String> yourMethodName(@RequestParam("email") String email, @RequestParam("password") String password) {
//    // Your code logic here
//
//    return ResponseEntity.ok("Success");
//




    @PostMapping("/password-reset")
    public ResponseEntity<String> resetPassword(@RequestBody StudentDTO studentDTO) {
    	String email=studentDTO.getEmail();
        try {
            StudentDTO student = studentServiceImpl.getStudentByEmail(email);
          
            if (student != null) {
                String otp = generateOTP();
                
                emailService.sendPasswordResetEmail(email, "Password Reset OTP", "Your OTP for Password Reset is: " + otp);
                
                studentServiceImpl.storeOtp(email, otp);
                
                return ResponseEntity.ok("OTP sent to your email.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found in the database");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
        }
    }

    private String generateOTP() {
        Random random = new Random();
        return String.format("%06d", random.nextInt(1000000));
    }

    @PostMapping("/forgotpassword")
    public ResponseEntity<String> validateOtp(@RequestBody Map<String, String> requestBody) {
        try {
            String email = requestBody.get("email");
            String otp = requestBody.get("otp");

            String storedOtp = studentServiceImpl.getStoredOtp(email);

            if (storedOtp != null && storedOtp.equals(otp)) {
                // OTP is valid
                return ResponseEntity.ok("OTP is valid.");
            } else {
                // Invalid OTP
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid OTP.");
            }
        } catch (Exception e) {
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
        }
    }

    @PutMapping("/updatepassword")
    public ResponseEntity<String> updatePassword(@RequestBody StudentDTO studentDTO) {
        try {
        
            // Perform updatePassword operation
            studentServiceImpl.updatePassword(studentDTO);

            return ResponseEntity.ok("Password updated successfully.");
        } catch (Exception e) {
           
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
        }
    }
}
