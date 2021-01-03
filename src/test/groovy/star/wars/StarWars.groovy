package star.wars

import groovyx.net.http.HttpResponseException
import groovyx.net.http.RESTClient
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Shared
import spock.lang.Specification

@SpringBootTest(classes = [StarWarsApplication], webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class StarWars extends Specification implements Result {

    @Shared
    def client = new RESTClient("http://localhost:8090")

    def 'should return character metadata containing proper fields'() {
        when: 'send request for character metadata'
        def response = client.get(path: '/characters/1')

        then: 'server returns set of metadata for a single character'
        assert response.status == 200: 'response code should be 200'
        assert response.contentType == 'application/json': 'response should be in json format'

        and: 'response contains all required fields'
        assert response.responseData.toString() == getCharacterOne()
    }

    def 'should return 404 (Not Found) code when used wrong id'() {
        when: 'send request for character metadata'
        client.get(path: '/characters/0')

        then: 'server returns 404 code (Not Found)'
        HttpResponseException e = thrown(HttpResponseException)
        assert e.response.status == 404: 'response code should be 404 when you use wrong id'
    }

    def 'should return list of character metadata containing proper fields'() {
        when: 'send request for list of character metadata'
        def response = client.get(path: '/characters', query: [page: 1])

        then: 'server returns set of metadata for a list of characters'
        assert response.status == 200: 'response code should be 200'
        assert response.contentType == 'application/json': 'response should be in json format'

        and: 'response contains all required fields'
        assert response.responseData.toString() == getCharacterList()
    }

    def 'should return 404 (Not Found) code when used wrong page number'() {
        when: 'send request for list of character metadata'
        client.get(path: '/characters', query: [page: 0])

        then: 'server returns 404 code (Not Found)'
        HttpResponseException e = thrown(HttpResponseException)
        assert e.response.status == 404: 'response code should be 404 when you use wrong page number'
    }
}