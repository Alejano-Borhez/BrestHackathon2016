package com.epam.hackathon2016.event.mail;

import com.epam.hackathon2016.event.domain.Event;
import com.epam.hackathon2016.event.domain.Group;
import com.epam.hackathon2016.event.domain.User;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by alexander on 11.9.16.
 */
@Component
public class EventMailSender {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private Configuration freeMarkerConfig;

    private boolean sendEventCreationEmail(Event event) {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);


        List<Group> groupList = event.getGroups();
        List<String> emails = event.getGroups().stream().collect(Collectors.toList()).stream().map(Group::getUserList).map(User::getEmail).collect(Collectors.toList());
        for (Group group: groupList) {
            userList.addAll(group.getUserList().stream().collect(Collectors.toList()));
        }


        helper.setTo(emails);
        try {
            helper.setSubject("Simple Social Network - password recovery");
            helper.setText(text, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        String text = prepareText("new", path, token, user);

        mailSender.send(mimeMessage);

        return true;
    }

    private String prepareMailText(Event event, String topic) throws IOException, TemplateException {
        StringWriter message = new StringWriter();

        Template template = freeMarkerConfig.getTemplate(topic + ".ftl");
        Map<String, Object> model = new HashMap<>();
        model.put("event", event);
        template.process(model, message);

        return message.toString();
    }
}
