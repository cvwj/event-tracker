package event.tracker

import static org.grails.jaxrs.response.Responses.*

import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.Produces
import javax.ws.rs.PUT
import javax.ws.rs.core.Response

import org.grails.jaxrs.provider.DomainObjectNotFoundException

@Consumes(['application/xml', 'application/json'])
@Produces(['application/xml', 'application/json'])
class UserResource {

    def userResourceService
    def id

    @GET
    Response read() {
        ok userResourceService.read(id)
    }

    @PUT
    Response update(User dto) {
        dto.id = id
        ok userResourceService.update(dto)
    }

    @DELETE
    void delete() {
        userResourceService.delete(id)
    }

}

