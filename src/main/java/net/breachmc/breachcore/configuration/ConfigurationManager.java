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

    /**
     * Access without any arguments is not allowed in this case.
     */
    private ConfigurationManager() {
    }

    /**
     * Creates file with given name and extension, and makes the instance for the methods from here.
     *
     * @param fileName The name of the file.
     * @param type     The type of the file.
     */
    public ConfigurationManager(String fileName, FileType type) {
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

    /**
     * @param path The path to the object.
     * @param <T> The object which is returned.
     * @return T
     */
    @SuppressWarnings("unchecked")
    public <T> T get(String path) {
        return (T) configuration.get(path);
    }

    /**
     * @param path The path in the configuration.
     * @param value The value for the given path.
     */
    public void set(String path, Object value) {
        configuration.set(path, value);
    }

    /**
     * @param path The path to remove from the configuration.
     */
    public void remove(String path) {
        this.set(path, null);
    }

    /**
     * @param path The path to check if it exists in the configuration.
     * @return True if it exists in the configuration else false.
     */
    public boolean contains(String path) {
        return configuration.contains(path);
    }

    /**
     * @see ConfigurationSection
     * @param path The path to create the configuration section for.
     * @return The ConfigurationSection with the given path.
     */
    public ConfigurationSection createConfigurationSection(String path) {
        return configuration.createSection(path);
    }

    /**
     * @return True if successfully saved else false.
     */
    public boolean save() {
        try {
            configuration.save(configurationFile);
            return true;
        } catch (IOException e) {
            throw new BreachException("Couldn't save '{file}': {reason}"
                    .replace("{file}", configurationFile.getName() + ".")
                    .replace("{reason}", e.getMessage())
            );
        }
    }

    /**
     * @see ConfigurationManager
     * FileType enum for the ConfigurationManager constructor.
     */
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
