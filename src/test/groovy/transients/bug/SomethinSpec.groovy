package transients.bug

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class SomethinSpec extends Specification implements DomainUnitTest<Somethin> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        given:
        Integer id
        Somethin.withTransaction {
            Somethin somethin = new Somethin(persisted: "complete", notPersisted: 'wut')
            somethin.save()
            id = somethin.id
        }

        expect: "Transient property should not be persisted"
        Somethin.get(id).notPersisted != 'wut'

    }
}
