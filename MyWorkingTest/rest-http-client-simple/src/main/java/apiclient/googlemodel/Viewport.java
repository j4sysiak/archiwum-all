package apiclient.googlemodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.ToString;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
@ToString
public class Viewport {

    @SerializedName("northeast")
    @Expose
    private Northeast northeast;
    @SerializedName("southwest")
    @Expose
    private Southwest southwest;

    public Northeast getNortheast() {
        return northeast;
    }

    public void setNortheast(Northeast northeast) {
        this.northeast = northeast;
    }

    public Southwest getSouthwest() {
        return southwest;
    }

    public void setSouthwest(Southwest southwest) {
        this.southwest = southwest;
    }

}