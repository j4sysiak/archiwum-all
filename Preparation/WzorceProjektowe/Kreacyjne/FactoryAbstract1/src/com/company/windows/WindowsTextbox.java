package com.company.windows;

import com.company.ITextbox;

public class WindowsTextbox implements ITextbox {

    @Override
    public void renderTextbox() {
        System.out.println("Render Windows textbox");
    }

    @Override
    public void handleTextboxInput() {
        System.out.println("Handle Windows text input");
    }
}
