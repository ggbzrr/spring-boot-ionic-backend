package com.gabriel.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.gabriel.cursomc.domain.Pedido;


public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);
}