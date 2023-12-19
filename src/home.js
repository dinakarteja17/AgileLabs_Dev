
import React from 'react';
import ResponsiveAppBar from './NavBar';
import AutomaticSlider from './AutomaticSlider';
import IPadd from './IPAddress.js';
//import Chatbot from './chatbot.js'
import './home.css';
import { Link } from 'react-router-dom';
//import { Yard } from '@mui/icons-material';
import Scrollbar from './ScrollBarTop';



function HomePage() {
  return (
    <>
    
   
    <div className='homebody'>
    
        <ResponsiveAppBar/>
         <AutomaticSlider/>
        <IPadd/>
        <Scrollbar/>
      
        
     
    </div>
    <div className='aboutheadandtext'>
      <br></br>
      <h1 className='abouthead'>About Us</h1>
      <br></br>
      
      <ul className='abouttext'>
        <li>
        <p>This is Learning Platform for Students and Job-Seekers. </p>
        </li>
        <li>
        <p>To enrich the knowledge & skill sets of young software engineers by providing value added training in the areas of Software Development & Testing.</p>
        </li>
        <li>
        <p>To serve the industries by providing trained human resources in the above areas. </p>
        </li>
        <li>
        <p>To provide quality Software Training & Consulting Services.</p>
        </li>
      </ul>
      
    </div>
    <br></br>
    <br></br>
    <div >
      <h1 className='serviceshead'>Our Services</h1>
      <br></br>
      <br></br>
      <div className='appwebandtest'>
        <div className='appdevelopmentheadandtext'>
        <i class="bi bi-android"></i>
        <h2>App Development</h2>
        <p>Mobile app development is the process of creating software applications that are designed to run on mobile devices, such as smartphones and tablets. These applications can be developed for different platforms, including iOS (Apple), Android (Google), and sometimes Windows (Microsoft) or other mobile operating systems.
         </p>
         <button className='learnmore'>Learn more</button>
        </div>

        <div className='webdevelopmentheadandtext'>
        <i class="bi bi-code-slash"></i>
          <h2>Web Development</h2>
          <p>Web programming involves creating web pages, web applications, and other online content that can be displayed in a web browser. Web programming is accomplished using a variety of programming languages, including HTML, CSS, JavaScript, PHP, Python, Ruby, and Java.
         </p>
         <button className='learnmore'>Learn more</button>
        </div>

        <div className='softwaretestingheadandtext'>
        <i class="bi bi-arrow-clockwise"></i>
          <h2>Software Testing</h2>
          <p>Software testing is the process of evaluating and verifying that a software product or application does what it is supposed to do. The benefits of testing include preventing bugs, reducing development costs and improving performance.
         </p>
         
         <button className='learnmore'>Learn more</button>
       
        </div>
        

        <div className='devopsazureawsheadandtext'>
        <i class="bi bi-cloud-check"></i>
          <h2>Devops Azure/AWS</h2>
          <p>DevOps is the combination of cultural philosophies, practices, and tools that increases an organization's ability to deliver applications and services at high velocity: evolving and improving products at a faster pace than organizations using traditional software development and infrastructure management processes.
         </p>
         <button className='learnmore'>Learn more</button>
        </div>
        
      </div>
    </div>
    <footer className='footer'>
    <br></br>
    <br></br>
    <br></br>
    <br></br>
    <div>
    <h1 className='contactmehead'>Contact Me</h1>
    <i class="bi bi-envelope"></i>
    <p>name@gmail.com</p>
    <i class="bi bi-telephone-outbound"></i>
    <p>1234567890</p>
    </div>
     <br></br>
    <Link  className="contactus" to="/ContactUSinHome" >Contact us(any queries) </Link>
    <br></br>
    <br></br>
    <h2>Connect With Us  agilelabs.com</h2>
    <br></br>
    <br></br>
    <br></br>
    <div className='followhead'> <h2>Follows us</h2> 
    <br></br>
    
      <ul className='followslist'>

        <Link to="/twitter"><i class="bi bi-twitter"></i></Link>
        <Link to="/instagram"><i class="bi bi-instagram"></i></Link>
        <Link to="https://www.facebook.com/"><i class="bi bi-facebook"></i></Link>
        <Link to="/whatsapp"><i class="bi bi-whatsapp"></i></Link>
      <Link to="/youtube"><i class="bi bi-youtube" ></i></Link> 
      </ul>
    </div>
    <div className='copyrighthead'>
       Copyright policy © 2023 Agile Labs
    </div>
    <br></br>
      <div className='supportandprivacyandterms'>
        <Link className='support'>Support</Link>
        <Link className='privacy'>Privacy policy</Link>
        <Link className='termsandconditions'>Terms and Conditions</Link>
     
    </div>
    <br></br>
   </footer>
   
   </>
    
  );
}

export default HomePage;


