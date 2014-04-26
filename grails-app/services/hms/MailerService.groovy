package hms

import freemarker.template.Configuration
import freemarker.template.Template
import freemarker.template.DefaultObjectWrapper

import javax.annotation.PostConstruct

class MailerService {

	def mailService

	static Configuration cfg


	@PostConstruct
	private void init() {
		/* Create and adjust the configuration */
        MailerService.cfg = new Configuration();
        cfg.setClassForTemplateLoading(
        		this.getClass(),
                "/freemarker");
        cfg.setObjectWrapper(new DefaultObjectWrapper());
	}

    def sendMail(License license, String subjectLine, String messageBody) {
		mailService.sendMail {     
  			to  license.email
  			subject subjectLine
  			body messageBody 
		}
    }

    def sendHtmlMail(License license, String subjectLine, String htmlBody) {
        mailService.sendMail {     
            to  license.email
            subject subjectLine
            html htmlBody 
        }
    }

    def sendConfirmationOnPasswordChange(License license, Map model) {

        Template temp = MailerService.cfg.getTemplate("passwordConfirmation.ftl");
        Writer out = new StringWriter()
        temp.process(model, out)
        def messageBody = out.toString()
        sendHtmlMail(license, "Confirmation on password change", messageBody)
    }

    def sendConfirmationOnEmailChange(License license, Map model) {

    	Template temp = MailerService.cfg.getTemplate("emailConfirmation.ftl");
    	Writer out = new StringWriter()
    	temp.process(model, out)
    	def messageBody = out.toString()
    	sendHtmlMail(license, "Confirmation on e-mail change", messageBody)
    }
}
