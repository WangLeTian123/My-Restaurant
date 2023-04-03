package com.myrestaurant.core.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.myrestaurant.core.entity.Classification;

import java.util.List;

public interface ClassificationService {
    boolean addClassification(Classification classification);

    boolean deleteClassificationById(int id);

    List<Classification> getAllClassification();

    IPage<Classification> page(int current, int size);
}
