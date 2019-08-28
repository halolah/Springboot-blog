package com.halo.blog.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by halo on 2019/8/5.
 */

@Data
public class PaginationDTO<T> {
    private List<T> data;
    private boolean showPrevious;
    private boolean showFistPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private Integer totalPage;
    private List<Integer> pages = new ArrayList<>();

    public void setPagination(Integer totalCount, Integer page, Integer size) {
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }
        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }
        this.page = page;

        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }

        // 是否展示上一页
        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }
        // 是否展示最后一页
        if (page.equals(totalPage)) {
            showNext = false;
        } else {
            showNext = true;
        }
        // 是否展示第一页
        if (!pages.contains(1)) {
            showFistPage = false;
        } else {
            showFistPage = true;
        }
        // 是否展示最后一页
        if (!pages.contains(totalPage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }

    }
}

