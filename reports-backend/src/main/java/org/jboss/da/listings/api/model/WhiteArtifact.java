package org.jboss.da.listings.api.model;

import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author Jozef Mrazek <jmrazek@redhat.com>
 *
 */
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@ToString(callSuper = true)
@Entity
public class WhiteArtifact extends Artifact {

    @Setter
    @Getter
    private boolean is3rdParty;

    @Setter
    @Getter
    @NonNull
    private String osgiVersion;

    public WhiteArtifact(GA ga, String version, String osgiVersion, boolean is3rdParty) {
        super(ga, version);
        this.is3rdParty = is3rdParty;
        this.osgiVersion = osgiVersion;
    }

}
