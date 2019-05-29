package com.tom.cloud.starter.common.i18n;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

/**
 * I18nAutoConfiguration
 *
 * @author Tom.Zeng
 * @date 2019/4/25 18:12
 */
@Slf4j
@Configuration
public class I18nAutoConfiguration {
    @Bean
    public LocaleResolver localeResolver() {
        LocaleResolver localeResolver = new I18nLocaleResolver();
        log.info("I18nLocaleResolver has been initialized.");
        return localeResolver;
    }

    @Bean
    public I18nUtil i18nUtil(MessageSource messageSource) {
        I18nUtil i18NUtil = new I18nUtil();
        i18NUtil.setMessageSource(messageSource);
        log.info("I18nUtil has been initialized.");
        return i18NUtil;
    }
}
