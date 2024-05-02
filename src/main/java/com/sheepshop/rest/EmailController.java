package com.sheepshop.rest;

import com.sheepshop.model.req.EmailRequest;
import com.sheepshop.services.EmailService;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.CompletableFuture;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/sendmail")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public void sendHtmlEmail(@RequestBody EmailRequest emailRequest) {
        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(10000); // Trì hoãn 10 giây
                emailService.sendHtmlMessage(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getBodyHtml());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }
}
