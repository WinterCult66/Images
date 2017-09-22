/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.images;

import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author krodriguez
 */
public class ImageServiceImpl {
    private String imageDir;
        @Value("${image.dir}")
    public void setImageDir(String imageDir) {
        this.imageDir = imageDir;
    }
    
    
}
