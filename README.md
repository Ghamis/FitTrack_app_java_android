# 🏋️‍♂️ FitTrack : Fitness App

## 📖 Overview
**FitTrack** is an Android application designed to help users track their fitness goals.  
It allows users to **register for an account** or **log in using existing credentials**.  

The app features a **user-friendly interface** with:
- A rotating image banner on the main screen  
- A scrollable list of muscle groups:
  - Back  
  - Chest  
  - Bicep  
  - Tricep  
  - Shoulder  
  - Legs  
  - Abs  

Clicking a muscle group button takes the user to a **dedicated activity** showcasing a list of exercises for that particular muscle group.  
Selecting an exercise displays:
- A **GIF image** demonstrating the exercise  
- A **detailed description**

---

## ⚙️ Functionality
- **User Login and Registration** (using Firebase Authentication)  
- **Main Screen** with Rotating Image Banner  
- **Muscle Group Selection** with Buttons  
- **Dedicated Activity** for Each Muscle Group  
- **List of Exercises** for Each Muscle Group  
- **View Exercise Details** (GIF and Description)

---

## 💻 Java Concepts Used

### 🧩 Activities
Represent different screens in the app:  
`MainActivity`, `SplashActivity`, `LoginActivity`, `RegisterActivity`,  
`BackActivity`, `ChestActivity`, `BicepsActivity`, `TricepActivity`,  
`ShoulderActivity`, `AbsActivity`, `LegsActivity`

### 🧱 Layouts
Define the arrangement of UI elements within an activity:  
`activity_main.xml`, `activity_splash.xml`, `activity_login.xml`,  
`activity_register.xml`, `activity_back.xml`, `activity_chest.xml`,  
`activity_bicep.xml`, `activity_tricep.xml`, `activity_shoulder.xml`,  
`activity_abs.xml`, `activity_legs.xml`

### 🪟 Views
Represent UI components like buttons, text views, and images:  
`ImageButton`, `TextView`, `ImageView`, `ListView`, etc.

### 🔄 Adapters
Provide data to views:  
`ArrayAdapter` for `ListView` in:  
`BackActivity.java`, `ChestActivity.java`, `BicepsActivity.java`,  
`TricepActivity.java`, `ShoulderActivity.java`, `AbsActivity.java`, `LegsActivity.java`

### 🚀 Intents
Used to navigate between activities:  
`startActivity()` in `MainActivity.java` and `BackActivity.java`

### 🔐 Firebase Authentication
Manages **user login** and **registration** securely.

### 🖼️ Glide Library
Used in `BackActivity.java` to **load and display GIF images** efficiently.

---

## 🗄️ Database
The app currently utilizes **Firebase Authentication** for user login and registration.  

Firebase Authentication provides a **robust and secure solution** for user authorization by handling user data on the **server-side**, eliminating the need for **local storage management**.
