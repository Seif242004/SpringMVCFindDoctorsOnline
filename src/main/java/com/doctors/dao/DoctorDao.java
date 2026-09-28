package com.doctors.dao;

import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.doctors.beans.Doctor;

@Repository
public class DoctorDao {
    private static final String SELECT_DOCTOR_FIELDS =
            "SELECT id, doctorName, doctorRegistrationNumber, qualification, gender FROM DoctorsDetails ";

    private final JdbcTemplate jdbcTemplate;

    public DoctorDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Doctor getDoctorsByName(String doctorName) throws SQLException {
        String sql = SELECT_DOCTOR_FIELDS + "WHERE doctorName = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Doctor>(Doctor.class), doctorName);
    }

    public Doctor getDoctorsByRegistrationNumber(String registrationNumber) throws SQLException {
        String sql = SELECT_DOCTOR_FIELDS + "WHERE doctorRegistrationNumber = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Doctor>(Doctor.class), registrationNumber);
    }
}