//FINAL ROUTES--->
//App.js
import React from 'react';
import { BrowserRouter, Route } from 'react-router-dom';
import {Routes} from 'react-router-dom';
import HomePage from './home.js';
import LoginPage from './Login.js';
import SignUpPage from './signup.jsx';
import Forgotpassword from './ForgotPassword';
import About from './About';
import Contact from './Contact';
import Services from './Services';

import AfterLoginhome from './afterLoginhome.js';
import Videos from './Video';
// import InterviewQuestionsReact from './interviewQuestionsReact.js';
import InterviewQuestionsReact from './ReactDemointerview.js'
import InterviewQuestionJava from './interviewQuestionsJava';
import InterviewQuestionTesting from './interviewQuestionsTesting';

import CodeJava from './codejavapage1.js';
import CodeJava2 from './codejavapage2.js';
import CodeJava3 from './codejavapage3.js';
import Testing from './TestingCodepage.js';
import Testing2 from './TestingCodepage2.js';
import React1 from './ReactCodepage.js';
import React2 from './ReactCodepage2.js';
import Devops from './DevOpsGuidepage.js';
import Page2 from './ReactVideo.js';
import Page4 from './AWSvideo.js';
import Page3 from './page4Video';
import Page5 from './page5Video';
import Logout from './Logout.js';
import ContactUs from './ContactUsinHome.js';



import DemoT from './TestingDemointerview.js';
import DemoJ from './JavaDemointerview.js';
import DemoR from './ReactDemointerview.js';


import IPAddr from './IPAddress.js';




function App() {
  return (
    
    < BrowserRouter>
       
        
        <Routes>
          <Route  path="/" element={<HomePage/>} />
          <Route  path="/login" element={<LoginPage/>} />
          <Route  path="/signup" element={<SignUpPage/>} />
          <Route path ='/password-reset' element={<Forgotpassword/>}/>
           <Route path ='/about' element={<About/>}/>
           <Route path ='/contact' element={<Contact/>}/>
           <Route path ='/services' element={<Services/>}/>

           <Route  path="/afterlogin" element={<AfterLoginhome/>} />
           <Route  path="/afterloginpage" element={<HomePage/>} />
           <Route  path="/videos" element={<Videos/>} />
           <Route  path="/interviewQuestionsReact" element={<InterviewQuestionsReact/>}/>
           <Route  path="/interviewQuestionsJava" element={<InterviewQuestionJava/>}/>
           <Route  path="/interviewQuestionsTesting" element={<InterviewQuestionTesting/>}/>
           <Route path="/javavideopage1"  element={<Videos/>}/>
           <Route path="/reactvideopage1"  element={<Page2/>}/>
           <Route path="/testingvideopage1"  element={<Page3/>}/>
           <Route path="/devopsvideopage1"  element={<Page4/>}/>
           <Route path="/javavideopage5"  element={<Page5/>}/>

           <Route  path="/javacodepage1" element={<CodeJava/>}/>
           <Route  path="/javacodepage2" element={<CodeJava2/>}/>
           <Route  path="/javacodepage3" element={<CodeJava3/>}/>

           <Route  path="/testingcodepage1" element={<Testing/>}/>
           <Route  path="/testingcodepage2" element={<Testing2/>}/>

           <Route  path="/reactcodepage1" element={<React1/>}/>
           <Route  path="/reactcodepage2" element={<React2/>}/>

           <Route  path="/devopscodepage1" element={<Devops/>}/>
           <Route path="/logout"  element={<Logout/>}/>
           <Route path="/ContactUSinHome" element={<ContactUs/>}/>
           





           <Route path="/testingquestionpage1" element={<DemoT/>}/>
           <Route path="/javaquestionpage1" element={<DemoJ/>}/>
           <Route path="/reactquestionpage1" element={<DemoR/>}/>


           <Route path="/ipaddres" element={<IPAddr/>}/>
               
        </Routes>
      
    </BrowserRouter>
   
  );
}

export default App;

















// // import React, { useState } from 'react';
// // import axios from 'axios';

// // const EmailOTPForm = () => {
// //   const [email, setEmail] = useState('');
// //   const [error, setError] = useState('');

// //   const sendOTP = async () => {
// //     // try {
// //     //   const response = await axios.post('http://localhost:8080/api/students/password-reset', { email });
// //     //   console.log('OTP sent:', response.data);
// //     //   // You can handle the response or show a success message to the user
// //     // } catch (error) {
// //     //   console.error('Error sending OTP:', error);
// //     //   setError('Failed to send OTP. Please check your email and try again.');
// //     //   // Handle errors or show an error message to the user
// //     // }
// //     const res =  await fetch('http://localhost:8080/api/students/password-reset', {
// //       method:"POST",
// //       mode:"cors",
// //       headers:{
// //           'Content-type' : "application/json"
// //       },
// //       body: JSON.stringify(req)
// //   })
// //   };

