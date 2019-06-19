package com.adweb.adweb.entity.resEntity;

import com.adweb.adweb.entity.Knowledge;

/**
 * 将knowledge转换为api中所需要的knowledge
 * */
public class ResKnowledge {
    /**
     * 知识点id
     */
    private Integer id;

    /**
     * 知识点种类 0代表图片 1代表文本
     */
    private Integer type;

    /**
     * 图片的话是url 文本的话就是对应内容
     */
    private String content;

    /**
     * 知识点的顺序号
     */
    private Integer order_number;

    /**
     * 知识点对应的小节id
     */
    private Integer section_id;

    /**
     * 表示知识点重要程度 0 1 2 3 0最重要
     */
    private Integer importance_degree;

    public ResKnowledge(Knowledge knowledge) {
        this.id = knowledge.getId();
        this.type = knowledge.getType();
        this.content = knowledge.getContent();
        this.order_number = knowledge.getOrderNumber();
        this.section_id = knowledge.getSectionId();
        this.importance_degree = knowledge.getImportanceDegree();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getOrder_number() {
        return order_number;
    }

    public void setOrder_number(Integer order_number) {
        this.order_number = order_number;
    }

    public Integer getSection_id() {
        return section_id;
    }

    public void setSection_id(Integer section_id) {
        this.section_id = section_id;
    }

    public Integer getImportance_degree() {
        return importance_degree;
    }

    public void setImportance_degree(Integer importance_degree) {
        this.importance_degree = importance_degree;
    }
}
