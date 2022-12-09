package ru.itis.karakurik.test.test3;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import ru.itis.karakurik.model.PostModel;
import ru.itis.karakurik.model.jaxb.Posts;
import ru.itis.karakurik.test.TeletypeTestBase;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

import static ru.itis.karakurik.generators.PostsGenerator.*;

@RunWith(Theories.class)
public class AddPostTest extends TeletypeTestBase {

    @DataPoints
    public static List<PostModel> postsFromXmlFile() {
        try {
            JAXBContext context = JAXBContext.newInstance(Posts.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Posts posts = (Posts) unmarshaller.unmarshal(new File(DIRECTORY + POSTS_FILENAME + FORMAT));
            return posts.getPosts();
        } catch (JAXBException exception) {
            throw new RuntimeException(exception);
        }

    }

    @Test
    @Theory
    public void addPost(PostModel post) throws Exception {
        applicationManager.getNavigationHelper().openNewPostPage();
        applicationManager.getPostHelper().createPost(post);
        applicationManager.getNavigationHelper().openBlogPage();

        PostModel createdPost = applicationManager.getPostHelper().getLastPost();
        Assert.assertEquals(post.getTitle(), createdPost.getTitle());
        Assert.assertEquals(post.getContent(), createdPost.getContent());
    }
}
