/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 9/5/2020 10:18 PM
 */
package com.slmora.learn.service.jspservlet;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This Class created for authenticate login user
 *
 * @Author: SLMORA
 * @DateTime: 9/5/2020 10:18 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          9/5/2020      SLMORA                Initial Code
 */
public class LoginService
{
    final static Logger LOGGER = LogManager.getLogger(LoginService.class);

    /**
     * Read Given property form given property file in resource
     *
     * @param propertyFile as String Object with location of filter file
     * @return String Object will return with file content
     * @throws IOException with file notfound aor compatibility issue
     * @apiNote Read file and all characters content in to one String Object
     * @Note Files.lines() method doesn't include line-termination character. If we want to read all text from a file
     * in to a String we can use this
     */
    public String getPropertyValueFromThisPropertyFile(String propertyFile, String propertyRef)
    {
        Properties properties = new Properties();
        String property = null;
        try (InputStream iStream = getClass().getClassLoader().getResourceAsStream(propertyFile)){
            properties.load(iStream);
            property = properties.getProperty(propertyRef);
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            e.printStackTrace();
        } finally {
            return property;
        }
    }

    public boolean authenticateUser(String userId, String password) throws Exception{
        String propUser = getPropertyValueFromThisPropertyFile("login.properties","MORA.user");
        String propPassword = getPropertyValueFromThisPropertyFile("login.properties","MORA.password");
        return (propUser.equals(userId)&&propPassword.equals(password)) ? true : false;
    }


}
