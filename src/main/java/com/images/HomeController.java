package com.images;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;


/**
 * @author Kevin Rodriguez
 */
@Controller
public class HomeController {

    private String imageDir;

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);
    @GetMapping("/**")
    public void images(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try {
            String requestURI = req.getRequestURI().trim();
            log.debug("{}", requestURI);

            String fullPath = imageDir + File.separator + requestURI.trim();
            log.debug("Full Path : {}", fullPath);

            File file = new File(fullPath);
            if (file.exists() && file.isFile()) {
                log.info("Exist the Image > URL> ... " + file.toString());
                ImageOptimizer.sendImage(req, resp, file);
            } else {
                //search in DB
                log.info("it is not possible to access the image (the most certain thing is that it does not exist.!!!!!)");
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
