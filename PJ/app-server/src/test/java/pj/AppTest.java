/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package pj;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test void appHasAGreeting() {
        ServerApp classUnderTest = new ServerApp();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
}
