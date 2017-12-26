package transients.bug

import grails.testing.mixin.integration.Integration
import grails.transaction.*
import spock.lang.Specification

@Integration
@Rollback
class DoableSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        given:
        Integer id
        Somethin.withTransaction {
            Somethin sumthin = new Somethin(persisted: 'blah')
            sumthin.forceUpdate = true
            sumthin.save(flush: true)
            id = sumthin.id
        }
        Somethin refreshedSomethin = Somethin.get(id)

        expect:
        refreshedSomethin.forceUpdate == false

    }
}