// //   const handleSubmit = (e) => {
// //     e.preventDefault();
// //     sendOTP();
// //   };

// //   return (
// //     <div>
// //       <form onSubmit={handleSubmit}>
// //         <input
// //           type="email"
// //           placeholder="Enter your email"
// //           value={email}
// //           onChange={(e) => setEmail(e.target.value)}
// //           required
// //         />
// //         <button type="submit">Send OTP</button>
// //       </form>
// //       {error && <p>{error}</p>}
// //     </div>
// //   );
// // };

// // export default EmailOTPForm;







// // import React, { useState } from 'react';

// // const OtpEmailForm = () => {
// //   const [email, setEmail] = useState('');
// //   const [isLoading, setIsLoading] = useState(false);
// //   const [error, setError] = useState(null);
// //   const [successMessage, setSuccessMessage] = useState('');

// //   const sendOTP = async () => {
// //     setIsLoading(true);
// //     setError(null);
// //     setSuccessMessage('');

// //     try {
// //       const response = await fetch('http://localhost:8080/api/students/password-reset', {
// //         method: 'POST',
// //         headers: {
// //           'Content-Type': 'application/json',
// //         },
// //         body: JSON.stringify(email), // Ensure 'email' parameter is included
// //       });

// //       if (!response.ok) {
// //         throw new Error('Failed to send OTP');
// //       }

// //       setSuccessMessage('OTP sent successfully!');
// //       setIsLoading(false);
// //     } catch (error) {
// //       setError('Error sending OTP');
// //       setIsLoading(false);
// //     }
// //   };

// //   const handleSubmit = (e) => {
// //     e.preventDefault();
// //     sendOTP();
// //   };

// //   return (
// //     <div>
// //       <h2>Send OTP to Email</h2>
// //       {successMessage && <p>{successMessage}</p>}
// //       <form onSubmit={handleSubmit}>
// //         <label>
// //           Email:
// //           <input
// //             type="email"
// //             value={email}
// //             onChange={(e) => setEmail(e.target.value)}
// //             required
// //           />
// //         </label>
// //         <button type="submit" disabled={isLoading}>
// //           {isLoading ? 'Sending...' : 'Send OTP'}
// //         </button>
// //       </form>
// //       {error && <p>{error}</p>}
// //     </div>
// //   );
// // };

// // export default OtpEmailForm;













// // import React, { useState } from 'react';
// // import axios from 'axios';

// // const LoginForm = () => {
// //   const [email, setEmail] = useState('');
// //   const [password, setPassword] = useState('');
 
  

// //   const handleSubmit = async (event) => {
// //     event.preventDefault();

// //     // try {
// //     //   const response = await axios.post('http://localhost:8080/api/students/login', {
// //     //     email,
// //     //     password,
// //     //   });

// //     //   // Assuming the backend responds with a success message or token upon successful login
// //     //   if (response.data && response.data.success) {
// //     //     setIsLoggedIn(true);
// //     //     setError(null);
// //     //     console.log('Login successful!');
// //     //   } else {
// //     //     setError('Login failed. Please check your credentials.');
// //     //     setIsLoggedIn(false);
// //     //   }
// //     // } catch (error) {
// //     //   setError('Login failed. Please try again later.');
// //     //   setIsLoggedIn(false);
// //     //   console.error('Error:', error);
// //     // }
// //     try {
// //       const response = await fetch('http://localhost:8080/api/students/login', {
// //         method: 'POST',
// //         headers: {
// //           'Content-Type': 'application/json',
// //         },
// //         body: JSON.stringify(email),
// //         body: JSON.stringify(password),
        
// //       });
  
// //       if (response.status === 200) {
// //         // Successful signup, update state or redirect to a success page
// //         console.log(' login successful');
// //       } else {
// //         // Handle signup error, e.g., show an error message
// //         console.error('login failed');
// //       }
// //     } catch (error) {
     
// //       console.error(error);
// //     }
// //   };

 

