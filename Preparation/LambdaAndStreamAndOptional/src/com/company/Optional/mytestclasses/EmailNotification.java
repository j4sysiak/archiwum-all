package com.company.Optional.mytestclasses;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
public class EmailNotification {

    public void sendNotification(User user) {
        System.out.println("Sending notification to user: " + user.name);
    }
}
