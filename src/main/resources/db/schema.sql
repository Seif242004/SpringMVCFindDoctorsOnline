CREATE DATABASE IF NOT EXISTS geeksforgeeks;
USE geeksforgeeks;

CREATE TABLE IF NOT EXISTS DoctorsDetails (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    doctorName VARCHAR(50) NOT NULL,
    doctorRegistrationNumber VARCHAR(10) NOT NULL,
    qualification VARCHAR(30) NOT NULL,
    gender VARCHAR(10),
    PRIMARY KEY (id),
    UNIQUE KEY uq_doctor_registration_number (doctorRegistrationNumber)
);

INSERT INTO DoctorsDetails (doctorName, doctorRegistrationNumber, qualification, gender)
SELECT sample.doctorName, sample.doctorRegistrationNumber, sample.qualification, sample.gender
FROM (
    SELECT 'doctorA' AS doctorName, '123-456' AS doctorRegistrationNumber, 'MDDCH' AS qualification, 'Female' AS gender
    UNION ALL SELECT 'doctorB', '111-222', 'MSNeuro', 'Male'
    UNION ALL SELECT 'doctorC', '222-444', 'MDGynae', 'Female'
    UNION ALL SELECT 'doctorD', '199-998', 'MSNephro', 'Male'
    UNION ALL SELECT 'doctorE', '444-666', 'MDCardio', 'Female'
) AS sample
WHERE NOT EXISTS (
    SELECT 1
    FROM DoctorsDetails existing
    WHERE existing.doctorRegistrationNumber = sample.doctorRegistrationNumber
);