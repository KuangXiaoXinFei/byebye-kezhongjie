package com.byebye.kzj.webapi.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 1.0 刘风栓
 */
@Data
@Accessors(chain = true)
public class NewsListVo implements Serializable {

    public NewsListVo() {
        this.userHeader = "";
        this.imageList = new ArrayList<>();
    }

    private Integer newsId;

    private String title;

    private String description;

    private Integer newsType;

    private Integer userId;

    private String userName;

    private String userHeader;

//    private String imagesUrl;

    private List<String> imageList;

    private Integer showModel;

    private Integer commentCount;

    private Integer likeCount;

    //是否已评论
//    private Boolean isCommented;

    //是否已赞
    private Boolean isLiked;

//    public void setImagesUrl(String imagesUrl) {
//        this.imagesUrl = imagesUrl;
//        if(!StringUtils.isEmpty(imagesUrl)){
//            List<String> showImages = Arrays.asList(imagesUrl.split(";"));
//            this.setImageList(showImages);
//        }
//    }
}
