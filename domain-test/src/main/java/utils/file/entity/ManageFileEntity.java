package utils.file.entity;

import lombok.Builder;

public class ManageFileEntity {
    private String fileName;
    private String fileType;
    private String fileData;
    private String fileSize;


    @Builder
    public ManageFileEntity(String fileName, String fileType, String fileData, String fileSize) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileData = fileData;
        this.fileSize = fileSize;
    }
}
