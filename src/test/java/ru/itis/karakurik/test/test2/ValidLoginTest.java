package ru.itis.karakurik.test.test2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import ru.itis.karakurik.base.TeletypeLoginTestBase;
import ru.itis.karakurik.model.UserModel;
import ru.itis.karakurik.model.jaxb.Users;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

import static ru.itis.karakurik.generators.UsersGenerator.*;

@RunWith(Theories.class)
public class ValidLoginTest extends TeletypeLoginTestBase {

    @DataPoints
    public static List<UserModel> usersFromXmlFile() {
        try {
            JAXBContext context = JAXBContext.newInstance(Users.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Users users = (Users) unmarshaller.unmarshal(new File(DIRECTORY + VALID_USERS_FILENAME + FORMAT));
            return users.getUsers();
        } catch (JAXBException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Test
    @Theory
    public void loginTestCase(UserModel user) throws Exception {
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(user);
        applicationManager.getHelperBase().sleep(5);

        Assert.assertTrue(applicationManager.getLoginHelper().isAuthorized());
        Assert.assertEquals(user.getNickName(), applicationManager.getLoginHelper().getAuthorizedUserNickName());

//        applicationManager.getLoginHelper().logout();
    }
}
