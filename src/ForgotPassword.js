
import './index.css';
import './forgotpassword.css'
import React, { useState, useNavigate } from 'react';

 export default function App() {
  // const navigate = useNavigate();
  const [step, setStep] = useState(1);
  const [email, setEmail] = useState('');
  const [otp, setOtp] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [errorMessage, setErrorMessage] = useState('');

  const sendOTP = async (email) => {
    try {
      const response = await fetch('http://localhost:8080/api/students/password-reset', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ email }),
      });

      if (response.ok) {
        console.log('OTP has been sent to your email.');
      } else {
        console.log('Failed to send OTP. Please try again.');
      }
    } catch (error) {
      console.error('Error sending OTP:', error);
    }
  };

const validateEmailOTP = async (email, otp) => {
  try {
    const response = await fetch('http://localhost:8080/api/students/forgotpassword', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ email, otp }),
    });

    if (response.ok) {
      // Handle success: OTP validated successfully
      console.log('Email OTP validated successfully.');
      // Perform further actions upon successful validation
    } else {
      // Handle failure: Invalid OTP
      console.log('Invalid Email OTP. Please try again.');
    }
  } catch (error) {
    console.error('Error validating Email OTP:', error);
    // Handle error scenarios
  }
};




const SetNewPassword = async (email,password) => {
 
  try {
    const response = await fetch('http://localhost:8080/api/students/updatepassword', {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ email,password }),
    });

    if (response.ok) {
      // Password set successfully
      console.log('Password set successfully:', password);
    
    } else {
      // Handle API error
    
      console.log('Failed to set password.');
    }
  } catch (error) {
    console.error('Error setting password:', error);
  }
};



  const handleEmailSubmit = async (e) => {
    e.preventDefault();
    if (!email) {
      setErrorMessage('Email is required.');
    } else {
      setErrorMessage('');
      setStep(2);
      sendOTP(email);
    }
  };

  const handleOtpSubmit = async (e) => {
    e.preventDefault();
    
    if (!otp) {
      setErrorMessage('OTP is required.');
    } else {
      setErrorMessage('');
      setStep(3);
        validateEmailOTP(email,otp); 

      
    }
  };
  const handlePasswordSubmit = (e) => {
        e.preventDefault();
        if (!password || !confirmPassword) 
        {
          setErrorMessage('Both Password and Confirm Password are required.');
        } 
        else if (password !== confirmPassword)
       {
          setErrorMessage('Passwords do not match.');
       } 
       else 
       {
          setErrorMessage('');
          setStep(4);
          SetNewPassword(email,password);
         }
        };


  return (
      <div className="signup-background">
        <div >
          <h1 id='forgotpasswordheader'>Forgot Password</h1>
          {errorMessage && <p className="error-message">{errorMessage}</p>}
          {step === 1 && (
            <form onSubmit={handleEmailSubmit} className='forgotpasswordform'>
              <div>
              <label htmlFor="email" id="enteremailheader">Enter your Gmail:</label>
              <br></br>
              <input
                type="text"
                id="email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                
              />
             <br></br>
              <br></br>
              <button type="submit" id="nextemail">Next</button>
              </div>
            </form>
          )}
          </div>
    
          {step === 2 && (
            <form onSubmit={handleOtpSubmit}>
    
    <label htmlFor="email" id="enteremailheader">Enter your Gmail:</label>
              <br></br>
              <input
                type="text"
                id="email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                
              />
              <label htmlFor="otp" id="otpheader">Enter OTP</label>
              <br></br>
              <input
                type="text"
                id="otp"
                value={otp}
                onChange={(e) => setOtp(e.target.value)}
              
              />
              
              <br></br>
              <button type="submit"id="nextotp">Next</button>
            </form>
          )}
    
          {step === 3 && (
            <form onSubmit={handlePasswordSubmit}>
              <label htmlFor="password"  id="setpasswordheder">Set Password</label>
              <br></br>
              <input
                type="password"
                id="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              
              />
              <br></br>
              <label htmlFor="confirmPassword" id="confirmpasswordheder">Confirm Password</label>
              <br></br>
              <input
                type="password"
                id="confirmPassword"
                value={confirmPassword}
                onChange={(e) => setConfirmPassword(e.target.value)}
                
              />
             
              <br></br>
              <button type="submit" id="submitbutton">Submit</button>
            </form>
          )}
    
          {step === 4 && (
            <div>
              <p id="passwordcreated"> New Password Created !!!</p>
            </div>
          )}
        </div>
      );
}
