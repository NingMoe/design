<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices) -->
<%--<script data-pace-options='{ "restartOnRequestAfter": true }' src="${ctx}/js/plugin/pace/pace.min.js"></script>--%>
<script>
  if (!window.jQuery) {
    document.write('<script src="${ctx}/js/libs/jquery-2.0.2.min.js"><\/script>');
  }
</script>
<script>
  if (!window.jQuery.ui) {
    document.write('<script src="${ctx}/js/libs/jquery-ui-1.10.3.min.js"><\/script>');
  }
</script>
<!-- IMPORTANT: APP CONFIG -->
<script src="${ctx}/js/app.config.js"></script>
<!-- JS TOUCH : include this plugin for mobile drag / drop touch events-->
<script src="${ctx}/js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script>
<!-- BOOTSTRAP JS -->
<script src="${ctx}/js/bootstrap/bootstrap.min.js"></script>
<!-- CUSTOM NOTIFICATION -->
<script src="${ctx}/js/notification/SmartNotification.min.js"></script>
<!-- JARVIS WIDGETS -->
<script src="${ctx}/js/smartwidgets/jarvis.widget.min.js"></script>
<!-- EASY PIE CHARTS -->
<script src="${ctx}/js/plugin/easy-pie-chart/jquery.easy-pie-chart.min.js"></script>
<!-- SPARKLINES -->
<script src="${ctx}/js/plugin/sparkline/jquery.sparkline.min.js"></script>
<!-- JQUERY VALIDATE -->
<script src="${ctx}/js/plugin/jquery-validate/jquery.validate.min.js"></script>
<!-- JQUERY MASKED INPUT -->
<script src="${ctx}/js/plugin/masked-input/jquery.maskedinput.min.js"></script>
<!-- JQUERY SELECT2 INPUT -->
<script src="${ctx}/js/plugin/select2/select2.min.js"></script>
<!-- JQUERY UI + Bootstrap Slider -->
<script src="${ctx}/js/plugin/bootstrap-slider/bootstrap-slider.min.js"></script>
<!-- browser msie issue fix -->
<script src="${ctx}/js/plugin/msie-fix/jquery.mb.browser.min.js"></script>
<!-- FastClick: For mobile devices: you can disable this in app.js -->
<script src="${ctx}/js/plugin/fastclick/fastclick.min.js"></script>
<!-- Demo purpose only -->
<script src="${ctx}/js/demo.min.js"></script>
<!-- MAIN APP JS FILE -->
<script src="${ctx}/js/app.min.js"></script>
<!-- ENHANCEMENT PLUGINS : NOT A REQUIREMENT -->