package com.company;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
class User {

    private String firstName;
    private String lastName;
    private Address address;

    // In the above implementation of the deep copy,
    // we haven't created new Strings (firstName, lastname) in our copy constructor because String is an immutable class.

    public User(User user) {
        this(user.getFirstName(), user.getLastName(), new Address(user.getAddress()));
    }

    @Override
    public Object clone() {
        User user = null;
        try {
            //Note that the super.clone() call returns a shallow copy of an object,
            // but we set deep copies of mutable fields manually, so the result is correct:
            user = (User) super.clone();
        } catch (CloneNotSupportedException e) {
            user = new User(
                    this.getFirstName(), this.getLastName(), this.getAddress());
        }
        user.address = (Address) this.address.clone();
        return user;
    }
}
