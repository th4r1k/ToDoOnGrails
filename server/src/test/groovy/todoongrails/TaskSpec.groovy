package todoongrails

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class TaskSpec extends Specification implements DomainUnitTest<Task> {

    def setup() {
    }

    def cleanup() {
    }

    void "Name can not be null"() {
        when:
        domain.name = value
        then:
        expected  == domain.validate(['name'])
        domain.errors['name'].code == expectedErrorCode

        where:
        value   | expected |    expectedErrorCode
        null    |   false   |   'nullable'
    }

    void "Description can not be null"() {
        when:
        domain.description = null
        then:
        !domain.validate(['description'])
        domain.errors['description'].code == 'nullable'
    }

    void "dateEnd must be 'yyyy-mm-dd' format"() {
        when:
        domain.endDate = value
        then:
        expected == domain.validate(['endDate'])
        domain.errors['endDate']?.code == expectedErrorCode

        where:
        value   | expected |    expectedErrorCode
        "2023-01-01"    |   true   |   null
        "2023-32-12"    |   false   | 'matches.invalid'
        01/01/2023      |   false   | 'matches.invalid'
        "01/01/2023"    |   false   | 'matches.invalid'
    }

    void "endTime must be 'HH:mm' format"() {
        when:
        domain.endTime = value
        then:
        expected == domain.validate(['endTime'])
        domain.errors['endTime']?.code == expectedErrorCode

        where:
        value  | expected |    expectedErrorCode
        "11:11" |   true    |   null
        null    |   false   |  'nullable'
        "2h33"    |   false   |  'matches.invalid'
        "6eonibus"|   false   |  'matches.invalid'
    }

    void "Category can not be null"() {
        when:
        domain.category = null
        then:
        !domain.validate(['category'])
        domain.errors['category'].code == 'nullable'
    }

    void "priority must be '[1-5]' format"() {
        when:
        domain.priority = value
        then:
        expected == domain.validate(['priority'])
        domain.errors['priority']?.code == expectedErrorCode

        where:
        value  | expected |    expectedErrorCode
        "1"    |   true   |   null
        "2"    |   true   |   null
        "3"    |   true   |   null
        "4"    |   true   |   null
        "5"    |   true   |   null
        null   |   false  |  'nullable'
        6      |   false   | 'matches.invalid'
        "high" |   false   | 'matches.invalid'
    }

    void "status must be 'todo|doing|done' format"() {
        when:
        domain.status = value
        then:
        expected == domain.validate(['status'])
        domain.errors['status']?.code == expectedErrorCode

        where:
        value  | expected |    expectedErrorCode
        "todo" |   true   |   null
        "doing"|   true   |   null
        "done" |   true   |   null
        null   |   false  |   'nullable'
        "almost"    |   false  |   'matches.invalid'
    }

}
