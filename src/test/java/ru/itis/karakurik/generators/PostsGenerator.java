package ru.itis.karakurik.generators;

import ru.itis.karakurik.model.PostModel;
import ru.itis.karakurik.model.jaxb.Posts;
import ru.itis.karakurik.test.TeletypeTestBase;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class PostsGenerator {
    public static final String DIRECTORY = "output/";
    private static final int COUNT = 2;
    public static final String FILENAME = "generatedPosts";
    public static final String FORMAT = ".xml";


    public static void main(String[] args) {
        List<PostModel> posts = new LinkedList<>();
        for (int i = 0; i < COUNT; i++) {
            posts.add(new PostModel(
                    TeletypeTestBase.generateRandomText(5, 20),
                    TeletypeTestBase.generateRandomText(50, 100)
            ));
        }
        try (FileWriter fileWriter = new FileWriter(DIRECTORY + FILENAME + FORMAT)) {
            writePostsToXmlFile(posts, fileWriter);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    static void writePostsToXmlFile(List<PostModel> postDataList, FileWriter fileWriter) {
        try {
            Posts posts = new Posts();
            posts.setPosts(postDataList);
            JAXBContext jaxbContext = JAXBContext.newInstance(Posts.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(posts, fileWriter);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
