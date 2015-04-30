package cn.edu.aufe.guixiaorun.bean;

/**
 * Created by guixiaorun on 15-4-5.
 */
public class Page {
    private int currentPage = 1;
    private int perPageCount = 10;
    private long totalCount = 0L;
    private int totalPages = 0;
    private String desc;

    public long getEndNum() {
        return endNum;
    }

    public void setEndNum(long endNum) {
        this.endNum = endNum;
    }

    private long endNum ;

    public long getStartNum() {
        return (currentPage - 1) * perPageCount;
    }

    public Integer getTotalPages() {
        return Integer.valueOf(this.totalPages);
    }

    public Long getTotalCount() {
        return Long.valueOf(this.totalCount);
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
        this.totalPages = (int)((totalCount - 1L) / this.perPageCount + 1L);
        if(this.currentPage > this.totalPages) {
            this.currentPage = this.totalPages;
        } else if(this.currentPage < 1L) {
            this.currentPage = 1;
        }

    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPerPageCount() {
        return this.perPageCount;
    }

    public void setPerPageCount(int perPageCount) {
        this.perPageCount = perPageCount;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("当前页:" + currentPage);
        sb.append(";每页数量:" + perPageCount);
        sb.append(";总数量:" + totalCount);
        sb.append(";总页数:" + getTotalPages());

        return sb.toString();
    }

}
