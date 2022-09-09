package utils.file.repository;

import utils.file.entity.ManageFileEntity;
import utils.file.payload.CreateManageFileDto;

import java.util.ArrayList;
import java.util.List;

public class ManageFileRepository {
    private List<ManageFileEntity> fileList = new ArrayList<>();


    public void save(CreateManageFileDto createManageFileDto){
        this.fileList.add(createManageFileDto.toEntity());
    }
}
