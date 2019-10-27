
package pl.akademiaspring.hwweek.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "link",
    "picture",
    "picture_small",
    "picture_medium",
    "picture_big",
    "picture_xl",
    "nb_album",
    "nb_fan",
    "radio",
    "tracklist",
    "type"
})
public class Datum {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("link")
    private String link;
    @JsonProperty("picture")
    private String picture;
    @JsonProperty("picture_small")
    private String pictureSmall;
    @JsonProperty("picture_medium")
    private String pictureMedium;
    @JsonProperty("picture_big")
    private String pictureBig;
    @JsonProperty("picture_xl")
    private String pictureXl;
    @JsonProperty("nb_album")
    private Integer nbAlbum;
    @JsonProperty("nb_fan")
    private Integer nbFan;
    @JsonProperty("radio")
    private Boolean radio;
    @JsonProperty("tracklist")
    private String tracklist;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    @JsonProperty("picture")
    public String getPicture() {
        return picture;
    }

    @JsonProperty("picture")
    public void setPicture(String picture) {
        this.picture = picture;
    }

    @JsonProperty("picture_small")
    public String getPictureSmall() {
        return pictureSmall;
    }

    @JsonProperty("picture_small")
    public void setPictureSmall(String pictureSmall) {
        this.pictureSmall = pictureSmall;
    }

    @JsonProperty("picture_medium")
    public String getPictureMedium() {
        return pictureMedium;
    }

    @JsonProperty("picture_medium")
    public void setPictureMedium(String pictureMedium) {
        this.pictureMedium = pictureMedium;
    }

    @JsonProperty("picture_big")
    public String getPictureBig() {
        return pictureBig;
    }

    @JsonProperty("picture_big")
    public void setPictureBig(String pictureBig) {
        this.pictureBig = pictureBig;
    }

    @JsonProperty("picture_xl")
    public String getPictureXl() {
        return pictureXl;
    }

    @JsonProperty("picture_xl")
    public void setPictureXl(String pictureXl) {
        this.pictureXl = pictureXl;
    }

    @JsonProperty("nb_album")
    public Integer getNbAlbum() {
        return nbAlbum;
    }

    @JsonProperty("nb_album")
    public void setNbAlbum(Integer nbAlbum) {
        this.nbAlbum = nbAlbum;
    }

    @JsonProperty("nb_fan")
    public Integer getNbFan() {
        return nbFan;
    }

    @JsonProperty("nb_fan")
    public void setNbFan(Integer nbFan) {
        this.nbFan = nbFan;
    }

    @JsonProperty("radio")
    public Boolean getRadio() {
        return radio;
    }

    @JsonProperty("radio")
    public void setRadio(Boolean radio) {
        this.radio = radio;
    }

    @JsonProperty("tracklist")
    public String getTracklist() {
        return tracklist;
    }

    @JsonProperty("tracklist")
    public void setTracklist(String tracklist) {
        this.tracklist = tracklist;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
