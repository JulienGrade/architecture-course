package fr.formation.layered;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*; import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.api.Test; import org.springframework.beans.factory.annotation.Autowired; import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc; import org.springframework.boot.test.context.SpringBootTest; import org.springframework.http.MediaType; import org.springframework.test.web.servlet.MockMvc;
@SpringBootTest @AutoConfigureMockMvc
class ReservationApiTest {
 @Autowired MockMvc mvc;
 @Test void rejectsReservationWhenRoomIsTooSmall() throws Exception {
  var room=mvc.perform(post("/api/rooms").contentType(MediaType.APPLICATION_JSON).content("{\"name\":\"Ada\",\"capacity\":4}" )).andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();
  var id=room.substring(room.indexOf("\"id\":\"")+6,room.indexOf("\"",room.indexOf("\"id\":\"")+6));
  mvc.perform(post("/api/reservations").contentType(MediaType.APPLICATION_JSON).content("{\"roomId\":\""+id+"\",\"organizerEmail\":\"ada@example.com\",\"participants\":5,\"startsAt\":\"2030-01-15T09:00:00\",\"endsAt\":\"2030-01-15T10:00:00\"}" )).andExpect(status().isUnprocessableEntity());
 }
}
