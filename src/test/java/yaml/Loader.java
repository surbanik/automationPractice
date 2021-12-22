package yaml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Loader {
    static private Logger logger = LoggerFactory.getLogger(Loader.class);
    public List<EnvDetails> createEnvList() throws IOException {
        YamlReader yamlReader = new YamlReader();
        EnvDetails test = yamlReader.getConfig().environments.getTest();
        EnvDetails dev = yamlReader.getConfig().environments.getDev();
        List<EnvDetails> envList = new ArrayList<>();
        envList.add(test);
        envList.add(dev);
        return envList;
    }


    public Loader() throws IOException {
        if (System.getProperty("Env_Val").isEmpty()) {
            logger.error("Env_Val is not empty");
            for (EnvDetails env : createEnvList()) {
                if (env.getActive().equals("y")) {
                    System.setProperty("webURL", env.getWebUrl());
                    System.setProperty("title", env.getTitle());
                    System.setProperty("browser", env.getBrowser());
                    System.setProperty("userEmail", env.getUserEmail());
                    System.setProperty("userPassword", env.getUserPassword());
                    System.setProperty("loginFailMessage", env.getLoginFailMessage());
                    break;
                }
            }
        }else if(!System.getProperty("Env_Val").isEmpty()){
            logger.error("Env_Val is empty");
            for (EnvDetails env : createEnvList()) {
                if (env.getEnvName().equals(System.getProperty("Env_Val"))) {
                    System.setProperty("webURL", env.getWebUrl());
                    System.setProperty("title", env.getTitle());
                    System.setProperty("browser", env.getBrowser());
                    System.setProperty("userEmail", env.getUserEmail());
                    System.setProperty("userPassword", env.getUserPassword());
                    System.setProperty("loginFailMessage", env.getLoginFailMessage());
                    break;
                }
            }

        }else{
            logger.error("niepoprawna nazwa środowiska");
        }
    }


}
