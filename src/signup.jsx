import './signup.css'

import React, { useState } from 'react';

function Signup() {
  const [formData, setFormData] = useState({
    firstName:'',
    lastName: '',
    dateOfBirth:'',
    email: '',
    password: '',
    confirmPassword: '',
    qualification: '',
    phoneNumber: '',
  });
  

  function calculateAge(dateOfBirth) {
    const dob = new Date(dateOfBirth);
    const today = new Date();
  
    // Calculate the difference in milliseconds
    const ageDiff = today - dob;
  
    // Convert the age difference from milliseconds to years
    const ageDate = new Date(ageDiff);
    const years = ageDate.getUTCFullYear() - 1970;
  
    return years;
  }
  


  const [errors, setErrors] = useState({});

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };


  const handleClickCancel = () =>
  {
    setFormData(
      {
        firstName :'',
        lastName:'',
        dateOfBirth:'',
        email:'',
        password:'',
        confirmPassword:'',
        qualification:'',
        phoneNumber:'',
      }
    )
  };

  const UsernameRegex = /^[a-zA-Z]+$/;
   const mailRegex= /\.com$|\.in$/;
  // const passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
  const qualificationRegex= /^[A-Za-z0-9\s.,'-]+$/i;
  const phonenumberRegex=  /^\d{10}$/;



  const handleSubmit = async (e) => {
    e.preventDefault();

  try {
    const response = await fetch('http://localhost:8080/api/students/signup', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(formData),
    });

    if (response.status === 200) {
      // Successful signup, update state or redirect to a success page
      console.log('Signup successful');
    } else {
      // Handle signup error, e.g., show an error message
      console.error('Signup failed');
    }
  } catch (error) {
    console.error(error);
  }

  
   setFormData(
      {
        firstName :'',
        lastName:'',
        dateOfBirth:'',
        email:'',
        password:'',
        confirmPassword:'',
        qualification:'',
        phoneNumber:'',
      }
    )



   // Empty dependency array ensures the effect runs only once (on component mount)
    
    setErrors({});
    // You can add your signup logic here, e.g., sending a POST request to your server
   

    const dateOfBirth = formData.dateOfBirth; // Replace with the entered date of birth
const age = calculateAge(dateOfBirth);
console.log(`Age: ${age} years`);


// Basic form validation
    const newErrors = {};
    if (!UsernameRegex.test(formData.firstName)) {
      
      newErrors.firstName = 'Firstname is required';
  
   
    }
    if (!UsernameRegex.test(formData.lastName)) {
      newErrors.lastName = 'Lastname is required';
    }
    if (!mailRegex.test(formData.email)) {
      newErrors.email = ' Mail is required';
    }


    if(formData.password.length>3)
    {
      if (formData.password.length < 8 && formData.password.length < 12 ){
        newErrors.password = 'Password is in 8 to 12 characters';
      }
      else if(formData.password.length > 12 )
      {
        newErrors.password ="Password is too long ";
      }
    }
    else{
      newErrors.password ="Password is required";
    }

    if(formData.password.length>3)
    {
      if (formData.password !== formData.confirmPassword) {
        newErrors.confirmPassword = 'Passwords do not match';
      }
    }
    else{
      newErrors.confirmPassword='Confirm password is required';
    }
    


    if (!qualificationRegex.test(formData.qualification)) {
      newErrors.qualification = 'Qualification is required';
    }

    if(age > 18)
    {
      newErrors.date ="Age is valid";
    }
    else{
      newErrors.date="Invalid Age";
      window.alert(newErrors.date +" Unable To Access");
    }



    if(phonenumberRegex.test(formData.phoneNumber))
    {
      newErrors.phoneNumber="valid number";
    }
    else if(formData.phoneNumber.length >10)
    {
      newErrors.phoneNumber ="Not a valid over 11 digits";
    }
    else if(!phonenumberRegex.test(formData.phoneNumber))
    {
      newErrors.phoneNumber ="(only numbers)";
    }

    else{
      newErrors.phoneNumber ="phone is required";
    }
    
  
    //If there are validation errors, set them and return early
    if (Object.keys(newErrors).length > 0) {
      setErrors(newErrors);
      return;
    }

   
  };

  return (
    <div  className='signup-background'> 
    
      <form onSubmit={handleSubmit}>
      <h1>Sign Up</h1>
        <div>
          <label>First Name</label>
          <input
            type="text"
            name="firstName"
            id="firstnamelabel"
            value={formData.firstName}
            onChange={handleChange}
            
          />
          
           {errors.firstName && <p className="error-message">{errors.firstName}</p>}
        </div>
        <div>
          <label>Last Name</label>
          <input
            type="text"
            name="lastName"
            id="lastnamelabel"
            value={formData.lastName}
            onChange={handleChange}
            
          />
          {errors.lastName && <p className="error-message">{errors.lastName}</p>}
        </div>

        <div>

        <label>Date of Birth</label>
          <input
            type="date"
            name="dateOfBirth"
            id="datelabel"
            value={formData.dateOfBirth}
            onChange={handleChange}
           
          />
          {errors.date && <p className="error-message">{errors.date}</p>}
        </div>

        <div>
          <label>Email</label>
          <input
            type="email"
            name="email"
            id="emaillabel"
            value={formData.email}
            onChange={handleChange}
           
          />
          {errors.email && <p className="error-message">{errors.email}</p>}
        </div>
        <div>
          <label>Password</label>
          <input
            type="password"
            name="password"
            id="passwordlabel"
            value={formData.password}
            onChange={handleChange}
            
          />
           {errors.password && <p className="error-message">{errors.password}</p>}
        </div>
        <div>
          <label>Confirm Password</label>
          <input
            type="password"
            name="confirmPassword"
            id="confirmpasswordlabel"
            value={formData.confirmPassword}
            onChange={handleChange}
           
          />
           {errors.confirmPassword && <p className="error-message">{errors.confirmPassword}</p>}
        </div>
        <div>
          <label>Qualification</label>
          <input
            type="text"
            name="qualification"
            id="qualificationlabel"
            value={formData.qualification}
            onChange={handleChange}
           
          />
           {errors.qualification && <p className="error-message">{errors.qualification}</p>}
        </div>
        <div>
          <label>Phone Number</label>
          <input
            type="tel"
            name="phoneNumber"
            id="phonenumberlabel"
            value={formData.phoneNumber}
            onChange={handleChange}
            
          />
          {errors.phoneNumber && <p className="error-message">{errors.phoneNumber}</p>}
        </div>
        <div>
          <button type="submit" className='submitarea'>Sign Up</button> 
          </div>
        <div>
        <button className='resetarea' onClick={handleClickCancel}>Cancel</button>
        </div>
      </form>
    </div>
  );
}

export default Signup;





