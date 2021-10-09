package com.leacar21.technical.show.catalog.config;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.Ticker;

@Configuration
@EnableCaching
@ConfigurationProperties(prefix = "custom.cache")
public class CacheConfig {

    Logger log = LoggerFactory.getLogger(CacheConfig.class);

    private Map<String, CacheSpec> specs;

    @Bean
    public CacheManager cacheManager(Ticker ticker) {
        SimpleCacheManager manager = new SimpleCacheManager();
        if (this.specs != null) {
            List<CaffeineCache> caches = this.specs.entrySet().stream().map(entry -> buildCache(entry.getKey(), entry.getValue(), ticker))
                    .collect(Collectors.toList());
            manager.setCaches(caches);
        }
        return manager;
    }

    private CaffeineCache buildCache(String name, CacheSpec spec, Ticker ticker) {
        this.log.info("Cache '{}' specified timeout of {} {} and max entries={}", name, spec.getTimeout(), spec.getTimeUnit().name(),
                spec.getMaxEntries());

        Caffeine<Object, Object> builder = Caffeine.newBuilder().expireAfterWrite(spec.getTimeout(), spec.getTimeUnit())
                .maximumSize(spec.getMaxEntries()).ticker(ticker);
        return new CaffeineCache(name, builder.build());
    }

    @Bean
    public Ticker ticker() {
        return Ticker.systemTicker();
    }

    public Map<String, CacheSpec> getSpecs() {
        return this.specs;
    }

    public void setSpecs(Map<String, CacheSpec> specs) {
        this.specs = specs;
    }

    public static class CacheSpec {

        private TimeUnit timeUnit = TimeUnit.HOURS;
        private Integer timeout = 1;
        private Integer maxEntries = 500;

        public TimeUnit getTimeUnit() {
            return this.timeUnit;
        }

        public void setTimeUnit(TimeUnit timeUnit) {
            this.timeUnit = timeUnit;
        }

        public Integer getTimeout() {
            return this.timeout;
        }

        public void setTimeout(Integer timeout) {
            this.timeout = timeout;
        }

        public Integer getMaxEntries() {
            return this.maxEntries;
        }

        public void setMaxEntries(Integer maxEntries) {
            this.maxEntries = maxEntries;
        }
    }
}