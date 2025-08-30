package apiclient.catfactmodel;

import javax.annotation.processing.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Status {

    @SerializedName("verified")
    @Expose
    private Object verified;
    @SerializedName("sentCount")
    @Expose
    private Integer sentCount;

    public Object getVerified() {
        return verified;
    }

    public void setVerified(Object verified) {
        this.verified = verified;
    }

    public Integer getSentCount() {
        return sentCount;
    }

    public void setSentCount(Integer sentCount) {
        this.sentCount = sentCount;
    }

}
