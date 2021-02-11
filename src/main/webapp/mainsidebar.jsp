<link rel="stylesheet" href="CSS/sidebar.css">
<div id="sidebar" class="sidebar"></div>
<script>
    var url = window.location.pathname;
    <sql:query var="rs" dataSource="${db}">select * from logfile where cusid=<%= session.getAttribute("cusid") %> and logid=(select max(logid) from logfile where cusid=<%= session.getAttribute("cusid") %>)</sql:query>
    <c:forEach var="row" items="${rs.rows}">
    var y = '${row.Date}';
    </c:forEach>
    if (url.match(/WebWorks_war_exploded\/dashboard.jsp/)){
        var sidebar = document.getElementById("sidebar");
        sidebar.innerHTML=`
                    <h2>Welcome</h2>
                    <h5 class="sidebar-heading">Platform</h5>
                    <c:if test="${plat==222}">
                    <a href="RewindNotes/rewindingdashboard.jsp" target="_self">Rewinding Details</a>
                    <a href="StockDetails/stockdashboard.jsp" target="_self">Stock Management</a>
                    <a href="EmployeeManagement/employeedashboard.jsp" target="_self">Employee Management</a>
                    <a href="RecordManagement/recordDashboard.jsp" target="_self">Record Management</a><hr>
                    </c:if>
                    <c:if test="${p3==1}">
                    <a href="StockDetails/stockdashboard.jsp" target="_self">Stock Management</a>
                    </c:if>
                    <c:if test="${p2==1}">
                    <a href="EmployeeManagement/employeedashboard.jsp" target="_self">Employee Management</a>
                    </c:if>
                    <c:if test="${p1==1}">
                    <a href="RecordManagement/recordDashboard.jsp" target="_self">Record Management</a><hr>
                    </c:if>

                    <label class="sidebar-footer">Last Login : `+y+`</label>`;
    }
    else if(url.match(/WebWorks_war_exploded\/RewindNotes/)){
        var sidebar = document.getElementById("sidebar");
        sidebar.innerHTML=`
                    <h2>Welcome</h2>
                    <a href="../dashboard.jsp" target="_self">Dashboard</a><hr>
                    <h5 class="sidebar-heading">Rewinding Details</h5>
                    <a href="addRdetails.jsp" target="_self">Add Rewinding Details</a>
                    <a href="updateRdetails.jsp" target="_self">Update Rewinding Details</a>
                    <a href="viewRdetails.jsp" target="_self">View Rewinding Details</a><hr>
                    <label class="sidebar-footer">Last Login :`+y+` </label>`;
    }
    else if(url.match(/WebWorks_war_exploded\/EmployeeManagement/)){
        var sidebar = document.getElementById("sidebar");
        sidebar.innerHTML=`
                    <h2>Welcome</h2>
                    <a href="../dashboard.jsp" target="_self">Dashboard</a><hr>
                    <h5 class="sidebar-heading">Employee Management</h5>
                    <a href="addemployee.jsp" target="_self">Add Employee</a>
                    <a href="editemployee.jsp" target="_self">Update Employee</a>
                    <a href="viewemployee.jsp" target="_self">View Employee</a>
                    <a href="leaveentry.jsp" target="_self">Leave Entry</a><hr>
                    <label class="sidebar-footer">Last Login :`+y+` </label>`;
    }
    else if(url.match(/WebWorks_war_exploded\/RecordManagement/)){
        var sidebar = document.getElementById("sidebar");
        sidebar.innerHTML=`
                    <h2>Welcome</h2>
                    <a href="../dashboard.jsp" target="_self">Dashboard</a><hr>
                    <h5 class="sidebar-heading">Record Management</h5>
                    <a href="addRecordDetails.jsp" target="_self">Add Record</a>
                    <a href="updateRecordDetails.jsp" target="_self">Update Record</a>
                    <a href="viewRecordDetails.jsp" target="_self">View Record</a><hr>
                    <label class="sidebar-footer">Last Login :`+y+` </label>`;
    }
    else if(url.match(/WebWorks_war_exploded\/StockDetails/)){
        var sidebar = document.getElementById("sidebar");
        sidebar.innerHTML=`
                    <h2>Welcome</h2>
                    <a href="../dashboard.jsp" target="_self">Dashboard</a><hr>
                    <h5 class="sidebar-heading">Record Management</h5>
                    <a href="addstock.jsp" target="_self">Add Stock</a>
                    <a href="viewstock.jsp" target="_self">View Stock</a><hr>
                    <label class="sidebar-footer">Last Login :`+y+` </label>`;
    }
</script>