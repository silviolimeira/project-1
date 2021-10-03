package com.sl.config.service;

import com.sl.config.model.Config;
import com.sl.config.repository.ConfigRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConfigService implements CrudService<Config> {

    private ConfigRepository configRepository;

    public ConfigService(ConfigRepository configRepository) {
        this.configRepository = configRepository;
    }

    @Override
    public List<Config> list() {
        return configRepository.findAll();
    }

    @Override
    public Config create(Config config) {
        return null;
    }

    @Override
    public Optional<Config> get(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Config config, int id) {

    }

    @Override
    public void delete(int id) {

    }
}
