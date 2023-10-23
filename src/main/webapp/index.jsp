<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<layout:main title="메인..">
    <c:if test="${sessionScope.member == null}"> <%-- 미 로그인 상태 --%>

    </c:if>
    <c:if test="${sessionScope.member != null}"> <%-- 로그인 상태 --%>

    </c:if>
</layout:main>