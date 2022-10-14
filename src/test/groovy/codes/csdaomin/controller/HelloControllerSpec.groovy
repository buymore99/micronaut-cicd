package codes.csdaomin.controller

import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import spock.lang.AutoCleanup
import spock.lang.Specification
import spock.lang.Shared

import jakarta.inject.Inject
import codes.csdaomin.AbstractSpec

@MicronautTest
class HelloControllerSpec extends AbstractSpec {

    @Shared @Inject
    EmbeddedServer embeddedServer

    @Shared @AutoCleanup @Inject @Client("/")
    HttpClient client

    void "test index"() {
        given:
        HttpResponse response = client.toBlocking().exchange("/hello")

        expect:
        response.status == HttpStatus.OK
    }
}
