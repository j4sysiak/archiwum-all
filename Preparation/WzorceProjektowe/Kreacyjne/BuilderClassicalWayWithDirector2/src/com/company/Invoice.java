package com.company;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;


@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    @Builder.Default
    public String number="";

    @Builder.Default
    public LocalDateTime date = LocalDateTime.now();

    @Builder.Default
    public String vendor="";

    @Builder.Default
    public String vendee="";

    @Builder.Default
    public Collection<String> lineItems = List.of("");  //lista pozycji na fakturze

    @Builder.Default
    public String note="";;
}
