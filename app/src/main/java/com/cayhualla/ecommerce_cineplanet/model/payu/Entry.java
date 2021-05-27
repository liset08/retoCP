package com.cayhualla.ecommerce_cineplanet.model.payu;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "entry")

public class Entry {

    @Attribute(name = "string", required = false)
    @ElementList(entry = "string", inline = true, required = false)
    private List<String> links;

    public List<String> getLinks() {
        return links;
    }
    public void setLinks(List<String> links) {
        this.links = links;
    }




}
