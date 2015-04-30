package cn.edu.aufe.guixiaorun.entity;

import org.apache.ibatis.type.Alias;

/**
 * Created by guixiaorun on 15-4-29.
 */
@Alias("AufeNotifyEntity")
public class AufeNotifyEntity {
    private Integer id ;
    private String notify ;
    private String warning ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNotify() {
        return notify;
    }

    public void setNotify(String notify) {
        this.notify = notify;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }
}
