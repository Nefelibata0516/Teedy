package com.sismics.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

/**
 * Test of {@link LocaleUtil}.
 */
public class TestLocaleUtil {
    @Test
    public void testGetLocaleWithNullOrEmptyCode() {
        Assert.assertEquals(Locale.ENGLISH, LocaleUtil.getLocale(null));
        Assert.assertEquals(Locale.ENGLISH, LocaleUtil.getLocale(""));
    }

    @Test
    public void testGetLocaleWithLanguageOnly() {
        Locale locale = LocaleUtil.getLocale("fr");
        Assert.assertEquals("fr", locale.getLanguage());
        Assert.assertEquals("", locale.getCountry());
        Assert.assertEquals("", locale.getVariant());
    }

    @Test
    public void testGetLocaleWithLanguageAndCountry() {
        Locale locale = LocaleUtil.getLocale("fr_FR");
        Assert.assertEquals("fr", locale.getLanguage());
        Assert.assertEquals("FR", locale.getCountry());
        Assert.assertEquals("", locale.getVariant());
    }

    @Test
    public void testGetLocaleWithLanguageCountryAndVariant() {
        Locale locale = LocaleUtil.getLocale("fr_FR_POSIX");
        Assert.assertEquals("fr", locale.getLanguage());
        Assert.assertEquals("FR", locale.getCountry());
        Assert.assertEquals("POSIX", locale.getVariant());
    }
}
