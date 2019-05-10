package com.tom.cloud.starter.common.i18n;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    public I18nUtils i18nUtils(MessageSource messageSource) {
        I18nUtils i18nUtils = new I18nUtils();
        i18nUtils.setMessageSource(messageSource);
        log.info("I18nUtils has been initialized.");
        return i18nUtils;
    }
}
