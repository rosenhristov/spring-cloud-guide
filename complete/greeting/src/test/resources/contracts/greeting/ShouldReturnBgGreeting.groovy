
import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url '/bg'
        headers {
        }
    }
    response {
        status 200
        body("Здравейте")
        headers {
            contentType(textPlain())
        }
    }
}
