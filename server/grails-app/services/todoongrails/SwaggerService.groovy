package todoongrails

import grails.gorm.transactions.Transactional
import io.swagger.util.Json

@Transactional
class SwaggerService {

    def swaggerConfig

    def generateJSON() {

        String[] schemes = ["http"]
        swaggerConfig.setSchemes(schemes)
        swaggerConfig.setScan(true)
        def swagger = swaggerConfig.getSwagger()

        Json.mapper().writeValueAsString(swagger)
    }
}
