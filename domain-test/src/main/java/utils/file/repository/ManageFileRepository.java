package utils.file.repository;

import utils.file.entity.ManageFileEntity;
import utils.file.payload.CreateManageFileDto;

import java.util.ArrayList;
import java.util.List;

public class ManageFileRepository {
    private List<ManageFileEntity> fileList = new ArrayList<>();


    public void save(ManageFileEntity manageFile){
        this.fileList.add(manageFile);
    }
}
