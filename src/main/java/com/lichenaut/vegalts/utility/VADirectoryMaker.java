package com.lichenaut.vegalts.utility;

import com.lichenaut.vegalts.VegAlts;

import java.io.File;

public class VADirectoryMaker {

    private final VegAlts plugin;

    public VADirectoryMaker(VegAlts plugin) {this.plugin = plugin;}

    public void makeDir(String path) {
        File dir = new File(path);
        if (!dir.exists()) {if (!dir.mkdirs()) {plugin.getLog().severe("Could not create file '" + path + "'! SecurityException?");}}
    }
}
