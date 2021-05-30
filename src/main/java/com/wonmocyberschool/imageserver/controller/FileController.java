package com.wonmocyberschool.imageserver.controller;

import com.wonmocyberschool.imageserver.DTO.ResponseDTO;
import com.wonmocyberschool.imageserver.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/wcs/image")
public class FileController {

    private final StorageService storageService;

    @Autowired
    public FileController(StorageService storageService){
        this.storageService = storageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<ResponseDTO> uploadImage(@RequestParam("file") MultipartFile file,
                                                   @RequestParam("userName") String userName) throws IOException {
        ResponseDTO res = new ResponseDTO();
        String result = storageService.saveFile(file, userName);
        res.setImageLocation(result);
        res.setMessage("done");
        return new ResponseEntity<ResponseDTO>(res, HttpStatus.OK);
    }
}
