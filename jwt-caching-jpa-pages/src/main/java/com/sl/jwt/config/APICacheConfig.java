package com.sl.jwt.config;

import com.sl.jwt.handler.APICacheFilter;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.sf.ehcache.config.CacheConfiguration;

@Configuration
@EnableCaching
public class APICacheConfig extends CachingConfigurerSupport {

    @Bean
    public APICacheFilter aPIFilter() {
        return new APICacheFilter();
    }

    @Bean
    public net.sf.ehcache.CacheManager ehCacheManager() {
        CacheConfiguration tenSecondCache = new CacheConfiguration();
        tenSecondCache.setName("ten-second-cache");
        tenSecondCache.setMemoryStoreEvictionPolicy("LRU");
        tenSecondCache.setMaxEntriesLocalHeap(1000);
        tenSecondCache.setTimeToLiveSeconds(10);

        CacheConfiguration twentySecondCache = new CacheConfiguration();
        twentySecondCache.setName("twenty-second-cache");
        twentySecondCache.setMemoryStoreEvictionPolicy("LRU");
        twentySecondCache.setMaxEntriesLocalHeap(1000);
        twentySecondCache.setTimeToLiveSeconds(20);

        net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
        config.addCache(tenSecondCache);
        config.addCache(twentySecondCache);
        return net.sf.ehcache.CacheManager.newInstance(config);
    }

    @Bean
    @Override
    public CacheManager cacheManager() {
        return new EhCacheCacheManager(ehCacheManager());
    }
}
