package com.tom.cloud.starter.common.i18n;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * I18nLocaleResolver
 *
 * @author Tom.Zeng
 * @date 2019/4/3 16:24
 */
@Slf4j
public class I18nLocaleResolver implements LocaleResolver {


    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String lang = request.getParameter("lang");
        log.debug("Resolved locale: lang={}", lang);
        Locale locale = Locale.getDefault();
        if (StringUtils.isNotEmpty(lang)) {
            locale = new Locale(lang);
        }
        LocaleContextHolder.setLocale(locale);
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
    }
}
