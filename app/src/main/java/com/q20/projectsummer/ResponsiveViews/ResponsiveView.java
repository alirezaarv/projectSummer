package com.q20.projectsummer.ResponsiveViews;

/**
 * Created by mohammadmahdi on 10/17/16.
 */
public interface ResponsiveView  {
    PixelDimensions getPixelDimensions();
    void calculateDimensions();
    void updateDimensions();
}
