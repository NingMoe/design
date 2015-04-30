package cn.edu.aufe.guixiaorun.bean;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by guixiaorun on 15-4-5.
 */
public class PageTag extends TagSupport{
    private static final long serialVersionUID = 3441235160861303080L;
    // 字符串缓冲区
    private StringBuilder buff;
    // 首页
    private String homePage = "首页";
    // 末页
    private String lastPage = "末页";
    // 页面总数
    private String totalData = "总数";
    // 上一页
    private String previousPage = "上一页";
    // 当前页之前的页数，默认为4。
    private int beforeNum = 4;
    // 当前页之后的页数，默认为5。
    private int afterNum = 5;
    // 分页对象
    private Page page;
    // 链接地址
    private String url;
    // 下一页
    private String nextPage = "下一页";
    // 当前页码
    private String pageIndex;
    // 页面大小
    private String pageSize;
    // 外层div样式
    private String divClass = "pagination";
    // 是否进行动态补足，默认为true。
    private boolean supplement = true;
    // Html标签
    private static final String LABEL_START = " ";
    private static final String LABEL_END = " ";
    private static final String SPAN_START = "";
    private static final String SPAN_END = "";

    // 日志记录器
    private static Log log = LogFactory.getLog(PageTag.class);


    /**
     * 标签处理开始，构造一个存放分页信息的字符串缓冲区。
     *
     * @return SKIP_BODY，忽略标签之间的内容。
     * @throws javax.servlet.jsp.JspException Jsp异常。
     */
    @Override
    public int doStartTag() throws JspException {
        buff = new StringBuilder();
        return SKIP_BODY;
    }


    /**
     * 标签实际分页处理逻辑。
     *
     * @return EVAL_PAGE，按正常的流程继续执行Jsp页面。
     * @throws javax.servlet.jsp.JspException Jsp异常。
     */
    @Override
    public int doEndTag() throws JspException {
        if (page == null) {
            log.info("page is null.");
            return EVAL_PAGE;
        }

        if (page.getTotalCount() >= 0) {
            // 写入开始DIV
            writeBeginDiv();

            // 写入分页信息
            writePageInfo();

            // 写入结束DIV
            writeEndDiv();

            // 记录日志
            // writeDebugLog();

            // 输出到页面
            printToPage();
        }


        return EVAL_PAGE;
    }


    /**
     * 写入实际的分页信息。 调用者可自行设定是否显示首页、末页、上一页、下一页 以及当前页面之前和之后的页数、是否进行动态补足等。
     */
    private void writePageInfo() {
        long beforeCount = countBefore();
        long afterCount = countAfter();

        // 如果定义了动态补足，则对当前页之前和之后的页数进行动态补足。
        if (supplement) {
            beforeCount = fixBeforeCount(beforeCount, afterCount);
            afterCount = fixAfterCount(beforeCount, afterCount);
        }

        if (page.getTotalCount() > 0) {
            long index = page.getCurrentPage();
            // 首页
            writeHomePage(index);

            // 上一页
            writePreviousPage(index);

            // 当前页之前的页码
            writeBeforePageIndex(index, beforeCount);

            // 当前页
            writeCurrentPageIndex(index);

            // 当前页之后的页码
            writeAfterPageIndex(index, afterCount);

            // 下一页
            writeNextPage(index);

            // 末页
            writeLastPage(index);
        }
        // 总数
        // writeTotalData(totalData);
    }


    /**
     * 计算当前页之前的页数。
     *
     * @return 当前页之前的页数。
     */
    private long countBefore() {
        long beforeCount = 0;
        if (page.getCurrentPage() - 1 > beforeNum) {
            beforeCount = beforeNum;
        } else {
            beforeCount = page.getCurrentPage() - 1;
        }

        return beforeCount;
    }


