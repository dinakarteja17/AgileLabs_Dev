import ResponsiveAppBar from './NavBar.js';
export default function About()
{
    return(
    <>
    <ResponsiveAppBar/>
    <div className='aboutinformation'>
    <h2>About:</h2><br></br>
    <p>This is Learning Platform for Students and Job-Seekers . </p>
    <p>To enrich the knowledge & skill sets of young software engineers by providing value added training in the areas of Software Development & Testing.</p>

    <p>To serve the industries by providing trained human resources in the above areas. </p>
    
    <p>To provide quality Software Training & Consulting Services.</p>
    </div>
    </>
    );
}