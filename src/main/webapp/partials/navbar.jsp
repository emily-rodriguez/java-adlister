<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-light bg-light">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Adlister</a>
        </div>
        <ul class="nav nav-pills">

            <c:if test="${user == null}">
            <li class="nav-item">
                <a class="nav-link" href="/login">Login</a>
            </li>
            </c:if>
            <c:if test="${user != null}">
            <li class="nav-item">
                <a class="nav-link" href="/profile">Profile</a>
            </li>
            </c:if>
            <li class="nav-item">
                <a class="nav-link" href="/ads">Ads</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/logout">Logout</a>
            </li>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
