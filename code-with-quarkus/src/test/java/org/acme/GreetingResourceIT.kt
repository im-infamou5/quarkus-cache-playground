package org.acme

import io.quarkus.test.junit.QuarkusIntegrationTest
import javax.inject.Inject
import io.quarkus.cache.CacheManager


@QuarkusIntegrationTest
class GreetingResourceIT : GreetingResourceTest() { 
    @Inject
    lateinit var cacheManager: CacheManager

    init {
        "test cache size"() {
            println("Cache size: " + cacheManager.getCache("default"))
        }
    }
}
