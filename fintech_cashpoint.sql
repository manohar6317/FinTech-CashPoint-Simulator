
-- Create Database
CREATE DATABASE IF NOT EXISTS atm_system;
USE atm_system;

-- Table for storing user details
CREATE TABLE users (
    card_no VARCHAR(20) PRIMARY KEY,
    pin VARCHAR(10) NOT NULL,
    name VARCHAR(100) NOT NULL,
    dob DATE,
    gender VARCHAR(10),
    email VARCHAR(100),
    phone VARCHAR(15),
    address VARCHAR(255),
    balance DECIMAL(12,2) DEFAULT 0.00
);

-- Table for storing transactions
CREATE TABLE transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    card_no VARCHAR(20),
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    type VARCHAR(20),   -- Deposit, Withdraw, FastCash
    amount DECIMAL(12,2),
    FOREIGN KEY (card_no) REFERENCES users(card_no)
);

-- Insert sample user
INSERT INTO users (card_no, pin, name, dob, gender, email, phone, address, balance)
VALUES ('1234567890123456', '1234', 'John Doe', '1995-06-15', 'Male',
        'john@example.com', '9876543210', '123 Main Street, City', 5000.00);

-- Insert sample transactions
INSERT INTO transactions (card_no, type, amount)
VALUES ('1234567890123456', 'Deposit', 2000.00),
       ('1234567890123456', 'Withdraw', 500.00),
       ('1234567890123456', 'FastCash', 1000.00);
