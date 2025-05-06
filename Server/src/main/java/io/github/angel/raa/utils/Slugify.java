package io.github.angel.raa.utils;

import org.jetbrains.annotations.NotNull;

import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * Converts a string to a slug.
 */
public class Slugify {
    private static final Pattern NON_LATIN = Pattern.compile("[^\\w-]");
    private static final Pattern SEPARATORS = Pattern.compile("[\\s\\p{Punct}&&[^-]]");
    public static @NotNull String slugify(@NotNull String text) {
        String noseparators = SEPARATORS.matcher(text).replaceAll("-");
        String normalized = Normalizer.normalize(noseparators, Normalizer.Form.NFD);
        String slug = NON_LATIN.matcher(normalized).replaceAll("");
        return slug.toLowerCase().replaceAll("-{2,}", "-").replaceAll("^-|-$", "");

    }

    public static void main(String[] args) {
        String text = "Léte ou es-tu?";
        String slug = Slugify.slugify(text);
        System.out.println("Hola Mundo " + slug); // Output: lete-ou-es-tu

    }
}
