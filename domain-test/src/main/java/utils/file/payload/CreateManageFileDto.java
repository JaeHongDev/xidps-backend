package utils.file.payload;


import utils.file.entity.ManageFileEntity;

public class CreateManageFileDto {

    private String fileName;
    private String fileData;
    private String fileSize;
    private String fileType;


    public ManageFileEntity toEntity(){
        return ManageFileEntity.builder()
                .fileData(this.fileData)
                .fileName(this.fileName)
                .fileSize(this.fileSize)
                .fileType(this.fileType)
                .build();
    }
}
