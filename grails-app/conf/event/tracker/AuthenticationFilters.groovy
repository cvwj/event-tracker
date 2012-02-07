package event.tracker

import org.codehaus.groovy.grails.plugins.codecs.Base64Codec
import org.grails.jaxrs.web.JaxrsUtils

class AuthenticationFilters {

    def filters = {
        all(controller:'jaxrs') {
            before = {
                String auth = request.getHeader("Authorization")
//                if (request.getMethod() == "POST" && ((String)request.getAttribute(JaxrsUtils.REQUEST_URI_ATTRIBUTE_NAME)).endsWith("/api/user"))
//                {
//                    return true
//                }
//
                if (!auth)
                {
                    response.sendError(401)
                    return false
                }
                if (auth.startsWith("Basic"))
                {
                    def userPassword = new String(Base64Codec.decode(auth.substring(auth.indexOf(" ") + 1))).split(":")
                    String user = userPassword[0]
                    String password = userPassword[1]
                    
                    def u = User.findByNameAndPassword(user, password)
                    if (!u)
                    {
                        response.sendError(401)
                        return false
                    }
                }

                return true
            }
        }
    }
}
