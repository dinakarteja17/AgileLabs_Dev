

import React from 'react';
import { useState } from 'react';
import Signup from './signup.jsx';
import Forgotpassword from './ForgotPassword';
import  { BrowserRouter,Routes,Route ,useNavigate, Link,} from 'react-router-dom';
 import './Login.css';
import './signup.css';






const App=( )=>{
  
  const [formData, setFormData] = useState({
    email: '',
    password: '',
  });

  const [errors, setErrors] = useState({
    email: '',
    password: '',
  });

  const UsernameRegex = /^[a-zA-Z]+$/;
  const PasswordRegex = /^[a-zA-Z0-9]+$/;
  const mailRegex= /\.com$|\.in$/;

  

   const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
    setErrors({
      ...errors,
      [name]: '', // Clear any previous error for the field being changed
    });
  };

  const handleButtonClickCancel = () =>
  {
    setFormData(
      {
        email:'',
        password:'',
      }
    );
  };



  

  const validateForm = () => {
    let isValid = true;

    if ( !mailRegex.test(formData.email)) {
      setErrors((prevErrors) => ({
        ...prevErrors,
        email: 'Email is required(only alphabets)',
      }));
      isValid = false;
      
    }
  
     if (!PasswordRegex.test(formData.password)) {
      setErrors((prevErrors) => ({
        ...prevErrors,
        password: 'Password is required (alphanumeric)',
      }));
      isValid = false;
    }

    // if(formData.password.length>3)
    // {
    //   if (formData.password.length < 8 && formData.password.length < 12 ){
    //     newErrors.password = 'Password is in 8 to 12 characters';
    //   }
    //   else if(formData.password.length > 12 )
    //   {
    //     newErrors.password ="Password is too long ";
    //   }
    // }
    // else{
    //   newErrors.password ="Password is required";
    // }

    return isValid;
   };

  const handleSubmit = async(e) => {
    e.preventDefault();
   

    
    
    

   

    if (validateForm()) {
      // Perform your login logic here, e.g., send data to a server
      // If successful, redirect the user or perform desired action


      // Perform validation, authentication, and backend communication here
    try {
      // Make a request to your backend API to authenticate the user
      const response = await fetch('http://localhost:8080/api/students/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
         
        },
        body: JSON.stringify(formData),
      });

      // Handle response - check for successful login, set user state, etc.
      const data = await response.json();
      // Handle successful login or show error messages
      console.log("login succesful");
       navigate('/afterlogin');
    } catch (error) {
      console.error('Error occurred during login:', error);
    }


      // console.log('Login successful!');
      
      // navigate('/afterlogin');
   
  };
}
  

  

  const handleButtonClickForgotPassword = async() => {
    
    navigate('/password-reset'); // Navigate to the '/forgotpassword' route
  };
  const handleButtonClickSignup = () => {
    navigate('/signup'); // Navigate to the '/signup' route
  };

return(

<div className='signup-background'>



<div className="login-form">
<h2 className='loginheader'>Login </h2>


  <div class="container">
    <label for="emailheader">Email</label>
    <input  type="text"
            id="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
      />  {errors.email && <p className="error">{errors.email}</p>}

    <label for="psw">Password</label>
    <input  type="password"
            id="password"
            name="password"
            value={formData.password}
            onChange={handleChange}/>
            
            { errors.password && <p className="error">{errors.password}</p>}
            <label>
            <p class="forgotpassword"><a onClick={handleButtonClickForgotPassword}>forgot password</a></p>
    </label>
        
             <br></br>
             <br></br>
    <button type="button" className="cancelbutton" onClick={handleButtonClickCancel} >Cancel</button>
    <button type="submit" className='loginbutton' onClick={handleSubmit}> Login</button>
    <br></br>
    <br></br>
    <br></br>
   
    
    
  <label className='didnotaccount'>Didn't have anyaccount ?</label>
  <button type="button" className="Registerbutton" onClick={handleButtonClickSignup} >Register</button>
   
  
  </div>


 
</div>
<div>
  
        <p style={{color:'white',fontSize:'30px'}}>sign in with</p>
        
     </div>

<div className='logingmailfacebooklinkedin'>



  <div>
  
 <Link to="https://tinyurl.com/yfhs4men"><i class="bi bi-google"></i></Link> 
  
  </div>
  <div>
  <Link to="https://www.facebook.com/"><i class="bi bi-facebook"></i></Link>
    
  </div>
  <div>
  <Link to="https://tinyurl.com/mr8fn3f4"><i class="bi bi-linkedin"></i></Link>
    
    </div>

</div>


</div>


);

}
export default App;








































// // LoginPage.js
// import React from 'react';

// const LoginPage=()=> {
//   return (
//     <div>
//       <h2>Login Page</h2>
//       {/* Your login form and content here */}
//     </div>
//   );
// }

// export default LoginPage;






