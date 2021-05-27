package com.cayhualla.ecommerce_cineplanet.model.payu;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "extraParameters")

public class ExtraParameters {

    @Attribute(name = "entry", required = false)
    @ElementList(entry = "entry", inline = true, required = false)
    private List<Entry> links;

    public List<Entry> getLinks() {
        return links;
    }

    public void setLinks(List<Entry> links) {
        this.links = links;
    }
}
