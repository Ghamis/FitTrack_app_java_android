Group Member Names	      Group Member Registration Number
Abdullah Ghamis Bashir	      L1F21BSSE0122
Syed Razee Abbass Rizvi	      L1F21BSSE0488
			

FitTrack : Fitness App
Overview
FitTrack is an Android application designed to help users track their fitness goals. It allows users to register for an account or log in using their existing credentials. The app features a user-friendly interface with a rotating image banner on the main screen and a scrollable list of muscle groups (back, chest, bicep, tricep, shoulder, legs, abs). Clicking a muscle group button takes the user to a dedicated activity showcasing a list of exercises for that particular muscle group. Selecting an exercise displays a GIF image demonstrating the exercise and a detailed description.
Functionality
•	User Login and Registration (using Firebase Authentication)
•	Main Screen with Rotating Image Banner
•	Muscle Group Selection with Buttons
•	Dedicated Activity for Each Muscle Group
•	List of Exercises for Each Muscle Group
•	View Exercise Details (GIF and Description)
Java Concepts Used
•	Activities: Represent different screens in the app (MainActivity, SplashActivity, LoginActivity, RegisterActivity, BackActivity, ChestActivity, BicepsActivity, TricepActivity, ShoulderActivity, AbsActivity, LegsActivity).
•	Layouts: Define the arrangement of UI elements within an activity (activity_main.xml, activity_splash.xml, activity_login.xml, activity_register.xml, activity_back.xml, activity_chest.xml, activity_bicep.xml, activity_tricep.xml, activity_shoulder.xml, activity_abs.xml, activity_legs.xml).
•	Views: Represent UI elements like buttons, text views, images, etc. (ImageButton, TextView, ImageView, ListView, etc.).
•	Adapters: Provide data to views (ArrayAdapter for ListView in BackActivity.java, , ChestActivity, BicepsActivity, TricepActivity, ShoulderActivity, AbsActivity, LegsActivity).
•	Intents: Used to navigate between activities (startActivity in MainActivity.java and BackActivity.java).
•	Firebase Authentication: Manages user login and registration.
•	Glide Library (used in BackActivity.java): Enables loading and displaying GIF images.
Database
The app currently utilizes Firebase Authentication for user login and registration. Firebase Authentication offers a robust and secure solution for user authorization by handling user data on the server-side, eliminating the need for local storage management.

