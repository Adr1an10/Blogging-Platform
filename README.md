# Blogging Platform 📝

![Blogging Platform](https://img.shields.io/badge/Blogging%20Platform-v1.0.0-blue.svg)  
[Download Releases](https://github.com/Adr1an10/Blogging-Platform/releases)

Welcome to the Blogging Platform! This project offers a modern blogging experience built with Spring Boot and React. It aims to provide a seamless interface for users to create, manage, and share their blogs effortlessly.

## Table of Contents

1. [Features](#features)
2. [Technologies Used](#technologies-used)
3. [Getting Started](#getting-started)
4. [Installation](#installation)
5. [Usage](#usage)
6. [API Documentation](#api-documentation)
7. [Contributing](#contributing)
8. [License](#license)
9. [Contact](#contact)

## Features 🌟

- **User Authentication**: Secure login and registration using Spring Security.
- **Responsive Design**: Built with Tailwind CSS for a modern look on all devices.
- **Rich Text Editor**: Create and format blog posts easily.
- **Comments Section**: Engage with readers through comments.
- **Tagging System**: Organize blogs with relevant tags.
- **Search Functionality**: Find blogs quickly with a robust search feature.
- **Docker Support**: Easy deployment with Docker and Docker Compose.

## Technologies Used 🛠️

This project utilizes a range of technologies to ensure a smooth and efficient experience:

- **Java**: The core language for the backend.
- **Spring Boot**: Framework for building the backend.
- **Spring Security**: For securing the application.
- **React**: Frontend library for building user interfaces.
- **TypeScript**: For type safety in React components.
- **JPA**: Java Persistence API for database interactions.
- **Docker**: Containerization for easy deployment.
- **Docker Compose**: Simplifies multi-container Docker applications.
- **Tailwind CSS**: For styling the application.
- **HTML**: Structure of the web pages.

## Getting Started 🚀

To get started with the Blogging Platform, you will need to have Java, Node.js, and Docker installed on your machine. Follow the installation instructions below to set up the project locally.

## Installation 🔧

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Adr1an10/Blogging-Platform.git
   cd Blogging-Platform
   ```

2. **Backend Setup**:
   - Navigate to the backend directory:
     ```bash
     cd backend
     ```
   - Install dependencies:
     ```bash
     ./mvnw install
     ```

3. **Frontend Setup**:
   - Navigate to the frontend directory:
     ```bash
     cd ../frontend
     ```
   - Install dependencies:
     ```bash
     npm install
     ```

4. **Run the Application**:
   - For the backend:
     ```bash
     ./mvnw spring-boot:run
     ```
   - For the frontend:
     ```bash
     npm start
     ```

5. **Docker Deployment**:
   - To deploy using Docker, ensure you have Docker and Docker Compose installed. Then run:
     ```bash
     docker-compose up
     ```
   - This command will build and run the application in containers.

## Usage 💻

Once the application is running, you can access it via your web browser at `http://localhost:3000`. Here, you can create an account, log in, and start writing your blogs. 

### Creating a Blog Post

1. Log in to your account.
2. Click on the "New Post" button.
3. Use the rich text editor to write your blog.
4. Add tags to categorize your blog.
5. Click "Publish" to share your post with the world.

### Commenting on Posts

Readers can leave comments on blog posts. Simply scroll to the comments section and enter your thoughts. 

### Searching for Blogs

Use the search bar at the top of the page to find specific blogs by keywords or tags.

## API Documentation 📚

The Blogging Platform offers a RESTful API for developers. Below are some key endpoints:

- **GET /api/posts**: Retrieve all blog posts.
- **POST /api/posts**: Create a new blog post.
- **GET /api/posts/{id}**: Retrieve a specific blog post by ID.
- **PUT /api/posts/{id}**: Update an existing blog post.
- **DELETE /api/posts/{id}**: Delete a blog post.
- **POST /api/auth/login**: Authenticate a user.
- **POST /api/auth/register**: Register a new user.

For more detailed API documentation, please refer to the [API Documentation](#).

## Contributing 🤝

We welcome contributions to the Blogging Platform! If you would like to contribute, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and commit them.
4. Push your changes to your fork.
5. Create a pull request.

## License 📄

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact 📬

For questions or feedback, feel free to reach out:

- **GitHub**: [Adr1an10](https://github.com/Adr1an10)
- **Email**: adr1an10@example.com

Thank you for checking out the Blogging Platform! We hope you enjoy using it as much as we enjoyed building it. For the latest updates, please visit the [Releases section](https://github.com/Adr1an10/Blogging-Platform/releases).