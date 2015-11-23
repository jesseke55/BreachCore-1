package net.breachmc.breachcore.command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Copyright (c) 2015, Experminator.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CommandData {

    String name();

    String description();

    String[] aliases();

    String permission();

    boolean isOnlyPlayer();
}
