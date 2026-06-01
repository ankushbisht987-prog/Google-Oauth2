  # Spring Boot OAuth2 Login (Google & GitHub)

A Spring Boot application that demonstrates OAuth2 Authentication using:

- Google Login
- GitHub Login
- Spring Security
- OAuth2 Client
- Spring Boot

## Features

- Login with Google Account
- Login with GitHub Account
- Secure Authentication using OAuth2
- Spring Security Integration
- User Information Retrieval after Login
- Customizable Security Configuration

---

## Technologies Used

- Java 21
- Spring Boot
- Spring Security
- OAuth2 Client
- Maven

---

## Project Structure

```text
src
├── main
│   ├── java
│   │   └── com.login.OauthTwo
│   │       ├── OauthTwoApplication.java
│   │       ├── LoginConfig.java
│   │       └── Controller
│   └── resources
│       └── application.properties
```

---

## Prerequisites

Before running the application, make sure you have:

- Java 21+
- Maven 3.9+
- Google OAuth Client Credentials
- GitHub OAuth App Credentials

---

## Google OAuth Setup

### Step 1: Create OAuth Credentials

1. Open Google Cloud Console:
   https://console.cloud.google.com/

2. Create a new project.

3. Navigate to:

   APIs & Services → Credentials

4. Click:

   Create Credentials → OAuth Client ID

5. Select:

   Web Application

6. Add Redirect URI:

```text
http://localhost:8080/login/oauth2/code/google
```

7. Copy:

- Client ID
- Client Secret

---

## GitHub OAuth Setup

### Step 1: Create OAuth App

1. Open:

   https://github.com/settings/developers

2. Click:

   New OAuth App

3. Configure:

```text
Application Name : Spring OAuth2 Demo

Homepage URL :
http://localhost:8080

Authorization Callback URL :
http://localhost:8080/login/oauth2/code/github
```

4. Copy:

- Client ID
- Client Secret

---

## Configuration

Add the following properties in:

`src/main/resources/application.properties`

```properties
# Google Login

spring.security.oauth2.client.registration.google.client-id=YOUR_GOOGLE_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret=YOUR_GOOGLE_CLIENT_SECRET

# GitHub Login

spring.security.oauth2.client.registration.github.client-id=YOUR_GITHUB_CLIENT_ID
spring.security.oauth2.client.registration.github.client-secret=YOUR_GITHUB_CLIENT_SECRET
```

---

## Security Configuration

Example:

```java
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http
        .authorizeHttpRequests(auth -> auth
            .anyRequest().authenticated()
        )
        .oauth2Login(Customizer.withDefaults());

    return http.build();
}
```

---

## Running the Application

Clone the repository:

```bash
git clone https://github.com/your-username/oauth2-login-demo.git
```

Move into the project directory:

```bash
cd oauth2-login-demo
```

Build the project:

```bash
mvn clean install
```

Run the application:

```bash
mvn spring-boot:run
```

Application will start on:

```text
http://localhost:8080
```

---

## Login Flow

```text
User
  │
  ▼
Application
  │
  ├── Login with Google
  │         │
  │         ▼
  │     Google OAuth Server
  │         │
  │         ▼
  │     User Information
  │
  └── Login with GitHub
            │
            ▼
       GitHub OAuth Server
            │
            ▼
       User Information
```

---

## Example Login URLs

Google Login:

```text
http://localhost:8080/oauth2/authorization/google
```

GitHub Login:

```text
http://localhost:8080/oauth2/authorization/github
```

---

## Common Issues

### Invalid Redirect URI

Ensure the redirect URI configured in Google/GitHub exactly matches:

```text
http://localhost:8080/login/oauth2/code/google
```

```text
http://localhost:8080/login/oauth2/code/github
```

---

### Client ID Not Found

Verify:

```properties
spring.security.oauth2.client.registration.google.client-id
spring.security.oauth2.client.registration.github.client-id
```

are correctly configured.

---

### Application Fails at Startup

Check:

- Java version
- Maven dependencies
- OAuth2 configuration
- Spring Security configuration

---

## Future Enhancements

- JWT Authentication
- Role-Based Authorization
- Database User Persistence
- Custom Login Page
- Logout Support
- User Profile Dashboard

---

## Author

Ankush

## License

This project is licensed under the MIT License.
