package domain.entity;


public class ManagementFile {
    private String fileName;
    private String fileSize;
    private String fileType;
    private String filePath;

    public ManagementFile(String fileName, String fileSize, String fileType, String filePath) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileType = fileType;
        this.filePath = filePath;
    }

    public static ManagementFile saveFile(String fileName, String fileSize, String fileType, String fileData){
        return new ManagementFile(fileName, fileSize, fileType, savePath(fileData));
    }

    private static String savePath(String fileData){
        return "url";
    }
}