// //   return (
// //     <div>
// //       <h2>Login</h2>
// //       <form onSubmit={handleSubmit}>
// //         <div>
// //           <label htmlFor="email">Email:</label>
// //           <input
// //             type="email"
// //             id="email"
// //             value={email}
// //             onChange={(e) => setEmail(e.target.value)}
// //             required
// //           />
// //         </div>
// //         <div>
// //           <label htmlFor="password">Password:</label>
// //           <input
// //             type="password"
// //             id="password"
// //             value={password}
// //             onChange={(e) => setPassword(e.target.value)}
// //             required
// //           />
// //         </div>
// //         <button type="submit">Login</button>
// //       </form>
// //     </div>
// //   );
// // };

// // export default LoginForm;





// // import React, { useState } from 'react';

// // const LoginForm = () => {
// //   const [email, setEmail] = useState('');
// //   const [password, setPassword] = useState('');
// //   const [error, setError] = useState('');

// //   const handleSubmit = async (event) => {
// //     event.preventDefault();

// //     try {
// //       const response = await fetch('http://localhost:8080/api/students/login', {
// //         method: 'POST',
// //         headers: {
// //           'Content-Type': 'application/json',
// //         },
// //         body: JSON.stringify({ email, password }),
// //       });

// //       if (response.ok) {
// //         // Login successful
// //         setError('');
// //         // Redirect or perform further actions upon successful login
// //         // Example: Redirect to dashboard
// //         // window.location.href = '/dashboard';
// //       } else {
// //         // Login failed, display error message based on the response status
// //         if (response.status === 400) {
// //           setError('Invalid email or password. Please try again.');
// //         } else {
// //           // setError('Login failed. Please try again later.');
// //         }
// //       }
// //     } catch (error) {
// //       setError('Login failed. Please try again later.');
// //       console.error('Error:', error);
// //     }
// //   };

// //   return (
// //     <div>
// //       <h2>Login</h2>
// //       {error && <p style={{ color: 'red' }}>{error}</p>}
// //       <form onSubmit={handleSubmit}>
// //         <div>
// //           <label>Email:</label>
// //           <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} required />
// //         </div>
// //         <div>
// //           <label>Password:</label>
// //           <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} required />
// //         </div>
// //         <button type="submit">Login</button>
// //       </form>
// //     </div>
// //   );
// // };

// // export default LoginForm;





















// // import React, { useState } from 'react';
// // import axios from 'axios'; // You'll need Axios to make HTTP requests

// // function WhatsAppChat() {
// //   const [message, setMessage] = useState('');
// //   const [recipient, setRecipient] = useState('whatsapp:1234567890'); // Replace with the recipient's WhatsApp number

// //   const sendMessage = async () => {
// //     try {
// //       const response = await axios.post('/api/sendWhatsAppMessage', {
// //         recipient,
// //         message,
// //       });
// //       console.log('Message sent:', response.data);
// //     } catch (error) {
// //       console.error('Failed to send message:', error);
// //     }
// //   };

// //   return (
// //     <div>
// //       <h1>WhatsApp Chatbot</h1>
// //       <div>
// //         <label>Recipient's WhatsApp Number:</label>
// //         <input
// //           type="text"
// //           value={recipient}
// //           onChange={(e) => setRecipient(e.target.value)}
// //         />
// //       </div>
// //       <div>
// //         <label>Message:</label>
// //         <textarea
// //           value={message}
// //           onChange={(e) => setMessage(e.target.value)}
// //         />
// //       </div>
// //       <button onClick={sendMessage}>Send Message</button>
// //     </div>
// //   );
// // }

// // export default WhatsAppChat;













// // //tracking via ip address
// // import React, { Component } from 'react';

// // class IPTracking extends Component {
// //   componentDidMount() {
// //     // Send a request to your server to log the user's IP address
// //     fetch('https://localhost:3000/afterlogin', {
// //       method: 'POST',
// //       headers: {
// //         'Content-Type': 'application/json',
// //       },
// //       body: JSON.stringify({ timestamp: Date.now() }),
// //     })
// //       .then(response => {
// //         if (response.ok) {
// //           console.log('IP address logged successfully.');
// //         } else {
// //           console.error('Failed to log IP address.');
// //         }
// //       })
// //       .catch(error => {
// //         console.error('Error:', error);
// //       });
// //   }

// //   render() {
// //     return (
// //       <div>
// //         <p>IP address tracking in progress...</p>
// //       </div>
// //     );
// //   }
// // }

// // export default IPTracking;


// // import 'bootstrap-icons/font/bootstrap-icons.css';
// // export default function App({ isLargeScreen })
// // {
// //   const iconSize = isLargeScreen ? '2rem' : '1.5rem';

// //   const iconStyle = {
// //     fontSize: iconSize,
// //   };
// //   return(
// //     <i class="bi bi-award-fill" style={iconStyle}> asked in IBM</i>
// //   )
// // }



