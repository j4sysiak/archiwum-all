package apiclient.googlemodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.ToString;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
@ToString
public class OpeningHours {

    @SerializedName("open_now")
    @Expose
    private Boolean openNow;

    public Boolean getOpenNow() {
        return openNow;
    }

    public void setOpenNow(Boolean openNow) {
        this.openNow = openNow;
    }

}
