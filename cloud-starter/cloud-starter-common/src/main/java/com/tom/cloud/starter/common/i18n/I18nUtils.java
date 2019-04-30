package com.tom.cloud.starter.common.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

/**
 * I18nUtils
 *
 * @author Tom.Zeng
 * @date 2019/3/29 18:33
 */
public class I18nUtils {

    private static MessageSource MESSAGE;

    public void setMessageSource(MessageSource messageSource) {
        MESSAGE = messageSource;
    }

    public static String getMessage(String key) {
        Locale locale = LocaleContextHolder.getLocale();
        return MESSAGE.getMessage(key, null, locale);
    }

    public static String getMessage(String key, Object... args) {
        Locale locale = LocaleContextHolder.getLocale();
        return MESSAGE.getMessage(key, args, locale);
    }

}
