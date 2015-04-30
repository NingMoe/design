package cn.edu.aufe.guixiaorun.entity;

import org.apache.ibatis.type.Alias;

/**
 * Created by guixiaorun on 15-4-7.
 */
@Alias("AufeAccountEntity")
public class AufeAccountEntity {
    private Integer account ;
    private String name ;
    private String password ;

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
