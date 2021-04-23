
import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url '/ru'
        headers {
        }
    }
    response {
        status 200
        body("Здравствуйте")
        headers {
            contentType(textPlain())
        }
    }
}
