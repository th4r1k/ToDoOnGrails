import io.swagger.jaxrs.config.BeanConfig

beans = {
    swaggerConfig(BeanConfig) {
        def serverUrl = "http://localhost:8080/"
        def hostName = "localhost:8080"
        resourcePackage = "todoongrails"
        host = hostName
        basePath = "/"
        version = 'v0'
        title = 'Swagger'
        description = 'API for Accessing  resources'
        contact = 'honda.tharik@gmail.com'
        license = ''
    }
}