// // import 'bootstrap-icons/font/bootstrap-icons.css';
// // import './index.css'; // Create a CSS file for your component

// // function MyComponent() {
// //   return (
// //     <div>
    
// //       <i class="bi bi-award-fill">Most asked in ibm</i>
// //     </div>
// //   );
// // }

// // export default MyComponent;










// // const accountSid = 'your_account_sid';
// // const authToken = 'your_auth_token';
// // const twilio = require('twilio');
// // const client = twilio(accountSid, authToken);

// // Function to send a WhatsApp message
// // function sendWhatsAppMessage(to, body) {
// //   client.messages
// //     .create({
// //       from: 'whatsapp:+1234567890', // Your Twilio WhatsApp number
// //       to: `whatsapp:${to}`, // Recipient's WhatsApp number
// //       body: body,
// //     })
// //     .then((message) => console.log(`Message sent: ${message.sid}`))


// // const accountSid = 'AC91596f291c0c9d6806e4fe39ae5588c8';
// // const authToken = '[AuthToken]';
// // const client = require('twilio')(accountSid, authToken);

// // client.messages
// //     .create({
// //                 to: '+918106241443'
// //     })
// //     .then(message => console.log(message.sid))
// //     .catch((error) => console.error(`Error sending message: ${error.message}`));


// // // Simulated chatbot logic
// // function chatbotResponse(userInput) {
// //   const responses = {
// //     'hi': 'Hello! How can I assist you today?',
// //     'how are you': "I'm just a bot, but I'm here to help!",
// //     'bye': 'Goodbye! If you have more questions, feel free to ask.',
// //   };

// //   return responses[userInput.toLowerCase()] || "I'm not sure what you mean.";
// // }

// // // Example: Respond to a user's message
// // const userMessage = 'hi'; // User's message
// // const botMessage = chatbotResponse(userMessage); // Get a response
// // const recipient = '8106241443'; // Recipient's WhatsApp number

// // sendWhatsAppMessage(recipient, botMessage);






// // export default function Reactinterviewquestions()
// // {
// //     return(
// //         <>
// //         <h2>what is React?</h2>
// //         <p>React(aka React.js or ReactJS) is an open-source front-end JavaScript library that is used for building composable user interfaces, especially for single-page applications. It is used for handling view layer for web and mobile apps based on components in a declarative approach.</p>
// //         <p>React was created by <a href="https://github.com/jordwalke">Jordan Walke</a>, a software engineer working for Facebook. React was first deployed on Facebook's News Feed in 2011 and on Instagram in 2012.</p>
// //         <br></br>

// //         <h2>What is the history behind React evolution?</h2>
// //         <p>The history of ReactJS started in 2010 with the creation of XHP. XHP is a PHP extension which improved the syntax of the language such that XML document fragments become valid PHP expressions and the primary purpose was used to create custom and reusable HTML elements.</p>
// //         <p>The main principle of this extension was to make front-end code easier to understand and to help avoid cross-site scripting attacks. The project was successful to prevent the malicious content submitted by the scrubbing user.</p>
// //        <p>But there was a different problem with XHP in which dynamic web applications require many roundtrips to the server, and XHP did not solve this problem. Also, the whole UI was re-rendered for small change in the application. Later, the initial prototype of React is created with the name FaxJ by Jordan inspired from XHP. Finally after sometime React has been introduced as a new library into JavaScript world.</p>
      
// //        <p>Note:JSX comes from the idea of XHP</p>
// //        <br></br>

// //        <h2>What are the major features of React?</h2>
// //        <p>The major features of React are:</p>
// //        <ul>
// //         <li>Uses JSX syntax, a syntax extension of JS that allows developers to write HTML in their JS code.</li>
// //        <li>It uses Virtual DOM instead of Real DOM considering that Real DOM manipulations are expensive.</li>
// //        <li>Supports server-side rendering which is useful for Search Engine Optimizations(SEO).</li>
// //       <li>Follows Unidirectional or one-way data flow or data binding.</li>
// //       <li>Uses reusable/composable UI components to develop the view.</li>
// //        </ul>
// //        <br></br>
// //        <h2>What is JSX?</h2>
// //        <p>JSX stands for JavaScript XML and it is an XML-like syntax extension to ECMAScript. Basically it just provides the syntactic sugar for the <code>React.createElement(type, props, ...children)</code>
// //        function, giving us expressiveness of JavaScript along with HTML like template syntax.</p>
// //        <p>In the example below, the text inside `h1` tag is returned as JavaScript function to the render function.</p>
// //         </>
// //     )
// // }