    /**
     * 计算当前页之后的页数。
     *
     * @return 当前页之后的页数。
     */
    private long countAfter() {
        long afterCount = 0;
        if (page.getTotalPages() - page.getCurrentPage() > afterNum) {
            afterCount = afterNum;
        } else {
            afterCount = page.getTotalPages() - page.getCurrentPage();
        }

        return afterCount;
    }


    /**
     * 动态补足当前页之前的页数。
     *
     * @param beforeCount 当前页之前的页数。
     * @param afterCount  当前页之后的页数。
     * @return 修正后的当前页之前的页数。
     */
    private long fixBeforeCount(long beforeCount, long afterCount) {
        long totalNum = beforeNum + afterNum + 1;
        long useNum = beforeCount + afterCount + 1;

        if (useNum < totalNum) {
            long befores = page.getCurrentPage() - 1;
            long margin = befores - beforeCount;
            if (margin > 0) {
                long needNum = totalNum - useNum;
                beforeCount += margin > needNum ? needNum : margin;
            }
        }

        return beforeCount;
    }


    /**
     * 动态补足当前页之后的页数。
     *
     * @param beforeCount 当前页之前的页数。
     * @param afterCount  当前页之后的页数。
     * @return 修正后的当前页之后的页数。
     */
    private long fixAfterCount(long beforeCount, long afterCount) {
        long totalNum = beforeNum + afterNum + 1;
        long useNum = beforeCount + afterCount + 1;

        if (useNum < totalNum) {
            long afters = page.getTotalPages() - page.getCurrentPage();
            long margin = afters - afterCount;
            if (margin > 0) {
                long needNum = totalNum - useNum;
                afterCount += margin > needNum ? needNum : margin;
            }
        }

        return afterCount;
    }


    /**
     * 写入首页信息，如果设定了显示首页。
     *
     * @param index 当前页码。
     */
    private void writeHomePage(long index) {
        if (homePage == null || homePage.isEmpty()) {
            return;
        }
        buff.append(LABEL_START);
        int homeIndex = 1;
        if (index > homeIndex) {
            writeUrlPageIndex(homeIndex, page.getPerPageCount(), homePage);
        } else {
            String clazz = index <= 1 ? " disabled" : "";
            buff.append("<li class=\"paginate_button previous").append(clazz).append("\"><a href=\"").append("#").append("\" data-page=\"").append(1).append("\">").append(homePage).append("</a></li>");
        }
        buff.append(LABEL_END);
    }


    /**
     * 写入末页信息，如果设定了显示末页。
     *
     * @param index 当前页码。
     */
    private void writeLastPage(long index) {
        if (lastPage == null || lastPage.isEmpty()) {
            return;
        }

        buff.append(LABEL_START);
        int lastIndex = page.getTotalPages();
        if (index < lastIndex) {
            writeUrlPageIndex(lastIndex, page.getPerPageCount(), lastPage);
        } else {
            String clazz = index >= lastIndex ? " disabled" : "";
            buff.append("<li class=\"paginate_button next").append(clazz).append("\"><a href=\"").append("#").append("\" data-page=\"").append(lastIndex).append("\">").append(lastPage).append("</a></li>");
        }
        buff.append(LABEL_END);
    }


    /**
     * 写入记录总数，如果设定了显示总数
     */
    private void writeTotalData(String totalData) {
        if (totalData != null) {
            long startNumber = (page.getCurrentPage() - 1) * page.getPerPageCount() + 1;
            long endNumber = page.getCurrentPage() * page.getPerPageCount();
            int totalNumber = page.getTotalCount().intValue();
            buff.append(LABEL_START);

            // buff.append("<div class=\"dataTables_info\">");
            // if (startNumber < endNumber) {
            // buff.append("第" + startNumber + "-" + endNumber + "条，共" +
            // page.getTotalCount() + "条");
            // } else if (startNumber == endNumber && totalNumber > 0) {
            // buff.append("第" + startNumber + "条，共" + totalNumber + "条");
            // } else {
            // buff.append("查询为空");
            // }
            //
            // // add at 2014-01-22
            // String s =
            // "<span style='margin-left:400px;'>当前为第 <span style='font-size:18px;color:red;'>"+page.getCurrentPage()+"</span> 页,共有<span style='font-size:18px;color:red;'>"+page.getTotalCount()+"</span>条数据</span>";
            // buff.append(s);
            // // add end
            //
            // buff.append("</div>");

            buff.append(LABEL_END);
        }
    }


