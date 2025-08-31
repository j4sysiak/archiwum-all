package com.company.mac;

import com.company.ITextbox;

public class MacTextbox implements ITextbox {

    @Override
    public void renderTextbox() {
        System.out.println("Render Mac textbox");
    }

    @Override
    public void handleTextboxInput() {
        System.out.println("Handle Mac text input");
    }
}
