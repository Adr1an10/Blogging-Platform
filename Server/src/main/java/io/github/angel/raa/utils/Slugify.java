package io.github.angel.raa.utils;

import org.jetbrains.annotations.NotNull;

/**
 * Converts a string to a slug.
 */
public class Slugify {
    public static @NotNull String slugify(@NotNull String text) {
        return text.toLowerCase().replaceAll("[^a-z0-9\\s-]", "").replaceAll("[\\s-]+", "-");
    }
}
