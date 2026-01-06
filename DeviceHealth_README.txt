DeviceHealth - Mobile Application

Project Overview

DeviceHealth is an Android mobile application designed to help users
monitor their smartphone’s overall health. The app provides real-time
insights into battery status, system performance, and hardware sensors,
allowing users to better understand their device condition and take
steps to improve efficiency and lifespan.

The application displays detailed battery information, live sensor
readings, and optimization tips through a clear dashboard interface.
DeviceHealth is developed using Kotlin, Jetpack Compose, MVVM
architecture, Firebase Authentication, and Room Database.

Key Features

Secure user authentication using Firebase Email and Password
Real-time battery monitoring including temperature, voltage, health, and
charging status
Live sensor tracking including accelerometer, gyroscope, light, and
proximity sensors
Dedicated sensor data screen
Offline storage of optimization tips using Room Database
API-based smartphone optimization tips
Matrix-inspired dark themed UI
Clean MVVM-based architecture
Splash to dashboard navigation flow

Technologies Used

Language: Kotlin
User Interface: Jetpack Compose
Architecture: MVVM
Authentication: Firebase Authentication
Local Storage: Room Database
API Integration: Smartphone optimization tips API
IDE: Android Studio
Version Control: Git and GitHub
Project Management: Trello

External API Used

Some Random API
https://api.some-random-api.com/

Application Flow

Splash Screen → Login or Register → Dashboard → Battery Insights →
Sensor Data → Optimization Tips

Security Implementation

Firebase Authentication is used for secure login
All network communication uses HTTPS
User access is restricted to authenticated users
Sensitive credentials are not stored locally
Sensor listeners automatically stop when screens are closed

Installation and Setup

Clone the repository
Open the project in Android Studio
Connect Firebase and enable Email and Password authentication
Sync Gradle and allow the project to build
Run the application on an emulator or physical Android device

Agile Development

The project followed a sprint-based Agile methodology across five
sprints. Development covered authentication setup, dashboard design, API
integration, theme enhancement, and advanced battery and sensor
monitoring features.

Future Enhancements

Long-term device performance analytics
Background health alerts
Support for additional hardware sensors
Cloud backup and restore options
Advanced battery optimization suggestions

Useful Links

GitHub: add your GitHub link
Trello: add your Trello link
Some Random API: https://api.some-random-api.com/
