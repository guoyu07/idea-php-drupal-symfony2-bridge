package de.espend.idea.php.drupal.tests.utils;

import com.intellij.util.containers.ContainerUtil;
import de.espend.idea.php.drupal.tests.DrupalLightCodeInsightFixtureTestCase;
import de.espend.idea.php.drupal.utils.IndexUtil;

import java.io.File;

/**
 * @author Daniel Espendiller <daniel@espendiller.net>
 */
public class IndexUtilTest extends DrupalLightCodeInsightFixtureTestCase {

    public void setUp() throws Exception {
        super.setUp();
        myFixture.copyFileToProject("classes.php");
    }

    public String getTestDataPath() {
        return new File(this.getClass().getResource("fixtures").getFile()).getAbsolutePath();
    }

    public void testIdIsResolved() {
        assertNotNull(ContainerUtil.find(IndexUtil.getFormClassForId(getProject(), "contact_form"), phpClass ->
            "\\Drupal\\Foo\\Entity\\ContactForm".equals(phpClass.getFQN())
        ));
    }
}
