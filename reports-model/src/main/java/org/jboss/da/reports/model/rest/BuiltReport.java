package org.jboss.da.reports.model.rest;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NoArgsConstructor
public class BuiltReport {

    @Getter
    @Setter
    @NonNull
    private String groupId;

    @Getter
    @Setter
    @NonNull
    private String artifactId;

    @Getter
    @Setter
    @NonNull
    private String version;

    @Getter
    @Setter
    private String builtVersion;

    @Getter
    @Setter
    @NonNull
    private Set<String> availableVersions = new HashSet<>();

}
