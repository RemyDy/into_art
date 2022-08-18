package nl.remco.novi.backend.eindopdracht.into_art.consoleApp;

import nl.remco.novi.backend.eindopdracht.into_art.dto.CreateUserDto;
import nl.remco.novi.backend.eindopdracht.into_art.dto.UserDto;
import nl.remco.novi.backend.eindopdracht.into_art.exception.RecordNotFoundException;
import nl.remco.novi.backend.eindopdracht.into_art.service.UserService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class IntoArtConsoleApp {

// To Do: segregate the methods in the UserService, to many unused methods
    UserService userService = new UserService() {
        @Override
        public UserDto createUser(CreateUserDto dto) {
            return null;
        }

        @Override
        public List<UserDto> getAllUsers() {
            return null;
        }

        @Override
        public UserDto getUserById(Long id) {
            return null;
        }

        @Override
        public UserDto getUserByName(String username) {
            return null;
        }

        @Override
        public void deleteUserById(Long id) {

        }
    };

    public void runIntoArtConsoleApp() {

        showWelcome();
// To Do:     logIn();

        try (var sc = new Scanner(System.in)) {
            String userSelection;

            do {
                showActions();
                userSelection = processUserSelection(sc);

            } while (!userSelection.equals("9"));
        }
    }

    //region Logic for IntoArtConsoleApp

    private void showWelcome() {

        System.out.println("""
                 
                 ************************
                 |      Welcome to      |
                 | Into Art Application |
                 ************************
                """);
    }

    private void showActions() {

        System.out.println("""
                 *****************************
                 |  Select action            |
                 |  ------------             |
                 |  1: Upload new ArtPiece   |
                 |  2: Get subscribers count |
                 |  3: Send newsletter       |
                 |  -----------              |
                 |  9: Quite App             |
                 *****************************
                """);
    }

    private String processUserSelection(Scanner sc) {

        var userSelection = sc.next();

        switch (userSelection) {
            case "1" -> uploadArtPiece(sc);
            case "2" -> getSubscriberCount();
            case "3" -> sendNewsLetterToSubscribers();
            case "9" -> showClosingStatement();
            default -> showInvalidInputMessage(userSelection);
        }
        return userSelection;
    }

    private void uploadArtPiece(Scanner sc) {

        String childPathUpload = "upload\\art.txt";
        var pathUpload = Paths.get(PARENT_PATH_UPLOAD).resolve(childPathUpload);

        try {
            // check if path really exists
            pathUpload.toRealPath();

            var json = Files.readAllLines(pathUpload);

            System.out.printf("text in file %n%s%n", json);

//            var artPieceDto = artPieceService.uploadArtPiece(CreateArtPieceDto, artPiece);

        } catch (NoSuchFileException ex) {
            System.err.format("""
                    The file -> %s <- in path %s does not exist.
                                        
                    Therefore you have been forwarded to the main menu.
                                        
                    Please select another action, or create a file in the right directory.
                                        
                    """, childPathUpload, pathUpload.getParent());

        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

        var confirm = sc.hasNextBoolean();
        System.out.printf("You have chosen %s", confirm);

        if (confirm) {
            // fill if statement
            System.out.println("ArtPiece has been successfully uploaded\n");
        }
    }

    private static void getSubscriberCount() {
//        UserService userService = new UserService().getAllUsers(); {};

        try {
//            var subscribers = userService.getAllUsers();
        System.out.println("test");
//            System.out.printf("You have %s subscribers for your newsletter %n%n", subscribers.size());

        } catch (RecordNotFoundException ex) {
            System.out.println("You have no subscribers");
        }
    }

    private void sendNewsLetterToSubscribers() {

        System.out.println("Send newsletter\n");
    }

    private void showClosingStatement() {

        System.out.println("Thanks for using the application!");
    }

    private void showInvalidInputMessage(String userSelection) {

        System.out.printf("""
                -> %s <-
                Is an invalid selection
                Please select another action.
                                            
                """, userSelection);
    }

    //endregion

    //region constant

    public static final String PARENT_PATH_UPLOAD = "C:\\Users\\Public\\Documents\\into_art";

    //endregion

    /* solution perhaps??
    public static void setUserService(UserServiceImpl userService) {
        IntoArtConsoleApp.userService = userService;
    }

    public static void setArtPieceService(ArtPieceService artPieceService) {
        IntoArtConsoleApp.artPieceService = artPieceService;
    }
    */
}
