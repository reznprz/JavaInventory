-- Create User table
CREATE TABLE IF NOT EXISTS users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Insert some rows
INSERT INTO users (username, password) VALUES ('Alice', 'password1');
INSERT INTO users (username, password) VALUES ('Bob', 'password2');
