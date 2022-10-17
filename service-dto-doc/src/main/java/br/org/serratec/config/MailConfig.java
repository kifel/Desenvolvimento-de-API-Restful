package br.org.serratec.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String para, String assunto, String texto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("joao.pereira51@aluno.senai.br");
        message.setTo(para);
        message.setSubject(assunto);
        message.setText(texto);
        message.setText("Dados do cadastro do usuário:\n" + texto + "\n\n\n\n" + "Serratec Residência-2022");
        javaMailSender.send(message);
    }
}
