<h1>SportShooterAppServer</h1>
<p>Welcome to the <strong>SportShooterAppServer</strong> repository! This backend server supports the SportShooterApp by managing user authentication, data storage, and synchronization across devices.</p>
<h2>Table of Contents</h2>
<ul>
   <li><a href="#overview">Overview</a></li>
   <li><a href="#features">Features</a></li>
   <li><a href="#api-endpoints">API Endpoints</a></li>
   <li><a href="#technologies-used">Technologies Used</a></li>
</ul>
<h2>Overview</h2>
<p>SportShooterAppServer is a Spring Boot-based backend application designed to work with the SportShooterApp. It provides essential services like user authentication using Google API, data storage, and synchronization of user data between devices. The server ensures that users can securely access and manage their training data across multiple devices.</p>
<h2>Features</h2>
<ul>
   <li><strong>User Authentication:</strong> Supports secure user authentication using Google Sign-In.</li>
   <li><strong>Data Storage:</strong> Stores user-related data, including training session logs and preferences.</li>
   <li><strong>Data Synchronization:</strong> Keeps user data synchronized across multiple devices to ensure a seamless experience.</li>
   <li><strong>API Support:</strong> Provides RESTful API endpoints for the SportShooterApp to interact with the backend.</li>
</ul>
<h2>API Endpoints</h2>
<p>The following are the key API endpoints provided by SportShooterAppServer include:</p>
<ul>
  <li><strong>GET api/training</strong>: Returns a list of all training sessions associated with the authenticated user.</li>
  <li><strong>POST api/training</strong>: Accepts a list of new training sessions as a parameter and saves them to the database.</li>
  <li><strong>POST api/training/ts</strong>: Accepts a timestamp as a parameter and returns all training sessions that occurred after the given timestamp.</li>
</ul>
<h2>Technologies Used</h2>
<ul>
   <li><strong>Backend Framework:</strong> Spring Boot</li>
   <li><strong>Programming Language:</strong> Java</li>
   <li><strong>Database:</strong> PostgreSQL</li>
   <li><strong>Security:</strong> Spring Security with OAuth 2.0 for Google authentication</li>
</ul>
