//// MailConfiguration.java
package com.agilelabs.email;
//MailConfiguration.java

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MailConfiguration {

 @Value("${spring.mail.host}")
 private String emailHost;

 @Value("${spring.mail.port}")
 private String emailPort;

 @Value("${spring.mail.auth}")
 private String emailAuth;

 @Value("${spring.mail.starttls.enable}")
 private String startTlsEnable;

 @Value("${spring.mail.username}")
 private String emailAuthUsername;

 @Value("${spring.mail.password}")
 private String emailAuthPassword;

 @Bean(name = "customMailSessionProvider")
 public MailSessionProvider mailSessionProvider() {
     return new MailSessionProvider(emailHost, emailPort, emailAuth, startTlsEnable, emailAuthUsername, emailAuthPassword);
 }
}

//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class MailConfiguration {
//
//    @Value("${spring.mail.host}")
//    private String emailHost;
//
//    @Value("${spring.mail.port}")
//    private String emailPort;
//
//    @Value("${spring.mail.auth}")
//    private String emailAuth;
//
//    @Value("${spring.mail.starttls.enable}")
//    private String startTlsEnable;
//
//    @Value("${spring.mail.username}")
//    private String emailAuthUsername;
//
//    @Value("${spring.mail.password}")
//    private String emailAuthPassword;
//
//    @Bean(name = "customMailSessionProvider")
//     MailSessionProvider mailSessionProvider() {
//        return new MailSessionProvider(emailHost, emailPort, emailAuth, startTlsEnable, emailAuthUsername, emailAuthPassword);
//    }
//}
