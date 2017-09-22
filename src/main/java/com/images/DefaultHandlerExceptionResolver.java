package com.images;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Franky Villadiego
 */

public class DefaultHandlerExceptionResolver implements HandlerExceptionResolver {


    private static final Logger log = LoggerFactory.getLogger(DefaultHandlerExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        log.info("Handling exception....");


        return null;
    }



}
