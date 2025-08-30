package com.example.demo.gui;

import com.example.demo.service.ImageUploader;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route("uploadXXXXXXXX")
public class UploadGui_TODO_with_vaaden_upload_api extends VerticalLayout {

    //wstrzykujemy w konstruktorze instancję ImageUploader
    private ImageUploader imageUploader;

    @Autowired
    public UploadGui_TODO_with_vaaden_upload_api(ImageUploader imageUploader) {
        this.imageUploader = imageUploader;

        Label label = new Label();
//        TextField textField = new TextField();

        MemoryBuffer memoryBuffer = new MemoryBuffer();
        Upload singleFileUpload = new Upload(memoryBuffer);

        singleFileUpload.addSucceededListener(event -> {

            String uploadedImage = imageUploader.uploadFileAndSaveToDb(event.getFileName());
            Image image = new Image(uploadedImage, "nie ma obrazka");
            label.setText("Udało się wrzucić obrazek");
            add(label);
            add(image);

//           Component component = createComponent(event.getMIMEType(),
//                   event.getFileName(), memoryBuffer.getInputStream());
//           showOutput(event.getFileName(), component, output);
        });

//        Button button = new Button("upload");
//        button.addClickListener(clickEvent -> {
//            String uploadedImage = imageUploader.uploadFileAndSaveToDb(textField.getValue());
//            Image image = new Image(uploadedImage, "nie ma obrazka");
//            label.setText("Udało się wrzucić obrazek");
//            add(label);
//            add(image);
//        });

        add(singleFileUpload);
//        add(button);
    }
}















