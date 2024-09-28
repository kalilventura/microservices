package br.com.github.kalilventura.api.global.shared;

import java.time.Duration;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;

@EnableCaching
@Configuration
public class RedisConfiguration {

  //    @Bean
  //    public RedisCacheConfiguration defaultCacheConfiguration() {
  //        final var serializer = new GenericJackson2JsonRedisSerializer();
  //        final var ttl = Duration.ofMinutes(120); // 2 hours
  //        return RedisCacheConfiguration.defaultCacheConfig()
  //            .entryTtl(ttl)
  //            .disableCachingNullValues()
  //            .serializeValuesWith(fromSerializer(serializer));
  //    }
  //
  //    @Bean
  //    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer(
  //        final RedisCacheConfiguration defaultCacheConfiguration) {
  //        return builder -> builder.withCacheConfiguration("products", defaultCacheConfiguration);
  //    }

  @Bean
  public RedisCacheManagerBuilderCustomizer myRedisCacheManagerBuilderCustomizer() {
    return (builder) ->
        builder.withCacheConfiguration(
            "products", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(2)));
  }
}
