package com.example.y_z;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {

    public List<String> materials = new ArrayList(){};

    public Dictionary() {
        materials.add("现状合流管");
        materials.add("现状雨水管");

        materials.add("Ⅱ级钢筋混凝土");
        materials.add("II级钢筋混凝土管");
        materials.add("缠绕结构壁管（B型）");
        materials.add("钢管压力管");
    }

    public List<String> getMaterials() {
        return materials;
    }
}
