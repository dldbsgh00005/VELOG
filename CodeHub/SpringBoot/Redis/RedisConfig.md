```
@Bean
    RedisTemplate<String, String> redisConfiguration(RedisConnectionFactory factory){

        // Constructor
        RedisTemplate<String, String> template = new RedisTemplate<>();

        // ConnectionFactory
        template.setConnectionFactory(factory);

        // Key Serializer
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());

        // Value Serializer
        template.setHashValueSerializer(new StringRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());

        template.afterPropertiesSet();

        return template;
    }

    @Bean
    RedisTemplate<String, SaveEmbeddingVectorToRedisRequestDTO> redisConfiguration2(RedisConnectionFactory factory){

        // Constructor
        RedisTemplate<String, SaveEmbeddingVectorToRedisRequestDTO> template = new RedisTemplate<>();

        // ConnectionFactory
        template.setConnectionFactory(factory);

        // Key Serializer
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());

        // Value Serializer
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        template.afterPropertiesSet();

        return template;
    }

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        // 기본 캐시 설정 (여기서 entryTtl로 TTL 지정)
        RedisCacheConfiguration cacheConfig = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(5)); // 예: 모든 캐시 항목의 유효기간을 5분으로 설정
```
        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(cacheConfig)
                .build();
    }
