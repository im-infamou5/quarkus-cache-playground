package org.acme;

import io.quarkus.cache.CacheResult

class GreetingResource {
    @CacheResult(cacheName = "default")
    fun hello(): String {
        return "Hello from RESTEasy Reactive"
    }
}
