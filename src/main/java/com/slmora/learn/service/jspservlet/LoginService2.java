/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 9/5/2020 10:18 PM
 */
package com.slmora.learn.service.jspservlet;

import com.slmora.learn.model.User;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

/**
 * This Class created for authenticate login user 2
 *
 * @Author: SLMORA
 * @DateTime: 9/6/2020 5:00 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          9/6/2020      SLMORA                Initial Code
 */
public class LoginService2
{
    final static Logger LOGGER = LogManager.getLogger(LoginService2.class);
    final static String TEST_FILE_LOCATION = "D:\\SLMORAWorkSpace\\IntelliJProjects\\MoraServletJSPLearn019\\data.json";

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

    public Optional<User> authenticateUser(String userId, String password) throws Exception{
        Optional<User> loginUser = getUserFromJson(userId);
        if(loginUser.isPresent()){
           if(loginUser.get().getPassword().equals(password)){
               return loginUser;
           }else {
               return Optional.empty();
           }
        }else {
            return Optional.empty();
        }
    }

    /**
     * Read Given property form given json file in given location
     *
     * @param userName as String Object with location of filter file
     * @return String Object will return with file content
     * @throws IOException with file notfound aor compatibility issue
     * @apiNote Read file and all characters content in to one String Object
     * @Note Files.lines() method doesn't include line-termination character. If we want to read all text from a file
     * in to a String we can use this
     */
    public Optional<User> getUserFromJson(String userName)
    {

        JSONParser jsonParser = new JSONParser();
        User loginUser = null;

        try (FileReader reader = new FileReader(TEST_FILE_LOCATION)){
            Object obj = jsonParser.parse(reader);
            JSONArray userList = (JSONArray) obj;
            LOGGER.info(userList);
            System.out.println(userList);

            for(Object user: userList){
                JSONObject userObject = (JSONObject) user;
                JSONObject selectedUser = (JSONObject) userObject.get("user");
                String jsonUserName = (String)selectedUser.get("userName");
                if(jsonUserName.equals(userName)){
                    loginUser = new User();
                    loginUser.setFirstName((String)selectedUser.get("firstName"));
                    loginUser.setLastName((String)selectedUser.get("lastName"));
                    loginUser.setUserName((String)selectedUser.get("userName"));
                    loginUser.setPassword((String)selectedUser.get("password"));
                }
            }
        } catch (FileNotFoundException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            e.printStackTrace();
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            e.printStackTrace();
        } catch (ParseException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            e.printStackTrace();
        }finally {
            return Optional.ofNullable(loginUser);
        }
    }

}
