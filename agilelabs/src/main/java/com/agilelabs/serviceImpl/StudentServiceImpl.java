//package com.agilelabs.serviceImpl;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.Cache;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.agilelabs.dto.StudentDTO;
//import com.agilelabs.entity.StudentEntity;
//import com.agilelabs.exception.NotFoundException;
//import com.agilelabs.exception.UserAlreadyExistsException;
//import com.agilelabs.repository.StudentRepository;
//
//@Service
//@Transactional
//@CacheConfig(cacheNames = "otpCache")
//public class StudentServiceImpl {
//	private final StudentRepository studentRepository;
//
//	@Autowired
//	private CacheManager cacheManager;
//	
//
//	@Autowired
//	public StudentServiceImpl(StudentRepository studentRepository) {
//		this.studentRepository = studentRepository;
//	}
//	
//	
//	
//	private final RedisTemplate<Object, Object> redisTemplate;
//
//    public StudentServiceImple(RedisTemplate<Object, Object> redisTemplate) {
//        this.redisTemplate = redisTemplate;
//    }
//
//    public void storeOtp(String email, String otp) {
//        redisTemplate.opsForValue().set("otpCache:" + email, otp, Duration.ofMinutes(10)); // Set your desired expiration time
//    }
//
//    public String getStoredOtp(String email) {
//        return (String) redisTemplate.opsForValue().get("otpCache:" + email);
//    }
//
//	public StudentDTO signup(StudentDTO studentDTO) {
//
//		StudentEntity studentEntity = convertToEntity(studentDTO);
//		// Checking if a user with the same email or phone already exists
//		StudentEntity studentData = studentRepository.findByEmailOrPhoneNumber(studentDTO.getEmail(),
//				studentDTO.getPhoneNumber());
//
//		// Handling the case where the user already exists
//		if (studentData != null) {
//			
//			throw new UserAlreadyExistsException("User with the same email or phone number already exists");
//		}
//
//		// Save the new user since no existing user with the same email or phone is
//		// found
//		StudentEntity createdStudentEntity = studentRepository.save(studentEntity);
//
//		return convertToDTO(createdStudentEntity);
//	}
//
//	public StudentDTO getStudentById(int id) {
//		StudentEntity studentEntity = studentRepository.findById(id)
//				.orElseThrow(() -> new NotFoundException("Student not found"));
//
//		return convertToDTO(studentEntity);
//	}
//
//	public StudentDTO studentLogin(String email, String password) {
//		Optional<StudentEntity> studentOptional = studentRepository.findByEmailAndPassword(email, password);
//		StudentEntity studentEntity = studentOptional.orElseThrow(() -> new NotFoundException("Student not found"));
//
//		return convertToDTO(studentEntity);
//	}
//
//	public StudentDTO getStudentByEmail(String email) {
//		StudentEntity studentEntity = studentRepository.findByEmail(email)
//				.orElseThrow(() -> new NotFoundException("Student not found"));
//
//		return convertToDTO(studentEntity);
//	}
//
//	public void storeOtp(String email, String otp) {
//		Cache cache = cacheManager.getCache("otpCache");
//		if (cache != null) {
//			cache.put(email, otp);
//		}
//	}
//
//	public String getStoredOtp(String email) {
//		Cache cache = cacheManager.getCache("otpCache");
//		if (cache != null) {
//			Cache.ValueWrapper valueWrapper = cache.get(email);
//			if (valueWrapper != null) {
//				return (String) valueWrapper.get();
//			}
//		}
//		return null;
//	}
//
//	public void updatePassword(StudentDTO studentDTO) {
//
//		// Retrieve the student by email
//		StudentDTO studentdata = getStudentByEmail(studentDTO.getEmail());
//		StudentEntity studentEntity = convertToEntity(studentdata);
//
//		// Update the password
//		studentEntity.setPassword(studentDTO.getPassword());
//
//		// Save the updated student entity
//		studentRepository.save(studentEntity);
//	}
//
//	// Helper method to convert StudentDTO to StudentEntity
//	private StudentEntity convertToEntity(StudentDTO studentDTO) {
//		StudentEntity studentEntity = new StudentEntity();
//		studentEntity.setId(studentDTO.getId());
//		studentEntity.setFirstName(studentDTO.getFirstName());
//		studentEntity.setLastName(studentDTO.getLastName());
//		studentEntity.setEmail(studentDTO.getEmail());
//		studentEntity.setDateOfBirth(studentDTO.getDateOfBirth());
//		studentEntity.setPassword(studentDTO.getPassword());
//		studentEntity.setPhoneNumber(studentDTO.getPhoneNumber());
//		studentEntity.setQualification(studentDTO.getQualification());
//
//		return studentEntity;
//	}
//
//	// Helper method to convert StudentEntity to StudentDTO
//	private StudentDTO convertToDTO(StudentEntity studentEntity) {
//		StudentDTO studentDTO = new StudentDTO();
//		studentDTO.setId(studentEntity.getId());
//		studentDTO.setFirstName(studentEntity.getFirstName());
//		studentDTO.setLastName(studentEntity.getLastName());
//		studentDTO.setEmail(studentEntity.getEmail());
//		studentDTO.setDateOfBirth(studentEntity.getDateOfBirth());
//		studentDTO.setPassword(studentEntity.getPassword());
//		studentDTO.setPhoneNumber(studentEntity.getPhoneNumber());
//		studentDTO.setQualification(studentEntity.getQualification());
//
//		return studentDTO;
//	}
//}

