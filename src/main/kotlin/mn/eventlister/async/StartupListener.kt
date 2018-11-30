package mn.eventlister.async

import io.micronaut.runtime.event.annotation.EventListener
import io.micronaut.runtime.server.event.ServerStartupEvent
import io.micronaut.scheduling.annotation.Async
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class StartupListener {
    val log = LoggerFactory.getLogger(javaClass)

    @EventListener
    @Async
    fun onStartup(event: ServerStartupEvent) {
        log.info("Startup {}", event)
    }
}