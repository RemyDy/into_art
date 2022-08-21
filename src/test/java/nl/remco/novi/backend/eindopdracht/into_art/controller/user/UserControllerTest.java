package nl.remco.novi.backend.eindopdracht.into_art.controller.user;

import nl.remco.novi.backend.eindopdracht.into_art.controller.UserController;
import nl.remco.novi.backend.eindopdracht.into_art.exception.RecordExistsException;
import nl.remco.novi.backend.eindopdracht.into_art.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Mock
    UserServiceImpl service;

    @Test
    void test_createUser() throws RecordExistsException {
//        when(service.createUser())
    }
}