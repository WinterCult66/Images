package com.images;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

/**
 * @author Franky Villadiego
 */

@Controller
public class HomeController {


    private String imageDir;

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);


    //private ImageService imageService;

/*    @GetMapping("/")
    public String home(){
        return "home";
    }*/


    @GetMapping("/**")
    public void images(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try {
            String requestURI = req.getRequestURI().trim();
            log.debug("{}", requestURI);

            String fullPath = imageDir + File.separator + requestURI.trim();
            log.debug("Full Path : {}", fullPath);

            File file = new File(fullPath);
            if (file.exists() && file.isFile()) {
                log.debug("Exist...");
                ImageOptimizer.sendImage(req, resp, file);
            } else {
                //search in DB
                    System.out.println("ERROR");
                }

            

        } catch (Exception ex) {
            log.error("Error : {}", ex);
        }

    }


    @Value("${image.dir}")
    public void setImageDir(String imageDir) {
        this.imageDir = imageDir;
        Constants.DIRECTORY = imageDir;
    }
}
