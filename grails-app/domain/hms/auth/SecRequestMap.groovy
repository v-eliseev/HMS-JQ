package hms.auth

import hms.DomainBaseClass

import org.springframework.http.HttpMethod

class SecRequestMap extends DomainBaseClass {

   String url
   String configAttribute
   HttpMethod httpMethod

   static mapping = {
      cache true
   }

   static constraints = {
      url blank: false, unique: 'httpMethod'
      configAttribute blank: false
      httpMethod nullable: true
   }
}