package top.BinGCU.Util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  The custom util is defined to simply the application
 *  context' s calling process.
 *
 * @author BinGCU
 * @version 1.0
 */
public class ApplicationContextShortcut {
    private static ApplicationContext applicationContext ;

    /**
     * Instantly obtain instance of class {@link ClassPathXmlApplicationContext}
     * <p>And it is the sluggard mode to load instance</p>
     * @return return one {@link ClassPathXmlApplicationContext}' s instance
     */
    public static ApplicationContext getInstance(){
        if (applicationContext==null)
            applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        return applicationContext;
    }
}
