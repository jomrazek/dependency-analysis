package org.jboss.da.bc.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class BuildConfiguration {

    @Getter
    @Setter
    protected String scmUrl;

    @Getter
    @Setter
    protected String pomPath;

    @Getter
    @Setter
    protected String scmRevision;

    @Getter
    @Setter
    protected boolean cloneRepo;

    @Getter
    @Setter
    protected Integer projectId;

    @Getter
    @Setter
    protected String buildScript;

    @Getter
    @Setter
    protected String name;

    @Getter
    @Setter
    protected String description;

    @Getter
    @Setter
    protected String internallyBuilt;

    @Getter
    @Setter
    protected boolean bcExists;

    @Getter
    @Setter
    protected boolean useExistingBc;

    @Getter
    @Setter
    protected GAV gav;

    @Getter
    @Setter
    protected Integer enviromentId;

    @Getter
    @Setter
    protected List<BuildConfiguration> dependencies;

    @Getter
    @Setter
    protected boolean selected;

}
