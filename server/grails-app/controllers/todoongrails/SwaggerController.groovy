package todoongrails

import grails.rest.*
import grails.converters.*

class SwaggerController {
	static responseFormats = ['json', 'xml', 'html']

    def swaggerService

    def swaggerJson() {
        render (swaggerService.generateJSON())
    }

}
