package codes.csdaomin

import io.micronaut.test.extensions.spock.annotation.MicronautTest;

@MicronautTest
public class HelloWorldSpec extends AbstractSpec {
    def "test hello world"() {
        def foo = 'bar'
        when:
        foo == 'bar'
        then:
        foo.reverse() == 'rab'
    }
}
