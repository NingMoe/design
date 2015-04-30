package cn.edu.aufe.guixiaorun.service;

/**
 * Created by guixiaorun on 15-4-29.
 */
public interface AccountService {
    boolean checkUser(int account, String password);

    String getUserName(int account);

    void addAccount(int id, String name, String password);

    void removeAccount(int id);

    void updateTeacher(Integer id, String name, String password);

    void updateStudent(Integer id, String name, String password);
}
