package fr.formation.modular.notification;
import org.slf4j.*; import org.springframework.stereotype.Service;
@Service class LoggingNotificationModule implements NotificationFacade { private static final Logger LOG=LoggerFactory.getLogger(LoggingNotificationModule.class); public void reservationConfirmed(String email){LOG.info("Reservation confirmation sent to {}",email);} }
