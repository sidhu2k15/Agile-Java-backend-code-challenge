CREATE TABLE users (
    username VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    gender VARCHAR(10),
    picture_url VARCHAR(255),
    country VARCHAR(100),
    state VARCHAR(100),
    city VARCHAR(100)
);
INSERT INTO users (username, name, email, gender, picture_url, country, state, city) 
VALUES 
    ('john_doe', 'John Doe', 'john.doe@example.com', 'male', 'https://randomuser.me/api/portraits/men/1.jpg', 'United States', 'California', 'Los Angeles'),
    ('jane_smith', 'Jane Smith', 'jane.smith@example.com', 'female', 'https://randomuser.me/api/portraits/women/2.jpg', 'United Kingdom', 'England', 'London'),
    ('sam_brown', 'Sam Brown', 'sam.brown@example.com', 'male', 'https://randomuser.me/api/portraits/men/3.jpg', 'Canada', 'Ontario', 'Toronto'),
    ('emma_wilson', 'Emma Wilson', 'emma.wilson@example.com', 'female', 'https://randomuser.me/api/portraits/women/4.jpg', 'Australia', 'New South Wales', 'Sydney'),
    ('michael_jones', 'Michael Jones', 'michael.jones@example.com', 'male', 'https://randomuser.me/api/portraits/men/5.jpg', 'India', 'Maharashtra', 'Mumbai'),
    ('lisa_taylor', 'Lisa Taylor', 'lisa.taylor@example.com', 'female', 'https://randomuser.me/api/portraits/women/6.jpg', 'Germany', 'Bavaria', 'Munich'),
    ('david_clark', 'David Clark', 'david.clark@example.com', 'male', 'https://randomuser.me/api/portraits/men/7.jpg', 'United States', 'Texas', 'Houston'),
    ('sarah_moore', 'Sarah Moore', 'sarah.moore@example.com', 'female', 'https://randomuser.me/api/portraits/women/8.jpg', 'France', 'Île-de-France', 'Paris'),
    ('chris_evans', 'Chris Evans', 'chris.evans@example.com', 'male', 'https://randomuser.me/api/portraits/men/9.jpg', 'Italy', 'Lombardy', 'Milan'),
    ('olivia_adams', 'Olivia Adams', 'olivia.adams@example.com', 'female', 'https://randomuser.me/api/portraits/women/10.jpg', 'Spain', 'Catalonia', 'Barcelona');
