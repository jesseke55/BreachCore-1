package net.breachmc.breachcore.configuration;

import net.breachmc.breachcore.Main;
import net.breachmc.breachcore.exception.BreachException;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Copyright (c) 2015, Experminator.
 */
public class ConfigurationManager {

    private File configurationFile;
    private FileConfiguration configuration;

    protected ConfigurationManager(String fileName, FileType type) {
        configurationFile = new File(Main.getPlugin().getDataFolder(), fileName + "." + type.getExtension());

        if (!(configurationFile.exists())) {
            try {
                configurationFile.createNewFile();
            } catch (IOException e) {
                throw new BreachException("Couldn't create '{file}': {reason}"
                        .replace("{file}", fileName + "." + type.getExtension())
                        .replace("{reason}", e.getMessage())
                );
            }
        }

        configuration = YamlConfiguration.loadConfiguration(configurationFile);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String path) {
        return (T) configuration.get(path);
    }

    public void set(String path, Object value) {
        configuration.set(path, value);
    }

    public boolean contains(String path) {
        return configuration.contains(path);
    }

    public ConfigurationSection createConfigurationSection(String path) {
        return configuration.createSection(path);
    }

    public void save() {
        try {
            configuration.save(configurationFile);
        } catch (IOException e) {
            throw new BreachException("Couldn't save '{file}': {reason}"
                    .replace("{file}", configurationFile.getName() + ".")
                    .replace("{reason}", e.getMessage())
            );
        }
    }

    public enum FileType {

        TEXT("txt"),
        YAML("yml");

        private String extension;

        FileType(String extension) {
            this.extension = extension;
        }

        public String getExtension() {
            return extension;
        }
    }
}
