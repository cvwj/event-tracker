package event.tracker

import org.grails.jaxrs.provider.DomainObjectNotFoundException

class UserResourceService {
    
    def create(User dto) {
        dto.save()
    }

    def read(def id) {
        def obj = User.get(id)
        if (!obj) {
            throw new DomainObjectNotFoundException(User.class, id)
        }
        obj
    }
    
    def readAll() {
        User.findAll()
    }
    
    def update(User dto) {
        def obj = User.get(dto.id)
        if (!obj) {
            throw new DomainObjectNotFoundException(User.class, dto.id)
        }
        obj.properties = dto.properties 
        obj
    }
    
    void delete(def id) {
        def obj = User.get(id)
        if (obj) { 
            obj.delete()
        }
    }
    
}

