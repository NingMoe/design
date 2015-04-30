<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside id="left-panel">
    <!-- 用户信息 -->
    <div class="login-info">
        <span>
            <a id="show-shortcut" data-action="toggleShortcut">
                <img src="${ctx}/img/avatars/male.png" alt="me" class="online"/>
                    <span>
                        ${user}
                    </span>
            </a>
        </span>
    </div>
    <%-- 主菜单 --%>
    <nav>
        <ul>
            <li><a href="/design/index" title="Dashboard"><i class="fa fa-fw fa-lg fa-home"></i>
                <span class="menu-item-parent">首页</span>
            </a>
            </li>
            <li><a href="#"><i class="fa fa-fw fa-lg fa-list-alt"></i>
                <span class="menu-item-parent">综合模块</span>
                <b class="collapse-sign"><em class="fa fa-expand-o"></em></b>
            </a>
                <ul>
                    <li><a href="#" onclick="normalTable();"><i class="fa fa-fw "></i><span>查看论文</span></a></li>
                </ul>
            </li>
            <li><a href="#"><i class="fa fa-fw fa-lg fa-user"></i>
                <span class="menu-item-parent">教师模块</span>
                <b class="collapse-sign"><em class="fa fa-expand-o"></em></b>
            </a>
                <ul>
                    <li><a href="#" onclick="showTeacher();"><i class="fa fa-fw "></i><span>个人信息</span></a></li>
                    <li><a href="#" onclick="postPaper();"><i class="fa fa-fw "></i><span>我的论文</span></a></li>
                </ul>
            </li>
            <li>
                <a href="#"><i class="fa fa-fw fa-lg fa-graduation-cap"></i>
                    <span class="menu-item-parent">学生模块</span>
                    <b class="collapse-sign"><em class="fa fa-expand-o"></em></b>
                </a>
                <ul>
                    <li><a href="#" onclick="showStudent();"><i class="fa fa-fw "></i> <span>个人信息</span></a></li>
                    <li><a href="#" onclick="selectPaper();"><i class="fa fa-fw "></i> <span>选择论文</span></a></li>
                    <li><a href="http://mail.qq.com/cgi-bin/frame_html"><i class="fa fa-fw "></i>
                        <span>发送论文</span></a></li>
                </ul>
            </li>
            <li>
                <a href="#"><i class="fa fa-fw fa-lg fa-wrench"></i>
                    <span class="menu-item-parent">系统管理</span>
                    <b class="collapse-sign"><em class="fa fa-expand-o"></em></b>
                </a>
                <ul>
                    <li><a href="#" onclick="updateNotify()"><i class="fa fa-fw "></i> <span>修改通知</span></a></li>
                    <li><a href="#"><i class="fa fa-fw "></i> <span>权限管理</span></a>
                        <ul style="display: none;">
                            <li><a href="#" onclick="teacherManage();"><i class="fa fa-fw "></i>
                                <span>教师管理</span></a>
                            </li>
                            <li><a href="#" onclick="studentManage();"><i class="fa fa-fw "></i>
                                <span>学生管理</span></a></li>
                        </ul>
                    </li>
                </ul>
            </li>
        </ul>
    </nav>
    <span class="minifyme" data-action="minifyMenu"> <i class="fa fa-arrow-circle-left hit"></i> </span>

</aside>
<!-- END NAVIGATION -->
