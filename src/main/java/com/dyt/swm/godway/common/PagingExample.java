package com.dyt.swm.godway.common;

import java.io.Serializable;

/**
 * 分页组件
 * 
 * @author max
 *
 */
// 使用说明：
// ***************************************************************************
// 1---------->对应generator生成的daoExample中加入当前（PagingExample）的属性：
// protected PagingExample pagingExample;
//
// public PagingExample getPagingExample() {
// return pagingExample;
// }
//
// public void setPagingExample(PagingExample pagingExample) {
// this.pagingExample = pagingExample;
// }
// ***************************************************************************
// 2---------->config.mapper.xml 中加入标签头：
// <sql id="pagingExample">
// <if test="pagingExample != null">
// limit ${pagingExample.offset}, ${pagingExample.limit}
// </if>
// </sql>
// ***************************************************************************
// 3---------->在<select>标签中加入<include refid="pagingExample" />
// ***************************************************************************
// 4---------->编码时在原先基础上添加下面两行就OK了
// PagingExample pagingExample = new PagingExample(pageNo, rowsPerPage);
// daoExample.setPagingExample(pagingExample);
// ***************************************************************************

public class PagingExample implements Serializable {
    /**
     * 
     */
    private static final long         serialVersionUID = 4463144150027492225L;

    public final static int           NO_ROW_OFFSET    = 0;
    public final static int           NO_ROW_LIMIT     = Integer.MAX_VALUE;
    public final static PagingExample DEFAULT          = new PagingExample();

    public final static int           NO_PAGENUMBER    = 0;

    // 偏移量
    private int                       offset;
    // 条数
    private int                       limit;
    // 页码
    private int                       pageNumber;

    public PagingExample() {
        this.offset = NO_ROW_OFFSET;
        this.limit = NO_ROW_LIMIT;
        this.pageNumber = NO_PAGENUMBER;
    }

    public PagingExample(int offset, int limit, int pageNumber) {
        this.offset = offset;
        this.limit = limit;
        this.pageNumber = pageNumber;
    }

    /**
     * 返回PagingExample实体信息
     * 
     * @param pageNumber
     *            页码
     * @param pageSize
     *            一页条数
     */
    public PagingExample(int pageNumber, int pageSize) {
        this.pageNumber = pageNumber;
        this.limit = pageSize;
        this.offset = (pageNumber - 1) * pageSize;
    }

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

}
