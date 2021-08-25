# Spring Boot Configuration

In this branch we've been working with properties files, this is very useful to config Spring Boot, also we can add new profiles with personalize configurations, in this example
we've added two new profiles: dev(for development) and pdn(for production), in dev we've changed the application port, now is 8090.
Important: All profiles share the configuration that we define in the general properties file named application.properties, in this case we changed the context path for: 
/platzi-market/api
