package fr.formation.layered.service;
import org.slf4j.Logger; import org.slf4j.LoggerFactory; import org.springframework.stereotype.Service;
@Service public class NotificationService { private static final Logger LOG=LoggerFactory.getLogger(NotificationService.class); public void confirmed(String email){LOG.info("Reservation confirmation sent to {}",email);} }
