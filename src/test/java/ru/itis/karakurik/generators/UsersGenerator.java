package ru.itis.karakurik.generators;

import ru.itis.karakurik.model.UserModel;
import ru.itis.karakurik.model.jaxb.Users;
import ru.itis.karakurik.utils.StringUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class UsersGenerator {
    public static final String DIRECTORY = "output/";
    private static final int COUNT = 1;
    public static final String INVALID_USERS_FILENAME = "invalid_users";
    public static final String VALID_USERS_FILENAME = "valid_users";
    public static final String FORMAT = ".xml";


    public static void main(String[] args) {
        List<UserModel> users = new LinkedList<>();
        for (int i = 0; i < COUNT; i++) {
            String randomEmail = StringUtils.generateRandomEmail(10, 15);
            users.add(new UserModel(
                    randomEmail,
                    StringUtils.generateRandomText(10, 20),
                    randomEmail.split("@")[0]
            ));
        }
        try (FileWriter fileWriter = new FileWriter(DIRECTORY + INVALID_USERS_FILENAME + FORMAT)) {
            writeUsersToXmlFile(users, fileWriter);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private static void writeUsersToXmlFile(List<UserModel> userDataList, FileWriter fileWriter) {
        try {
            ;
            Users users = new Users();
            users.setUsers(userDataList);
            JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(users, fileWriter);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
