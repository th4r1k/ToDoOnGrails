package todoongrails

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class SwaggerControllerSpec extends Specification implements ControllerUnitTest<SwaggerController> {


    void "Controller call swwagerService"() {
        given:
        controller.swaggerService = Mock(SwaggerService) {
            generateJSON() >> "ok"
        }
        when:
        controller.swaggerJson()

        then:
        response.status == 200
        response.text == "ok"
    }
}