package com.sl.config.repository;

import com.sl.config.model.Config;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ConfigRepository implements CrudRepository<Config> {

    @Override
    public List<Config> findAll() {
        List<Config> configs = new ArrayList<>();
        Config config = new Config(
                1,
                "Config Project1",
                "jdbc:mysql://localhost:3306/project1?useTimezone=true&serverTimezone=UTC&useSSL=false",
                "root",
                "admin"
        );
        configs.add(config);

        return configs;
    }
}
