package com.sl.config.dao;

import com.sl.config.model.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public class ConfigJdbcDAO implements DAO<Config> {

    private static final Logger log = LoggerFactory.getLogger(ConfigJdbcDAO.class);
    private JdbcTemplate jdbcTemplate;

    public ConfigJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Maps a row in the database to a Course
     */
    RowMapper<Config> rowMapper = (rs, rowNum) -> {
        Config config = new Config();
        config.setId(rs.getInt("id"));
        config.setName(rs.getString("name"));
        config.setUrl(rs.getString("url"));
        return config;
    };

    @Override
    public List<Config> list() {
        String sql = "SELECT course_id, title, description, link from course";
        return jdbcTemplate.query(sql,rowMapper);
    }

    // CRUD (Create, Read, Update, Delete)

    @Override
    public void create(Config config) {
        String sql = "insert into course(title,description,link) values(?,?,?)";
        int insert = jdbcTemplate.update(sql,config.getUrl());
        if(insert == 1) {
            log.info("New Config Created: " + config.getUrl());
        }
    }

    @Override
    public Optional<Config> get(int id) {
        String sql = "SELECT id,name,url from config where id = ?";
        Config config = null;
        try {
            config = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        }catch (DataAccessException ex) {
            log.info("Course not found: " + id);
        }
        return Optional.ofNullable(config);
    }

    @Override
    public void update(Config config, int id) {
        String sql = "update course set name = ?, url = ? where id = ?";
        int update = jdbcTemplate.update(sql,config.getName(),config.getUrl(),id);
        if(update == 1) {
            log.info("Course Updated: " + config.getName());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from config where id = ?";
        int delete = jdbcTemplate.update(sql,id);
        if(delete == 1) {
            log.info("Course Deleted: " + id);
        }
    }}
