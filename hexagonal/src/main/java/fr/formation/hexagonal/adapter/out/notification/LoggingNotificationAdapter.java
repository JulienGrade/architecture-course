package fr.formation.hexagonal.adapter.out.notification;
import fr.formation.hexagonal.application.port.out.NotificationPort; import org.slf4j.*; import org.springframework.stereotype.Component;
@Component public class LoggingNotificationAdapter implements NotificationPort {private static final Logger LOG=LoggerFactory.getLogger(LoggingNotificationAdapter.class);public void reservationConfirmed(String email){LOG.info("Reservation confirmation sent to {}",email);}}