    /**
     * 写入上一页信息，如果设定了显示上一页。
     *
     * @param index 当前页码。
     */
    private void writePreviousPage(long index) {
        if (previousPage == null || previousPage.isEmpty()) {
            return;
        }

        buff.append(LABEL_START);
        if (index > 1) {
            writeUrlPageIndex(index - 1, page.getPerPageCount(), previousPage);
        } else {
            String clazz = index <= 1 ? " disabled" : "";
            buff.append("<li class=\"paginate_button").append(clazz).append("\"><a href=\"#").append("\" data-page=\"").append(index - 1).append("\">").append(previousPage).append("</a></li>");
        }
        buff.append(LABEL_END);
    }


    /**
     * 写入下一页信息，如果设定了显示下一页。
     *
     * @param index 当前页码。
     */
    private void writeNextPage(long index) {
        if (nextPage == null || nextPage.isEmpty()) {
            return;
        }

        buff.append(LABEL_START);
        if (index < page.getTotalPages()) {
            writeUrlPageIndex(index + 1, page.getCurrentPage(), nextPage);
        } else {
            String clazz = index >= page.getTotalPages() ? " disabled" : "";
            buff.append("<li class=\"paginate_button").append(clazz).append("\"><a href=\"").append("#").append("\" data-page=\"").append(index + 1).append("\">").append(nextPage).append("</a></li>");
        }
        buff.append(LABEL_END);
    }


    /**
     * 写入当前页之前的页码。
     *
     * @param index       当前页码。
     * @param beforeCount 前页之前的页数。
     */
    private void writeBeforePageIndex(long index, long beforeCount) {
        long beginIndex = index - beforeCount < 0 ? 1 : index - beforeCount;
        for (long i = beginIndex; i < index; i++) {
            buff.append(LABEL_START);
            writeUrlPageIndex(i, page.getPerPageCount(), String.valueOf(i));
            buff.append(LABEL_END);
        }
    }


    /**
     * 写入当前页之后的页码。
     *
     * @param index      当前页码。
     * @param afterCount 前页之后的页数。
     */
    private void writeAfterPageIndex(long index, long afterCount) {
        long endIndex = index + afterCount > page.getTotalPages() ? page.getTotalPages() : index + afterCount;
        for (long i = index + 1; i <= endIndex; i++) {
            buff.append(LABEL_START);
            writeUrlPageIndex(i, page.getPerPageCount(), String.valueOf(i));
            buff.append(LABEL_END);
        }
    }


    /**
     * 写入当前页的页码。
     *
     * @param index 当前页码。
     */
    private void writeCurrentPageIndex(long index) {
        buff.append(SPAN_START);
        buff.append("<a><li id=\"paginate_button\" class=\"paginate_button active\">").append(index).append("</a></li>");
        buff.append(SPAN_END);
    }


    /**
     * 写入开始div，如果指定样式divClass，那么样式也将被写入。
     */
    private void writeBeginDiv() {

        long startNum = (page.getCurrentPage() - 1) * page.getPerPageCount() + 1;
        long en = startNum + page.getPerPageCount() - 1;
        en = en > page.getTotalCount() ? page.getTotalCount() : en;
        String desc = StringUtils.isEmpty(page.getDesc()) ? "" : page.getDesc();
        buff.append("<div class=\"dt-toolbar-footer\">")
                .append("<div class=\"col-sm-6 col-xs-12 hidden-xs\">")
                .append("<div class=\"dataTables_info\" id=\"dt_basic_info\" role=\"status\" aria-live=\"polite\">")
                .append("当前显示第 <span class=\"txt-color-darken\">").append(startNum).append("</span> - <span class=\"txt-color-darken\">").append(en).append("</span> 条，共 <span id=\"totalCount\" class=\"text-primary\">")
                .append(page.getTotalCount()).append("</span> 条 ").append(desc).append("</div></div>")
                .append("<div class=\"col-xs-12 col-sm-6\"><div class=\"dataTables_paginate paging_simple_numbers\" id=\"dt_basic_paginate\"><ul class=\"pagination pagination-sm\">");
    }


