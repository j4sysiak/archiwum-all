package com.company;

import com.company.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
/*Moduł niskopoziomowy*/
public class SmslNotification implements INotificationSender {

    public void sendNotification(User user) {
        System.out.println("Sending SMS notification to user: " + user.name);
    }
}
