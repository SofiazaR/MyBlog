package ru.itis.models;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FileInfo {
    private Long id;
    private String originalName;
    private UUID storageName;
    private Long size;
    private String type;
}
