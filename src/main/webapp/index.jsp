<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Emergency MedBus System</title>
  <link rel="stylesheet" href="style.css" />
</head>

<body>

  <!-- Header -->
  <h1>🚑 Emergency MedBus System</h1>
  <img class="img" src="Logo.png" alt="MedBus Logo" width="128" height="128" />

 


  <!-- Form Section -->
  <div class="form-container">
    <h2>Raise Emergency Request</h2>

   <form action="AddPatientServlet" method="post">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name" required>

  <label for="age">Age:</label>
  <input type="number" id="age" name="age" required>

  <label for="location">Location:</label>
  <input type="text" id="location" name="location" required>

  <label for="contact">Contact:</label>
  <input type="text" id="contact" name="contact" required>

  <label for="emergency">Emergency Type:</label>
  <input type="text" id="emergency" name="emergencyType" required>

  <button type="submit">Submit Request</button>
</form>



  </div>

 <!-- Navigation Buttons -->
  <div style="text-align:center; margin-top: 15px;">
      

      <a href="ListPatientServlet" class="btn"
         style="padding:10px 20px; background:#28a745; color:white; border-radius:6px; text-decoration:none;">
         📋 View Patients
      </a>
  </div>
  
 

  <script src="script.js"></script>
</body>
</html>