package com.agilelabs.serviceImpl;

import java.time.Duration;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agilelabs.dto.StudentDTO;
import com.agilelabs.entity.StudentEntity;
import com.agilelabs.exception.NotFoundException;
import com.agilelabs.exception.UserAlreadyExistsException;
import com.agilelabs.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl {

    private final StudentRepository studentRepository;
    private final CacheManager cacheManager;
    private final RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, CacheManager cacheManager,
                              RedisTemplate<Object, Object> redisTemplate) {
        this.studentRepository = studentRepository;
        this.cacheManager = cacheManager;
        this.redisTemplate = redisTemplate;
    }

    public StudentDTO signup(StudentDTO studentDTO) {
        StudentEntity studentEntity = convertToEntity(studentDTO);

        // Checking if a user with the same email or phone already exists
        StudentEntity existingStudent = studentRepository.findByEmailOrPhoneNumber(
                studentDTO.getEmail(), studentDTO.getPhoneNumber());

        // Handling the case where the user already exists
        if (existingStudent != null) {
            throw new UserAlreadyExistsException("User with the same email or phone number already exists");
        }

        // Save the new user since no existing user with the same email or phone is found
        StudentEntity createdStudentEntity = studentRepository.save(studentEntity);

        return convertToDTO(createdStudentEntity);
    }

    public StudentDTO getStudentById(int id) {
        StudentEntity studentEntity = studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Student not found"));

        return convertToDTO(studentEntity);
    }

    public StudentDTO studentLogin(String email, String password) {
        Optional<StudentEntity> studentOptional = studentRepository.findByEmailAndPassword(email, password);
        StudentEntity studentEntity = studentOptional.orElseThrow(() -> new NotFoundException("Student not found"));

        return convertToDTO(studentEntity);
    }

    public StudentDTO getStudentByEmail(String email) {
        StudentEntity studentEntity = studentRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Student not found"));

        return convertToDTO(studentEntity);
    }

    public void storeOtp(String email, String otp) {
        try {
            
            if (redisTemplate != null) {
                redisTemplate.opsForValue().set("otpCache:" + email, otp, Duration.ofMinutes(10));
            
            } else {
                System.err.println("RedisTemplate is null");
            }
        } catch (Exception e) {
            // Log the exception or print the stack trace
            e.printStackTrace();
           
        }
    }


    public String getStoredOtp(String email) {
        return (String) redisTemplate.opsForValue().get("otpCache:" + email);
    }

    public void updatePassword(StudentDTO studentDTO) {
        // Retrieve the student by email
        StudentDTO studentData = getStudentByEmail(studentDTO.getEmail());
        StudentEntity studentEntity = convertToEntity(studentData);

        // Update the password
        studentEntity.setPassword(studentDTO.getPassword());

        // Save the updated student entity
        studentRepository.save(studentEntity);
    }

    // Helper method to convert StudentDTO to StudentEntity
    private StudentEntity convertToEntity(StudentDTO studentDTO) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(studentDTO.getId());
        studentEntity.setFirstName(studentDTO.getFirstName());
        studentEntity.setLastName(studentDTO.getLastName());
        studentEntity.setEmail(studentDTO.getEmail());
        studentEntity.setDateOfBirth(studentDTO.getDateOfBirth());
        studentEntity.setPassword(studentDTO.getPassword());
        studentEntity.setPhoneNumber(studentDTO.getPhoneNumber());
        studentEntity.setQualification(studentDTO.getQualification());

        return studentEntity;
    }

    // Helper method to convert StudentEntity to StudentDTO
    private StudentDTO convertToDTO(StudentEntity studentEntity) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(studentEntity.getId());
        studentDTO.setFirstName(studentEntity.getFirstName());
        studentDTO.setLastName(studentEntity.getLastName());
        studentDTO.setEmail(studentEntity.getEmail());
        studentDTO.setDateOfBirth(studentEntity.getDateOfBirth());
        studentDTO.setPassword(studentEntity.getPassword());
        studentDTO.setPhoneNumber(studentEntity.getPhoneNumber());
        studentDTO.setQualification(studentEntity.getQualification());

        return studentDTO;
    }
}
