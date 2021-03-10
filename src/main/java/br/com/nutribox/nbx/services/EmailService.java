package br.com.nutribox.nbx.services;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import br.com.nutribox.nbx.entity.Pessoa;

@Service
public interface EmailService {

void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Pessoa pessoa, String newPass);
	
}