    /**
     * 写入结束div。
     */
    private void writeEndDiv() {
        String endHtml = "</ul></div></div></div>";
        buff.append(endHtml);
    }


    /**
     * 将分页信息输入到页面上。
     */
    private void printToPage() {
        try {
            pageContext.getOut().write(buff.toString());
        } catch (IOException ex) {
            log.error(ex.getMessage(), ex);
        }
    }
    
    /**
     * 写入添加链接地址url后的指定内容，并在链接地址url后添加pageIndex参数，
     * 如果指定了pageSize参数，也会将此参数添加到链接地址url中。
     *
     * @param index 当前页码。
     * @param size  页面大小。
     * @param body  写入内容。
     */
    private void writeUrlPageIndex(long index, long size, String body) {
        buff.append("<li ").append(" name=\"_page" ).append("\"><a href=\"").append(url).append("\" data-page=\"").append(index).append("\">").append(body).append("</a></li>");
    }


    /**
     * 设置首页的显示内容。
     *
     * @param homePage 首页。
     */
    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }


    /**
     * 设置末页的显示内容。
     *
     * @param lastPage 末页。
     */
    public void setLastPage(String lastPage) {
        this.lastPage = lastPage;
    }


    /**
     * 设置上一页的显示内容。
     *
     * @param previousPage 上一页。
     */
    public void setPreviousPage(String previousPage) {
        this.previousPage = previousPage;
    }


    /**
     * 设置下一页的显示内容。
     *
     * @param nextPage 下一页。
     */
    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }


    /**
     * 设置当前页之前显示的页数。
     *
     * @param beforeNum 当前页之前显示的页数。
     */
    public void setBeforeNum(int beforeNum) {
        this.beforeNum = beforeNum;
    }


    /**
     * 设置当前页之后显示的页数。
     *
     * @param afterNum 当前页之后显示的页数。
     */
    public void setAfterNum(int afterNum) {
        this.afterNum = afterNum;
    }


    /**
     * 设置分页信息。
     *
     * @param page 分页信息。
     */
    public void setPage(Page page) {
        // Page page1 = new Page(10,100);
        this.page = page;
    }


    /**
     * 设置点击页码转向的url链接地址。
     *
     * @param url 链接地址。
     */
    public void setUrl(String url) {
        this.url = url;
    }


    /**
     * 设置当前页码参数名称。
     *
     * @param pageIndex 当前页码参数名称。
     */
    public void setPageIndex(String pageIndex) {
        this.pageIndex = pageIndex;
    }


    /**
     * 设置页面大小参数名称。
     *
     * @param pageSize 页面大小参数名称。
     */
    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }


    /**
     * 设置外层div样式。
     *
     * @param divClass 样式名称。
     */
    public void setDivClass(String divClass) {
        this.divClass = divClass;
    }


    /**
     * 设置是否对当前页面之前和之后的页数进行动态补足。
     *
     * @param supplement 是否进行动态补足。 <tt>true</tt>进行动态补足，<tt>false</tt>不进行动态补足。
     */
    public void setSupplement(boolean supplement) {
        this.supplement = supplement;
    }


    /**
     * 设置页面总数
     *
     * @param totalData 页面总数
     */
    public void setTotalData(String totalData) {
        this.totalData = totalData;
    }

}
